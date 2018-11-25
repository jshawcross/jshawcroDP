package main.java.state;

public class AttackState implements BeeState {

    /**
     * Method for performing actions.
     * 
     * @see main.java.state.BeeState#doAction(main.java.state.BeeS)
     */
    public String doAction(BeeS input) {
        // Use 1 stamina to complete action
        input.setStamina(input.getStamina() - 1);
        
        // If stamina is out then return, otherwise continue searching
        if (input.getStamina() ==  0) {
            input.setState(new ReturnState());
        } else {
            input.setState(new SearchState());
        }
        
        return "attack";
    }
    
    public String toString() {
        return "Attacking";
    }
}
