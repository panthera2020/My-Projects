public class Amphibians extends Vertebrates{

    public Amphibians(String name, int age, int weight) {
        super(name, age, weight);
    }

    @Override
    public void move() {
        IO.println(name + " is Jumping");
    }
}
