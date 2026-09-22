public class Mammals extends Vertebrates {

    public Mammals(String name, int age, int weight) {
        super(name, age, weight);
    }

    @Override
    public void move() {
        IO.println(name + " is Walking");
    }
}
