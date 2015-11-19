package GameClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class RunMVC {

    public static void main(String[] args) {

        GameModel model = new GameModel();
        GameView frame = new GameView(model, new File("Game.dat"));
        GameController controller = new GameController(model, frame);

        frame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

}
