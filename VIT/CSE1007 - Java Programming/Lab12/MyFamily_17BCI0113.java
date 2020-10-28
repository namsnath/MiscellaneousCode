import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
import java.sql.*;

public class MyFamily_17BCI0113 extends Application {
    static Connection conn;

    public static void main(String args[]) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver loaded");

            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/MyFamily_17BCI0113",
                "namsnath",
                "namsnath"
            );
        } catch(Exception e) {
            System.err.println("Exception");
            System.err.println(e);
            System.err.println(e.getMessage());
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String[] labelText = {
            "Name", "Relationship", "Favorite Color",
            "Favorite Place", "Phone Number", "DoB"
        };
        Label[] labels = new Label[labelText.length];
        final TextField[] textFields = new TextField[labels.length - 1];
        final DatePicker dobField = new DatePicker();
        final Button submitBtn = new Button();
        final VBox root = new VBox();
        final GridPane fieldsGrid = new GridPane();

        primaryStage.setTitle("My Family 17BCI0113");

        root.setAlignment(Pos.CENTER);

        fieldsGrid.setHgap(10);
        fieldsGrid.setVgap(10);
        fieldsGrid.setAlignment(Pos.CENTER);
        fieldsGrid.setPadding(new Insets(25, 25, 25, 25));

        for (int i = 0; i < labels.length; i++) {
            labels[i] = new Label(labelText[i]);
            fieldsGrid.add(labels[i], 0, i);

            if (i < labels.length - 1) {
                textFields[i] = new TextField();
                fieldsGrid.add(textFields[i], 1, i);
            } else {
                fieldsGrid.add(dobField, 1, i);
            }
        }

        submitBtn.setText("Submit");
        submitBtn.setOnAction(e -> {
            String values[] = new String[textFields.length];
            for(int i = 0; i < textFields.length; i++) {
                values[i] = textFields[i].getText();
            }
            Date d = Date.valueOf(dobField.valueProperty().get());

            submitData(values, d);
        });

        root.getChildren().add(fieldsGrid);
        root.getChildren().add(submitBtn);

        primaryStage.setScene(new Scene(root, 400, 350));
        primaryStage.show();
    }

    public void submitData(String[] values, Date date) {
        try {
            String query = "INSERT INTO Family VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = MyFamily_17BCI0113.conn.prepareStatement(query);
            for (int i = 0; i < values.length; i++) {
                stmt.setString(i+1, values[i]);
            }

            stmt.setDate(values.length + 1, date);

            stmt.execute();
        } catch(Exception e) {
            System.err.println("Exception");
            System.err.println(e);
            System.err.println(e.getMessage());
        }
    }
}