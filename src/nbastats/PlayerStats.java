package nbastats;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PlayerStats extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World!");

       //Controls to be added to the HBox
       Label label = new Label("Player Name:");
       TextField tb = new TextField();

        Button btn = new Button();
        btn.setText("Search");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        HBox root = new HBox();
        root.getChildren().addAll(label, tb, btn);
        root.setAlignment(Pos.TOP_LEFT);

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();     
    }
    
}
