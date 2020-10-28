/*
    Write a JavaFX Program to create a page with 5 buttons named 
    red, blue, green, pink, black
    On clicking the button, print color name in console
*/
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class JavaFXColor_17BCI0113 extends Application {
    public static void main(String args[]) {
        launch(args);
    }

    public JavaFXColor_17BCI0113() {}

    @Override
    public void start(Stage primaryStage) {
        final String[] colors = {"red", "green", "blue", "pink", "black", "brown"};
        final String[] hex = {"#FF0000", "#00FF00", "#0000FF", "#FFC0CB", "#000000", "#D2691E"};
        Button[] colorBtns = new Button[colors.length];
        final Label text = new Label();
        text.setMaxWidth(Double.MAX_VALUE);
        text.setAlignment(Pos.CENTER);
        int cols = 3;

        VBox root = new VBox();
        primaryStage.setTitle("Hello World!");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));

        for(int i = 0; i < colors.length; i++) {
            final int j = i;
            colorBtns[i] = new Button();
            colorBtns[i].setText(colors[i]);
            colorBtns[i].setOnAction(e -> {
                text.setText(colors[j]);
                colorBtns[j].setStyle("-fx-background-color: " + hex[j]);
            });
            grid.add(colorBtns[i], i % cols, i / cols);
        }

        root.getChildren().add(text);
        root.getChildren().add(grid);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}