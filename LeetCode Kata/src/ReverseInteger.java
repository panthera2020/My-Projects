public class ReverseInteger {
    public int reverseInt(int number) {
        int reversed = 0;

        while (number != 0) {
            int lastDigit = number % 10;
            reversed = reversed * 10 + lastDigit;
            number = number / 10;
        }

        if (reversed < Math.pow(2, 31) * -1 || reversed > Math.pow(2, 31) - 1) {
            return 0;
        }
        return reversed;
    }
}
