import java.util.Stack;

/**
 * Created by hungtran on 6/12/16.
 */
public class GameManager {
    private Stack<Screen> stackScreen;
    private static GameManager ourInstance = new GameManager();

    public static GameManager getInstance() {
        return ourInstance;
    }

    private GameManager() {
        stackScreen = new Stack<>();
    }

    public Stack<Screen> getStackScreen() {
        return stackScreen;
    }
}
