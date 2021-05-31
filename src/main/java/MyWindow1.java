import javax.swing.*;
import java.awt.*;

public class MyWindow1 extends JFrame {
    private MyPanel1 panelOfTextFields;
    private MyCanvas1 myCanvas1;
    private SetColorButton setColorButton;

    public MyWindow1(String nameOfWindow){
        super(nameOfWindow);
        this.setLayout(new BorderLayout());

        this.panelOfTextFields = new MyPanel1();
        this.myCanvas1 = new MyCanvas1();
        this.setColorButton = new SetColorButton("Set Color", this.myCanvas1, this.panelOfTextFields);

        this.add(this.panelOfTextFields, BorderLayout.PAGE_START);
        this.add(this.setColorButton, BorderLayout.CENTER);
        this.add(this.myCanvas1, BorderLayout.PAGE_END);

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
