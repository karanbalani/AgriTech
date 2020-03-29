package com.example.kbala.agritech;

public class Machine {

    private String type;
    private String district;

    public Machine(String type,String district)
    {
    this.type = type;
    this.district = district;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
