package project;

import java.io.BufferedReader;
import java.io.FileReader;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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

    private int[] totalByPosition = new int[] {0, 0, 0, 0, 0};
    private ObservableList<Stat> playerStats = FXCollections.observableArrayList();
    private TextField tb = new TextField();
    private TableView<Stat> table = new TableView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("2020/2021 NBA Player Stats");

       //Controls to be added to the HBox
       Label label = new Label("Player Name:");

        Button chartBtn = new Button();
        chartBtn.setText("Chart Button");
        chartBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                PieChartBox.display(totalByPosition);
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

        loadData();
        filterData();

        //table.setItems(playerStats);
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
    

    private void loadData() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/project/nbaplayerstats.csv"));
    
            String[] names = reader.readLine().split(",");
            String line = "";

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(","); 

                try {

                    String player = data[1];
                    String position = data[2];

                    int gamesPlayed = Integer.parseInt(data[5]);
                    int points = Integer.parseInt(data[29]);
                    int rebounds = Integer.parseInt(data[23]);
                    int assists = Integer.parseInt(data[24]);
                    int steals = Integer.parseInt(data[25]);
                    int turnovers = Integer.parseInt(data[27]);

                    playerStats.add(new Stat(player, gamesPlayed, points, rebounds, assists, steals, turnovers));

                    if (position.length() > 2 ) {
                        position = position.substring(0, 2);
                        System.out.println(position);
                    }

                    switch (position) {
                        case "PG" :
                            totalByPosition[0] = totalByPosition[0] + points;
                            break; 
                        case "SG" :
                            totalByPosition[1] = totalByPosition[1] + points;
                            break;
                        case "SF" :
                            totalByPosition[2] = totalByPosition[2] + points;
                            break;
                        case "PF" :
                            totalByPosition[3] = totalByPosition[3] + points;
                            break;
                        case "C" :
                            totalByPosition[4] = totalByPosition[4] + points;
                            break;
                        case "C-" :
                            totalByPosition[4] = totalByPosition[4] + points;
                            break;
                        default:
                            break;
                    }
            
                } catch (Exception ex) {
                    System.out.println("player " + data[1]);
                    ex.printStackTrace();
                }
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void filterData() {      
        
        FilteredList<Stat> filteredData = new FilteredList<>(playerStats, b -> true);
		
		tb.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(stat -> {
				
                //if search field is empty, show record
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
                //if search field matches, show record
				if (stat.getPlayer().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true;
				}

                //hide if not matching
				return false;
			});
		});
		 
		SortedList<Stat> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		table.setItems(sortedData);
               
        
    }

}
