package master.tmexp;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.EventListener;

public class Menu_center {

    public GridPane Jpane_1(){
        //引用
        Action_Listen action = new Action_Listen();
        //url框
        GridPane pane = new GridPane();
        Value_static.url_value.setPrefWidth(300);
        pane.setVgap(5);
        pane.setHgap(10);
        pane.setPadding(new Insets(5,5,5,5));
        pane.add(new Label("URL:"),1,1);
        pane.add(Value_static.url_value,2,1);


        //漏洞类型
        pane.add(action.app_list(),3,1);
        //漏洞编号
        pane.add(action.vuln_list(),4,1);
        //漏洞验证按钮
        Button button_Ldyz=new Button("漏洞验证");
        button_Ldyz=Action_Listen.button_ldyz_listen(button_Ldyz);
        pane.add(button_Ldyz,5,1);
        //清空信息按钮
        Button button_pljc=new Button("批量检测");

        button_pljc=Action_Listen.button_pljc_listen(button_pljc);
        Button button_qkxx=new Button("清空信息");
        pane.add(button_pljc,6,1);
        button_qkxx=Action_Listen.button_qkxx_listen(button_qkxx);
        pane.add(button_qkxx,7,1);
        return pane;
    }
    //第二行
    public static GridPane Jpane_2(){
        GridPane pane = new GridPane();
        TextField url_value=new TextField();
        pane.setVgap(5);
        pane.setHgap(10);
        pane.setPadding(new Insets(5,5,5,5));

        Label method = new Label("Method");
        pane.add(method,1,2);

        ComboBox comboBox_method=new ComboBox(Value_static.method);
        comboBox_method.getSelectionModel().select(1);

        comboBox_method=Action_Listen.comboBox_method_listen(comboBox_method);
        pane.add(comboBox_method,2,2);

        Label cookie =new Label("Cookie");
        pane.add(cookie,3,2);

        TextField textField_cookie=new TextField();
        textField_cookie.setPrefWidth(300);
        pane.add(textField_cookie,4,2);
        CheckBox checkBox_cookie=new CheckBox();
        checkBox_cookie=Action_Listen.checkBox_cookie_listen(checkBox_cookie,textField_cookie);
        pane.add(checkBox_cookie,5,2);
        return pane;
    }
    //功能
    public  GridPane Jpane_3(){
        Value_static.function.getChildren().add(Menu_center.Jpane_2());
        return  Value_static.function;
    }
    //标签
    public TabPane tabPane(){
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(10);
        pane.setPadding(new Insets(5,5,5,5));

        TabPane tap=new TabPane();
        Tab info=new Tab("验证信息");
       // Tab respone_info=new Tab("响应包");
        Tab command=new Tab("命令执行");

        tap.getTabs().addAll(info,command);
        info.setClosable(false);
        info.setContent(info_tab());
       // respone_info.setClosable(false);
       // respone_info.setContent(respone_info_tab());
        command.setClosable(false);
        command.setContent(command_tab());
        return tap;
    }

    public BorderPane info_tab(){
        BorderPane info_Bp = new BorderPane();
        info_Bp.setPrefHeight(370);
        info_Bp.setCenter(Value_static.textArea_info_tab);
        return  info_Bp;
    }
    public BorderPane respone_info_tab(){
        BorderPane respone_info_Bp = new BorderPane();
        respone_info_Bp.setPrefHeight(370);
        respone_info_Bp.setCenter(Value_static.respone_info_tab);
        return  respone_info_Bp;
    }

    public VBox command_tab(){
        VBox command_vb=new VBox();
        GridPane pane=new GridPane();
        pane.setVgap(5);
        pane.setHgap(10);
        pane.setPadding(new Insets(5,5,5,5));
        Label label = new Label("命令:");
        pane.add(label,1,1);
        TextField textField =new TextField();
        textField.setPrefWidth(300);
        pane.add(textField,2,1);
        Button button =new Button("执行");
        button=Action_Listen.button_zx_listen(button,textField);
        pane.add(button,3,1);
        command_vb.getChildren().add(pane);

        BorderPane info_Bp = new BorderPane();
        info_Bp.setPrefHeight(370);
        info_Bp.setCenter(Value_static.textArea_cmd_tab);
        command_vb.getChildren().add(info_Bp);
        return command_vb;
    }

}
