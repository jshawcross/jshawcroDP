package main.java.main;

import main.java.builder.BeeHive;
import main.java.builder.BeeHive.BeeSpecies;
import main.java.factory.Bee;
import main.java.factory.Bee.BeeSpeciesF;
import main.java.factory.BeeFactory;
import main.java.singleton.Apiary;
import main.java.singleton.BeeHiveS;
import main.java.state.BeeS;


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
        System.out.println("\nSingleton Design Pattern\n------------------------");
        
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
        System.out.println("Builder Design Pattern\n----------------------");
        
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
        System.out.println("Output of BeeHive status: \n" + hiveb3.toString() + "\n");
        
        // Factory Design Pattern section
        
        System.out.println("Factory Design Pattern\n----------------------");
        System.out.println("Creating a queen bee of species Honey, id 1, BeeHive id 1");
        Bee bee1 = BeeFactory.getBee("Queen", 1, 1, BeeSpeciesF.Honey);
        System.out.println(bee1.toString() + "\n");
        
        System.out.println("Having queen bee, id 1, make 25 actions");
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                System.out.print(bee1.doAction() + " ");
            }
            System.out.print("\n");
        }
        
        System.out.println("\nCreating a worker bee of species Carpenter, id 2, BeeHive id 2");
        Bee bee2 = BeeFactory.getBee("Worker", 2, 2, BeeSpeciesF.Carpenter);
        System.out.println(bee2.toString() + "\n");
        
        System.out.println("Having worker bee, id 2, make 25 actions");
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                System.out.print(bee2.doAction() + " ");
            }
            System.out.print("\n");
        }
        
        System.out.println("\nCreating a warrior bee of species Killer, id 3, BeeHive id 3");
        Bee bee3 = BeeFactory.getBee("Warrior", 3, 3, BeeSpeciesF.Killer);
        System.out.println(bee3.toString() + "\n");
        
        System.out.println("Having warrior bee, id 3, make 25 actions");
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                System.out.print(bee3.doAction() + " ");
            }
            System.out.print("\n");
        }

        System.out.println("\nCreating a drone bee of species Super, id 4, BeeHive id 4");
        Bee bee4 = BeeFactory.getBee("Drone", 4, 4, BeeSpeciesF.Super);
        System.out.println(bee4.toString() + "\n");
        
        System.out.println("Having drone bee, id 4, make 25 actions");
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                System.out.print(bee4.doAction() + " ");
            }
            System.out.print("\n");
        }
        
        // State Design Pattern section
        System.out.println("\nState Design Pattern\n--------------------");
        System.out.println("Create Queen bee with 10 stamina");
        System.out.println("Having be make 25 actions");
        BeeS beeS1 = new BeeS(10, "Queen");
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                System.out.print(beeS1.doAction(beeS1) + " ");
            }
            System.out.print("\n");
        }
        
        System.out.println("\nCreate Worker bee with 10 stamina");
        System.out.println("Having be make 25 actions");
        BeeS beeS2 = new BeeS(10, "Worker");
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                System.out.print(beeS2.doAction(beeS2) + " ");
            }
            System.out.print("\n");
        }
        
        System.out.println("\nCreate Warrior bee with 10 stamina");
        System.out.println("Having be make 25 actions");
        BeeS beeS3 = new BeeS(10, "Warrior");
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                System.out.print(beeS3.doAction(beeS3) + " ");
            }
            System.out.print("\n");
        }
        
        System.out.println("\nCreate Drone bee with 10 stamina");
        System.out.println("Having be make 25 actions");
        BeeS beeS4 = new BeeS(10, "Drone");
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                System.out.print(beeS4.doAction(beeS4) + " ");
            }
            System.out.print("\n");
        }
    }
}
