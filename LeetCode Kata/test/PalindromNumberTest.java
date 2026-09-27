import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromNumberTest {

    @Test
    public void TestThatWhenIGetAPalindromeNumberReturnsTrue() {
        PalindromNumber palindrome = new PalindromNumber();
        assertTrue(palindrome.isNumberPalindrome(121));
        assertFalse(palindrome.isNumberPalindrome(123));
    }


}
