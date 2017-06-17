package by.zmitser;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamelController {
    private final
    ProducerTemplate producerTemplate;

    @Autowired
    public CamelController(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    @RequestMapping(value = "/{message}")
    public void startCamel(@PathVariable String message) {
        producerTemplate.sendBody("direct:test", message);
    }
}