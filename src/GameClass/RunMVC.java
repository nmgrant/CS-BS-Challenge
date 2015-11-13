package GameClass;


public class RunMVC {

   public static void main(String[] args) {
      GameModel model = new GameModel();
      GameView frame = new GameView(model);
      GameController controller = new GameController(model, frame);

      frame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
      frame.setVisible(true);
   }
}
