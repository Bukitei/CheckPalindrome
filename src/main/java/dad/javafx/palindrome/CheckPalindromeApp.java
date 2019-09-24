package dad.javafx.palindrome;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckPalindromeApp extends Application {

	private TextField sentenceText;
	private Button CompButton;
	private Label palindromLabel;

	public void start(Stage primaryStage) throws Exception {

		sentenceText = new TextField();
		sentenceText.setPromptText("Introduce una sentencia");
		sentenceText.setMaxWidth(150);

		CompButton = new Button();
		CompButton.setText("Comprobar");
		CompButton.setDefaultButton(true);
		CompButton.setOnAction(e -> returnLabel(e));

		palindromLabel = new Label();

		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(sentenceText, CompButton, palindromLabel);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("Comprobación del Palindrome");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {

		launch(args);

	}

	private void returnLabel(ActionEvent e) {
		boolean verdad = comprobarPalindrome();

		if (verdad) {
			palindromLabel.setText("Es palíndromo.");
			palindromLabel.setStyle("-fx-text-fill:green; -fx-font: italic bold 30 consolas;");
		} else {
			palindromLabel.setText("NO es palíndromo.");
			palindromLabel.setStyle("-fx-text-fill:red; -fx-font: italic bold 30 consolas;");
		}
	}

	boolean comprobarPalindrome() {
		String nombre = sentenceText.getText();
		int longitud = nombre.length();

		if (longitud <= 1) {
			return true;
		}
		for (int i = 0; i < longitud / 2; i++) {
			if (nombre.charAt(i) != nombre.charAt(longitud - i - 1)) {
				return false;
			}
		}
		return true;

	}

}
