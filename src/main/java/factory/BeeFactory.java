package main.java.factory;

import main.java.factory.Bee.BeeSpeciesF;

/**
 * Factory class to create bees of different types.
 * 
 * @author Jason Shawcross
 *
 */
public class BeeFactory {

    /**
     * Factory method to return new bee of the specified type.
     * 
     * @param inputType String, type of bee to create
     * @param inputId Integer, id of bee
     * @param inputHiveId Integer, id of bee hive the bee belongs to
     * @param inputSpecies BeeSpecies, Species of the bee
     * @return
     */
    public static Bee getBee(String inputType, int inputId, 
                int inputHiveId, BeeSpeciesF inputSpecies) {
        if  (inputType.equals("Queen")) {
            return new Queen(inputId, inputHiveId, inputSpecies);
        } else if  (inputType.equals("Worker")) {
            return new Worker(inputId, inputHiveId, inputSpecies);
        } else if  (inputType.equals("Warrior")) {
            return new Warrior(inputId, inputHiveId, inputSpecies);
        } else if  (inputType.equals("Drone")) {
            return new Drone(inputId, inputHiveId, inputSpecies);
        }
        
        return null;
    }
}
