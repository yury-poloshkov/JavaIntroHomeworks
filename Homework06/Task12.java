package Homework06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Homework06.Notebook.Color;
import Homework06.Notebook.HDtype;
import Homework06.Notebook.OpSystem;
import Homework06.Notebook.Producer;
import Homework06.Notebook.Storage;;

/**
 * Task12
 * Создать множество ноутбуков.
 * Написать метод, который будет запрашивать у пользователя критерий фильтрации 
 * и выведет ноутбуки, отвечающие фильтру.
 */
public class Task12 {

    public static void main(String[] args){
        List<Notebook> notebooks = new ArrayList<>();
        initialazeTestStock(notebooks);
        HashMap<String, String> filter = new HashMap<>();
        chooseFilters(filter);
        System.out.println(filter.toString());
        List<Notebook> filtredNotebooks = new ArrayList<>();
        filtredNotebooks.addAll(notebooks);
        chooseNotebooks(filtredNotebooks, filter);
        PrintPriceList(filtredNotebooks);
    }

    private static void PrintPriceList(List<Notebook> filtredNotebooks) {
        int i = 0;
        for (Notebook notebook : filtredNotebooks) {
            System.out.println((i+1) + ": " + notebook.toString() + " @: " + 
                            notebook.getStockplace() + " - " + notebook.getPrice() + " руб.");
            i++;
        }
    }

    private static void chooseNotebooks(List<Notebook> filtredNotebooks, HashMap<String, String> filter) {
        for (var item : filter.keySet()) {
            switch (item) {
                case "producer":
                    for (int i = filtredNotebooks.size()-1; i >=0; i--) {
                        if (!filtredNotebooks.get(i).getProducer().equals(filter.get(item))){
                            filtredNotebooks.remove(i);
                        }
                    }
                    break;
                case "hd":
                    for (int i = filtredNotebooks.size()-1; i >=0; i--) {
                        if (!filtredNotebooks.get(i).getHd().equals(filter.get(item))){
                            filtredNotebooks.remove(i);
                        }
                    }
                    break;
                case "hdCapacity":
                    for (int i = filtredNotebooks.size()-1; i >=0; i--) {
                        if (filtredNotebooks.get(i).getHdCapacity() < Integer.parseInt(filter.get(item))){
                            filtredNotebooks.remove(i);
                        }
                    }                     
                    break;
                case "ramCapacity":
                    for (int i = filtredNotebooks.size()-1; i >=0; i--) {
                        if (filtredNotebooks.get(i).getRamCapacity() < Integer.parseInt(filter.get(item))){
                            filtredNotebooks.remove(i);
                        }
                    }                     
                    break;
                case "graphics":
                    for (int i = filtredNotebooks.size()-1; i >=0; i--) {
                        if (!filtredNotebooks.get(i).getGraphics().equals(filter.get(item))){
                            filtredNotebooks.remove(i);
                        }
                    }                    
                    break;
                case "processor":
                    for (int i = filtredNotebooks.size()-1; i >=0; i--) {
                        if (!filtredNotebooks.get(i).getProcessor().equals(filter.get(item))){
                            filtredNotebooks.remove(i);
                        }
                    }                    
                    break;
                case "os":
                    for (int i = filtredNotebooks.size()-1; i >=0; i--) {
                        if (!filtredNotebooks.get(i).getOs().equals(filter.get(item))){
                            filtredNotebooks.remove(i);
                        }
                    }                    
                    break;
                case "color":
                    for (int i = filtredNotebooks.size()-1; i >=0; i--) {
                        if (!filtredNotebooks.get(i).getColor().equals(filter.get(item))){
                            filtredNotebooks.remove(i);
                        }
                    }                      
                    break;
                case "price": // printing less than target price 
                    for (int i = filtredNotebooks.size()-1; i >=0; i--) {
                        if (filtredNotebooks.get(i).getPrice() > Float.parseFloat(filter.get(item))){
                            filtredNotebooks.remove(i);
                        }
                    }                     
                    break;
                default:
                    break;
            }
            
        }
    }

    public static void chooseFilters(HashMap<String, String> filter){
        List<String> filters = new ArrayList<>(List.of(
            "----- Поиск ноутбуков по параметрам -----",
            "1 - по производителю",
            "2 - по типу жесткого диска",
            "3 - по объему жесткого диска",
            "4 - по объему оперативной памяти",
            "5 - по графической карте",
            "6 - по процессору",
            "7 - по операционной системе",
            "8 - по цвету",
            "9 - по цене",
            "-------------------------------------",
            "0 - Искать по выбранным параметрам"
        ));

        int userChoice = -1;
        int subChoise = 0;
        int counter = 0;
        List<String> subMenu = new ArrayList<>();
        while (userChoice != 0) {
            if (!filter.isEmpty()){
                System.out.println(filter.toString());
                timeOut();
            }
            userChoice = showMainMenu(filters);
            counter = 1;
            subMenu.clear();
            switch (userChoice) {        
                case 1:
                    for (var item : Producer.values()) {
                        subMenu.add("" + counter + " - " + item);
                        counter++;                        
                    }
                    subChoise = showMainMenu(subMenu);
                    if (!(subChoise>subMenu.size())){
                        filter.put("producer", "" + Producer.valueOf(subMenu.get(subChoise-1).substring(subMenu.get(subChoise-1).lastIndexOf(" - ")+3)));
                    }
                    break;
                case 2:
                    for (var item : HDtype.values()) {
                        subMenu.add("" + counter + " - " + item);
                        counter++;                        
                    }
                    subChoise = showMainMenu(subMenu);
                    if (!(subChoise>subMenu.size())){
                        filter.put("hd", "" + HDtype.valueOf(subMenu.get(subChoise-1).substring(subMenu.get(subChoise-1).lastIndexOf(" - ")+3)));
                    }
                    break;
                case 3:
                    for (int i = 0; i < 4; i++) {
                        subMenu.add("" + i + " - " + (int)Math.pow(2, 8 + i)); 
                    }
                    subChoise = showMainMenu(subMenu);
                    if (!(subChoise>subMenu.size())){
                        filter.put("hdCapacity", "" + (subMenu.get(subChoise-1).substring(subMenu.get(subChoise-1).lastIndexOf(" - ")+3)));
                    }
                    break;
                case 4:
                    for (int i = 0; i < 8; i++) {
                        subMenu.add("" + i + " - " + (int)Math.pow(2, 8 + i)); 
                    }
                    subChoise = showMainMenu(subMenu);
                    if (!(subChoise>subMenu.size())){
                        filter.put("ramCapacity", "" + (subMenu.get(subChoise-1).substring(subMenu.get(subChoise-1).lastIndexOf(" - ")+3)));
                    }
                    break;
                case 5:
                    subMenu.add("1 - Radeon");
                    subMenu.add("2 - nVidea");
                    subChoise = showMainMenu(subMenu);
                    if (!(subChoise>subMenu.size())){
                        filter.put("graphics", "" + (subMenu.get(subChoise-1).substring(subMenu.get(subChoise-1).lastIndexOf(" - ")+3)));
                    }
                    break;
                case 6:
                    subMenu.add("1 - Intel");
                    subMenu.add("2 - Athlon");
                    subChoise = showMainMenu(subMenu);
                    if (!(subChoise>subMenu.size())){
                        filter.put("processor", "" + (subMenu.get(subChoise-1).substring(subMenu.get(subChoise-1).lastIndexOf(" - ")+3)));
                    }
                    break;
                case 7:
                    for (var item : OpSystem.values()) {
                        subMenu.add("" + counter + " - " + item);
                        counter++;                        
                    }
                    subChoise = showMainMenu(subMenu);
                    if (!(subChoise>subMenu.size())){
                        filter.put("os", "" + OpSystem.valueOf(subMenu.get(subChoise-1).substring(subMenu.get(subChoise-1).lastIndexOf(" - ")+3)));
                    }
                    break;
                case 8:
                    for (var item : Color.values()) {
                        subMenu.add("" + counter + " - " + item);
                        counter++;                        
                    }
                    subChoise = showMainMenu(subMenu);
                    if (!(subChoise>subMenu.size())){
                        filter.put("color", "" + Color.valueOf(subMenu.get(subChoise-1).substring(subMenu.get(subChoise-1).lastIndexOf(" - ")+3)));
                    }
                    break;
                case 9:
                    System.out.print("\nВведите цену ноутбука: ");
                    Scanner scn = new Scanner(System.in);
                    float price = Float.parseFloat(scn.next());
                    if (price > 0){
                        filter.put("price", ""+price);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.printf("Error: %s - unsupported operation!\n", userChoice);
                    timeOut();
                    break;

            }
        }
    }
    public static int showMainMenu(List<String> menu) {
        System.out.print("\033[H\033[J");
        for (String option : menu) {
            System.out.println(option);
        }
        System.out.print("\nВведите код фильтрации: ");
        Scanner scn = new Scanner(System.in);
        int choice = Integer.parseInt(scn.next());
        if (choice == 0) scn.close();
        return choice;
    }
    public static void initialazeTestStock(List<Notebook> nb) {
        int count = 100;
        Random rnd = new Random();
        List colors = new ArrayList(List.of(Color.values()));
        List opSystems = new ArrayList(List.of(OpSystem.values()));
        List producers = new ArrayList(List.of(Producer.values()));
        List hds = new ArrayList(List.of(HDtype.values()));
        List storages = new ArrayList(List.of(Storage.values()));
        for (int i = 0; i < count; i++) {
            String producer = "" + producers.get(rnd.nextInt(producers.size()));
            String os = producer.equals(producers.get(0))?""+opSystems.get(0):""+opSystems.get(rnd.nextInt(opSystems.size())); 
            String hdType = "" + hds.get(rnd.nextInt(hds.size()));
            int hdCapacity = (int)Math.pow(2, 8 + rnd.nextInt(4));
            int ramCapacity = (int)Math.pow(2, 8 + rnd.nextInt(8));
            String graphics = rnd.nextInt()>0.5?"Radeon":"nVidea";
            String processor = rnd.nextInt()>0.5?"Intel":"Athlon";
            String color = "" + colors.get(rnd.nextInt(colors.size()));
            String stock = "" + storages.get(rnd.nextInt(storages.size()));
            String stockplace = String.format("Shelf: %d, position: %d", ((int)i/10+1), (int)(i%10+1));
            float price = ramCapacity*10 + hdCapacity/5 + 10000/(1 + producers.indexOf(producer)/producers.size())+
                10000/(1 + opSystems.indexOf(os)/opSystems.size()) + 10000/(1 + hds.indexOf(hdType)/hds.size());
            Notebook notebook = new Notebook(producer, hdType, hdCapacity, ramCapacity, graphics, 
                                            processor, os, color, stock, stockplace, price);
            nb.add(notebook);
        }
    }
    
    private static void timeOut(){
        System.out.println("Press ENTER to continue");
        Scanner stopscn = new Scanner(System.in);
        stopscn.nextLine();
        //stopscn.close();
    }    
}