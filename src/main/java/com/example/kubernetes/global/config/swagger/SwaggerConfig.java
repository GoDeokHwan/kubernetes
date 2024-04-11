package com.example.kubernetes.global.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile(value = "local")
@Configuration
public class SwaggerConfig {

    // http://localhost:8080/webjars/swagger-ui/index.html#/
    @Bean
    public OpenAPI openAPI() {
        // 개발환경 서버 추가
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("개발환경 서버");

        // 스테이징환경 서버 추가
        Server stagingServer = new Server();
        stagingServer.setUrl("https://staging.example.com");
        stagingServer.setDescription("스테이징환경 서버");

        // 프로덕션환경 서버 추가
        Server productionServer = new Server();
        productionServer.setUrl("https://api.example.com");
        productionServer.setDescription("프로덕션환경 서버");

        Tag boardTag = new Tag();
        boardTag.setName("게시판");

        return new OpenAPI()
                .info(
                        new Info()
                                .title("test")
                                .version("1.0.0")
                                .description("test test")
                )
                .addServersItem(devServer)
                .addServersItem(stagingServer)
                .addServersItem(productionServer)
                .addTagsItem(boardTag)
                ;
    }


}
