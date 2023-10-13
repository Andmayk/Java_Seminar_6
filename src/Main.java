import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Set<Laptop> laptops = new HashSet<>();

        int countLaptops = 10;

        supplyOfLaptops(laptops, countLaptops);

        printSet(laptops);

    }

    static void supplyOfLaptops(Set<Laptop> set, int count) {
        Random random = new Random();
        Integer[] ramArray = new Integer[] {4, 8, 16, 32, 64};
        Integer[] hddArray = new Integer[] {256, 512, 1024, 2048, 4096};
        String[] firmArray = new String[] {"A5U5", "IIP", "Lenivo", "M51", "Maple", "616aByte", "5am5UNG"};
        String[] osArray = new String[] {"без ОС", "Windoors", "Lenix", "Ioss"};
        String[] colorArray = new String[] {"черный", "белый", "серебритый", "красный", "синий", "желтый", "зеленый"};

        for (int i = 0; i < count; i++ ) {
            Laptop nout = new Laptop();
            nout.setFirm(firmArray[random.nextInt(0, firmArray.length)]);
            nout.setRam(ramArray[random.nextInt(0, ramArray.length)]);
            nout.setHdd(hddArray[random.nextInt(0, hddArray.length)]);
            nout.setOs(osArray[random.nextInt(0, osArray.length)]);
            nout.setColor(colorArray[random.nextInt(0, colorArray.length)]);
            set.add(nout);
        }
    }

    static void printSet(Set<Laptop> set){
        for (Laptop laptop: set){
            System.out.println(laptop);
        }
    }
}