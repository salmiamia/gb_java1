package java2.lesson1;

import java.awt.*;


public class Background {
    static int x = 0;

    static void setBackground(GameCanvas canvas) {
        Color c = new Color(x, x, x);
        canvas.setBackground(c);
            x++;
            if (x == 256) {
                x = 0;
        }
    }
}