public class Problem {
    private final String name;
    private final String description;
    private final String ProblemType;
    private boolean status;

    public Problem(String name, String description, String ProblemType) {
        this.name = name;
        this.description = description;
        this.ProblemType = ProblemType;
    }
}
