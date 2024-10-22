public class Lab5 {

// массив типу byte[] сортування за зростанням Insertion sort та Bubble sort


    public static void bubbleSort(byte[] array) {
    // довжина масиву
    int n = array.length;

    for (int i = 0; i < n - 1; i++) {
        // цикл для порівняння сусідніх елементів
        for (int j = 0; j < n - i - 1; j++) {
            // якщо елемент більший за наступний, обмін
            if (array[j] > array[j + 1]) {
                byte temp = array[j];       // елемент в temp
                array[j] = array[j + 1];    // Замщення поточного елементу наступним
                array[j + 1] = temp;        // тимчасовий елемент на місце наступного
            }
        }
    }
}

    public static void insertionSort(byte[] array) {
    
    for (int i = 1; i < array.length; i++) {
            byte key = array[i]; // елемент в key
            int j = i - 1;       // індекс попереднього елемента

            // Зміщення елементів, які більші за key, на 1
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j]; // Зміщення елементу на +1
                j--;
            }
        // вствка key на правильну позицію
        array[j + 1] = key;
        }
    }

    public static void printArray(byte[] array) {
        for (byte b : array) {
            System.out.print(b + " ");
        }
        System.out.println();
    }

    public static void main(String[] args ) {
        byte[] array = {5, 3, 8, 6, 2, 32, 16, 2};

        insertionSort(array);
        printArray(array);

        bubbleSort(array);
        printArray(array);
    }
}