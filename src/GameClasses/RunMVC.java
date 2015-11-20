package GameClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RunMVC {

    public static void main(String[] args) {

        File gameFile = new File("Game.dat");
        GameModel model = loadGame(gameFile);
        GameView frame = new GameView(model, gameFile);
        GameController controller = new GameController(model, frame);

        frame.setVisible(true);
    }

    public static GameModel loadGame(File gameFile) {
        GameModel model = new GameModel();

        Object[] options = {"Yes", "No"};
        int loadGame = JOptionPane.showOptionDialog(new JFrame(), "Would you like to load your "
                + "most recently saved game?", "Load Game", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        if (loadGame == 0) {
            if (gameFile.exists()) {
                try {
                    ObjectInputStream in = new ObjectInputStream(
                            new FileInputStream(gameFile));

                    model = (GameModel) in.readObject();
                    in.close();
                    System.out.println("Game loaded.");
                } catch (IOException e) {
                    System.out.println("Error processing file.");
                } catch (ClassNotFoundException c) {
                    System.out.println("Class not found.");
                }
            }
        }
        return model;
    }
}
