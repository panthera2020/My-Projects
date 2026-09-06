package student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FunctionTest {

    @Test
    public void testThatInputIsValid(){
        Function test = new Function();
        assertTrue(test.isInputValid("1"));
    }

    @Test
    public void testThatNumberOfSubjectIsValid(){
        Function test = new Function();
        assertTrue(test.isNumberOfSubjectValid("10"));
    }
}
