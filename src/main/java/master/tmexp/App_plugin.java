package master.tmexp;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class App_plugin {
    Value_static value_static = new Value_static();
    public App_plugin(String app_value) {
        switch (app_value) {
            case "Shiro":
                value_static.function.getChildren().clear();
                value_static.function.getChildren().add(Shiro());
                break;
            default:
                value_static.function.getChildren().clear();
                value_static.function.getChildren().add(Menu_center.Jpane_2());
        }
    }
    public GridPane Shiro(){
        GridPane shiro = new GridPane();
        Button check = new Button("检测密钥");
        Button blast = new Button("爆破密钥");
        value_static.keyword.setPrefWidth(100);
        value_static.keyword.setText("rememberMe");
        Action_Listen.shiro_key_check(check);
        value_static.shirokey.setPrefWidth(250);
        shiro.setVgap(5);
        shiro.setHgap(10);
        shiro.setPadding(new Insets(5,5,5,5));
        shiro.add(new Label("关键字"),1,0);
        shiro.add(value_static.keyword,2,0);
        shiro.add(new Label(" 密钥"),3,0);
        shiro.add(value_static.shirokey,4,0);
        shiro.add(check,5,0);
        shiro.add(blast,6,0);
        return shiro;
    }
}