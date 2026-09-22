public class Pisces  extends Vertebrates{

    public Pisces(String name, int age, int weight) {
        super(name, age, weight);
    }

    @Override
    public void move(){
        IO.println(name + " is Moving");
    }
}
