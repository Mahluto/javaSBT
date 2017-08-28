
public class Client extends Person implements ClientQuestions{

    private String bank;

    public Client(String company, String name, String surname, String eyeColor, int height, double weight) {

        super("Tim", "Jons", "Back", 172, 81);
        this.bank = company;

    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Банк: " + this.bank);
    }

    public void questionAboutBankAccount() {
        System.out.println("What types of accounts does your bank have?");
    }

    public void questionAboutСondition(){
        System.out.println("What conditions does your bank provide to new clients?");
    }

}
