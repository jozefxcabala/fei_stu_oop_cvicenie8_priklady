import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyCanvas1 extends JPanel implements MouseMotionListener, MouseListener {
    private final Point startPoint;
    @Getter @Setter
    private Color color;
    private Point actualPosition;
    private ArrayList<Line> listOfLines;
    private ArrayList<Point> listOfPoints;
    private boolean pressed;

    public MyCanvas1(){
        this.setBackground(Color.WHITE);
        this.color = new Color(0,0,0);
        this.startPoint = new Point();
        this.actualPosition = new Point();
        this.listOfPoints = new ArrayList<>();
        this.listOfLines = new ArrayList<>();
        this.pressed = false;
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        this.setPreferredSize(new Dimension(300, 300));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));

        g.setColor(this.color);

        for(int i = 0; i < this.listOfLines.size(); i++){
            for(int j = 0; j < this.listOfLines.get(i).getListOfPoints().size()-1; j++ ) {
                g.setColor(this.listOfLines.get(i).getColor());
                g.drawLine(this.listOfLines.get(i).getListOfPoints().get(j).x, this.listOfLines.get(i).getListOfPoints().get(j).y, this.listOfLines.get(i).getListOfPoints().get(j + 1).x, this.listOfLines.get(i).getListOfPoints().get(j + 1).y);
            }
        }

        for(int j = 0; j < this.listOfPoints.size()-1; j++ ) {
            g.setColor(this.color);
            g.drawLine(this.listOfPoints.get(j).x, this.listOfPoints.get(j).y, this.listOfPoints.get(j + 1).x, this.listOfPoints.get(j + 1).y);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.pressed = true;
        this.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.actualPosition.x = e.getX();
        this.actualPosition.y = e.getY();
        this.listOfPoints.add(new Point(this.actualPosition));
        this.repaint();
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.pressed = false;
        this.listOfLines.add(new Line(this.listOfPoints, this.color));
        this.listOfPoints = new ArrayList<>();
        this.repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
