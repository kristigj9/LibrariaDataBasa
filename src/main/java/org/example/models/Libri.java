package org.example.models;

public abstract class Libri {


    private String id;
    private String titulli;
    private int numriFaqeve;
    private Gjinia_Librit gjiniaLibrit;
    private Tipi tipi;
    private String formati;


    public Libri(String id, String titulli, int numriFaqeve ,Gjinia_Librit gjiniaLibrit, Tipi tipi,String formati) {
        this.id = id;
        this.titulli = titulli;
        this.numriFaqeve = numriFaqeve;
        this.gjiniaLibrit=gjiniaLibrit;
        this.tipi=tipi;
        this.formati=formati;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getTitulli() {
        return titulli;
    }

    public void setTitulli(String titulli) {
        this.titulli = titulli;
    }

    public int getNumriFaqeve() {
        return numriFaqeve;
    }

    public void setNumriFaqeve(int numriFaqeve) {
        this.numriFaqeve = numriFaqeve;
    }

    public Gjinia_Librit getGjiniaLibrit() {
        return gjiniaLibrit;
    }

    public void setGjiniaLibrit(Gjinia_Librit gjiniaLibrit) {
        this.gjiniaLibrit = gjiniaLibrit;
    }

    public Tipi getTipi() {
        return tipi;
    }

    public void setTipi(Tipi tipi) {
        this.tipi = tipi;
    }

    public String getFormati() {
        return formati;
    }

    public void setFormati(String formati) {
        this.formati = formati;
    }
}
