import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(7);
        Rectangle rectangle = new Rectangle(5, 5);

        ArrayList<Shapes> shapes = new ArrayList<>();

        shapes.add(circle);
        shapes.add(rectangle);

        for (Shapes shape : shapes) {
            IO.println(shape.describe());
        }
    }
}
