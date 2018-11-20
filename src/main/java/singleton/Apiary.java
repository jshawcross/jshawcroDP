package main.java.singleton;

import java.util.Vector;

/**
 * @author user
 *
 */
public class Apiary {
    
    private static Apiary apiaryInstance = null;
    
    private String name;
    private Vector<BeeHive> hives;

    /**
     * @param inputName
     */
    private Apiary(String inputName) {
        name = inputName;
        hives = new Vector<BeeHive>();
    }
    
    /**
     * @param inputName
     * @return
     */
    public static Apiary getInstance(String inputName) {
        if (apiaryInstance == null) {
            apiaryInstance = new Apiary(inputName);
        }
        
        return apiaryInstance;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param inputName
     */
    public void setName(String inputName) {
        this.name = inputName;
    }
    
    public void addBeeHive() {
        
    }
    
}
