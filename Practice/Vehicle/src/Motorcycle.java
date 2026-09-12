public class Motorcycle extends Vehicle {
    private boolean hasSideCar;

    public Motorcycle(String brand, int topSpeed, boolean hasSideCar) {
        super(brand, topSpeed);
        this.hasSideCar = hasSideCar;
    }

    public String getBrand() {
        return super.getBrand();
    }

    public int getTopSpeed() {
        return super.getTopSpeed();
    }

    public String isSideCarThere() {
        String sideCar = "";
        if(hasSideCar){
            sideCar = "has side car" ;
        }else{
            sideCar = " does not have side car";
        }
        return sideCar;
    }

    public String describe(){
        return "This is a " + getBrand() + " with a Top Speed Of " + getTopSpeed() + " and " + isSideCarThere();
    }

}
