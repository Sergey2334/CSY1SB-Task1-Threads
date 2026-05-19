import java.util.Random;

public final class MyUtils {
    private MyUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static Random random = new Random();
    public static int getRandomNumber(int min, int max) {
        return random.nextInt(min, max + 1);
    }
}

