package master.tmexp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.shape.VLineTo;

import java.lang.reflect.Type;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Action_Listen {
    Logic logic = new Logic();
    Value_static value_static = new Value_static();
    public static CheckBox checkBox_Proxy_listen(CheckBox checkBox, TextField textField_host, TextField textField_port, Label label_title){
        checkBox.setOnAction(actionEvent ->{

            Value_static.proxy_host=textField_host.getText();
            Value_static.proxy_port= Integer.parseInt(textField_port.getText());
            if (checkBox.isSelected()){
                Value_static.checkBox_proxy=true;
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("警告！");
                alert.setHeaderText(null);
                if(!Logic.isInteger(String.valueOf(Value_static.proxy_port))){
                    alert.setContentText("错误！非整数类型");
                    alert.showAndWait();
                    checkBox.setSelected(false);
                }
                else if(Integer.valueOf(Value_static.proxy_port)>65535 || Integer.valueOf(Value_static.proxy_port)<=0){
                    alert.setContentText("错误！只允许输入整数1-65535之间的值");
                    alert.showAndWait();
                    checkBox.setSelected(false);
                }
                else {
                    label_title.setText("代理设置成功!");
                }
            }
            else {
                Value_static.checkBox_proxy=false;
                label_title.setText("代理取消成功!");
            }
        } );
    return checkBox;
    }
    public static CheckBox checkBox_cookie_listen(CheckBox checkBox_cookie,TextField cookie_tab){
        checkBox_cookie.setOnAction(actionEvent -> {
            if (checkBox_cookie.isSelected()){
                Value_static.cookie=cookie_tab.getText();
                System.out.println(Value_static.cookie);
            }
            else {
                Value_static.cookie="";
                System.out.println(Value_static.cookie);
            }
        });
        return checkBox_cookie;
    }
    public ComboBox app_list(){
        logic.app.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                value_static.function.getChildren().clear();//清空第三行
                value_static.app_value =logic.app.getValue().toString();
                new App_plugin(value_static.app_value);
                logic.vuln.getItems().clear();
                Set<String> key1 = value_static.app_list.get(value_static.app_value).keySet();
                for(String key:key1){logic.vuln.getItems().add(key);}
                logic.vuln.getSelectionModel().select(0);
            }
        });
        return logic.app;
    }
    public  ComboBox vuln_list(){
        logic.vuln.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                try{
                    value_static.vuln_value = "";
                    value_static.vuln_value  = logic.vuln.getValue().toString();
                }catch (Exception e){}
            }
        });
        return logic.vuln;
    }
    public static ComboBox comboBox_method_listen(ComboBox comboBox_method){
        comboBox_method.setOnAction(actionEvent -> {
            switch (String.valueOf(comboBox_method.getValue())){
                case "POST":
                    Value_static.http_method="POST";
                    break;
                case "GET":
                    Value_static.http_method="GET";
                    break;
            }
        });
        return comboBox_method;
    }
    public static TextField textField_cookie_listen(TextField textField_cookie){
        textField_cookie.setOnAction(actionEvent -> {
            Value_static.cookie=textField_cookie.getText();
            System.out.println(Value_static.cookie);
        });
        return textField_cookie;
    }
    public static Button button_ldyz_listen(Button button_ldyz){

        button_ldyz.setOnAction(actionEvent -> {
            if (Logic.isNull(Value_static.url_value)) {
                Http http = new Http();
                String payload = (String) Value_static.app_list.get(Value_static.app_value).get(Value_static.vuln_value);
                switch (Value_static.http_method) {
                    case "POST":
                        http.post_response(Value_static.url_value.getText(), payload, Value_static.vuln_value);
                        break;
                    case "GET":
                        http.get_response(Value_static.url_value.getText(), payload, Value_static.vuln_value);
                        break;
                }
            }
            else {
                Alert alert =new Alert(Alert.AlertType.WARNING);
                alert.setContentText("警告！请正确输入url");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        });

        return button_ldyz;
    };
    public static Button button_qkxx_listen(Button button_qkxx){
        button_qkxx.setOnAction(actionEvent -> {
            Value_static.textArea_info_tab.clear();
        });
        return button_qkxx;
    }
    public static Button button_pljc_listen(Button button_pljc){

        button_pljc.setOnAction(actionEvent -> {
            if (Logic.isNull(Value_static.url_value)) {
                String url = Value_static.url_value.getText();
                Http http = new Http();
                Set<String> key = Value_static.app_list.get(Value_static.app_value).keySet();
                for (String key1 : key) {
                    String payload = (String) Value_static.app_list.get(Value_static.app_value).get(key1);
//                http.get_response(url,payload,key1);
                }
            }
            else {
                Alert alert =new Alert(Alert.AlertType.WARNING);
                alert.setContentText("警告！请正确输入url");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        });

        return button_pljc;
    }
    public static Button button_zx_listen(Button button_zx,TextField textField_cmd){
            button_zx.setOnAction(actionEvent -> {
                if (Logic.isNull(Value_static.url_value)){
                Http http=new Http();
                String payload=Value_static.app_list.get(Value_static.app_value).get(Value_static.vuln_value).toString();
                payload=payload.replace("whoami",textField_cmd.getText());
                switch (Value_static.http_method){
                    case "POST":
                        http.post_response(Value_static.url_value.getText(),payload,Value_static.vuln_value);
                        break;
                    case "GET":
                        http.get_response(Value_static.url_value.getText(),payload,Value_static.vuln_value);
                        break;
                }
                }
                else {
                    Alert alert =new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("警告！请正确输入url");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
            });

        return button_zx;
    }
    public static Button shiro_key_check(Button button){
        button.setOnAction(actionEvent -> {
            Value_static.cookie = Value_static.keyword+"=1";
        });
        return button;
    }
}
