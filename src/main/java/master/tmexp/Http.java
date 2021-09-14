package master.tmexp;
import okhttp3.*;
import java.io.*;
import java.net.*;
import java.util.Random;

public class Http {
    public static OkHttpClient client;

    public String[] UserAgent = new String[]{"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; en) Opera 9.50", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.57.2 (KHTML, like Gecko) Version/5.1.7 Safari/534.57.2", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.16 (KHTML, like Gecko) Chrome/10.0.648.133 Safari/534.16", "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.11 TaoBrowser/2.0 Safari/536.11", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Maxthon/4.4.3.4000 Chrome/30.0.1599.101 Safari/537.36", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SV1; QQDownload 732; .NET4.0C; .NET4.0E; SE 2.X MetaSr 1.0)", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; QQDownload 732; .NET4.0C; .NET4.0E; LBBROWSER)", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0", "Opera/9.80 (Windows NT 6.1; U; en) Presto/2.8.131 Version/11.11", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; TencentTraveler 4.0)"};

    public void post_response(String url ,String payload,String vuln_name){
        if(Value_static.checkBox_proxy){
            Proxy proxy =new Proxy(Proxy.Type.HTTP,new InetSocketAddress(Value_static.proxy_host,Value_static.proxy_port));
            client = new Customization_Okhttp().getUnsafeOkHttpClient().newBuilder().proxy(proxy).build();
        }else {
            client = new Customization_Okhttp().getUnsafeOkHttpClient();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), payload);
        Request.Builder builder = new Request.Builder();
        int randvalue = new Random().nextInt(UserAgent.length);
        Request request = builder.url(url).header("User-Agent", UserAgent[randvalue]).header("Cookie",Value_static.cookie).post(body).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Value_static.Respone_yzxx = response.body().string();
                Check(vuln_name);
            }
        });

    }

    public void get_response(String url, String payload,String vuln_name) {

        if (Value_static.checkBox_proxy) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(Value_static.proxy_host, Value_static.proxy_port));
            client = new Customization_Okhttp().getUnsafeOkHttpClient().newBuilder().proxy(proxy).build();
        } else {
            client = new Customization_Okhttp().getUnsafeOkHttpClient();
        }

        Request.Builder builder = new Request.Builder();
        int randvalue = new Random().nextInt(UserAgent.length);
        Request request = builder.get().url(url + payload).header("User-Agent", UserAgent[randvalue]).header("Cookie",Value_static.cookie).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Value_static.Respone_yzxx = response.body().string();
                Check(vuln_name);
            }
        });
    }
    public void Check(String vuln_name) throws IOException {
        if(Value_static.vuln_checkValue){
            Value_static.textArea_cmd_tab.appendText(Value_static.Respone_yzxx+"\n");
        }
        else{
            if(Value_static.Respone_yzxx.equals("root\n")){
                Value_static.textArea_info_tab.appendText(Value_static.url_value.getText()+"存在"+vuln_name+"漏洞\n");
                Value_static.vuln_checkValue = true;
            }
            else{
                Value_static.textArea_info_tab.appendText(Value_static.url_value.getText()+"不存在"+vuln_name+"漏洞\n");
            }
        }
    }
}