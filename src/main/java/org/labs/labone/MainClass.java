package org.labs.labone;

public class MainClass {
    public static void main(String[] args) {
        Water w = new Water();

        System.out.println(w.bottleColor);
        System.out.println(w.type);
        System.out.println(w.volume);

        System.out.println(w.bottleFlip);

        w.bottleFlip();

        System.out.println(w.bottleFlip);

        w.printVolume();
    }
}
