package com.product;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import jdk.jfr.Description;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info =@Info(
                title = " Ecommerece project",
                description = "it is for all Ecommerce project",
                version = "latest v1",
                contact = @Contact
                        (
                        name = "anshu",
                         email = "anshu@gmail.com"
                         )
               ),
        externalDocs = @ExternalDocumentation
                (
                description = "share point url product service",
                url = "example.com"
                )





)


@SpringBootApplication
public class EcommerceProjectApplication
{
	public static void main(String[] args)
    {
		SpringApplication.run(EcommerceProjectApplication.class, args);
	}
}
