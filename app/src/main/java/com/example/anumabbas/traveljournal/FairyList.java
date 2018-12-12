package com.example.anumabbas.traveljournal;

/**
 * Created by anumabbas on 09/12/2018.
 */

public class FairyList {

    private String url;
    private String description;
    private String location;

    public FairyList() {

    }

    public FairyList(String url, String description, String location) {
        this.url = url;
        this.description = description;
        this.location = location;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
