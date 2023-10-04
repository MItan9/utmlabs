package org.labs.labone;

public class Water {
    String type = "Carbonated";
    String bottleColor = "Blue";
    int volume = 500;

    static boolean drunkWater = false;
    static boolean bottleFlip = true;

    public static void drunkWater(){
        drunkWater = true;
    }
    public static void bottleFlip(){
        bottleFlip = false;
    }
    public void printVolume() {
        System.out.println("volume: " + this.volume);

    }
}
