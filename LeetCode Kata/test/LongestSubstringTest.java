import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LongestSubstringTest {

    @Test
    public void testThatWhenIEnterAStringItReturnsLengthOfTheLongestSubstring(){
        LongestSubstring longestSubstring = new LongestSubstring();
        assertEquals(3,longestSubstring.getLengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void testThatWhenIEnterAStringItReturnsLengthOfTheLongestSubstring1(){
        LongestSubstring longestSubstring = new LongestSubstring();
        assertEquals(1,longestSubstring.getLengthOfLongestSubstring("bbbbb"));
    }

    @Test
    public void testThatICanAddTwoStrings(){
        LongestSubstring longestSubstring = new LongestSubstring();
        assertEquals("ab", longestSubstring.addStrings("a", "b"));
    }

    @Test
    public void testThatWhenIGetAString_ReturnsTrueIfStringIsInWord(){
        LongestSubstring longestSubstring = new LongestSubstring();
        assertTrue(longestSubstring.isStringIn("abc","a"));
    }
}
