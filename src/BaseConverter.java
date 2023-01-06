public class BaseConverter {
    private String[] digits;
    private int number;

    public BaseConverter(int number) {
         digits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "+", "/"};
        this.number = number;
    }

    public String convert(int base) {
        String newNum = "";
        while (number != 0) {
            newNum = (digits[number % base]) + newNum;
            number /= base;
        }
        return newNum;
    }

    public String convertToDecimal(int number) {
        String newNum = "";
    }

    public String getDigits() {
        return digits[35];
    }
}

