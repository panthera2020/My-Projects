import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Problem> problems = new ArrayList<Problem>();
    private List<Problem> unsolvedProblems = new ArrayList<Problem>();
    public void addProblem(String name, ProblemType  problemType) {
        Problem newProblem = new Problem(name, problemType);
        problems.add(newProblem);
    }

    public void solveProblem(String problemName) {
        for(Problem thatProblem : problems){
            if(thatProblem.getName().equals(problemName)){
                thatProblem.changeStatus();
            }
        }
    }

    public List<Problem> tellProblem(){
        for(Problem thatProblem : problems){
            if(!thatProblem.getStatus()){
                unsolvedProblems.add(thatProblem);
            }
        }
        return unsolvedProblems;
    }
}
