public class Problem {
    private final String name;
    private final ProblemType ProblemType;
    private boolean status = false;

    public Problem(String name, ProblemType ProblemType) {
        this.name = name;
        this.ProblemType = ProblemType;
    }

    public String getName() {
        return name;
    }

    public void changeStatus(){
        this.status = true;
    }

    public boolean getStatus(){
        return status;
    }
}
