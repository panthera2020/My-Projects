import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Rex");
        Cat cat = new Cat("Whiskers");
        Bird bird = new Bird("Tweety");

        ArrayList<Animal> animals = new ArrayList<Animal>();

        animals.add(dog);
        animals.add(cat);
        animals.add(bird);

        for (Animal animal : animals) {
            IO.println(animal.makeSound());
        }
    }
}
