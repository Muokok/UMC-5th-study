package umc.spring.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 파일을 등록해주어야 하기 때문에 @Configuration으로 Component Scan 범위 영역 내에 존재하도록 설정
public class SwaggerConfig {

    @Bean //Swagger 설정을 위한 OpenAPI 객체 생성
    public OpenAPI UMCstudyAPI(){
        Info info = new Info() // 해당 Swagger 페이지가 무엇을 나타내는지 알려주기 위해 작성
                .title("UMC Server WorkBook API") // API 제목
                .description("UMC Server WorkBook API 명세서")// API 설명
                .version("1.0.0"); // API 버전

        String jwtSchemeName = "JWT TOKEN";

        //API 요청 헤더에 인증 정보 요구
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);

        //SecuritySchemes 등록
        Components components = new Components()
                .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
                        .name(jwtSchemeName)
                        .type(SecurityScheme.Type.HTTP) // HTTP 방식
                        .scheme("bearer")
                        .bearerFormat("JWT"));

        return new OpenAPI()
                .addServersItem(new Server().url("/")) // 서버 URL 지정
                .info(info) // API 정보 설정
                .addSecurityItem(securityRequirement) // 인증 요구사항 설정
                .components(components);
    }

}
