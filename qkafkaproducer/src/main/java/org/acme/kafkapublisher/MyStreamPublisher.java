package org.acme.kafkapublisher;

import javax.enterprise.context.ApplicationScoped;


import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

// import java.util.Random;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class MyStreamPublisher {

    // private Random random = new Random();
    int cnt = 0;

    @Outgoing("mystream")
    public Flowable<String> generate() {
        return Flowable.interval(1, TimeUnit.SECONDS)
                .map(msg -> "{\"message\":\"stuff-" + cnt++ +"\"}");
    }
    
}