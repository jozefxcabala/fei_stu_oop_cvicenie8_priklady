import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class MyPanel1 extends JPanel {
    private JLabel r;
    private JLabel g;
    private JLabel b;
    private JTextField red;
    private JTextField green;
    private JTextField blue;

    public MyPanel1(){
        this.red = new JTextField();
        this.green = new JTextField();
        this.blue = new JTextField();
        this.r = new JLabel("r");
        this.g = new JLabel("g");
        this.b = new JLabel("b");

        this.setLayout(new GridLayout(6,1));
        this.add(this.r);
        this.add(this.red);
        this.add(this.g);
        this.add(this.green);
        this.add(this.b);
        this.add(this.blue);
    }
}
