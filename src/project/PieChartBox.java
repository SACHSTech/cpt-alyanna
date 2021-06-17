package project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PieChartBox {

    public static void display(int[] totalByPosition) {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Pie Chart");
        window.setMinWidth(600);

        System.out.println(totalByPosition[0]);
        System.out.println(totalByPosition[1]);
        System.out.println(totalByPosition[2]);
        System.out.println(totalByPosition[3]);
        System.out.println(totalByPosition[4]);

        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
            new PieChart.Data("Point Guard", totalByPosition[0]),
            new PieChart.Data("Shooting Guard", totalByPosition[1]),
            new PieChart.Data("Small Forward", totalByPosition[2]),
            new PieChart.Data("Power Forward", totalByPosition[3]),
            new PieChart.Data("Center", totalByPosition[4])
        );

        PieChart pChart = new PieChart(pieData);
        pChart.setTitle("Points by Position");

        Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");

        for (PieChart.Data data : pChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, 
            new EventHandler<MouseEvent>() {

                @Override 
                public void handle(MouseEvent e) {
                    caption.setTranslateX(e.getSceneX());
                    caption.setTranslateY(e.getSceneY());
                    caption.setText(String.valueOf(data.getPieValue()) + "%");
                }
            });
        }

        Group root = new Group(pChart);
        Scene scene = new Scene(root, 600, 400);

        window.setScene(scene);
        window.showAndWait();
    }
}
