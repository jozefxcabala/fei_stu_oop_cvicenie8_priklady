import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxPanel extends JPanel implements ItemListener {
    private JCheckBox checkBoxR;
    private JCheckBox checkBoxG;
    private JCheckBox checkBoxB;

    private MyCanvas1 canvas;

    public CheckBoxPanel(MyCanvas1 canvas){
        this.canvas = canvas;

        this.setLayout(new GridLayout(1,3));

        this.checkBoxR = new JCheckBox("RED");
        this.checkBoxR.addItemListener(this);
        this.checkBoxG = new JCheckBox("GREEN");
        this.checkBoxG.addItemListener(this);
        this.checkBoxB = new JCheckBox("BLUE");
        this.checkBoxB.addItemListener(this);

        this.add(this.checkBoxR);
        this.add(this.checkBoxG);
        this.add(this.checkBoxB);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(this.checkBoxR.isSelected() && this.checkBoxG.isSelected() && this.checkBoxB.isSelected()){
            this.canvas.setColor(Color.WHITE);
        }
        else if(!this.checkBoxR.isSelected() && !this.checkBoxG.isSelected() && !this.checkBoxB.isSelected()){
            this.canvas.setColor(Color.BLACK);
        }
        else if(this.checkBoxR.isSelected() && this.checkBoxG.isSelected() && !this.checkBoxB.isSelected()){
            this.canvas.setColor(Color.YELLOW);
        }
        else if(this.checkBoxR.isSelected() && !this.checkBoxG.isSelected() && this.checkBoxB.isSelected()){
            this.canvas.setColor(Color.PINK);
        }
        else if(!this.checkBoxR.isSelected() && !this.checkBoxG.isSelected() && this.checkBoxB.isSelected()){
            this.canvas.setColor(Color.BLUE);
        }
        else if(!this.checkBoxR.isSelected() && this.checkBoxG.isSelected() && !this.checkBoxB.isSelected()){
            this.canvas.setColor(Color.GREEN);
        }
        else if(this.checkBoxR.isSelected() && !this.checkBoxG.isSelected() && !this.checkBoxB.isSelected()){
            this.canvas.setColor(Color.RED);
        }
        else if(!this.checkBoxR.isSelected() && this.checkBoxG.isSelected() && this.checkBoxB.isSelected()){
            this.canvas.setColor(new Color(64,224,208));
        }
    }
}
