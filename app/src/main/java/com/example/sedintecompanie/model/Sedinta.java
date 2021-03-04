package com.example.sedintecompanie.model;

import java.io.Serializable;
import java.util.Date;

public class Sedinta implements Serializable {

    private String companie;
    private boolean areProiector;
    private boolean areTabla;
    private Date date;
    private int nrScaune;

    public Sedinta() {
    }

    public Sedinta(String companie, boolean areProiector, boolean areTabla, Date date, int nrScaune) {
        this.companie = companie;
        this.areProiector = areProiector;
        this.areTabla = areTabla;
        this.date = date;
        this.nrScaune = nrScaune;
    }

    public String getCompanie() {
        return companie;
    }

    public void setCompanie(String companie) {
        this.companie = companie;
    }

    public boolean isAreProiector() {
        return areProiector;
    }

    public void setAreProiector(boolean areProiector) {
        this.areProiector = areProiector;
    }

    public boolean isAreTabla() {
        return areTabla;
    }

    public void setAreTabla(boolean areTabla) {
        this.areTabla = areTabla;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNrScaune() {
        return nrScaune;
    }

    public void setNrScaune(int nrScaune) {
        this.nrScaune = nrScaune;
    }

    @Override
    public String toString() {
        return "Sedinta{" +
                "companie='" + companie + '\'' +
                ", areProiector=" + areProiector +
                ", areTabla=" + areTabla +
                ", date=" + date +
                ", nrScaune=" + nrScaune +
                '}';
    }
}
