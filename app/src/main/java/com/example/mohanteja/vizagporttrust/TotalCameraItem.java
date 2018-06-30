package com.example.mohanteja.vizagporttrust;

public class TotalCameraItem {
    private String type;   //PTZ/FIXED
    private String WORKING;
    private String NOT_WORKING;
    private String REMARKS;

    public TotalCameraItem(String type, String WORKING, String NOT_WORKING, String REMARKS) {
        this.type = type;
        this.WORKING = WORKING;
        this.NOT_WORKING = NOT_WORKING;
        this.REMARKS = REMARKS;
    }

    public String getType() {
        return type;
    }

    public String getWORKING() {
        return WORKING;
    }

    public String getNOT_WORKING() {
        return NOT_WORKING;
    }

    public String getREMARKS() {
        return REMARKS;
    }

    @Override
    public String toString() {
        return "TotalCameraItem{" +
                "type='" + type + '\'' +
                ", WORKING='" + WORKING + '\'' +
                ", NOT_WORKING='" + NOT_WORKING + '\'' +
                ", REMARKS='" + REMARKS + '\'' +
                '}';
    }
}
