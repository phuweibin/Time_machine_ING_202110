package com.time_machine.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;

@Component(value = "picture")
public class Picture implements Serializable {
    private static final long serialVersionUID = -4226717759108144287L;
    private long id;
    private String pictureName;
    private Timestamp shootTime;
    private String shootLocation;
    private String longitude;
    private String latitude;
    private String path;
    private String pictureType;
    private String description;
    private String privacy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public Timestamp getShootTime() {
        return shootTime;
    }

    public void setShootTime(Timestamp shootTime) {
        this.shootTime = shootTime;
    }

    public String getShootLocation() {
        return shootLocation;
    }

    public void setShootLocation(String shootLocation) {
        this.shootLocation = shootLocation;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPictureType() {
        return pictureType;
    }

    public void setPictureType(String pictureType) {
        this.pictureType = pictureType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

}
