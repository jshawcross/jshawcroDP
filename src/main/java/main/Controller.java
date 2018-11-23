package main.java.main;

import main.java.singleton.Apiary;
import main.java.singleton.BeeHive;

/**
 * Main controller used to demonstrate design patterns.
 * 
 * @author Jason Shawcross
 *
 */
public class Controller {

    /**
     * Main Class.
     * 
     * @param args String[], Default args
     */
    public static void main(String[] args) {
        System.out.println("Design Patterns, SER 316, jshawcro");

        // Singleton design pattern section
        System.out.println("\nSingleton\n---------");
        
        System.out.println("Initializing 1st reference with name 'Bee City'");
        Apiary beeApiary = Apiary.getInstance("Bee City");
        System.out.println("Name of 1st reference: " + beeApiary.getName());
        
        System.out.println("\nInitializing 2nd reference with name 'Bee Ville'");
        Apiary beeApiary2 = Apiary.getInstance("Bee Ville");
        System.out.println("Name of 2nd reference: " + beeApiary2.getName());
        
        System.out.println("\nSetting 1st reference name to 'Bee Ville'");
        beeApiary.setName("Bee Ville");
        System.out.println("Name of 1st reference: " + beeApiary.getName());
        System.out.println("Name of 2nd reference: " + beeApiary2.getName());
        
        System.out.println("\nCreating and adding a hive to 1st reference");
        BeeHive hive1 = new BeeHive(1);        
        beeApiary.addBeeHive(hive1);
        System.out.println(beeApiary.toString());
        
        System.out.println("Creating and adding two hives to 2nd reference");
        BeeHive hive2 = new BeeHive(2);
        BeeHive hive3 = new BeeHive(3);
        beeApiary2.addBeeHive(hive2);
        beeApiary2.addBeeHive(hive3);
        System.out.println(beeApiary2.toString());
        
        System.out.println("Removing a hive from 1st reference");
        beeApiary.removeBeeHive(2);
        System.out.println(beeApiary.toString());
        
        System.out.println("Getting a count of the number of BeeHives");
        System.out.println(beeApiary.countBeeHives());
        
        System.out.println("\nCreating and adding another hive and getting a count");
        BeeHive hive4 = new BeeHive(4);        
        beeApiary.addBeeHive(hive4);
        System.out.println(beeApiary.countBeeHives());
        
        // Factory Design Pattern section
        System.out.println("\nFactory\n-------");
        System.out.println("\nFactory\n-------");
        System.out.println("\nFactory\n-------");

        System.out.println("\nFactory\n-------");
    }

}
