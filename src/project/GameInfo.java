package project;

import java.io.BufferedReader;
import java.io.FileReader;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameInfo extends Application {


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

        Button chartBtn = new Button();
        chartBtn.setText("Chart Button");
        chartBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                PieChartBox.display(null);
            }
        });

        Button closeBtn = new Button();
        closeBtn.setText("Close");
        closeBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        
        TableColumn<Stat, String> playerColumn = new TableColumn<>("Player");
        playerColumn.setMinWidth(200);
        playerColumn.setCellValueFactory(new PropertyValueFactory<>("player"));

        TableColumn<Stat, Integer> gamesPlayedColumn = new TableColumn<>("GP");
        gamesPlayedColumn.setMinWidth(100);
        gamesPlayedColumn.setCellValueFactory(new PropertyValueFactory<>("gamesPlayed"));

        TableColumn<Stat, Integer> pointsColumn = new TableColumn<>("Points");
        pointsColumn.setMinWidth(100);
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));

        TableColumn<Stat, Integer> reboundsColumn = new TableColumn<>("Rebounds");
        reboundsColumn.setMinWidth(100);
        reboundsColumn.setCellValueFactory(new PropertyValueFactory<>("totalRebound"));

        TableColumn<Stat, Integer> assistsColumn = new TableColumn<>("Assists");
        assistsColumn.setMinWidth(100);
        assistsColumn.setCellValueFactory(new PropertyValueFactory<>("assists"));

        TableColumn<Stat, Integer> stealsColumn = new TableColumn<>("Steals");
        stealsColumn.setMinWidth(100);
        stealsColumn.setCellValueFactory(new PropertyValueFactory<>("steals"));

        TableColumn<Stat, Integer> turnoversColumn = new TableColumn<>("Turnovers");
        turnoversColumn.setMinWidth(100);
        turnoversColumn.setCellValueFactory(new PropertyValueFactory<>("turnovers"));

        TableView<Stat> table = new TableView<>();
        table.setItems(getPlayerStatsFromCsv());
        table.getColumns().addAll(playerColumn, 
                                    gamesPlayedColumn,
                                    pointsColumn,
                                    reboundsColumn, 
                                    assistsColumn, 
                                    stealsColumn, 
                                    turnoversColumn);

        table.setOnMouseClicked((MouseEvent event) -> {
            if(event.getClickCount() == 2) {
                System.out.println(table.getSelectionModel().getSelectedItem());
                DetailBox.display(table.getSelectionModel().getSelectedItem());
            }
        });
        
        VBox root = new VBox();
        root.getChildren().addAll(label, tb, btn, table, chartBtn, closeBtn);

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();     
    }
    
    private ObservableList<Stat> getPlayerStats() {
        ObservableList<Stat> playerStats = FXCollections.observableArrayList();
        playerStats.add(new Stat("Curry", 67, 2500, 120, 300, 56, 100));
        playerStats.add(new Stat("Durant", 66, 2200, 100, 150, 44, 111));
        playerStats.add(new Stat("Irving", 64, 2400, 120, 434, 33, 121));
        playerStats.add(new Stat("James", 65, 2300, 120, 333, 44, 133));
        playerStats.add(new Stat("Doncic", 63, 2200, 120, 443, 66, 123));

        return playerStats;
    }

    private ObservableList<Stat> getPlayerStatsFromCsv() {
        ObservableList<Stat> playerStats = FXCollections.observableArrayList();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/project/nbaplayerstats.csv"));
    
            String[] names = reader.readLine().split(",");
            System.out.println(names[1]);
            System.out.println(names[5]);
            System.out.println(names[29]);
            System.out.println(names[23]);
            System.out.println(names[24]);
            System.out.println(names[25]);
            System.out.println(names[27]);

            String line = "";

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(","); 

                try {

                    String player = data[1];

                    int gamesPlayed = Integer.parseInt(data[5]);
                    int points = Integer.parseInt(data[29]);
                    int rebounds = Integer.parseInt(data[23]);
                    int assists = Integer.parseInt(data[24]);
                    int steals = Integer.parseInt(data[25]);
                    int turnovers = Integer.parseInt(data[27]);

                    playerStats.add(new Stat(player, gamesPlayed, points, rebounds, assists, steals, turnovers));
            
                } catch (Exception ex) {
                    System.out.println("player " + data[1]);
                    ex.printStackTrace();
                }
            }
    
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return playerStats;
    }

}
