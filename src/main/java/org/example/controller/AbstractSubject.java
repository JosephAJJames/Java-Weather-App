package org.example.controller;

import org.example.model.Observer;
import org.jxmapviewer.viewer.DefaultWaypoint;

import java.util.ArrayList;

public abstract class AbstractSubject {
    private ArrayList<Observer> list = new ArrayList<Observer>();

    public void notifyObservers(DefaultWaypoint wayPoint) {
        for (Observer obj : this.list) {
            obj.notifyObj(wayPoint);
        }
    }

    public void addObservor(Observer obj) {
        this.list.add(obj);
    }
}
