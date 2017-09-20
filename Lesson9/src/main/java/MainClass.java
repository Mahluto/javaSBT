import service.Service;
        import serviceImp.ServiceImp;

        import java.io.IOException;


public class MainClass {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Service service = new ServiceImp();
        double r = service.doHardWork("work1", 10, "data1.dat");
    }
}