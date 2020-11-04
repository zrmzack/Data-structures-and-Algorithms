package Chapter1;

public class Question5 {
    private static int recursion(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else if (n % 2 == 0) {
            return recursion(n / 2);
        } else {
            return 1+recursion(n / 2);
        }

    }

    public static void main(String[] args) {
        System.out.println(recursion(5));
    }
}
