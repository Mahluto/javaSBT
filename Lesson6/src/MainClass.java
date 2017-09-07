import java.awt.*;
import javax.swing.*;

public class MainClass {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Calculator frame = new Calculator();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });



    }
}




