import java.awt.*;

/**
 * Created by hungtran on 6/12/16.
 */
public class MenuScreen implements Screen {
    Frame frame;

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void pressN() {
        PlayScreen playScreen = new PlayScreen();
        frame.addKeyListener(playScreen);
        GameManager.getInstance().getStackScreen().push(playScreen);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.drawString("MENU SCREEN", 300, 400);
    }


}
