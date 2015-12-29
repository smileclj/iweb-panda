package com.iweb.panda.entity;

import java.io.Serializable;
import java.util.Date;

public class TestObject implements Serializable {

    private static final long serialVersionUID = -4078626308349257072L;

    private int               c_int;
    private char              c_char;
    private char              c_char_valid     = '1';
    private double            c_double;
    private float             c_float;
    private long              c_long;
    private short             c_short;
    private byte              c_byte;
    private boolean           c_boolean;

    private String            c_string;
    private Object            c_object;
    private Date              c_date;
    private Date              now              = new Date();

    public int getC_int() {
        return c_int;
    }

    public void setC_int(int c_int) {
        this.c_int = c_int;
    }

    public char getC_char() {
        return c_char;
    }

    public void setC_char(char c_char) {
        this.c_char = c_char;
    }

    public double getC_double() {
        return c_double;
    }

    public void setC_double(double c_double) {
        this.c_double = c_double;
    }

    public float getC_float() {
        return c_float;
    }

    public void setC_float(float c_float) {
        this.c_float = c_float;
    }

    public long getC_long() {
        return c_long;
    }

    public void setC_long(long c_long) {
        this.c_long = c_long;
    }

    public short getC_short() {
        return c_short;
    }

    public void setC_short(short c_short) {
        this.c_short = c_short;
    }

    public byte getC_byte() {
        return c_byte;
    }

    public void setC_byte(byte c_byte) {
        this.c_byte = c_byte;
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

    public Object getC_object() {
        return c_object;
    }

    public void setC_object(Object c_object) {
        this.c_object = c_object;
    }

    public Date getC_date() {
        return c_date;
    }

    public void setC_date(Date c_date) {
        this.c_date = c_date;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public char getC_char_valid() {
        return c_char_valid;
    }

    public void setC_char_valid(char c_char_valid) {
        this.c_char_valid = c_char_valid;
    }

}
