package com.arunkpatra.blog.model;

public class Person {

    private long id;
    private String first;
    private String last;

    public Person() {
    }

    public Person(long id, String first, String last) {
        this.id = id;
        this.first = first;
        this.last = last;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
