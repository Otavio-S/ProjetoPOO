/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Otavio
 */
public class Data implements Cloneable {
    
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }
    
    @Override
    public Data clone() {
        try {
            return (Data) super.clone();
        } catch (CloneNotSupportedException e) {
            return (Data) this;
        }
    }

    @Override
    public String toString() {
        return "Data{" + "dia=" + dia + ", mes=" + mes + ", ano=" + ano + '}';
    }
    
    public static boolean isEqual(Data d1, Data d2) {
        if(d1.getDia() == d2.getDia() && 
                d1.getMes() == d2.getMes() &&
                d1.getAno() == d2.getAno()) {
            return true;
        }
        return false;
    }
    
    public static boolean isBetween(Data dataMiddle, Data dataBegin, Data dataEnd) {
        if(dataBegin.getDia()<=dataMiddle.getDia() &&
                dataBegin.getMes()<=dataMiddle.getMes() &&
                dataBegin.getAno()<=dataMiddle.getAno() &&
                dataEnd.getDia()>=dataMiddle.getDia() &&
                dataEnd.getMes()>=dataMiddle.getMes() &&
                dataEnd.getAno()>=dataMiddle.getAno()) {
            return true;
        }
        return false;
    }
    
}
