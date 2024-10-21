public class Lab4 {
// собственно завдання 21 51 67
// для перевірки буду використовувати масив A^2 до 12 з чергуванням знаку : -2 9 -16 25 -36 49 -64 81 -100 121 -144

// Задано масиви А(n) та В(n). Сформувати масив С(2*n), елементами якого є
// елементи масивів A(n) та B(n), записані через один (a1, b1, a2, b2, a3, b3, ...)

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
    public static double task51() {
        int[] array = {-2, 9, -16, 25, -36, 49, -64, 81, -100, 121, -144};

        double sum = 0;

        // Проходимо по елементах з індексами, що кратні 2
        for (int i = 0; i < array.length; i += 2) {
            if (array[i] < 0) {
                sum += array[i];
            }
        }
        return sum;
    }

    public static void main(String[] args ) {
        int[] testArray1 = {-2, 9, -16, 25, -36, 49, -64, 81, -100, 121, -144};
        int[] testArray2 = {2, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144};
        int[] testArray3 = {-2, -9, -16, -25, -36, -49, -64, -81, -100, -121, -144};

        System.err.println("Чергування +-    >>>" + task21(testArray1));
        System.err.println("Додатный массив  >>>" + task21(testArray2));
        System.err.println("Від'ємний массив >>>" + task21(testArray3));

    }
}