public class Lab6 {
    
// 3 Перетворити значення int у об’єкт String, що представляє собою число у вісімковій системі числення
    public static String toOctalStr(int num){
        String octalString = Integer.toOctalString(num);
        return octalString;
    }

// 7 Об’єкт String представляє собою речення, що містить слова (складаються з літер a-z, A-Z), цілі числа (складаються з цифр 0-9), та комбінації літер та цифр.
// Підрахувати кількість слів у реченні.
    public static int countWords(String sentence) {
       
        String[] words = sentence.split("\\s+"); //розбиває речення на слова за пробілами.
                
        int count = 0;
        for (String word : words) {
            
            if (word.matches("[a-zA-Z]+")) {  // Перевіряє,чи слово містить тільки літери
                count++;
            }
        }
    return count;
    }

    public static void main(String[] args ) {
        int number = 511;
        System.out.println("Вісімкове представлення числа " + number + " : " + toOctalStr(number));

        String input = "The user with the nickname koala757677 this month left 3 times more comments than the user with the nickname croco181dile181920 4 months ago";

        System.out.println("Кількість слів у реченні: " + countWords(input));
    }
}