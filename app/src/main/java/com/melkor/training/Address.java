package com.melkor.training;

import android.provider.Telephony;
import android.telephony.SubscriptionInfo;

/**
 * Created by franco.salvatierra on 08/02/2018.
 */

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public Address(){}

    public Address(String Street, String Suite, String City, String Zipcode, Geo Geo)
    {
        this.street = Street;
        this.suite = Suite;
        this.city = City;
        this.zipcode = Zipcode;
        this.geo = Geo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
