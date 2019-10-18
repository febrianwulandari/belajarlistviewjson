package com.iky.appgempabumi;

//tempat data

public class Gempa {
    private double Maginitude;
    private String Location;
    private long TimeMilliseconds;
    private String Url;

    /**
     *
     * @param Maginitude adalah besarnya dari suatu gempa
     * @param Location adalah tempat gempa itu terjadi
     * @param TimeMilliseconds adalah waktu gempa / second
     * @param Url adalah url website yang diambil datanya
     */

    public Gempa(double Maginitude, String Location, long TimeMilliseconds, String Url) {
        this.Maginitude = Maginitude;
        this.Location = Location;
        this.TimeMilliseconds = TimeMilliseconds;
        this.Url = Url;
    }

    public double getMaginitude() {
        return Maginitude;
    }


    public String getLocation() {
        return Location;
    }

    public long getTimeMilliseconds() {
        return TimeMilliseconds;
    }


    public String getUrl() {
        return Url;
    }
}
