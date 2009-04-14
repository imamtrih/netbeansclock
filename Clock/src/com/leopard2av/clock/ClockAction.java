/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leopard2av.clock;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.util.actions.Presenter;

public final class ClockAction implements ActionListener, Presenter.Toolbar {

    private Component comp = new ClockPanel();

    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }

    public Component getToolbarPresenter() {
        return comp;
    }
}
