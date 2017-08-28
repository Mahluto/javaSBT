
public class Person extends Human{

    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Person(String name, String surname, String eyeСolor, int height, double weight) {
        super(eyeСolor, height, weight);
        this.name = name;
        this.surname = surname;
    }

    public void displayInfo() {
        System.out.println("Имя: " + this.name);
        System.out.println("Фамилия: " + this.surname);
        System.out.println("Рост: " + super.getHeight());
        System.out.println("Вес: " + super.getWeight());
        System.out.println("Цвет глаз: " + super.getEyeСolor());

    }

}
