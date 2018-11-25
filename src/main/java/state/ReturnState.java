package main.java.state;

public class ReturnState implements BeeState {

    /**
     * Method for performing actions.
     * 
     * @see main.java.state.BeeState#doAction(main.java.state.BeeS)
     */
    public String doAction(BeeS input) {
        // Bee returns to hive and changes to resting
        input.setState(new RestState());
        
        return "return";
    }
    
    public String toString() {
        return "Returning";
    }
}
