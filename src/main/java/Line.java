import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;

@Getter
@Setter
public class Line {
    private ArrayList<Point> listOfPoints;
    private Color color;

    public Line(ArrayList<Point> listOfPoints, Color color){
        this.listOfPoints = listOfPoints;
        this.color = color;
    }

}
