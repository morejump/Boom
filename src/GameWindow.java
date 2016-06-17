import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by admin on 6/11/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Image background;
    BufferedImage bufferedImage;
    ArrayList<ExplosiveBarrier> explosiveBarriers;
    Player player;
    Pirate pirate;
    long startTime;
    public GameWindow() {// constructor
        this.setSize(750, 650);
        this.setTitle("Boom- Đồi Cô Lựu");
        this.setVisible(true);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });// closing window
        pirate = new Pirate(400, 500, "haitac");
        player = new Player(400, 400, "player");
        explosiveBarriers = new ArrayList<ExplosiveBarrier>();
        explosiveBarriers.add(new ExplosiveBarrier(600, 400, "Gach"));
        explosiveBarriers.add(new ExplosiveBarrier(350, 400, "Gach"));
        explosiveBarriers.add(new ExplosiveBarrier(200, 400, "Gach"));
        explosiveBarriers.add(new ExplosiveBarrier(100, 400, "Gach"));
        explosiveBarriers.add(new ExplosiveBarrier(600, 350, "Gach"));
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //vua an phim
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //phim duoc an va giu
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        player.speedY = -6;
                        break;
                    case KeyEvent.VK_LEFT:
                        player.speedX = -6;
                        break;
                    case KeyEvent.VK_DOWN:
                        player.speedY = 6;
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.speedX = 6;
                        break;
                    case KeyEvent.VK_SPACE:
                        if (player.boomPlayers.size() == 0) {
                            startTime = System.currentTimeMillis();// starting count time here form time of droping bomb
                            BoomPlayer boomPlayer = player.dropBoom();
                            boomPlayer.register(pirate);
                            for (ExplosiveBarrier explosiveBarrier : explosiveBarriers) {
                                if (getDistance(explosiveBarrier.positionX + 45, explosiveBarrier.positionY + 45, boomPlayer.positionX + 45, boomPlayer.positionY + 45) <= 120) {
                                    boomPlayer.register(explosiveBarrier);// checking a distance before register

                                }
                            }
                        }
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.speedX = 0;
                player.speedY = 0;
            }
        });// catch key and move
        try {
            background = ImageIO.read(new File("Resources/Background.png"));// set background
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gameUpdate() throws InterruptedException {
        player.update();
        pirate.update();
        if (System.currentTimeMillis() - startTime>=2000){// calcuting time to explosive bomb here :))
            for (BoomPlayer boomPlayer1 : player.boomPlayers) {
                try {
                    boomPlayer1.notifyBarrier(boomPlayer1.positionX,boomPlayer1.positionY);

                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            player.boomPlayers.clear();// after explosiving barrier, then delete remove all bomb from arraylist :)
        }

    }

    @Override
    public void update(Graphics g) {
        if (bufferedImage == null) {
            bufferedImage = new BufferedImage(750, 650, 1);
        }
        Graphics bufferedGraphics = bufferedImage.getGraphics();
        bufferedGraphics.drawImage(background, 0, 0, null);
        player.draw(bufferedGraphics);
        pirate.draw(bufferedGraphics);
        for (ExplosiveBarrier explosiveBarrier : explosiveBarriers) {
            explosiveBarrier.draw(bufferedGraphics);
        }
        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void run() {
        while (true) {
            try {

                Thread.sleep(17);
                gameUpdate();
                repaint();// this method will invoke update method above which is overided
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}

