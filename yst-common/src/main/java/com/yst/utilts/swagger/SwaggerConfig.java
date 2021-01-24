package com.yst.utilts.swagger;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhanghuaxi
 * @title: SwaggerConfig
 * @projectName yst-parem
 * @description: TODO
 * @date 2021/1/24下午7:58
 */

@Configuration
@EnableSwagger2 // Swagger的开关，表示已经启用Swagger
//@EnableSwaggerBootstrapUI
public class SwaggerConfig {
    @Bean
    public Docket api() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select() // 选择哪些路径和api会生成document
                .apis(RequestHandlerSelectors.any())// 对所有api进行监控
                //.apis(RequestHandlerSelectors.basePackage("com.hanstrovsky.controller"))// 选择监控的package
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))// 只监控有ApiOperation注解的接口
                //不显示错误的接口地址
                .paths(Predicates.not(PathSelectors.regex("/error.*")))//错误路径不监控
                .paths(PathSelectors.regex("/.*"))// 对根下所有路径进行监控
                .build();
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("api文档的标题或者名称")
                .description("这里是关于这个api文档的简单描述")
                .version("1.0.0")// 版本号
                .build();
    }

}
