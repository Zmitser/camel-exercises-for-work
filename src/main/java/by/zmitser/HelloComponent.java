package by.zmitser;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component("helloComponent")
public class HelloComponent {


    public void hello(Exchange exchange) {
        System.out.println("Hello!");
        exchange.setProperty("value", "New Message For me");
    }

    public void newHello(Exchange exchange) {
        System.out.println(exchange.getProperty("value"));
    }

    public void by() {
        System.out.println("By!");
    }
}
