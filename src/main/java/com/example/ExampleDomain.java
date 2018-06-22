package com.example;

public class ExampleDomain {

    private String a;
    private String b;
    private Integer c;

    public ExampleDomain() {
    }

    public ExampleDomain(String a, String b, Integer c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "ExampleDomain{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c=" + c +
                '}';
    }
}
