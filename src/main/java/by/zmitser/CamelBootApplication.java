package by.zmitser;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CamelBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CamelBootApplication.class, args);
    }




    @Bean
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                rest("/say")
                        .get("/hello").consumes("application/json").to("direct:hello")
                        .get("/bye").consumes("application/json").to("direct:bye")
                        .post("/bye").to("mock:update");

                from("direct:hello")
                        .transform().constant("Hello World");
                from("direct:bye")
                        .transform().constant("Bye World");
            }
        };
    }
}
