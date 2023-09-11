package hr.hrsak.amazon.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpConfig {


    @Bean
    public OkHttpClient getHttpClient() {
        return new OkHttpClient();
    }
}
