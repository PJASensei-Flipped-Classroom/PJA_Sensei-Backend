package com.example.PjaSensei.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.nio.charset.StandardCharsets;
import java.net.http.HttpClient;

@Configuration
public class AiRestClientConfig {
    private final String aiUrl;

    public AiRestClientConfig(@Value("${ai-properties.ai-url}") String aiUrl) {
        this.aiUrl = aiUrl;
    }

    @Bean
    public RestClient restClient() {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        return RestClient.builder()
                .baseUrl(aiUrl)
                .requestFactory(new JdkClientHttpRequestFactory(httpClient))
                .requestInterceptor(aiRequestLoggingInterceptor())
                .build();
    }

    private ClientHttpRequestInterceptor aiRequestLoggingInterceptor() {
        return (request, body, execution) -> {
            System.out.printf(
                    "[AI HTTP] %s %s contentType=%s contentLength=%d body=%s%n",
                    request.getMethod(),
                    request.getURI(),
                    request.getHeaders().getFirst("Content-Type"),
                    body.length,
                    new String(body, StandardCharsets.UTF_8));

            var response = execution.execute(request, body);
            System.out.printf(
                    "[AI HTTP] response status=%s contentType=%s%n",
                    response.getStatusCode(),
                    response.getHeaders().getFirst("Content-Type"));
            return response;
        };
    }
}
