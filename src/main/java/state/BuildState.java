package main.java.state;

public class BuildState implements BeeState {

    /**
     * Method for performing actions.
     * 
     * @see main.java.state.BeeState#doAction(main.java.state.BeeS)
     */
    public String doAction(BeeS input) {
        // Use 1 stamina to complete action
        input.setStamina(input.getStamina() - 1); 
        
        // If stamina is out then rest, otherwise change to hatching 
        if (input.getStamina() ==  0) {
            input.setState(new RestState());
        } else {
            input.setState(new HatchState());
        }
        
        return "+work";
    }
    
    public String toString() {
        return "Building";
    }
}