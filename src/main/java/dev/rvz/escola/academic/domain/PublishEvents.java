package dev.rvz.escola.academic.domain;

import java.util.ArrayList;
import java.util.List;

public class PublishEvents {
    private List<Listenner> listenners = new ArrayList<>();

    public void add(Listenner listenner) {
        this.listenners.add(listenner);
    }

    public void publish(Event event) {
        this.listenners.forEach(listenner -> {
            listenner.process(event);
        });
    }
}
