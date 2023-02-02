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
            if (base == 1) {
                newNum = "1" + newNum;
                number--;
            } else if (base == 0) {
                newNum = "0";
            } else {
                newNum = (digits[number % base]) + newNum;
                number /= base;
            }
        }
        return newNum;
    }

    public int convertToDecimal(String number, int base) {
        int newNum = 0;
        int numberAtIndex = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            for (int v = 0; v < digits.length; v++) {
                if (digits[v].equals(number.substring(i, i + 1))) {
                    numberAtIndex = v;
                }
            }
            newNum += numberAtIndex * (int) Math.pow(base, number.length() - (1 + i));
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

    public String convertToB(String number, int base){
        return convert(convertToDecimal(number, base), 2);
    }

    public String convertToO(String number, int base) {
        return convert(convertToDecimal(number, base), 8);
    }

    public String convertToH(String number, int base) {
        return convert(convertToDecimal(number, base), 16);
    }

    public String[] getDigits() {
        return digits;
    }
}

