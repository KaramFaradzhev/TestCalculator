import javax.naming.ldap.HasControls;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {
    private static String multiplication = "*";
    private static String division = "/";
    private static String plus = "+";
    private static String minus = "-";
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String vvod;
        while (true) {
            vvod = reader.readLine();
            if (!vvod.contains(multiplication) && !vvod.contains(division) && !vvod.contains(plus) && !vvod.contains(minus)) {
                throw new Exception("Строка не является математической операцией");
            }
            if (vvod.contains(multiplication) && (vvod.contains(division) || vvod.contains(plus) || vvod.contains(minus))) {
                throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            if (vvod.contains(division) && (vvod.contains(minus) || vvod.contains(multiplication) || vvod.contains(plus))) {
                throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            if (vvod.contains(plus) && (vvod.contains(division) || vvod.contains(multiplication) || vvod.contains(minus))) {
                throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            if (vvod.contains(minus) && (vvod.contains(division) || vvod.contains(plus) || vvod.contains(multiplication))) {
                throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            arabianCalculator(vvod);
        }

    }
    public static void arabianCalculator(String vvod) throws Exception {
        if (vvod.contains("I") || vvod.contains("V") || vvod.contains("X")) {
            romeCalc(vvod);
            return;
        }
        int first1 = 0;                //здесь будет храниться значение первой переменной, находящейся до знака
        int last1 = 0;                 // здесь значение второй переменной
        String[] parts = new String[2];
        if (vvod.contains(multiplication)){          // если введенная строка содержит знак умножения, то выполняется код в блоке
            try {
                parts = vvod.split("\\*");      // разбиваю строку на подстроки до знака умножения и после
            }
            catch (Exception e) {
                System.out.println("Неверно введена арифмеическая операция.");
            }
            String part1 = parts[0].trim();        // убираю пробелы с начала и конца подстроки
            String part2 = parts[1].trim();
            if (parts.length != 2) {           // если строка разбилась на более чем две подстроки (было введено минимум 2 знака уножения), то выбрасывается исключение
                throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            try {
                first1 = Integer.parseInt(part1);      //преобразовывю 1 подстроку в число
                last1 = Integer.parseInt(part2);
            }
            catch (NumberFormatException e) {
                System.out.println("Введенная строка не поддерживается");
                return;
            }
            if (first1 > 10 || last1 >10 || first1 < 1 || last1 < 1) {
                throw new ArithmeticException ("Калькулятор принимает на вход числа от 1 до 10 включительно, не более.");
            }
            System.out.println(first1 * last1);
        }
        if (vvod.contains(division)){
            parts = vvod.split(division);
            String part1 = parts[0].trim();
            String part2 = parts[1].trim();
            if (parts.length != 2) {
                throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            try {
                first1 = Integer.parseInt(part1);
                last1 = Integer.parseInt(part2);
            }
            catch (NumberFormatException e) {
                System.out.println("Введены не числа");
                return;
            }
            first1 = Integer.parseInt(part1);
            last1 = Integer.parseInt(part2);
            if (first1 > 10 || last1 >10 || first1 < 1 || last1 < 1) {
                throw new ArithmeticException ("Калькулятор принимает на вход числа от 1 до 10 включительно, не более.");
            }
            System.out.println(first1 / last1);
        }
        if (vvod.contains(plus)){
            parts = vvod.split("\\+");
            String part1 = parts[0].trim();
            String part2 = parts[1].trim();
            if (parts.length != 2) {
                throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            try {
                first1 = Integer.parseInt(part1);
                last1 = Integer.parseInt(part2);
            }
            catch (NumberFormatException e) {
                System.out.println("Введены не числа");
                return;
            }
            first1 = Integer.parseInt(part1);
            last1 = Integer.parseInt(part2);
            if (first1 > 10 || last1 >10 || first1 < 1 || last1 < 1) {
                throw new ArithmeticException ("Калькулятор принимает на вход числа от 1 до 10 включительно, не более.");
            }
            System.out.println(first1 + last1);
        }
        if (vvod.contains(minus)){
            parts = vvod.split(minus);
            String part1 = parts[0].trim();
            String part2 = parts[1].trim();
            if (parts.length != 2) {
                throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            try {
                first1 = Integer.parseInt(part1);
                last1 = Integer.parseInt(part2);
            }
            catch (NumberFormatException e) {
                System.out.println("Введены не числа");
                return;
            }
            first1 = Integer.parseInt(part1);
            last1 = Integer.parseInt(part2);
            if (first1 > 10 || last1 >10 || first1 < 1 || last1 < 1) {
                throw new ArithmeticException ("Калькулятор принимает на вход числа от 1 до 10 включительно, не более.");
            }
            System.out.println(first1 - last1);
        }
    }
    public static void romeCalc (String vvod) throws Exception {
        RomeCalculator romeI = RomeCalculator.I;                 //создаю объекты из "класса" enum, которым уже присвоены соответсвующие значения
        RomeCalculator romeII = RomeCalculator.II;
        RomeCalculator romeIII = RomeCalculator.III;
        RomeCalculator romeIV = RomeCalculator.IV;
        RomeCalculator romeV = RomeCalculator.V;
        RomeCalculator romeVI = RomeCalculator.VI;
        RomeCalculator romeVII = RomeCalculator.VII;
        RomeCalculator romeVIII = RomeCalculator.VIII;
        RomeCalculator romeIX = RomeCalculator.IX;
        RomeCalculator romeX = RomeCalculator.X;
        RomeCalculator romeXX = RomeCalculator.XX;
        RomeCalculator romeXXX = RomeCalculator.XXX;
        RomeCalculator romeXL = RomeCalculator.XL;
        RomeCalculator romeL = RomeCalculator.L;
        RomeCalculator romeLX = RomeCalculator.LX;
        RomeCalculator romeLXX = RomeCalculator.LXX;
        RomeCalculator romeLXXX = RomeCalculator.LXXX;
        RomeCalculator romeXC = RomeCalculator.XC;
        RomeCalculator romeC = RomeCalculator.C;
        if (vvod.contains("1") || vvod.contains("2") || vvod.contains("3") || vvod.contains("4") || vvod.contains("5") || vvod.contains("6") || vvod.contains("7") || vvod.contains("8") || vvod.contains("9") || vvod.contains("0")) {
            throw new Exception("Используются одновременно разные системы счисления");
        }
        int a = 0;               //здесь будет первое число из введенной строки, переведенное в арабский стиль с типом int
        int b = 0;              //здесь второе число
        int c = 0;              // здесь будет ответ
        String[] parts;
        if (vvod.contains(multiplication)){
            parts = vvod.split("\\*");
            String part1 = parts[0].trim();
            String part2 = parts[1].trim();
            if (parts.length != 2) {
                throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            if (!part1.equals("I") && !part1.equals("II") && !part1.equals("III") && !part1.equals("IV") && !part1.equals("V") && !part1.equals("VI") && !part1.equals("VII") && !part1.equals("VIII") && !part1.equals("IX") && !part1.equals("X")) {
                throw new Exception("Числа могут быть от I до X");
            }
            if (!part2.equals("I") && !part2.equals("II") && !part2.equals("III") && !part2.equals("IV") && !part2.equals("V") && !part2.equals("VI") && !part2.equals("VII") && !part2.equals("VIII") && !part2.equals("IX") && !part2.equals("X")) {
                throw new Exception("Числа могут быть от I до X");
            }
            if (part1.equals("I")) {                     // если первая строка равна "I", то a присваивается соответсвующее значение объекта enum с типом int
                a = romeI.getTranslate();
            }
            if (part1.equals("II")) {
                a = romeII.getTranslate();
            }
            if (part1.equals("III")) {
                a = romeIII.getTranslate();
            }
            if (part1.equals("V")) {
                a = romeV.getTranslate();
            }
            if (part1.equals("IV")) {
                a = romeIV.getTranslate();
            }
            if (part1.equals("VI")) {
                a = romeVI.getTranslate();
            }
            if (part1.equals("VII")) {
                a = romeVII.getTranslate();
            }
            if (part1.equals("VIII")) {
                a = romeVIII.getTranslate();
            }
            if (part1.equals("X")) {
                a = romeX.getTranslate();
            }
            if (part1.equals("IX")) {
                a = romeIX.getTranslate();
            }

            if (part2.equals("I")) {
                b = romeI.getTranslate();
            }
            if (part2.equals("II")) {
                b = romeII.getTranslate();
            }
            if (part2.equals("III")) {
                b = romeIII.getTranslate();
            }
            if (part2.equals("V")) {
                b = romeV.getTranslate();
            }
            if (part2.equals("IV")) {
                b = romeIV.getTranslate();
            }
            if (part2.equals("VI")) {
                b = romeVI.getTranslate();
            }
            if (part2.equals("VII")) {
                b = romeVII.getTranslate();
            }
            if (part2.equals("VIII")) {
                b = romeVIII.getTranslate();
            }
            if (part2.equals("X")) {
                b = romeX.getTranslate();
            }
            if (part2.equals("IX")) {
                b = romeIX.getTranslate();
            }
            c = a*b;
        }
        if (vvod.contains(division)){
            parts = vvod.split(division);
            String part1 = parts[0].trim();
            String part2 = parts[1].trim();
            if (parts.length != 2) {
                throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            if (!part1.equals("I") && !part1.equals("II") && !part1.equals("III") && !part1.equals("IV") && !part1.equals("V") && !part1.equals("VI") && !part1.equals("VII") && !part1.equals("VIII") && !part1.equals("IX") && !part1.equals("X")) {
                throw new Exception("Числа могут быть от I до X");
            }
            if (!part2.equals("I") && !part2.equals("II") && !part2.equals("III") && !part2.equals("IV") && !part2.equals("V") && !part2.equals("VI") && !part2.equals("VII") && !part2.equals("VIII") && !part2.equals("IX") && !part2.equals("X")) {
                throw new Exception("Числа могут быть от I до X");
            }
            if (part1.equals("I")) {
                a = romeI.getTranslate();
            }
            if (part1.equals("II")) {
                a = romeII.getTranslate();
            }
            if (part1.equals("III")) {
                a = romeIII.getTranslate();
            }
            if (part1.equals("V")) {
                a = romeV.getTranslate();
            }
            if (part1.equals("IV")) {
                a = romeIV.getTranslate();
            }
            if (part1.equals("VI")) {
                a = romeVI.getTranslate();
            }
            if (part1.equals("VII")) {
                a = romeVII.getTranslate();
            }
            if (part1.equals("VIII")) {
                a = romeVIII.getTranslate();
            }
            if (part1.equals("X")) {
                a = romeX.getTranslate();
            }
            if (part1.equals("IX")) {
                a = romeIX.getTranslate();
            }

            if (part2.equals("I")) {
                b = romeI.getTranslate();
            }
            if (part2.equals("II")) {
                b = romeII.getTranslate();
            }
            if (part2.equals("III")) {
                b = romeIII.getTranslate();
            }
            if (part2.equals("V")) {
                b = romeV.getTranslate();
            }
            if (part2.equals("IV")) {
                b = romeIV.getTranslate();
            }
            if (part2.equals("VI")) {
                b = romeVI.getTranslate();
            }
            if (part2.equals("VII")) {
                b = romeVII.getTranslate();
            }
            if (part2.equals("VIII")) {
                b = romeVIII.getTranslate();
            }
            if (part2.equals("X")) {
                b = romeX.getTranslate();
            }
            if (part2.equals("IX")) {
                b = romeIX.getTranslate();
            }
            c = a/b;
        }
        if (vvod.contains(plus)){
            parts = vvod.split("\\+");
            String part1 = parts[0].trim();
            String part2 = parts[1].trim();
            if (parts.length != 2) {
                throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            if (!part1.equals("I") && !part1.equals("II") && !part1.equals("III") && !part1.equals("IV") && !part1.equals("V") && !part1.equals("VI") && !part1.equals("VII") && !part1.equals("VIII") && !part1.equals("IX") && !part1.equals("X")) {
                throw new Exception("Числа могут быть от I до X");
            }
            if (!part2.equals("I") && !part2.equals("II") && !part2.equals("III") && !part2.equals("IV") && !part2.equals("V") && !part2.equals("VI") && !part2.equals("VII") && !part2.equals("VIII") && !part2.equals("IX") && !part2.equals("X")) {
                throw new Exception("Числа могут быть от I до X");
            }
            if (part1.equals("I")) {
                a = romeI.getTranslate();
            }
            if (part1.equals("II")) {
                a = romeII.getTranslate();
            }
            if (part1.equals("III")) {
                a = romeIII.getTranslate();
            }
            if (part1.equals("V")) {
                a = romeV.getTranslate();
            }
            if (part1.equals("IV")) {
                a = romeIV.getTranslate();
            }
            if (part1.equals("VI")) {
                a = romeVI.getTranslate();
            }
            if (part1.equals("VII")) {
                a = romeVII.getTranslate();
            }
            if (part1.equals("VIII")) {
                a = romeVIII.getTranslate();
            }
            if (part1.equals("X")) {
                a = romeX.getTranslate();
            }
            if (part1.equals("IX")) {
                a = romeIX.getTranslate();
            }

            if (part2.equals("I")) {
                b = romeI.getTranslate();
            }
            if (part2.equals("II")) {
                b = romeII.getTranslate();
            }
            if (part2.equals("III")) {
                b = romeIII.getTranslate();
            }
            if (part2.equals("V")) {
                b = romeV.getTranslate();
            }
            if (part2.equals("IV")) {
                b = romeIV.getTranslate();
            }
            if (part2.equals("VI")) {
                b = romeVI.getTranslate();
            }
            if (part2.equals("VII")) {
                b = romeVII.getTranslate();
            }
            if (part2.equals("VIII")) {
                b = romeVIII.getTranslate();
            }
            if (part2.equals("X")) {
                b = romeX.getTranslate();
            }
            if (part2.equals("IX")) {
                b = romeIX.getTranslate();
            }
            c = a+b;
        }
        if (vvod.contains(minus)) {
            parts = vvod.split(minus);
            String part1 = parts[0].trim();
            String part2 = parts[1].trim();
            if (parts.length != 2) {
                throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            if (!part1.equals("I") && !part1.equals("II") && !part1.equals("III") && !part1.equals("IV") && !part1.equals("V") && !part1.equals("VI") && !part1.equals("VII") && !part1.equals("VIII") && !part1.equals("IX") && !part1.equals("X")) {
                throw new Exception("Числа могут быть от I до X");
            }
            if (!part2.equals("I") && !part2.equals("II") && !part2.equals("III") && !part2.equals("IV") && !part2.equals("V") && !part2.equals("VI") && !part2.equals("VII") && !part2.equals("VIII") && !part2.equals("IX") && !part2.equals("X")) {
                throw new Exception("Числа могут быть от I до X");
            }
            if (part1.equals("I")) {
                a = romeI.getTranslate();
            }
            if (part1.equals("II")) {
                a = romeII.getTranslate();
            }
            if (part1.equals("III")) {
                a = romeIII.getTranslate();
            }
            if (part1.equals("V")) {
                a = romeV.getTranslate();
            }
            if (part1.equals("IV")) {
                a = romeIV.getTranslate();
            }
            if (part1.equals("VI")) {
                a = romeVI.getTranslate();
            }
            if (part1.equals("VII")) {
                a = romeVII.getTranslate();
            }
            if (part1.equals("VIII")) {
                a = romeVIII.getTranslate();
            }
            if (part1.equals("X")) {
                a = romeX.getTranslate();
            }
            if (part1.equals("IX")) {
                a = romeIX.getTranslate();
            }

            if (part2.equals("I")) {
                b = romeI.getTranslate();
            }
            if (part2.equals("II")) {
                b = romeII.getTranslate();
            }
            if (part2.equals("III")) {
                b = romeIII.getTranslate();
            }
            if (part2.equals("V")) {
                b = romeV.getTranslate();
            }
            if (part2.equals("IV")) {
                b = romeIV.getTranslate();
            }
            if (part2.equals("VI")) {
                b = romeVI.getTranslate();
            }
            if (part2.equals("VII")) {
                b = romeVII.getTranslate();
            }
            if (part2.equals("VIII")) {
                b = romeVIII.getTranslate();
            }
            if (part2.equals("X")) {
                b = romeX.getTranslate();
            }
            if (part2.equals("IX")) {
                b = romeIX.getTranslate();
            }
            c = a - b;
        }
        if (c <= 0) {
            throw new ArithmeticException("Римская цифра не может равняться нулю или быть отрицательной");
        }
        if (c == 1) {                               //если ответ "с" равен 1, то вызывается соответсвующий объект из enum и выводится на экран
            System.out.println(romeI);
        }
        if (c == 2) {
            System.out.println(romeII);
        }
        if (c == 3) {
            System.out.println(romeIII);
        }
        if (c == 4) {
            System.out.println(romeIV);
        }
        if (c == 5) {
            System.out.println(romeV);
        }
        if (c == 6) {
            System.out.println(romeVI);
        }
        if (c == 7) {
            System.out.println(romeVII);
        }
        if (c == 8) {
            System.out.println(romeVIII);
        }
        if (c == 9) {
            System.out.println(romeIX);
        }
        if (c == 10) {
            System.out.println(romeX);
        }
        if (c == 11) {
            System.out.print(romeX);
            System.out.println(romeI);
        }
        if (c == 12) {
            System.out.print(romeX);
            System.out.println(romeII);
        }
        if (c == 13) {
            System.out.print(romeX);
            System.out.println(romeIII);
        }
        if (c == 14) {
            System.out.print(romeX);
            System.out.println(romeIV);
        }
        if (c == 15) {
            System.out.print(romeX);
            System.out.println(romeV);
        }
        if (c == 16) {
            System.out.print(romeX);
            System.out.println(romeVI);
        }
        if (c == 17) {
            System.out.print(romeX);
            System.out.println(romeVII);
        }
        if (c == 18) {
            System.out.print(romeX);
            System.out.println(romeVIII);
        }
        if (c == 19) {
            System.out.print(romeX);
            System.out.println(romeIX);
        }
        if (c == 20) {
            System.out.println(romeXX);
        }
        if (c == 21) {
            System.out.print(romeXX);
            System.out.println(romeI);
        }
        if (c == 23) {
            System.out.print(romeXX);
            System.out.println(romeIII);
        }
        if (c == 24) {
            System.out.print(romeXX);
            System.out.println(romeIV);
        }
        if (c == 25) {
            System.out.print(romeXX);
            System.out.println(romeIV);
        }
        if (c == 27) {
            System.out.print(romeXX);
            System.out.println(romeVII);
        }
        if (c == 28) {
            System.out.print(romeXX);
            System.out.println(romeVIII);
        }
        if (c == 30) {
            System.out.println(romeXXX);
        }
        if (c == 32) {
            System.out.print(romeXXX);
            System.out.println(romeII);
        }
        if (c == 35) {
            System.out.print(romeXXX);
            System.out.println(romeV);
        }
        if (c == 36) {
            System.out.print(romeXXX);
            System.out.println(romeVI);
        }
        if (c == 40) {
            System.out.println(romeXL);
        }
        if (c == 42) {
            System.out.print(romeXL);
            System.out.println(romeII);
        }
        if (c == 45) {
            System.out.print(romeXL);
            System.out.println(romeV);
        }
        if (c == 48) {
            System.out.print(romeXL);
            System.out.println(romeVIII);
        }
        if (c == 49) {
            System.out.print(romeXL);
            System.out.println(romeIX);
        }
        if (c == 50) {
            System.out.print(romeL);
        }
        if (c == 54) {
            System.out.print(romeL);
            System.out.println(romeIV);
        }
        if (c == 56) {
            System.out.print(romeL);
            System.out.println(romeVI);
        }
        if (c == 60) {
            System.out.print(romeLX);
        }
        if (c == 63) {
            System.out.print(romeLX);
            System.out.println(romeIII);
        }
        if (c == 64) {
            System.out.print(romeLX);
            System.out.println(romeIV);
        }
        if (c == 70) {
            System.out.println(romeLXX);
        }
        if (c == 72) {
            System.out.print(romeLXX);
            System.out.println(romeII);
        }
        if (c == 80) {
            System.out.print(romeLXXX);
        }
        if (c == 81) {
            System.out.print(romeLXXX);
            System.out.println(romeI);
        }
        if (c == 90) {
            System.out.println(romeXC);
        }
        if (c == 100) {
            System.out.println(romeC);
        }
    }
}
