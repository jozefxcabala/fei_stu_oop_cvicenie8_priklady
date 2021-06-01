import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetColorButton extends JButton implements ActionListener {
    private MyCanvas1 canvas;
    private MyPanel1 panel;

    public SetColorButton(String nameOfButton, MyCanvas1 canvas, MyPanel1 panel) {
        super(nameOfButton);
        this.canvas = canvas;
        this.panel = panel;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int r, g, b;

        try{
            r = Integer.parseInt(this.panel.getRed().getText());
            g = Integer.parseInt(this.panel.getGreen().getText());
            b = Integer.parseInt(this.panel.getBlue().getText());

            try {
                this.canvas.setColor(new Color(r, g, b));
                String newString = r + "-" + g + "-" + b;
                this.panel.getChoice().remove(3);
                this.panel.getChoice().add(newString);
            }
            catch(IllegalArgumentException c){
                System.out.println("RGB outside of bounderies");
            }
        }
        catch(NumberFormatException n){
            System.out.println("wrong input!");
        }
    }
}
