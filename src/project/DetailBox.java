package project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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


        Text playerText = new Text(stat.getPlayer());
        playerText.setUnderline(true);
        playerText.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        Text gamesPlayedText = new Text("Games Played: " + stat.getGamesPlayed() + "");
        Text gamesStartedText = new Text("Games Started: " + stat.getGamesStarted());
        Text teamText = new Text("Team: " + stat.getTeam());
        Text pointsText = new Text("Points: " + stat.getPoints());
        Text reboundsText = new Text("Rebounds: " + stat.getTotalRebound());
        Text assistsText = new Text("Assists: " + stat.getAssists());
        Text stealsText = new Text("Steals: " + stat.getSteals());
        Text turnoversText = new Text("Turnovers: " + stat.getTurnovers());

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> {
            window.close();
        });

        GridPane bodyLayout = new GridPane();
        bodyLayout.setHgap(35);
        bodyLayout.setVgap(10);
        bodyLayout.setAlignment(Pos.CENTER);
        bodyLayout.setPadding(new Insets(0, 10, 0, 10));

        //first row
        bodyLayout.add(playerText, 1, 0);

        //second row
        bodyLayout.add(teamText, 0, 1);
        bodyLayout.add(gamesPlayedText, 1, 1);
        bodyLayout.add(gamesStartedText, 2, 1);

        //third row
        bodyLayout.add(pointsText, 0, 2);
        bodyLayout.add(reboundsText, 1, 2);
        bodyLayout.add(assistsText, 2, 2);

        //fourth row
        bodyLayout.add(stealsText, 0, 3);
        bodyLayout.add(turnoversText, 1, 3);

        //sixth row
        bodyLayout.add(closeButton, 1,5);

        Scene scene = new Scene(bodyLayout);
        window.setScene(scene);
        window.showAndWait();
    }
    
}
