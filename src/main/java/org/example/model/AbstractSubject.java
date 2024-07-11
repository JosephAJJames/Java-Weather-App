package org.example.model;

public abstract class AbstractSubject {
    private Observer[] observers;

    public void notifyObservers() {
        for (Observer obj : this.observers) {
            obj.notifyObj();
        }
    }
}
