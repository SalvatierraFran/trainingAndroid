package com.melkor.training;

/**
 * Created by franco.salvatierra on 08/02/2018.
 */

public class Company {

    private String name;
    private String catchPhrase;
    private String bs;

    public Company(){}

    public Company(String Name, String CatchPhrase, String Bs)
    {
        this.name = Name;
        this.catchPhrase = CatchPhrase;
        this.bs = Bs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
