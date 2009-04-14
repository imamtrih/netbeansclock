/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leopard2av.clock;

import java.util.Date;

/**
 *
 * @author pedro
 */
public class Reminder {

    private Date when;
    private String appointment;

    public Reminder(Date when, String appointment) {
        this.when = when;
        this.appointment = appointment;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }
}
