import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainClass {

    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Calc frame = new Calc();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}




