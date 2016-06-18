import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by hungtran on 6/12/16.
 */
public class MenuScreen implements Screen {
    Frame frame;
    BufferedImage image1,image2,image3;
    int x,y;
    public Frame getFrame() {
        return frame;
    }
    public MenuScreen(){
        try {
            this.image1 = ImageIO.read(new File("Resources/Image 1239.png"));
            this.image2 = ImageIO.read(new File("Resources/btnhuongdan.png"));
            this.image3 = ImageIO.read(new File("Resources/btnBatDau.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public  void pressM(){
        SupportScreen supportScreen = new SupportScreen();
        supportScreen.setFrame(frame);
        frame.addMouseListener(supportScreen);
        GameManager.getInstance().getStackScreen().push(supportScreen);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.image1,15,40,null);
        g.drawImage(this.image2,150,500,null);
        g.drawImage(this.image3,400,500,null);
    }


}
