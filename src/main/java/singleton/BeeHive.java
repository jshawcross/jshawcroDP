package main.java.singleton;

/**
 * Dummy class used for Apiary class in singleton demo.
 * 
 * @author Jason Shawcross
 *
 */
public class BeeHive {

    private int id;

    public BeeHive(int input) {
        id = input;
    }
        
    public int getId() {
        return id;
    }
    
    public String toString() {
        return "Beehive id: " + String.valueOf(id);
    }
}
