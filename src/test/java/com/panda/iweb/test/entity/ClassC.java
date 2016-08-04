package com.panda.iweb.test.entity;

import java.util.Date;

public class ClassC {

    private double   c_double;
    private boolean  c_boolean;
    private String   c_string;
    private Date     c_date;
    private RefClass ref;

    public double getC_double() {
        return c_double;
    }

    public void setC_double(double c_double) {
        this.c_double = c_double;
    }

    public boolean isC_boolean() {
        return c_boolean;
    }

    public void setC_boolean(boolean c_boolean) {
        this.c_boolean = c_boolean;
    }

    public String getC_string() {
        return c_string;
    }

    public void setC_string(String c_string) {
        this.c_string = c_string;
    }

    public Date getC_date() {
        return c_date;
    }

    public void setC_date(Date c_date) {
        this.c_date = c_date;
    }

    public RefClass getRef() {
        return ref;
    }

    public void setRef(RefClass ref) {
        this.ref = ref;
    }

}
