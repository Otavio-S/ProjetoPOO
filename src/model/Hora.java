package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Otavio
 */
public class Hora implements Cloneable, Comparable<Hora> {
    
    private int hora;
    private int minuto;

    public Hora(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }
    
    public int toMinute() {
        return hora*60 + minuto;
    }
    
    @Override
    public Hora clone() {
        try {
            return (Hora) super.clone();
        } catch (CloneNotSupportedException e) {
            return (Hora) this;
        }
    }

    @Override
    public String toString() {
        if(hora>0 && hora<10 && minuto>0 && minuto<10) {
            return "0"+hora+":0"+minuto;
        }
        if(hora>0 && hora<10 && minuto==0) {
            return "0"+hora+":00";
        }
        if(hora>0 && hora<10) {
            return "0"+hora+":"+minuto;
        }
        if(minuto>0 && minuto<10 && hora==0) {
            return "00:0"+minuto;
        }
        if(minuto>0 && minuto<10) {
            return hora+":0"+minuto;
        }
        if(hora == 0) {
            return "00:"+minuto;
        }
        if (minuto == 0) {
        return hora + ":00";
        }
        return hora + ":" + minuto;
    }
    
    public static boolean isEqual(Hora h1, Hora h2) {
        return h1.getHora() == h2.getHora() && h1.getMinuto() == h2.getMinuto();
    }
    
    public static boolean isBetween(Hora horaMiddle, Hora horaBegin, Hora horaEnd) {
        return horaBegin.getHora()<=horaMiddle.getHora() &&
                horaBegin.getMinuto()<=horaMiddle.getMinuto()&&
                horaEnd.getHora()>=horaMiddle.getHora() &&
                horaEnd.getMinuto()>=horaMiddle.getMinuto();
    }

    @Override
    public int compareTo(Hora horario) {
        int h = horario.toMinute();
        return this.toMinute() - h;
    }

}