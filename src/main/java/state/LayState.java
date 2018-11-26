package main.java.state;

/**
 * Lay state class.
 * 
 * @author Jason Shawcross
 *
 */
public class LayState implements BeeState {

    /**
     * Method for performing actions.
     * 
     * @see main.java.state.BeeState#doAction(main.java.state.BeeS)
     */
    public String doAction(BeeS input) {
        // Use 1 stamina to complete action
        input.setStamina(input.getStamina() - 1);  
        
        // If stamina is out then rest, otherwise continue laying
        if (input.getStamina() ==  0) {
            input.setState(new RestState());
        }
        
        return "+egg";
    }
    
    public String toString() {
        return "Laying";
    }
}
