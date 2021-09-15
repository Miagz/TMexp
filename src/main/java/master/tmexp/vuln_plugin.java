package master.tmexp;

import okhttp3.Response;

public class vuln_plugin {
    public  static  Boolean Check(Response response){
        switch (Value_static.app_value){
            case "Shiro":
                if(check_shiro_frame(response)){

                }
                else{
                    return false;
                }
        }
        return  true;
    }
    public static Boolean check_shiro_frame(Response response){
        if(response.headers("Set-Cookie").toString().contains("rememberMe")){
            Value_static.textArea_info_tab.appendText("存在Shiro框架"+"\n");
            return true;
        }
        else{
            Value_static.textArea_info_tab.appendText("未检测到Shiro框架"+"\n");
            return false;
        }
    }
}
