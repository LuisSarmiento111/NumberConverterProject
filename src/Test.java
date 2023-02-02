import java.net.Inet4Address;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Arrays;

public class Test {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Converter!\n--------------------------------");
        System.out.println("Would you like to use the (b)asic converter or the (a)dvanced converter? (b or a)");
        String answer = scanner.nextLine();
        while (answer.equals("b") == false && answer.equals("a") == false && answer.equals("A") == false && answer.equals("B") == false) {
            System.out.println("That is not a valid answer");
            System.out.println("Would you like to use the (b)asic converter or the (a)dvanced converter? (b or a)");
            answer = scanner.nextLine();
        }
        if (answer.equals("b") || answer.equals("B")) {
            System.out.print("Enter the base of your number (2, 8, 10 or 16): ");
            answer = scanner.nextLine();
            while (answer.equals("2") == false && answer.equals("8") == false && answer.equals("10") == false && answer.equals("16") == false){
                System.out.println("That is not a valid base value for the basic converter");
                System.out.print("Enter the base of your number (2, 8, 10 or 16): ");
                answer = scanner.nextLine();
            }
            int base = Integer.parseInt(answer);
            BaseConverter converter = new BaseConverter(base);
            System.out.print("Enter your number: ");
            answer = scanner.nextLine();
            while (converter.validNumberForBase(answer)){
                System.out.println("There is a number/letter that does not comply with your base's number system.");
                System.out.print("Enter your number: ");
                answer = scanner.nextLine();
            }
            int number = Integer.parseInt(answer);
            if (base != 2) {
                System.out.println("Binary number: " + converter.convertToB(number,base));
            }
            if (base != 8) {
                System.out.println("Octal number: " + converter.convertToO(number, base));
            }
            if (base != 10) {
                System.out.println("Decimal number: " + converter.convertToDecimal(number, base));
            }
            if (base != 16) {
                System.out.println("Hexadecimal number: " + converter.convertToH(number, base));
            }
        }
        if (answer.equals("a") || answer.equals("A")) {
            BaseConverter converter = new BaseConverter(10);
            System.out.print("Enter any base 10 number: ");
            answer = scanner.nextLine();
            while (converter.validNumberForBase(answer)){
                System.out.println("There is a number/letter that does not comply with your base's number system.");
                System.out.print("Enter any base 10 number: ");
                answer = scanner.nextLine();
            }
            int number = Integer.parseInt(answer);
            System.out.print("Enter what base you would like to convert to (1-64): ");
            answer = scanner.nextLine();
            while (Integer.parseInt(answer) > 64 && Integer.parseInt(answer) < 1) {
                System.out.println("That is an invalid base option");
                System.out.print("Enter what base you would like to convert to (1-64): ");
                answer = scanner.nextLine();
            }
            int convertTo = Integer.parseInt(answer);
            System.out.println("Base " + convertTo + " number: " + converter.convert(number, convertTo));
        }
    }
}