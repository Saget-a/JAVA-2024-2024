public class Lab3 {
// собственно завдання 1
    public static double task1(double m, double k){

        double sum = 0;

        for (int i = 1; i <= k; i++) {
            sum += Math.sqrt(m * (1.0 / i)) * Math.sin(m * i);
        }
        return sum;
    }
// завдання 10 собственно 
    public static double task2(double t, int n) {

        double sum = 0;

        if (t < 0) {
            for (int i = 1; i <= n; i++) {
                sum += t * t * i;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                sum += Math.sqrt(t * i);
            }
        }
        return sum;
    }
// завдання 14 собственно 
    public static double task3(double epsilon) {

    double sum = 0; int i = 0; double term;

    if (epsilon <= 0){
        sum = -0.40404;
    } else {
        do {
            term = Math.pow(-2, i) / (factorial(i) * (i + 1));
            sum += term;
            i++;
        } while (Math.abs(term) >= epsilon);
    }

    return sum;
    }
// обчислення факторіала для 14 завдання (ібо я так захотів)
    public static long factorial(int n) {

    if (n == 0) {
        return 1;
    }
    return n * factorial(n - 1);
    }

    public static void main(String[] args ) {

        double result1 = task1(3,30);
        System.out.printf("1 результат  %.5f%n", result1);
        
        double result2 = task2(-2,5);
        System.out.printf("2 результат  %.5f%n", result2);

        double result3 = task3(4);
        System.out.printf("3 результат  %.5f%n", result3);
    }
}