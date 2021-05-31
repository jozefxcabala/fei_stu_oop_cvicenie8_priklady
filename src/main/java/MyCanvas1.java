import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyCanvas1 extends Canvas implements MouseMotionListener, MouseListener {
    private final Point startPoint;
    @Getter @Setter
    private Color color;
    private Point actualPosition;
    private ArrayList<ArrayList<Point>> listOfLines;
    private ArrayList<Point> listOfPoints;
    private boolean pressed;

    public MyCanvas1(){
        this.setBackground(Color.WHITE);
        this.setSize(300,300);
        this.color = new Color(0,0,0);
        this.startPoint = new Point();
        this.actualPosition = new Point();
        this.listOfPoints = new ArrayList<>();
        this.listOfLines = new ArrayList<>();
        this.pressed = false;
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));

        g.setColor(this.color);

        for(int i = 0; i < this.listOfLines.size(); i++){
            for(int j = 0; j < this.listOfLines.get(i).size()-1; j++ ) {
                g.drawLine(this.listOfLines.get(i).get(j).x, this.listOfLines.get(i).get(j).y, this.listOfLines.get(i).get(j + 1).x, this.listOfLines.get(i).get(j + 1).y);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.pressed = true;
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
        this.listOfLines.add(this.listOfPoints);
        this.listOfPoints = new ArrayList<>();

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
