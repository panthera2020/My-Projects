import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @Test
    public void testThatWhenIGetAWord_AndIGetACharacter_IReturnTheNumberOfOccurenceInWord() {
        MyString myString = new MyString();
        assertEquals(2,myString.getOccurrenceOfCharacterIn("Village","l"));
    }
}
