package models;

import android.graphics.Bitmap;

/**
 * Created by Junaid-Invision on 5/16/2016.
 */
public class Interchange {

    String truckNumber;
    String sealNumber;
    String trailerNumber;
    boolean isLoaded;
    boolean goingIn;
    byte[] image;


    public Interchange ()
    {
        truckNumber = "";
        trailerNumber = "";
        sealNumber = "";
        isLoaded = false;
        goingIn = false;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public String getSealNumber() {
        return sealNumber;
    }

    public void setSealNumber(String sealNumber) {
        this.sealNumber = sealNumber;
    }

    public String getTrailerNumber() {
        return trailerNumber;
    }

    public void setTrailerNumber(String trailerNumber) {
        this.trailerNumber = trailerNumber;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }

    public boolean isGoingIn() {
        return goingIn;
    }

    public void setGoingIn(boolean goingIn) {
        this.goingIn = goingIn;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
