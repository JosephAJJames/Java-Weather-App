package org.example.controller;

import org.example.view.MainView;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.input.PanMouseInputListener;

import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MainController {
    private MainView mainView;

    public MainController(MainView view) {
        this.mainView = view;
        this.addEventListeners(view);
    }

    public void addEventListeners(MainView view) {
        JXMapViewer map = this.mainView.getMap();

        MouseInputListener mouseInputListener = new PanMouseInputListener(map);
        map.addMouseListener(mouseInputListener);
        map.addMouseMotionListener(mouseInputListener);
    }
}
