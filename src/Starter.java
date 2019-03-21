import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Program that uses keyboard macros to type a, q, s, A, Q, and S.
 * @author wntan
 *
 */
public class Starter extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = new AreaPane();
		Scene scene = new Scene(root, 900, 620);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
