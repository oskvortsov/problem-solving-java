package data.structure.stack;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/car-fleet/description/
public class CarFleet {
    private static class Car {
        private final int pos;
        private final int speed;

        Car(int p, int s) {
            pos = p;
            speed = s;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) cars[i] = new Car(position[i], speed[i]);
        Arrays.sort(cars, (Car a, Car b) -> b.pos - a.pos);

        Stack<Double> stack = new Stack<>();

        for (Car car: cars) {
            double timeToTarget = (double) (target - car.pos) / car.speed;

            if (stack.isEmpty() || stack.peek() < timeToTarget) {
                stack.add(timeToTarget);
            }
        }


        return stack.size();
    }
}
