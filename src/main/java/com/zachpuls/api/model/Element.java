package com.zachpuls.api.model;

/**
 * Created by zpuls on 3/17/2016.
 */
public class Element {

    private String label = "";
    private String id = "";

    public Element() {}

    public Element(String label, String value) {
        this.label = label;
        this.id = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
