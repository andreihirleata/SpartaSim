package com.sparta;

public class TrainingCenter {
    private static int centerID =0;

    public TrainingCenter(){
        setCenterID(centerID++);
    }

    public int getCenterID() {return centerID;}

    public void setCenterID(int centerID) {
        this.centerID = centerID;
    }

    @Override
    public String toString() {
        return "TrainingCenter{" +
                "centerID=" + centerID +
                '}';
    }

}
