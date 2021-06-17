package project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PieChartBox {

    public static void display(Stat stat) {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Pie Chart");
        window.setMinWidth(600);

        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
            new PieChart.Data("Point Guard", 40),
            new PieChart.Data("Shooting Guard", 40),
            new PieChart.Data("Small Forward", 40),
            new PieChart.Data("Power Forward", 40),
            new PieChart.Data("Center", 40)
        );

        PieChart pChart = new PieChart(pieData);

        pChart.setTitle("Points by Position");

        Group root = new Group(pChart);
        Scene scene = new Scene(root, 600, 400);

        window.setScene(scene);
        window.showAndWait();
    }
}
