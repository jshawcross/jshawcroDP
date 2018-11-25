package main.java.state;

/**
 * Bee class for the State design pattern.
 * 
 * @author Jason Shawcross
 *
 */
public class BeeS implements BeeState {
    
    private int stamina;
    private int staminaMax;
    private String beeType;
    private BeeState currentState;
    
    /**
     * Constructor class.
     * 
     * @param inputStamina Integer, stamina
     * @param inputType String, type
     */
    public BeeS(int inputStamina, String inputType) {
        this.stamina = inputStamina;
        this.staminaMax = inputStamina;
        this.beeType = inputType;
        this.currentState = new RestState();
    }
    
    /**
     * Getter for stamina.
     * 
     * @return the stamina
     */
    public int getStamina() {
        return stamina;
    }

    /**
     * Setter for stamina.
     * 
     * @param stamina the stamina to set
     */
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    /**
     * Getter for max stamina.
     * 
     * @return the staminaMax
     */
    public int getStaminaMax() {
        return staminaMax;
    }

    /**
     * Getter for bee type.
     *  
     * @return the staminaMax
     */
    public String getBeeType() {
        return beeType;
    }

    
    public void setState(BeeState state) {
        this.currentState = state;
    }
    
    public BeeState getState() {
        return this.currentState;
    }
    
    
    public String doAction(BeeS input) {
        return this.currentState.doAction(input);
    }
    
}
