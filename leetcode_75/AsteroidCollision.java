
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            if (a > 0) {
                stack.push(a);
            } else {
                boolean destroyed = false;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    int top = stack.peek();
                    if (top < -a) { // top explodes
                        stack.pop();
                        continue;
                    } else if (top == -a) { // both explode
                        stack.pop();
                        destroyed = true;
                        break;
                    } else { // current explodes
                        destroyed = true;
                        break;
                    }
                }
                if (!destroyed) {
                    stack.push(a);
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] asteroids = {3,5,-6,2,-1,4};
        AsteroidCollision obj = new AsteroidCollision();
        int[] result = obj.asteroidCollision(asteroids);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
