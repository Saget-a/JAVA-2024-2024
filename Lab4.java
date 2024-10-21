public class Lab4 {

// завдання 21 
// Знайти добуток модулів найбільшого та найменшого елементів масиву
    public static double task21(int[] array) {
        
        int max = array[0];
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        int maxAbs = Math.abs(max);
        int minAbs = Math.abs(min);

        int product = maxAbs * minAbs;
        return product;
    }
   
// завдання 51
// Знайти суму від’ємних елементів, індекс яких кратний 2
    public static double task51(int[] array) {

        double sum = 0;

        for (int i = 0; i < array.length; i += 2) {
            if (array[i] < 0) {
                sum += array[i];
            }
        }
        return sum;
    }
// завдання 67
// Задано масиви А(n) та В(n). Сформувати масив С(2*n), елементами якого є
// елементи масивів A(n) та B(n), записані через один (a1, b1, a2, b2, a3, b3, ...)

    public static int[] task67(int[] A, int[] B) {

        if (A.length != B.length) {
            System.out.println("ERROR 67.01");
        }
    
        int n = A.length;
        int[] C = new int[2 * n];

        for (int i = 0; i < n; i++) {
            C[2 * i] = A[i];       
            C[2 * i + 1] = B[i];   
        }
    return C;
    }

    
    public static void main(String[] args ) {
        int[] testArray1 = {-2, 9, -16, 25, -36, 49, -64, 81, -100, 121, -144};
        int[] testArray2 = {2, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144};
        int[] testArray3 = {-2, -9, -16, -25, -36, -49, -64, -81, -100, -121, -144};
        
        int[] A = {9, 25, 49, 81, 121};
        int[] B = {2, 16, 36, 64, 100};

        System.err.println("тест завдання 21");
        System.err.println("Чергування +-    >>> " + task21(testArray1));
        System.err.println("Додатный массив  >>> " + task21(testArray2));
        System.err.println("Від'ємний массив >>> " + task21(testArray3) + "\n");

        System.err.println("тест завдання 51");
        System.err.println("Чергування +-    >>> " + task51(testArray1));
        System.err.println("Додатный массив  >>> " + task51(testArray2));
        System.err.println("Від'ємний массив >>> " + task51(testArray3) + "\n");

        System.err.println("тест завдання 67");

        int [] result67 = task67(A,B);
        
        System.out.print("З'єднання масиивів A & B: ");
        for (int value : result67) {
            System.out.print(value + " ");
        }
    }
}