import java.lang.Math;
import java.util.Scanner;




public class Main {




  public static void main(String[] args) {

    Scanner stdIn = new Scanner(System.in);

    Projectile projectile1 = new Projectile();


    System.out.println("Enter the initial position of the projectile in the x direction (meters): ");
    projectile1.setPositionX(stdIn.nextDouble());

    System.out.println("Enter the initial position of the projectile in the y direction (meters): ");
    projectile1.setPositionY(stdIn.nextDouble());

    System.out.println("Enter the initial velocity of the projectile (meters/second): ");
    projectile1.setVelocity(stdIn.nextDouble());

    System.out.println("Enter the initial angle of the projectile (degrees): ");
    projectile1.setDegreesAngle(stdIn.nextDouble());

    System.out.println("Enter the initial height of the projectile (meters): ");
    projectile1.setHeight(stdIn.nextDouble());

    System.out.println("Enter the cross sectional area of the projectile (meters squared): ");
    projectile1.setCrossArea(stdIn.nextDouble());


    








  }


}
