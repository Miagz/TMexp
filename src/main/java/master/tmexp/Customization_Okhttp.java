package master.tmexp;

import okhttp3.OkHttpClient;

import javax.net.ssl.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Customization_Okhttp {
    public OkHttpClient getUnsafeOkHttpClient() {
        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }
                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }
                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) (trustAllCerts[0]));
            builder.hostnameVerifier(new HostnameVerifier() {
                //这里存放不需要忽略SSL证书的域名，为空即忽略所有证书
                String[]ssls = {};
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return !Arrays.asList(ssls).contains(hostname);
                }
            });
            OkHttpClient okHttpClient = builder.connectTimeout(10, TimeUnit.MINUTES).
                    writeTimeout(10, TimeUnit.MINUTES).readTimeout(10, TimeUnit.MINUTES).retryOnConnectionFailure(true).build();
            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
