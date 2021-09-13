package master.tmexp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.*;

import java.util.Optional;

public class Menu_top {
    public static void mianzhe(){
//        Alert alert = new Alert(Alert.AlertType.WARNING);
//        alert.setTitle("免责声明！");
//        alert.setContentText("该工具只供学习使用，任何组织，个人利用该工具从事非法工作均与开发者无关！");
//        alert.setHeaderText(null);
//        alert.showAndWait();

        int OK= JOptionPane.showConfirmDialog(null, "该工具只供学习使用，任何组织，个人利用该工具从事非法工作均与开发者无关！",
                "免责声明",JOptionPane.YES_NO_OPTION);
        if (OK==1){
            System.exit(0);
        }

    }
    public Menu shezhi(){
        Menu menu =new Menu("设置");
        MenuItem menuItem=new MenuItem("代理");
        menuItem.setOnAction(actionEvent -> {
            Stage stage =new Stage();
            GridPane gridPane =new GridPane();
            CheckBox checkBox =new CheckBox();
            if (Value_static.checkBox_proxy){
                checkBox.setSelected(true);
            }
            Label label_host =new Label("HOST:");
            Label label_port =new Label("PORT:");
            Label label_title=new Label();
            TextField textField_host=new TextField();
            TextField textField_port =new TextField();
            textField_host.setText(Value_static.proxy_host);
            textField_port.setText(String.valueOf(Value_static.proxy_port));
            textField_port.setPrefWidth(60);
            gridPane.setPadding(new Insets(10,10,10,10));
            gridPane.setHgap(5);
            gridPane.add(label_host,1,0);
            gridPane.add(textField_host,2,0);
            gridPane.add(label_port,3,0);
            gridPane.add(textField_port,4,0);
            gridPane.add(label_title,2,1);
            checkBox=Action_Listen.checkBox_Proxy_listen(checkBox,textField_host,textField_port,label_title);
            gridPane.add(checkBox,5,0);
            Scene scene =new Scene(gridPane,400,200);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        });
        menu.getItems().add(menuItem);
        return menu;
    }
    public Menu guanyu(){
        Menu menu=new Menu("关于");
        return menu;
    }



}
