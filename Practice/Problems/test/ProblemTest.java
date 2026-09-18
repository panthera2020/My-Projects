import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProblemTest {

    @Test
    public void TestThatPersonCanAddOneProblem() {
        Person person = new Person();
        person.addProblem("Gbese",ProblemType.FINANCIAL);
        assertEquals(1,person.tellProblem().size());
    }

    @Test
    public void TestThatPersonCanAddOneProblemAndSolveProblemStatusOfProblemIsSolved() {
        Person person = new Person();
        person.addProblem("Gbese",ProblemType.FINANCIAL);
        person.solveProblem("Gbese");
        assertEquals(0,person.tellProblem().size());
    }
}
