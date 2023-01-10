import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class Test {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Converter!\n--------------------------------");
        System.out.println("Would you like to use the (b)asic converter or the (a)dvanced converter? (b or a)");
        String answer = scanner.nextLine();
        while (answer.equals("b") == false && answer.equals("a") == false) {
            System.out.println("That is not a valid answer");
            System.out.println("Would you like to use the (b)asic converter or the (a)dvanced converter? (b or a)");
            answer = scanner.nextLine();
        }
        if (answer.equals("b")) {
            System.out.println("Enter the base of your number (2, 8 or 10): ");
            answer = scanner.nextLine();
            while (answer.equals("2") == false && answer.equals("8") == false && answer.equals("10") == false){
                System.out.println("That is not a valid base value for the basic converter");
                System.out.println("Enter the base of your number (2, 8 or 10, 16): ");
                answer = scanner.nextLine();
            }
            int base = Integer.parseInt(answer);
            BaseConverter converter = new BaseConverter(base);
            System.out.println("Enter your number: ");
            answer = scanner.nextLine();
            while (converter.validNumberForBase(answer)){
                System.out.println("There is a number/letter that does not comply with your base's number system.");
                System.out.println("Enter your number: ");
                answer = scanner.nextLine();
            }
            int number = Integer.parseInt(answer);
            System.out.println("Decimal number: " + converter.convertToDecimal(number, base));
            System.out.println("Octal number: " + converter.convertToO(number, base));
            System.out.println("Hexadecimal number: " + converter.convertToH(number, base));
        }
    }
}