import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
/**
 * Text Area for typing, listens for keystroke combinations to type out other characters.
 * Displays labels on what those key combinations are at the top
 * 
 * @author wntan
 *
 */
public class AreaPane extends BorderPane {
	private TextArea area;

	public AreaPane() {
		super();
		
		// alt+shift key combo labels
		HBox bshift = new HBox();
		// alt key combo labels
		HBox balt = new HBox();

		// labels for alt combos
		Label shiftCodesZ = new Label("alt + x = z");
		Label shiftCodesS = new Label("alt + s = a");
		Label shiftCodesQ = new Label("alt + w = q");
		balt.getChildren().addAll(shiftCodesZ,shiftCodesS, shiftCodesQ);
		
		balt.setStyle("-fx-padding: 5");
		bshift.setStyle("-fx-padding: 5");
		
		balt.setSpacing(15);
		bshift.setSpacing(15);
		
		// labels for alt+shift combos
		Label altCodesZ = new Label("alt shift + x = Z");
		Label altCodesS = new Label("alt shift + s = A");
		Label altCodesQ = new Label("alt shift + w = Q");
		bshift.getChildren().addAll(altCodesZ, altCodesS, altCodesQ);
		
		// hold the labels in two different boxes at top of pane for display
		VBox codeBox = new VBox();
		codeBox.getChildren().addAll(bshift, balt);
		
		this.setTop(codeBox);
		
		// main body of pane is the text area
		area = new TextArea();
		area.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// listen for alt key combos
				if (event.isAltDown() && !event.isShiftDown()) {
					if (event.getCode() == KeyCode.X)
						area.appendText("z");
					if (event.getCode() == KeyCode.S)
						area.appendText("a");
					if (event.getCode() == KeyCode.W)
						area.appendText("q");

				}
				// listen for alt+shift combos
				if (event.isShiftDown() && event.isAltDown()) {
					if (event.getCode() == KeyCode.X)
						area.appendText("Z");
					if (event.getCode() == KeyCode.S)
						area.appendText("A");
					if (event.getCode() == KeyCode.W)
						area.appendText("Q");
				}

			}

		});

		this.setCenter(area);

	}
}
