package main.java.state;

public class RestState implements BeeState {

    /**
     * Method for performing actions.
     * 
     * @see main.java.state.BeeState#doAction(main.java.state.BeeS)
     */
    public String doAction(BeeS input) {
        // Regain stamina from resting
        input.setStamina(input.getStaminaMax()); 
        
        // Change to next state based on bee type
        if (input.getBeeType() == "Queen") {
            input.setState(new LayState());
        } else if (input.getBeeType() == "Worker") {
            input.setState(new BuildState());
        } else if (input.getBeeType() == "Warrior") {
            input.setState(new SearchState());
        } else if (input.getBeeType() == "Drone") {
            input.setState(new ForageState());
        }
        
        return "-food";
    }
    
    public String toString() {
        return "Resting";
    }
}