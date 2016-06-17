import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Admin on 6/15/2016.
 */
public class Pirate extends Character implements IObsever {
    ArrayList<BoomPirate> boomPirates;

    public Pirate(int positionX, int positionY, String pathImage) {
        super(positionX, positionY, pathImage);
        boomPirates = new ArrayList<BoomPirate>();
    }

    @Override
    public void update() throws InterruptedException {
        Random random = new Random();
        int x = random.nextInt(100);
        if (x == 0 && positionX - 3 >= 0) {// pirate moves to left side
            int count = 0;
            while (count != 20) {

                count++;
                this.speedX = -3;
                this.speedY = 0;
                super.update();
            }

        } else if (x == 1 && positionX + 90 + 3 <= 750) {// pirate moves to right side
            int count = 0;
            while (count != 20) {
                count++;
                this.speedX = +3;
                this.speedY = 0;
                super.update();
            }
        } else if (x == 2 && positionY - 3 >= 0) {// pirate move go up
            int count = 0;
            while (count != 20) {
                count++;
                this.speedX = 0;
                this.speedY = -3;
                super.update();
            }
        } else if (x == 3 && positionY + 90 + 3 <= 650) {// pirate move go down
            int count = 0;
            while (count != 20) {
                count++;
                this.speedX = 0;
                this.speedY = 3;
                super.update();
            }

        } else if (x >= 4 || x <= 99) {
            int count = 0;
            while (count != 20) {
                count++;
                this.speedX = 0;
                this.speedY = 0;
                super.update();
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.image, this.positionX, this.positionY, null);
        for (BoomPirate boomPirate : boomPirates) {
            boomPirate.draw(g);
        }
    }

    @Override
    public BoomPirate dropBoom() {
        BoomPirate boomPirate = new BoomPirate(this.positionX, this.positionY);
        boomPirates.add(boomPirate);
        return boomPirate;

    }

    @Override
    public void explosive(int positionX, int positionY) throws IOException, InterruptedException {
        // action for pirate after bomb explosives (checking a current distance with bomb)
        if (this.getDistance(this.positionX, this.positionY, positionX, positionY) <= 200) {
            System.out.println("Em bi no roi nhe");// just test
        }
    }

    public double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}
