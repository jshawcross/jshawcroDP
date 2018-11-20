package main.java.main;

import main.java.singleton.Apiary;

/**
 * @author user
 *
 */
public class Controller {

    /**
     * @param args
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
    }

}
