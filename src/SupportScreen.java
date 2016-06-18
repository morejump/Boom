import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by hungtran on 6/12/16.
 */
public class SupportScreen implements Screen,MouseListener {
    Frame frame;
    BufferedImage image1,image2,image3;
    int x,y;
    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }
    BufferedImage image5,image6,image7,image8,image9,image10;
    public SupportScreen(){
        try {
            this.image5 = ImageIO.read(new File("Resources/Image 1254.png"));
            this.image6 = ImageIO.read(new File("Resources/Image 1256.png"));
            this.image7 = ImageIO.read(new File("Resources/Image 1258.png"));
            this.image8 = ImageIO.read(new File("Resources/Image 1260.png"));
            this.image9 = ImageIO.read(new File("Resources/Image 1262.png"));
            this.image10 = ImageIO.read(new File("Resources/btnBatDau.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
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
        g.drawImage(this.image5,15,40,null);
        g.drawImage(this.image6,57,120,null);
        g.drawImage(this.image7,35,170,null);
        g.drawImage(this.image8,69,210,null);
        g.drawImage(this.image9,227,210,null);
        g.drawImage(this.image10,116,300,null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = new Point(e.getX(), e.getY());
        Rectangle rectangle3 = new Rectangle(116, 300, 167, 54);
        if (rectangle3.contains(p)) {
            // chuyen sang man hinh play
            pressN();

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
