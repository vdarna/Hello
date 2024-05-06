package com.example.department.entity;
public enum Element {

    ONE("1","one is 1"),
    TWO("2","two is 2"),
    THREE("3","three is 3");

    public final String id;
    public final String label;

    private Element(String id,String label) {
        this.id = id;
        this.label = label;
    }

    public static String valueOfLabel(String label) {
        for (Element e : values()) {
            if (e.id.equals(label)) {
                return e.label;
            }
        }
        return null;
    }
}