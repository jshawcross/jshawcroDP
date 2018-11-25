package main.java.state;

import java.util.Random;

public class SearchState implements BeeState {

    private Random rdm = new Random();
    
    /**
     * Method for performing actions.
     * 
     * @see main.java.state.BeeState#doAction(main.java.state.BeeS)
     */
    public String doAction(BeeS input) {  
        // Use 1 stamina to complete action
        input.setStamina(input.getStamina() - 1);  
        
        // If stamina is out then return, otherwise change to attacking
        if (input.getStamina() ==  0) {
            input.setState(new ReturnState());
        } else {
            if (rdm.nextBoolean()) {
                input.setState(new AttackState());
            }
        }
        
        return "search";
    }
    
    public String toString() {
        return "Searching";
    }
}