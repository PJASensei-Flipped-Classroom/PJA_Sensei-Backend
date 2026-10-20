package com.example.PjaSensei.config;

import org.eclipse.jgit.http.server.GitServlet;
import org.eclipse.jgit.transport.resolver.FileResolver;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class GitServerConfig {

    @Bean
    public ServletRegistrationBean<?> gitServlet() {
        GitServlet gitEngine = new GitServlet();

        File gitDirectory = new File("./git-data");
        if (!gitDirectory.exists()) {
            gitDirectory.mkdirs();
        }
        gitEngine.setRepositoryResolver(new FileResolver<>(gitDirectory, true));

        ServletRegistrationBean<?> reg = new ServletRegistrationBean<>(gitEngine, "/repo/*");
        reg.setName("GitServlet");
        return reg;
    }
}
