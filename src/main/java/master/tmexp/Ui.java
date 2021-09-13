package master.tmexp;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.EventListener;
import java.util.Objects;

public class Ui extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Menu_top.mianzhe();

        VBox vBox1=new VBox();
        Menu_top menu_top=new Menu_top(); //代理
        Menu_center menu_center=new Menu_center();//核心ui
        Scene scene=new Scene(vBox1,800,500);
        MenuBar menuBar =new MenuBar();

        vBox1.getChildren().add(menuBar);
        menuBar.getMenus().addAll(menu_top.shezhi(),menu_top.guanyu());
        vBox1.getChildren().add(menu_center.Jpane_1());
        vBox1.getChildren().add(menu_center.Jpane_3());
        vBox1.getChildren().add(menu_center.tabPane());
        stage.getIcons().add(new Image("file:D:\\java\\test_gui\\src\\main\\icon\\icon.png"));
        stage.setScene(scene);
        stage.show();
    }
}