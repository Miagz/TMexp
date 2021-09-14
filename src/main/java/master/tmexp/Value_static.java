package master.tmexp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Value_static {
    //下拉框method
    public static ObservableList<String> method= FXCollections.observableArrayList("POST","GET");

    //输入框
    public static TextField url_value=new TextField(); //url框 获取 Value_static.urlvalue.gettext()

    //验证信息的值
    public static TextArea textArea_info_tab=new TextArea();

    //命令执行的值
    public static TextArea textArea_cmd_tab=new TextArea();

    //返回包的接受面板
    public static TextArea respone_info_tab=new TextArea();
    public static TextArea textArea_cmd=new TextArea();
    public static String http_method="";
    public static String proxy_host="";

    public static String cookie="";
    public static int proxy_port;

    public static Boolean vuln_checkValue=false;

    public static String check_cmd="whoami";
    public static boolean checkBox_proxy=false;
    public static String Respone_yzxx;
    public static  Map<String, Map> app_list = new HashMap<>();
    //按钮值
    public static  String app_value = ""; //回传的漏洞类型的值，这个就是选择后漏洞类型的值
    public static  String vuln_value =""; //漏洞编号的值

    //功能面板
    public  static GridPane function = new GridPane();

    //-------功能全局参数-----
    //shiro
    public static TextField keyword = new TextField();
    public static TextField shirokey = new TextField();

}
