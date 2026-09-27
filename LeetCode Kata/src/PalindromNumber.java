public class PalindromNumber {
    public boolean isNumberPalindrome(int number) {
        if (number < 0) return false;
        int store = number;
        boolean isPalindrome = false;
        int reversed = 0;
        while (number != 0) {
            int lastDigit = number % 10;
            reversed = reversed * 10 + lastDigit;
            number = number / 10;
        }

        if (store == reversed) {
            isPalindrome = true;
        }
        return isPalindrome;
    }
}
