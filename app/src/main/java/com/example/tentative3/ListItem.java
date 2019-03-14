package com.example.tentative3;

import org.json.JSONArray;

import java.util.ArrayList;

public class ListItem {

    private String head;
    private String desc;
    private String imageUrl;
    private String type;
    private String height;
    private String weight;
    private String weaknesses;


    public ListItem(String head, String desc, String imageUrl, String type, String height, String weight, String weaknesses) {
        this.head = head;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.weaknesses = weaknesses;

    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getType() { return type; }

    public String getHeight() { return height; }

    public String getWeight() { return weight; }

    public String getWeaknesses() {return weaknesses; }
}
