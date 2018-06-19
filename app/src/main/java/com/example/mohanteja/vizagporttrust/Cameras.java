package com.example.mohanteja.vizagporttrust;

public class Cameras {
    private String location;
    private String status;
    private String remarks;

    public Cameras(String location, String status, String remarks) {
        this.location = location;
        this.status = status;
        this.remarks = remarks;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public String getRemarks() {
        return remarks;
    }

    @Override
    public String toString() {
        return "Cameras{" +
                "location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
