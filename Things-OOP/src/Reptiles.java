public class Reptiles extends Vertebrates{
    public Reptiles(String name, int age, int weight) {
        super(name, age, weight);
    }

    @Override
    public void move() {
        IO.println(name + " is Crawling");
    }
}
