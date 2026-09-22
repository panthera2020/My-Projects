public class Aves extends Vertebrates {

    public Aves(String name, int age, int weight) {
        super(name, age, weight);
    }

    public void move(){
        IO.println(name + " is Flying");
    }
}
