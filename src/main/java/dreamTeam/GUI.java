package dreamTeam;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        GridPane g1 = new GridPane();

        Scene scene = new Scene(g1,300,200);

        g1.getColumnConstraints().add(new ColumnConstraints(25));
        g1.getColumnConstraints().add(new ColumnConstraints(50));


        Button b1 = new Button("Hallo");

        GridPane.setRowIndex(b1, 0);
        GridPane.setColumnIndex(b1, 0);
        //g1.getChildren().add(b1);
        //g1.add(new TextField(), 0, 0);
        //g1.add(new TextField(), 1, 0);
        g1.getChildren().add(b1);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
