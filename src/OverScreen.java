import java.awt.*;

/**
 * Created by hungtran on 6/12/16.
 */
public class OverScreen implements Screen {
    @Override
    public void pressN() {
        System.out.println("Het cmnr");
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.drawString("OVER SCREEN", 300, 400);
    }


}
