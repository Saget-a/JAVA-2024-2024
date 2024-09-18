class Lab2 {
    public static void main(String[] args) {

        double y, y1, y2;
        double a = -1.49, b = 23.4, c = 1.23, d = 2.542;
        y = Math.sqrt(Math.abs(Math.sin(a) - (4 * Math.log(b)) / Math.pow(c, d)));
        
        double a1 = 3.56, b1 = 1.02, c1 = 3, d1 = 2.43;
        y1 = 2 * Math.log(Math.pow(b1, a1)) + Math.abs(Math.asin(-Math.sqrt(d1/c1)));

        double a2 = -2.86, b2 = 1.62, c2 = 10.874, d2 = 2.91;
        if (a2 <= 0){
            System.out.println("ERROR значення a2 має бути в діапазоні (0, Infinity)");
        }
        y2 = Math.pow(2 * Math.cos(Math.sqrt(a2/b2)) + 4 * Math.log(d2 + Math.sqrt(d2 * d2 - 1)), c2); 
        // arcosh(x) не придумали того логарифмычна розбивка Math.log(d2 + Math.sqrt(d2 * d2 - 1))
        // вираз видає NaN через те що по завданню а = -2.86 а корінь відь'ємного числа дорівнює комплексному числу
        // вивод завдання №3 некоректне для відтворення у джава
        System.out.printf(" Завдання №1: %.5f%n Завдання №2: %.5f%n Завдання №3: %.5f%n", y, y1, y2);
    }
}