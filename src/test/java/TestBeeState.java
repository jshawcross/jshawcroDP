package test.java;

import static org.junit.Assert.assertTrue;

import main.java.state.AttackState;
import main.java.state.BeeS;
import main.java.state.BuildState;
import main.java.state.ForageState;
import main.java.state.GatherState;
import main.java.state.HatchState;
import main.java.state.LayState;
import main.java.state.ReturnState;
import main.java.state.SearchState;

import org.junit.Test;

public class TestBeeState {

    // State tests
    
    /**
     * Test for a BeeS object starting with rest state.
     */
    @Test
    public void startState() {
        BeeS bee1 = new BeeS(10, "Queen");
        assertTrue((bee1.getState()).toString().equals("Resting"));
    }
    
    /**
     * Test for a Queen BeeS object changing to second state.
     */
    @Test
    public void queenSecondState() {
        BeeS bee1 = new BeeS(10, "Queen");
        assertTrue(bee1.doAction(bee1).equals("-food"));
        assertTrue((bee1.getState()).toString().equals("Laying"));
    }
    
    /**
     * Test for a Worker BeeS object changing to second state.
     */
    @Test
    public void workerSecondState() {
        BeeS bee1 = new BeeS(10, "Worker");
        assertTrue(bee1.doAction(bee1).equals("-food"));
        assertTrue((bee1.getState()).toString().equals("Building"));
    }
    
    /**
     * Test for a Warrior BeeS object changing to second state.
     */
    @Test
    public void warriorSecondState() {
        BeeS bee1 = new BeeS(10, "Warrior");
        assertTrue(bee1.doAction(bee1).equals("-food"));
        assertTrue((bee1.getState()).toString().equals("Searching"));
    }
    
    /**
     * Test for a Drone BeeS object changing to second state.
     */
    @Test
    public void droneSecondState() {
        BeeS bee1 = new BeeS(10, "Drone");
        assertTrue(bee1.doAction(bee1).equals("-food"));
        assertTrue((bee1.getState()).toString().equals("Foraging"));
    }
    
    /**
     * Test for a AttackState, stamina not out.
     */
    @Test
    public void attackState() {
        BeeS bee1 = new BeeS(10, "Warrior");
        bee1.setState(new AttackState());
        assertTrue(bee1.doAction(bee1).equals("attack"));
        assertTrue((bee1.getState()).toString().equals("Searching"));
    }
    
    /**
     * Test for a AttackState, stamina out.
     */
    @Test
    public void attackStateStaminaOut() {
        BeeS bee1 = new BeeS(1, "Warrior");
        bee1.setState(new AttackState());
        assertTrue(bee1.doAction(bee1).equals("attack"));
        assertTrue((bee1.getState()).toString().equals("Returning"));
    }
    
    /**
     * Test for a BuildState, stamina not out.
     */
    @Test
    public void buildState() {
        BeeS bee1 = new BeeS(10, "Worker");
        bee1.setState(new BuildState());
        assertTrue(bee1.doAction(bee1).equals("+work"));
        assertTrue((bee1.getState()).toString().equals("Hatching"));
    }
    
    /**
     * Test for a Build State, stamina out.
     */
    @Test
    public void buildStateStaminaOut() {
        BeeS bee1 = new BeeS(1, "Worker");
        bee1.setState(new BuildState());
        assertTrue(bee1.doAction(bee1).equals("+work"));
        assertTrue((bee1.getState()).toString().equals("Resting"));
    }
    
    /**
     * Test for a Forage State, stamina not out.
     */
    @Test
    public void forageState() {
        BeeS bee1 = new BeeS(10, "Drone");
        bee1.setState(new ForageState());
        assertTrue(bee1.doAction(bee1).equals("forage"));
        String test = bee1.getState().toString();
        assertTrue(test.equals("Foraging") || test.equals("Gathering"));
    }
    
    /**
     * Test for a Forage State, stamina out.
     */
    @Test
    public void forageStateStaminaOut() {
        BeeS bee1 = new BeeS(1, "Drone");
        bee1.setState(new ForageState());
        assertTrue(bee1.doAction(bee1).equals("forage"));
        assertTrue((bee1.getState()).toString().equals("Returning"));
    }
    
    /**
     * Test for a Gather State, stamina not out.
     */
    @Test
    public void gatherState() {
        BeeS bee1 = new BeeS(10, "Drone");
        bee1.setState(new GatherState());
        assertTrue(bee1.doAction(bee1).equals("+food"));
        assertTrue((bee1.getState()).toString().equals("Foraging"));
    }
    
    /**
     * Test for a Gather State, stamina out.
     */
    @Test
    public void gatherStateStaminaOut() {
        BeeS bee1 = new BeeS(1, "Drone");
        bee1.setState(new GatherState());
        assertTrue(bee1.doAction(bee1).equals("+food"));
        assertTrue((bee1.getState()).toString().equals("Returning"));
    }
    
    /**
     * Test for a Hatch State, stamina not out.
     */
    @Test
    public void hatchState() {
        BeeS bee1 = new BeeS(10, "Worker");
        bee1.setState(new HatchState());
        assertTrue(bee1.doAction(bee1).equals("-egg"));
        assertTrue((bee1.getState()).toString().equals("Building"));
    }
    
    /**
     * Test for a Hatch State, stamina out.
     */
    @Test
    public void hatchStateStaminaOut() {
        BeeS bee1 = new BeeS(1, "Worker");
        bee1.setState(new HatchState());
        assertTrue(bee1.doAction(bee1).equals("-egg"));
        assertTrue((bee1.getState()).toString().equals("Resting"));
    }
    
    /**
     * Test for a Lay State stamina out.
     */
    @Test
    public void layStateStaminaOut() {
        BeeS bee1 = new BeeS(1, "Queen");
        bee1.setState(new LayState());
        assertTrue(bee1.doAction(bee1).equals("+egg"));
        assertTrue((bee1.getState()).toString().equals("Resting"));
    }
    
    /**
     * Test for a Return State stamina out.
     */
    @Test
    public void returnState() {
        BeeS bee1 = new BeeS(0, "Warrior");
        bee1.setState(new ReturnState());
        assertTrue(bee1.doAction(bee1).equals("return"));
        assertTrue((bee1.getState()).toString().equals("Resting"));
    }
    
    /**
     * Test for a Search State, stamina not out.
     */
    @Test
    public void searchState() {
        BeeS bee1 = new BeeS(10, "Warrior");
        bee1.setState(new SearchState());
        assertTrue(bee1.doAction(bee1).equals("search"));
        String test = bee1.getState().toString();
        assertTrue(test.equals("Attacking") || test.equals("Searching"));
    }
    
    /**
     * Test for a Search State, stamina out.
     */
    @Test
    public void searchStateStaminaOut() {
        BeeS bee1 = new BeeS(1, "Warrior");
        bee1.setState(new SearchState());
        assertTrue(bee1.doAction(bee1).equals("search"));
        assertTrue((bee1.getState()).toString().equals("Returning"));
    }

}
