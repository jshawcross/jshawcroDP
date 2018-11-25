package main.java.state;

public class HatchState implements BeeState {

    /**
     * Method for performing actions.
     * 
     * @see main.java.state.BeeState#doAction(main.java.state.BeeS)
     */
    public String doAction(BeeS input) {
        // Use 1 stamina to complete action
        input.setStamina(input.getStamina() - 1); 
        
        // If stamina is out then rest, otherwise start building
        if (input.getStamina() ==  0) {
            input.setState(new RestState());
        } else {
            input.setState(new BuildState());
        }
        
        return "-egg";
    }
    
    public String toString() {
        return "Hatching";
    }
}