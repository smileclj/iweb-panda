package com.panda.iweb.test.rpc;

import java.io.*;
import java.util.List;

/**
 * Created by huixiangdou on 2017/2/4.
 */
public class SerializationTest {
    private static String PATH = "/Users/chenlijiang/tmp/Serialization";

    public static void out() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(PATH));
            Param param = new Param();
//            param.setId(1);
            oos.writeObject(param);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void in() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(PATH));
            Param param = (Param) ois.readObject();
            System.out.println(param);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Param implements Serializable {
        private static final long serialVersionUID = 8171646200789765260L;
        private List<Integer> id;

        public List<Integer> getId() {
            return id;
        }

        public void setId(List<Integer> id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
//        SerializationTest.out();

        SerializationTest.in();
    }
}
