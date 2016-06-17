import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Admin on 6/13/2016.
 */
public abstract class Boom implements ISubject {
    public int positionX;
    public int positionY;
    public BufferedImage image,image1,image2,image3;
    public int index=0;
    public int speed=0;
    ArrayList<IObsever> iObsevers;
    public Boom(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        try {
            this.image = ImageIO.read(new File("Resources/Image 805.png"));

            this.image1 = ImageIO.read(new File("Resources/Image 807.png"));

            this.image2 = ImageIO.read(new File("Resources/Image 809.png"));

            this.image3 = ImageIO.read(new File("Resources/Image 811.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        iObsevers = new ArrayList<IObsever>();
    }

    public void draw(Graphics g) {
        if(this.index==0)
        g.drawImage(this.image, this.positionX, this.positionY, null);
        else if(this.index==1){
            g.drawImage(this.image1, this.positionX, this.positionY, null);
        }
        else  if(this.index==2){
            g.drawImage(this.image2, this.positionX, this.positionY, null);
        }
        else if(this.index==3){
            g.drawImage(this.image3, this.positionX, this.positionY, null);
        }
        if(index==3) index=0;
        if(speed>5){
            index++;
            speed=0;
        }
        speed++;
    }

    @Override
    public void register(IObsever iObsever) {
        iObsevers.add(iObsever);
    }

    @Override
    public void cancel(IObsever iObsever) {
        iObsevers.remove(iObsevers);
    }

    @Override
    public void notifyBarrier(int positionX, int positionY) throws IOException, InterruptedException {
        for (IObsever iObsever : iObsevers) {
            iObsever.explosive(positionX,positionY);// denpend on object, will create appropriate method inside ExplosiveBarrier class


        }

    }
}
