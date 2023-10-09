public class Mathematics {
    public static boolean isPrime(int n) {
        int v = 2;
        double limit = Math.sqrt(n);
        while (v <= limit && n % v != 0) {
            v++;
        }
        return n == v && n > 1;
    }

    public static boolean isPerfect(int n) {
        int sum = 0;
        double limit = Math.sqrt(n);
        for (int i = 1; i <= limit; i++) {
            if (n % i == 0) {
                sum = sum + i;
            }
        }
        return sum == n;
    }

    public static int factorialRec(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorialRec(n - 1);
        }
    }

    public static int factorialIt(int n) {
        int result = 1;
        for (int k = 1; k <= n; k++) {
            result *= k;
        }
        return result;
    }

    public static int gcdRec(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcdRec(b, a % b);
        }
    }

    public static int gcdIt(int a, int b) {
        while (b>0) {
            int old_a = a;
            a = b;
            b = old_a % b;
        }
        return a;
    }

    public static int sumSquaredIt(int n) {
        int result = 0;
        for (int k = 1; k <= n; k++) {
            result += k * k;
        }
        return result;
    }

    public static int sumSquaredRec(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n * n + sumSquaredRec(n - 1);
        }
    }
}
