import java.io.IOException;

/**
 * Created by Admin on 6/15/2016.
 */
public interface ISubject {
    void register(IObsever iObsever);
    void cancel(IObsever iObsever);
    void notifyBarrier(int positionX, int positionY) throws IOException, InterruptedException;
}
