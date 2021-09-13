package master.tmexp;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logic {
    Value_static value_static = new Value_static();
    ComboBox app = new ComboBox();
    ComboBox vuln = new ComboBox();

    //这里是监听得到的值
    public Logic() {
        new Poc().add_applist(); //执行添加applist
        Set<String> key1 = value_static.app_list.keySet();
        for (String key : key1) {
            app.getItems().add(key);
        } //放入到combobox里面
        app.getSelectionModel().select(0);
        value_static.app_value = app.getValue().toString();

        Set<String> key2 = value_static.app_list.get(value_static.app_value).keySet();
        for (String key : key2) {
            vuln.getItems().add(key);
        }
        vuln.getSelectionModel().select(0);
        value_static.vuln_value = vuln.getValue().toString();

//        aes();
    }

    //对port做判断是否为数字
    public static boolean isInteger(String textField_port) {
        Matcher mer = Pattern.compile("^[+-]?[0-9]+$").matcher(textField_port);
        return mer.find();
    }

    //判断url是否正确输入
    public static boolean isNull(TextField textField_url) {
        Pattern pattern = Pattern.compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$");
        return pattern.matcher(textField_url.getText()).matches();
    }
}
