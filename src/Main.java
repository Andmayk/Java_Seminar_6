import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Set<Laptop> laptops = new HashSet<>();
        Laptop laptopSearch = new Laptop();
        laptopSearch.clear();

        Integer[] ramArray = new Integer[] {4, 8, 16, 32, 64};
        Integer[] hddArray = new Integer[] {256, 512, 1024, 2048, 4096};
        String[] firmArray = new String[] {"A5U5", "IIP", "Lenivo", "M51", "Maple", "6i6aByte", "5AM5UNG"};
        String[] osArray = new String[] {"без ОС", "Windoors", "Lenix", "Ioss"};
        String[] colorArray = new String[] {"черный", "белый", "серебритый", "красный", "синий", "желтый", "зеленый"};

        int countLaptops = 10;
        supplyOfLaptops(laptops, countLaptops, ramArray, hddArray, firmArray, osArray, colorArray);

        try (Scanner scanner = new Scanner(System.in)) {
            int userAnsver;
            do {
                System.out.println("""
                        Введите цифру, соответствующую необходимому критерию:
                        1 - ОЗУ
                        2 - Объем ЖД
                        3 - Операционная система
                        4 - Цвет
                        5 - Фирма производитель
                        6 - Поиск по заданным параметрам
                        7 - для вывода всего списка ноутбуков
                        8 - очистить параметры поиска
                        0 - для выхода""");

                userAnsver = Integer.parseInt(scanner.nextLine());
                switch (userAnsver) {
                    case 1 -> {
                        System.out.print("Введите минимальный объём ОЗУ: ");
                        laptopSearch.setRam(Integer.parseInt((scanner.nextLine())));
                    }
                    case 2 -> {
                        System.out.print("Введите минимальный объём HDD: ");
                        laptopSearch.setHdd(Integer.parseInt((scanner.nextLine())));
                    }
                    case 3 -> {
                        System.out.println("Введите цифру, соответствующую необходимой ОС: ");
                        laptopSearch.setOs(select(osArray));
                    }
                    case 4 -> {
                        System.out.println("Введите цифру, соответствующую цвету для отбора: ");
                        laptopSearch.setColor(select(colorArray));
                    }
                    case 5 -> {
                        System.out.println("Введите цифру, для отбора по производителю: ");
                        laptopSearch.setFirm(select(firmArray));
                    }
                    case 6 -> printFind(laptops, laptopSearch);
                    case 7 -> printSet(laptops);
                    case 8 -> laptopSearch.clear();
                }

            } while (userAnsver != 0);
        }
    }

    static void printFind(Set<Laptop> set, Laptop findLaptop){
        System.out.println("Список ноутбуков по Вашим параметрам:");
        boolean found = false;
        for (Laptop laptop: set){
            if (findLaptop.getRam()>0){
                if (findLaptop.getRam() > laptop.getRam()){
                    continue;
                }
            }
            if (findLaptop.getHdd()>0){
                if (findLaptop.getHdd() > laptop.getHdd()){
                    continue;
                }
            }
            if (!findLaptop.getOs().isEmpty()){
                if (!findLaptop.getOs().equals(laptop.getOs())){
                    continue;
                }
            }
            if (!findLaptop.getFirm().isEmpty()){
                if (!findLaptop.getFirm().equals(laptop.getFirm())){
                    continue;
                }
            }
            if (!findLaptop.getColor().isEmpty()){
                if (!findLaptop.getColor().equals(laptop.getColor())){
                    continue;
                }
            }
            found = true;
            System.out.println(laptop);
            }

        if (!found){
            System.out.println("По Вашему параметрам ничего не найдено.");
        }
    }

    static String select(String[] Array) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i<Array.length; i++){
            System.out.println((i+1)+ " - " + Array[i]);
        }
        int i = Integer.parseInt((scanner.nextLine()));
        return Array[i-1];
    }

    static void supplyOfLaptops(Set<Laptop> set, int count, Integer[] ramArray, Integer[] hddArray, String[] firmArray ,String[] osArray , String[] colorArray) {
        Random random = new Random();

        while (set.size()<count) {
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
