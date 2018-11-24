package main.java.main;

import main.java.builder.BeeHive;
import main.java.builder.BeeHive.BeeSpecies;
import main.java.singleton.Apiary;
import main.java.singleton.BeeHiveS;

/**
 * Controller used to demonstrate design patterns.
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
        BeeHiveS hive1 = new BeeHiveS(1);        
        beeApiary.addBeeHive(hive1);
        System.out.println(beeApiary.toString());
        
        System.out.println("Creating and adding two hives to 2nd reference");
        BeeHiveS hive2 = new BeeHiveS(2);
        BeeHiveS hive3 = new BeeHiveS(3);
        beeApiary2.addBeeHive(hive2);
        beeApiary2.addBeeHive(hive3);
        System.out.println(beeApiary2.toString());
        
        System.out.println("Getting count of Number of hives: " + beeApiary.countBeeHives() + "\n");
        
        System.out.println("Removing a hive from 1st reference");
        beeApiary.removeBeeHive(2);
        System.out.println(beeApiary.toString());
        
        System.out.println("Getting count of Number of hives: " + beeApiary.countBeeHives() + "\n");
        
        // Builder Design Pattern section
        System.out.println("Builder\n-------");
        
        System.out.println("Creating BeeHive with id 1 and location (2,3)");
        System.out.println("and default parameters");
        BeeHive hiveb1 = new BeeHive.BeeHiveBuilder(1, 2, 3).build();
        System.out.println("Output of BeeHive status: \n" + hiveb1.toString());
        
        System.out.println("\nCreating BeeHive with id 2, and location (5,6)");
        System.out.println("and setting bee species to Bumble");
        BeeHive hiveb2 = new BeeHive.BeeHiveBuilder(2, 5, 6).setSpecies(BeeSpecies.Bumble).build();
        System.out.println("Output of BeeHive status: \n" + hiveb2.toString());
        
        System.out.println("\nCreating BeeHive with id 3, and location (-10,4)");
        System.out.println("and setting bee species to Killer, food to 20, eggs to 2,");
        System.out.println("rooms to 5, and work required to 25");
        BeeHive hiveb3 = new BeeHive.BeeHiveBuilder(3, -10, 4)
                .setSpecies(BeeSpecies.Killer)
                .setFoodAmount(20)
                .setEggAmount(2)
                .setRoomAmount(5)
                .setWorkRequired(25)
                .build();
        System.out.println("Output of BeeHive status: \n" + hiveb3.toString());
    }

}
