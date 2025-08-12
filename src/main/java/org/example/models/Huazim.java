package org.example.models;

import java.util.Date;

public class Huazim {
    private Punonjesit punonjesit;
    private Libri libri;
    private Date data_Kthimit;
    private Date getData_Huazimit;
    private int id;


    public Punonjesit getPunonjesit() {
        return punonjesit;
    }

    public void setPunonjesit(Punonjesit punonjesit) {
        this.punonjesit = punonjesit;
    }

    public Libri getLibri() {
        return libri;
    }

    public void setLibri(Libri libri) {
        this.libri = libri;
    }

    public Date getData_Kthimit() {
        return data_Kthimit;
    }

    public void setData_Kthimit(Date data_Kthimit) {
        this.data_Kthimit = data_Kthimit;
    }

    public Date getGetData_Huazimit() {
        return getData_Huazimit;
    }

    public void setGetData_Huazimit(Date getData_Huazimit) {
        this.getData_Huazimit = getData_Huazimit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public Huazim( Punonjesit punonjesit, Libri libri, Date data_Kthimit, Date getData_Huazimit) {
        this.punonjesit = punonjesit;
        this.libri = libri;
        this.data_Kthimit = data_Kthimit;
        this.getData_Huazimit = getData_Huazimit;
        this.id = id;


    }

    @Override
    public String toString() {
        return "Huazim{" +
                "punonjesit=" + punonjesit +
                ", libri=" + libri +
                ", data_Kthimit=" + data_Kthimit +
                ", getData_Huazimit=" + getData_Huazimit +
                ", id='" + id + '\'' +
                '}';
    }
}
