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
        exchange.setProperty("mess", "I am a stupid developer");
    }

    public void stupid(String message) {
        System.out.println(message);
    }

    public String returnStringMessage() {
        return "New String For Me!";
    }

    public void printString(String message) {
        System.out.println(message);
    }

    public void by() {
        System.out.println("By!");
    }
}
