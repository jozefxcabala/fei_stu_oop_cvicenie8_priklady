import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

@Getter
@Setter
public class MyPanel1 extends JPanel implements ItemListener {
    private JLabel r;
    private JLabel g;
    private JLabel b;
    private JTextField red;
    private JTextField green;
    private JTextField blue;

    private JLabel choose;
    private Choice choice;
    private String listOfColors[];
    private MyCanvas1 canvas;

    private CheckBoxPanel checkBoxPanel;

    public MyPanel1(MyCanvas1 canvas){
        this.canvas = canvas;
        this.red = new JTextField();
        this.green = new JTextField();
        this.blue = new JTextField();
        this.r = new JLabel("r");
        this.g = new JLabel("g");
        this.b = new JLabel("b");
        this.checkBoxPanel = new CheckBoxPanel(this.canvas);


        this.choose = new JLabel("Choose color ");
        this.listOfColors = new String[]{"RED", "BLUE", "GREEN", "SINGLE INPUT"};

        this.choice = new Choice();
        this.choice.addItemListener(this);
        addItemToChoice();

        this.setLayout(new GridLayout(9,1));
        this.add(this.r);
        this.add(this.red);
        this.add(this.g);
        this.add(this.green);
        this.add(this.b);
        this.add(this.blue);
        this.add(this.choose);
        this.add(this.choice);
        this.add(this.checkBoxPanel);
        this.setVisible(true);
    }

    private void addItemToChoice(){
        for(int i = 0; i < this.listOfColors.length; i++){
            this.choice.add(this.listOfColors[i]);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("Choose color is: " + e.getItem().toString());
        if(e.getItem().toString().equals("RED")){
            this.canvas.setColor(Color.RED);
        }
        else if(e.getItem().toString().equals("BLUE")){
            this.canvas.setColor(Color.BLUE);
        }
        else if(e.getItem().toString().equals("GREEN")){
            this.canvas.setColor(Color.GREEN);
        }
        else if(e.getItem().toString().equals("SINGLE INPUT")){
            System.out.println("COLOR IS NOT CHANGED");
        }
        else{
            String[] newColor = splitString(e.getItem().toString());
            this.canvas.setColor(new Color(Integer.parseInt(newColor[0]), Integer.parseInt(newColor[1]), Integer.parseInt(newColor[2])));
        }
    }

    private String[] splitString(String colorRGB){
        return colorRGB.split("-");
    }
}
