import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observer;

/**
 * Created by Admin on 6/15/2016.
 */
public class Player extends Character implements IObsever {
    ArrayList<BoomPlayer> boomPlayers;
    boolean isLive = true;

    public Player(int positionX, int positionY, String pathImage) {
        super(positionX, positionY, pathImage);
        boomPlayers = new ArrayList<BoomPlayer>();
    }

    @Override
    public void draw(Graphics g) {

        g.drawImage(this.image1,this.positionX+15,this.positionY+60,null);
        g.drawImage(this.image, this.positionX, this.positionY, null);
        for (BoomPlayer boomPlayer : boomPlayers) {
            boomPlayer.draw(g);
        }
    }

    @Override
    public void update() throws InterruptedException {
        super.update();
    }

    @Override
    public BoomPlayer dropBoom() {
        BoomPlayer boomPlayer = new BoomPlayer(this.positionX+10, this.positionY+40);
        boomPlayers.add(boomPlayer);
        return  boomPlayer;
    }

    @Override
    public void explosive(int positionX, int positionY) throws IOException, InterruptedException {
        if (this.getDistance(this.positionX, this.positionY, positionX, positionY) <= 100) {
            isLive = false;
        }
    }

    public double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
    }
}
