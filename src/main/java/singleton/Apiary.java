package main.java.singleton;

import java.util.Vector;

public class Apiary {
    
    private static Apiary apiaryInstance = null;
    
    private String name;
    private Vector<BeeHive> hives;

    private Apiary(String inputName) {
        name = inputName;
        hives = new Vector<BeeHive>();
    }
    
    public static Apiary getInstance(String inputName) {
        if (apiaryInstance == null) {
            apiaryInstance = new Apiary(inputName);
        }
        
        return apiaryInstance;
    }

    public String getName() {
        return name;
    }

    public void setName(String inputName) {
        this.name = inputName;
    }
    
    
}
