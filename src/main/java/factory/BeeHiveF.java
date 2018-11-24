package main.java.factory;

/**
 * Dummy class used for Bee class in factory demo.
 * 
 * @author Jason Shawcross
 *
 */
public class BeeHiveF {

    public static enum BeeSpecies {
        Honey, Killer, Carpenter, Bumble, Tiny, Super;
    }
    
    private int id;
    private BeeSpecies species;

    public BeeHiveF(int input, BeeSpecies inputSpecies) {
        id = input;
        species = inputSpecies;
    }
        
    public int getId() {
        return id;
    }
    
    public BeeSpecies getSpecies() {
        return species;
    }

    public String toString() {
        return "Beehive id: " + String.valueOf(id);
    }
}