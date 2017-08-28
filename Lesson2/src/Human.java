
public abstract class Human {
    private int height;
    private double weight;
    private String eyeСolor;

    public String getEyeСolor() {
        return eyeСolor;
    }

    public int getHeight() {

        return height;
    }

    public double getWeight() {

        return weight;
    }

    public Human(String eyeСolor, int height, double weight) {
        this.eyeСolor = eyeСolor;
        this.height = height;
        this.weight = weight;
    }

    public abstract void displayInfo();
}
