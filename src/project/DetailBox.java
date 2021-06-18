package project;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * 
 * Generates the window that pops up and displays the detailed statistics of a player.
 * @author Alyanna Santos
 * 
 */
public class DetailBox {

    public static void display(Stat stat) {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Player Info");
        window.setMinWidth(400);

        Label label = new Label();
        label.setText(stat.getPlayer());

        Label gamesPlayedLabel = new Label();
        gamesPlayedLabel.setText("Games Played: " + stat.getGamesPlayed() + "");

        Label pointsLabel = new Label();
        pointsLabel.setText("Points: " + stat.getPoints() + "");

        Label reboundsLabel = new Label();
        reboundsLabel.setText("Rebounds: " + stat.getTotalRebound() + "");

        Label assistsLabel = new Label();
        assistsLabel.setText("Assists: " + stat.getAssists() + "");

        Label stealsLabel = new Label();
        stealsLabel.setText("Steals: " + stat.getSteals() + "");

        Label turnoversLabel = new Label();
        turnoversLabel.setText("Turnovers: " + stat.getTurnovers() + "");

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> {
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, 
                                    gamesPlayedLabel, 
                                    pointsLabel, 
                                    reboundsLabel, 
                                    assistsLabel, 
                                    stealsLabel, 
                                    turnoversLabel, 
                                    closeButton);

        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }
    
}
