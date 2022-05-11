package dev.rvz.escola.domain;

public abstract class Listenner {
    public void process(Event event) {
        if (this.shouldProcess(event)) {
            this.reactTo(event);
        }
    }

    protected abstract void reactTo(Event event);

    protected abstract Boolean shouldProcess(Event event);
}
