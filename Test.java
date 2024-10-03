class Test{
    public static void main(String[] args ) {
    int n = 30;
    double im;
        do {

            im = factorial(n);
            System.out.println("Factorial " + n + " is " + im);
            n--;
        } while (n > 0);
    }

public static double factorial(int n) {

    if (n == 0) {
        return 1;
    }
    return n * factorial(n - 1);
    }
}
