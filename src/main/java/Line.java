import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Line {
    private int x;
    private int y;
    private Color color;

    public Line(){
        this.x = 0;
        this.y = 0;
        this.color = new Color(0,0,0);
    }

}
