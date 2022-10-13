package com.domain;

public class Hospital {
    private String id;
    private String address;
    private String district;
    private String category;
    private String emergencyRoom; // snake camel
    private String name; // snake camel
    private String subdivision; // snake camel

    public Hospital(String id, String address, String district, String category, String emergencyRoom,
                    String name, String subdivision) {

        String[] str = district.split(" ");

//        this.id = id.replaceAll("\"", "");
        this.id = id;
        this.address = address;
        this.district = str[0] + str[1];
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
        this.subdivision = subdivision;
    }


    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getCategory() {
        return category;
    }

    public String getEmergencyRoom() {
        return emergencyRoom;
    }

    public String getName() {
        return name;
    }

    public String getSubdivision() {
        return subdivision;
    }
}