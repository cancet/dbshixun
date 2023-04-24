package com.example.dbshixun.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SwaggerConfig
 * @author cancet
 * @Date 2023/4/24/13:45
 * @Description swagger的配置类
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(apiInfo())
                .externalDocs(new ExternalDocumentation()
                        .description("SpringDoc Wiki Documentation")
                        .url("https://springdoc.org/v2"));
    }

    private Info apiInfo() {
        return new Info()
                .title("基于web的咖啡连锁门店运营管理系统的设计与实现")
                .description("专业综合实训大项目 第一组")
                .version("1.0.0")
                .contact(new Contact()
                        .name("cancet")
                        .email("1063471378@qq.com")
                )
                .license(new License()
                        .name("Apache 2.0")
                        .url("http://www.apache.org/licenses/LICENSE-2.0.txt")
                );
    }
}
