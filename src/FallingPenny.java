/**
 * Tingxuan Lin - Lab 1
 * CS 514
 * My repo is Tingxuan Lin
 */

// member variable local variable

import java.lang.management.GarbageCollectorMXBean;
import java.math.*;
import java.lang.Math;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class FallingPenny {
    // simulating the falling velocity of a penny.
    public static double acceleration = 9.8;
    public static long ESBHeight = 381;
       // add acceleration here.
             // add ESBHeight here.

    public static void main(String[] args) {
           // add falling time here.

        double fallingTimeVar;
        long buildingHeight;

        double localAccel;
        String planet;
        double velocity = 0;
        double timeToTerminalVelocity = 0;
        double timeAtTerminalVelocity = 0;
        double accelDistance = 0;
        Scanner in = new Scanner(System.in);
        String keepGoing;

        // Part 1. Computing falling time
        fallingTimeVar = sqrt(2 * ESBHeight / acceleration);
        System.out.println("It takes " + fallingTimeVar + " to reach the ground.");

        // Part 2. So how fast is the penny moving?
        velocity = fallingTimeVar * acceleration;
        System.out.println("Velocity at impact: " + velocity);

        // Part 3. but what about terminal velocity? This is the point at which air resistance == gravity.
        // 18 m/s is terminal velocity. How long will it take to get there?
        timeToTerminalVelocity = 18 / acceleration;
        System.out.println("Time is: " + timeToTerminalVelocity);

        // Part 4.  So how far will the penny fall during the pre-terminal velocity time? Let's store this in a variable
        // called accelDistance.
        accelDistance = acceleration * (timeToTerminalVelocity * timeToTerminalVelocity) / 2;
        System.out.println("Distance fallen before terminal velocity: " + accelDistance);

        // Part 5. And how long will the penny fall at terminal velocity?
        timeAtTerminalVelocity =
                (ESBHeight - accelDistance) / 18;
        System.out.println("Time last at terminal velocity is " + timeAtTerminalVelocity);

       // part 10: put your while loop here.

       do {
           System.out.print("Please enter a height: ");
           buildingHeight = in.nextInt();
           in.nextLine();
           System.out.print("Please enter a planet: ");
           planet = in.nextLine();
           localAccel = getAcceleration(planet);
           System.out.print("" + spaceFallingTime(buildingHeight, localAccel));

           System.out.println();
           keepGoing = in.nextLine();
       } while (keepGoing.equalsIgnoreCase("Y"));

    }

    // part 6.  Make a static method called fallingTime. It should take one parameter,
    // called fallingDistance, as input, and return the time needed to fall a
    // given distance, according to the expression above. Try it out with different distances.
    /*
    According to part 3, when velocity equals 18m/s, penny will stop accelerating.
    So, fallingTime will be split into 2 parts: accelerate and constant speed.
    For accelerating,
        distance = acceleration * time^2 /2
        velocity = acceleration * time
        time = velocity / acceleration
        so we can get : distance = velocity ^ 2 / (2 * acceleration).
        and we also know constant speed will keep 18 m/s
     */
    public static double fallingTime(double fallingDistance) {
        //      accelerating time +   constant speed time
        return  18 / acceleration + (fallingDistance - 18 * 18 / (2 * acceleration)) / 18;
    }

    // part 7. Step 7: Make a static method called spaceFallingTime that takes two parameters:
    // a distance and a local acceleration, and returns the time elapsed.
    /*
    For this part, we do not know when penny will keep constant speed, so we donot consider this situation.
     */
    public static double spaceFallingTime(long fallingDistance, double localAcceleration) {
        return sqrt(2 * fallingDistance / localAcceleration);
    }

    // part 8, 9: Let's make a helper function called getAcceleration. It will take a string,
    //###  representing our location, and return the appropriate value. We'll do this using a
    //  conditional or if statement.

    public static double getAcceleration(String currentLocation) {
        if (currentLocation.equals("moon")) {
            return 1.6;
        } else if (currentLocation.equals("mars")) {
            return 3.69;
        } else if (currentLocation.equals("jupiter")) {
            return 24.79;
        } else if (currentLocation.equals("saturn")) {
            return 10.44;
        } else if (currentLocation.equals("titan")) {
            return 1.4;
        } else if (currentLocation.equals("venus")) {
            return 8.87;
        } else {
            System.out.println("Cannot find the acceleration in this area. Here is the earth.");
            return 9.8;
        }
    }


}
