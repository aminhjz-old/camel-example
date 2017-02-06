package com.backbase.training.services;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by amin on 1/23/17.
 */
@Component
public class TrainingRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:foo")
                .to("https://www.ing.nl/api/locator/atms/")
                .convertBodyTo(String.class)
                .to("log:bar")
                .to("file:/tmp/atm");
    }
}
