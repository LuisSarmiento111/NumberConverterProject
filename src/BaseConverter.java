import java.awt.*;

public class BaseConverter {
    private String[] digits;
    private int base;

    public BaseConverter(int base) {
         digits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "+", "/"};
         this.base = base;
    }

    public String convert(int number, int base) {
        String newNum = "";
        while (number != 0) {
            newNum = (digits[number % base]) + newNum;
            number /= base;
        }
        return newNum;
    }

    public int convertToDecimal(int number, int base) {
        int newNum = 0;
        String numberAsString = number + "";
        for (int i = numberAsString.length() - 1; i >= 0; i--) {
            newNum += (Integer.parseInt(numberAsString.substring(i, i + 1)) * (int) Math.pow(base, numberAsString.length() - (1 + i)));
        }
        return newNum;
    }

    public boolean validNumberForBase(String number){
        boolean valid = false;
        for (int i = base; i < digits.length; i++) {
            if (number.contains(digits[i])) {
                valid = true;
            }
        }
        return valid;
    }

    public int convertToB(int number, int base){
        return Integer.parseInt(convert(convertToDecimal(number, base), 2));
    }

    public int convertToO(int number, int base) {
        return Integer.parseInt(convert(convertToDecimal(number, base), 8));
    }

    public String convertToH(int number, int base) {
        return convert(convertToDecimal(number, base), 16);
    }

    public String getDigits() {
        return digits[31];
    }
}

