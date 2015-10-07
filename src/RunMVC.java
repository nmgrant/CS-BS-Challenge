
public class RunMVC {

   public static void main(String[] args) {
      GameModel model = new GameModel();
      GameFrame frame = new GameFrame(model);
      GameController controller = new GameController(model, frame);

      frame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
      frame.setVisible(true);
   }
}
