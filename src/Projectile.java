import java.lang.Math;
import java.util.Scanner;

public class Projectile {

  public double time = 0;
  private double positionX;
  private double positionY;
  private double velocity;
  private double degreesAngle;
  private double height;

  private double crossArea;
  private double dragCoefficient = 0.5;


  public Projectile() {
    this.positionX = 0;
    this.positionY = 0;
    this.velocity = 0;
    this.degreesAngle = 0;
    this.height = 0;
    this.crossArea = 0;
  }

  public Projectile(double positionX, double positionY, double velocity, double degreesAngle, double height, double crossArea) {
    this.positionX = positionX;
    this.positionY = positionY;
    this.velocity = velocity;
    this.degreesAngle = degreesAngle;
    this.height = height;
    this.crossArea = crossArea;
  }


  //getters
    public double getPositionX () {
      return positionX;
    }

    public double getPositionY () {
      return positionY;
    }

    public double getVelocity () {
      return velocity;
    }

    public double getDegreesAngle () {
      return degreesAngle;
    }

    public double getHeight () {
      return height;
    }

    public double getDragCoefficient () {
      return dragCoefficient;
    }

    public double getCrossArea () {
      return crossArea;
    }

    public double getTime () {
      return time;
    }


  //setters
    public void setPositionX (double positionX) {
      this.positionX = positionX;
    }

    public void setPositionY (double positionY) {
      this.positionY = positionY;
    }

    public void setVelocity (double velocity) {
      this.velocity = velocity;
    }

    public void setDegreesAngle (double degreesAngle) {
      this.degreesAngle = degreesAngle;
    }

    public void setHeight (double height) {
      this.height = height;
    }

    public void setDragCoefficient (double dragCoefficient) {
      this.dragCoefficient = dragCoefficient;
    }

    public void setCrossArea (double crossArea) {
      this.crossArea = crossArea;
    }

    public void setTime (double time) {
      this.time = time;
    }






  //methods

  public static double magnitudeToXComponentForm(double magnitude, double degDirection) {
    double radAngle = (degDirection / (180 / Math.PI));
    double radcos = Math.cos(radAngle);
    double xcompositepart = magnitude * radcos;
    return xcompositepart;
  }

  public static double magnitudeToYComponentForm(double magnitude, double degDirection) {
    double radAngle = (degDirection / (180 / Math.PI));
    double radsin = Math.sin(radAngle);
    double ycompositepart = magnitude * radsin;
    return ycompositepart;
  }

  public static double pressureCalculation(double height) {
    double temp = 0;
    double pressure = 0;
    if (height < 11000) {
      temp = 15.04 - (0.00649 * height);
      pressure = 101.29 * Math.pow(((temp + 273.1) / 288.08), 5.256);
    }
    if (height > 11000 && height < 25000) {
      temp = -56.46;
      pressure = 22.65 * Math.exp(1.73 - (0.000157 * height));
    }
    if (height > 25000) {
      temp = -131.21 + (0.00299 * height);
      pressure = 2.488 * Math.pow(((temp + 273.1) / 216.6), -11.388);
    }
    return pressure;
  }

  public static double densityPressureCalculation(double height) {
    double temp = 0;
    double pressure = 0;
    if (height < 11000) {
      temp = 15.04 - (0.00649 * height);
      pressure = 101.29 * Math.pow(((temp + 273.1) / 288.08), 5.256);
    }
    if (height > 11000 && height < 25000) {
      temp = -56.46;
      pressure = 22.65 * Math.exp(1.73 - (0.000157 * height));
    }
    if (height > 25000) {
      temp = -131.21 + (0.00299 * height);
      pressure = 2.488 * Math.pow(((temp + 273.1) / 216.6), -11.388);
    }
    double density = pressure / (0.2869 * (temp + 273.1));
    return density;
  }

  public static double forceDrag(double height, double dragCoeff, double crossArea, double veloc) {
    double density = densityPressureCalculation(height);
    double forceDrag = (0.5 * density * Math.pow(veloc, 2) * dragCoeff * crossArea);
    return forceDrag;
  }

  public static double forceDragDeg(double degAngle) {
    double degAngleDrag = degAngle + 180;
    return degAngleDrag;
  }

  public static double forceDragVeloComp(double height, double dragCoeff, double crossArea, double velocX, double velocY) {
    double density = densityPressureCalculation(height);
    double veloc = Math.sqrt(Math.pow(velocX, 2) + Math.pow(velocY, 2));
    double forceDrag = (0.5 * density * Math.pow(veloc, 2) * dragCoeff * crossArea);
    return forceDrag;
  }

  public static double forceDragDegVeloComp(double velocX, double velocY) {
    double dragDegRadians = Math.atan(velocY / velocX);
    double tempDragDegs = dragDegRadians * (180 / Math.PI);
    double finalDragDeg = tempDragDegs + 180;
    return finalDragDeg;
  }

  public static double forceDragXComponent(double height, double dragCoeff, double crossArea, double velocX, double velocY) {
    double forceDrag = forceDragVeloComp(height, dragCoeff, crossArea, velocX, velocY);
    double forceDragDeg = forceDragDegVeloComp(velocX, velocY);
    double forceDragXComponent = magnitudeToXComponentForm(forceDrag, forceDragDeg);
    return forceDragXComponent;
  }

  public static double forceDragYComponent(double height, double dragCoeff, double crossArea, double velocX, double velocY) {
    double forceDrag = forceDragVeloComp(height, dragCoeff, crossArea, velocX, velocY);
    double forceDragDeg = forceDragDegVeloComp(velocX, velocY);
    double forceDragYComponent = magnitudeToYComponentForm(forceDrag, forceDragDeg);
    return forceDragYComponent;
  }




}
