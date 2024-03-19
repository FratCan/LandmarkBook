package com.firatcan.landmarkbook;

public class Singleton {
    private LandMark sentLandmark;
    private static Singleton singleton;
    private Singleton(){

    }

    public LandMark getSentLandmark() {
        return sentLandmark;
    }

    public void setSentLandmark(LandMark sentLandmark) {
        this.sentLandmark = sentLandmark;
    }


    public static Singleton getInstance(){
        if(singleton==null){
            singleton= new Singleton();
        }
        return singleton;
    }
}
