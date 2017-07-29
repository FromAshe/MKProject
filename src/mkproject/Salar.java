/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject;

/**
 *
 * @author Ashenafi
 */
import mkproject.UserInterfaceModule.Border;
import mkproject.UserInterfaceModule.ApplicationWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ashenafi
 */
public class Salar {

    Button bt, bt2;
    TextField txf1, txf2, txf3, txf4;
    CheckBox checkBox;
    Stage st;

    public void salaried() {
        BorderPane borderPane = Border.getBorderPaneInstance().setBorderProperty();
        st = ApplicationWindow.getApplicationWindowInstance();
        //st.setTitle("Salaried Employee Window");

        //st.setScene(new Scene(borderPane, 500, 200));

        txf1 = new TextField();
        txf2 = new TextField();
        txf3 = new TextField();
        Label lb1 = new Label("Salary");
        Label lb2 = new Label("Tax");
        Label lb3 = new Label("Eet Income");
        Label lb4 = new Label("Has Allowance");
        bt = new Button("Add Allowance");
        bt2 = new Button("Back");
        checkBox = new CheckBox();
        bt.setVisible(false);

        GridPane gridPane = new GridPane();
        gridPane.add(lb1, 0, 0, 5, 1);
        gridPane.add(lb2, 0, 1, 5, 1);
        gridPane.add(lb3, 0, 2, 5, 1);
        gridPane.add(txf1, 5, 0, 5, 1);
        gridPane.add(txf2, 5, 1, 5, 1);
        gridPane.add(txf3, 5, 2, 5, 1);
        gridPane.add(bt2, 0, 3, 3, 1);

        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setHgap(5);
        FlowPane flowPane = new FlowPane();
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(30, 30, 30, 30));

        flowPane.getChildren().addAll(checkBox, new Label("has Allowance"));
        FlowPane flowPane2 = new FlowPane();
        flowPane2.getChildren().add(bt);
        flowPane2.setHgap(10);
        vBox.getChildren().addAll(flowPane, flowPane2);

        bt.setOnAction(new NetIncome());
        vBox.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ev) {
                if (!checkBox.selectedProperty().get()) {
                    bt.setVisible(false);
                    ev.consume();
                } else if (checkBox.selectedProperty().get()) {
                    bt.setVisible(true);
                }
            }

        });

        bt2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ee) {
                st.hide();
                new Assignment2().playBack();
            }
        });

        borderPane.setRight(vBox);
        borderPane.setLeft(gridPane);
        st.show();
    }

    class NetIncome implements EventHandler<ActionEvent> {

        public void handle(ActionEvent ev) {
            try {
                Double net;
                double salary, tax;

                salary = Double.parseDouble(txf1.getText());
                tax = salary * (1 / 100);
                tax = Double.parseDouble(txf2.getText());
                net = salary - tax;

                txf3.setText(net.toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please fill the appropreate space");
            }
        }
    }
}
