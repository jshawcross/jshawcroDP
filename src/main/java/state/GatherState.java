package main.java.state;

/**
 * Gather state class.
 * 
 * @author Jason Shawcross
 *
 */
public class GatherState implements BeeState {

    /**
     * Method for performing actions.
     * 
     * @see main.java.state.BeeState#doAction(main.java.state.BeeS)
     */
    public String doAction(BeeS input) {
        // Use 1 stamina to complete action
        input.setStamina(input.getStamina() - 1); 
        
        // If stamina is out then return, otherwise start foraging again
        if (input.getStamina() ==  0) {
            input.setState(new ReturnState());
        } else {
            input.setState(new ForageState());
        }
        
        return "+food";
    }
    
    public String toString() {
        return "Gathering";
    }
}
