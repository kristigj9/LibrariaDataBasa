package org.example.models;

public class Punonjesit {
    private String emer;
    private String mbiemer;
    private String Id;

    public Punonjesit(String mbiemer, String emer, String id) {
        this.mbiemer = mbiemer;
        this.emer = emer;
        this.Id = id;
    }

    public String getEmer() {
        return emer;
    }

    public void setEmer(String emer) {
        this.emer = emer;
    }

    public String getMbiemer() {
        return mbiemer;
    }

    public void setMbiemer(String mbiemer) {
        this.mbiemer = mbiemer;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
