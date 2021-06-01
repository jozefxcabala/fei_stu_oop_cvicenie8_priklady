import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyWindow2 extends JFrame implements ActionListener {
    private TextArea originalText;
    private TextArea transformedText;
    private JButton transform;

    public MyWindow2(String nameOfWindow) {
        super(nameOfWindow);
        initialize();
        setRules();

    }

    private void setRules(){
        this.originalText.setEditable(true);
        this.transformedText.setEditable(false);
    }

    private void initialize(){
        this.originalText = new TextArea();
        this.transformedText = new TextArea();

        this.transform = new JButton("TRANSFORM");
        this.transform.addActionListener(this);

        this.setLayout(new BorderLayout());

        this.add(this.originalText, BorderLayout.PAGE_START);
        this.add(this.transformedText, BorderLayout.CENTER);
        this.add(this.transform, BorderLayout.PAGE_END);

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = this.originalText.getText();
        String transformedText = transformText(text);
        this.transformedText.setText(transformedText);
    }

    private String transformText(String textInput){
        StringBuilder textOutput = new StringBuilder();

        for(int i = textInput.length() - 1; i >= 0; i--)
        {
            textOutput.append(textInput.charAt(i));
        }

        return textOutput.toString();
    }
}
