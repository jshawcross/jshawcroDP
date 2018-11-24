package test.java;

import static org.junit.Assert.assertTrue;

import main.java.factory.Bee;
import main.java.factory.Bee.BeeSpeciesF;
import main.java.factory.Bee.BeeState;
import main.java.factory.BeeFactory;

import org.junit.Test;

public class TestFactory {

    /**
     * Test to make sure null is returned if invalid bee type passed.
     */
    @Test
    public void createInvalid() {
        Bee bee1 = BeeFactory.getBee("none", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1 == null);
    }
    
    /**
     * Test the getId method of superclass Bee.
     */
    @Test
    public void testGetId() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1.getId() == 1);
    }
    
    /**
     * Test the getBeeHiveId method of superclass Bee.
     */
    @Test
    public void testGetBeeHiveId() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1.getBeeHiveId() == 5);
    }
    
    /**
     * Test the setBeeHiveId method of superclass Bee.
     */
    @Test
    public void testSetBeeHiveId() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Honey);
        bee1.setBeeHiveId(10);
        assertTrue(bee1.getBeeHiveId() == 10);
    }
    
    /**
     * Test the getSpecies method of superclass Bee.
     */
    @Test
    public void testGetSpecies() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Honey);
    }
    
    /**
     * Test the getAttack method of superclass Bee.
     */
    @Test
    public void testGetAttack() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1.getAttack() == 15);
    }
    
    /**
     * Test the getHealth method of superclass Bee.
     */
    @Test
    public void testGetHealth() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1.getHealth() == 50);
    }
    
    /**
     * Test the getHealthMax method of superclass Bee.
     */
    @Test
    public void testGetHealthMax() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1.getHealthMax() == 50);
    }
    
    /**
     * Test the getStamina method of superclass Bee.
     */
    @Test
    public void testGetStamina() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1.getStamina() == 20);
    }
    
    /**
     * Test the getStamina method of superclass Bee.
     */
    @Test
    public void testGetStaminaMax() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1.getStaminaMax() == 20);
    }    
    
    /**
     * Test the toString method of superclass Bee.
     */
    @Test
    public void testToString() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1.toString().equals("Bee id: 1\n"
                + "BeeHive id: 5\n"
                + "Species: Honey\n"
                + "Type: Queen\n"
                + "Attack: 15\n"
                + "Health: 50/50\n"
                + "Stamina: 20/20"));
    }    
    
    // Queen Subclass specific tests
    
    /**
     * Test to create Queen subclass of species Honey.
     */
    @Test
    public void createQueenHoney() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1.getType().equals("Queen"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Honey);
    }
    
    /**
     * Test to create Queen subclass of species Killer.
     */
    @Test
    public void createQueenKiller() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Killer);
        assertTrue(bee1.getType().equals("Queen"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Killer);
    }
    
    /**
     * Test to create Queen subclass of species Carpenter.
     */
    @Test
    public void createQueenCarpenter() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Carpenter);
        assertTrue(bee1.getType().equals("Queen"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Carpenter);
    }
    
    /**
     * Test to create Queen subclass of species Bumble.
     */
    @Test
    public void createQueenBumble() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Bumble);
        assertTrue(bee1.getType().equals("Queen"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Bumble);
    }
    
    /**
     * Test to create Queen subclass of species Tiny.
     */
    @Test
    public void createQueenTiny() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Tiny);
        assertTrue(bee1.getType().equals("Queen"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Tiny);
    }
    
    /**
     * Test to create Queen subclass of species Super and make sure stats update.
     */
    @Test
    public void createQueenSuper() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Super);
        assertTrue(bee1.getType().equals("Queen"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Super);
        assertTrue(bee1.getAttack() == 20);
        assertTrue(bee1.getHealth() == 65);
        assertTrue(bee1.getStamina() == 28);
    }
    
    /**
     * Test Queen subclass starting action.
     */
    @Test
    public void actionQueenStart() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1.doAction().equals("Nothing"));
    }
    
    /**
     * Test Queen subclass second action.
     */
    @Test
    public void actionQueenSecond() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Honey);
        bee1.doAction();
        assertTrue(bee1.doAction().equals("+egg"));
    }
    
    /**
     * Test Queen subclass rest action.
     */
    @Test
    public void actionQueenRest() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Honey);
        bee1.setState(BeeState.Rest);
        assertTrue(bee1.doAction().equals("-food"));
    }
    
    /**
     * Test Queen subclass invalid set state.
     */
    @Test
    public void setInvalidQueenState() {
        Bee bee1 = BeeFactory.getBee("Queen", 1, 5, BeeSpeciesF.Honey);
        bee1.setState(BeeState.Rest);
        assertTrue(bee1.getCurrentState() == BeeState.Rest);
        bee1.setState(BeeState.Attack);
        assertTrue(bee1.getCurrentState() == BeeState.Rest);
    }
    
    // Worker Subclass specific tests
    
    /**
     * Test to create Worker subclass of species Honey.
     */
    @Test
    public void createWorkerHoney() {
        Bee bee1 = BeeFactory.getBee("Worker", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1.getType().equals("Worker"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Honey);
    }
    
    /**
     * Test to create Worker subclass of species Killer.
     */
    @Test
    public void createWorkerKiller() {
        Bee bee1 = BeeFactory.getBee("Worker", 1, 5, BeeSpeciesF.Killer);
        assertTrue(bee1.getType().equals("Worker"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Killer);
    }
    
    /**
     * Test to create Worker subclass of species Carpenter.
     */
    @Test
    public void createWorkerCarpenter() {
        Bee bee1 = BeeFactory.getBee("Worker", 1, 5, BeeSpeciesF.Carpenter);
        assertTrue(bee1.getType().equals("Worker"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Carpenter);
    }
    
    /**
     * Test to create Wrker subclass of species Bumble.
     */
    @Test
    public void createWorkerBumble() {
        Bee bee1 = BeeFactory.getBee("Worker", 1, 5, BeeSpeciesF.Bumble);
        assertTrue(bee1.getType().equals("Worker"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Bumble);
    }
    
    /**
     * Test to create Worker subclass of species Tiny.
     */
    @Test
    public void createWorkerTiny() {
        Bee bee1 = BeeFactory.getBee("Worker", 1, 5, BeeSpeciesF.Tiny);
        assertTrue(bee1.getType().equals("Worker"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Tiny);
    }
    
    /**
     * Test to create Worker subclass of species Super and make sure stats update.
     */
    @Test
    public void createWorkerSuper() {
        Bee bee1 = BeeFactory.getBee("Worker", 1, 5, BeeSpeciesF.Super);
        assertTrue(bee1.getType().equals("Worker"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Super);
        assertTrue(bee1.getAttack() == 12);
        assertTrue(bee1.getHealth() == 12);
        assertTrue(bee1.getStamina() == 40);
    }
    
    /**
     * Test Worker subclass starting action.
     */
    @Test
    public void actionWorkerStart() {
        Bee bee1 = BeeFactory.getBee("Worker", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1.doAction().equals("Nothing"));
    }
    
    /**
     * Test Worker subclass second action.
     */
    @Test
    public void actionWorkerSecond() {
        Bee bee1 = BeeFactory.getBee("Worker", 1, 5, BeeSpeciesF.Honey);
        bee1.doAction();
        String action = bee1.doAction();
        assertTrue(action.equals("+work") || action.equals("-egg"));
    }
    
    /**
     * Test Worker subclass build action.
     */
    @Test
    public void actionWorkerBuild() {
        Bee bee1 = BeeFactory.getBee("Worker", 1, 5, BeeSpeciesF.Honey);
        bee1.setState(BeeState.Build);
        assertTrue(bee1.doAction().equals("+work"));
    }
    
    /**
     * Test Worker subclass build action.
     */
    @Test
    public void actionWorkerHatch() {
        Bee bee1 = BeeFactory.getBee("Worker", 1, 5, BeeSpeciesF.Honey);
        bee1.setState(BeeState.Hatch);
        assertTrue(bee1.doAction().equals("-egg"));
    }
    
    /**
     * Test Worker subclass rest action.
     */
    @Test
    public void actionWorkerRest() {
        Bee bee1 = BeeFactory.getBee("Worker", 1, 5, BeeSpeciesF.Honey);
        bee1.setState(BeeState.Rest);
        assertTrue(bee1.doAction().equals("-food"));
    }
    
    /**
     * Test Worker subclass invalid set state.
     */
    @Test
    public void setInvalidWorkerState() {
        Bee bee1 = BeeFactory.getBee("Worker", 1, 5, BeeSpeciesF.Honey);
        bee1.setState(BeeState.Rest);
        assertTrue(bee1.getCurrentState() == BeeState.Rest);
        bee1.setState(BeeState.Attack);
        assertTrue(bee1.getCurrentState() == BeeState.Rest);
    }
    
    // Warrior Subclass specific tests
    
    /**
     * Test to create Warrior subclass of species Honey.
     */
    @Test
    public void createWarriorHoney() {
        Bee bee1 = BeeFactory.getBee("Warrior", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1.getType().equals("Warrior"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Honey);
    }
    
    /**
     * Test to create Warrior subclass of species Killer.
     */
    @Test
    public void createWarriorKiller() {
        Bee bee1 = BeeFactory.getBee("Warrior", 1, 5, BeeSpeciesF.Killer);
        assertTrue(bee1.getType().equals("Warrior"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Killer);
    }
    
    /**
     * Test to create Warrior subclass of species Carpenter.
     */
    @Test
    public void createWarriorCarpenter() {
        Bee bee1 = BeeFactory.getBee("Warrior", 1, 5, BeeSpeciesF.Carpenter);
        assertTrue(bee1.getType().equals("Warrior"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Carpenter);
    }
    
    /**
     * Test to create Warrior subclass of species Bumble.
     */
    @Test
    public void createWarriorBumble() {
        Bee bee1 = BeeFactory.getBee("Warrior", 1, 5, BeeSpeciesF.Bumble);
        assertTrue(bee1.getType().equals("Warrior"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Bumble);
    }
    
    /**
     * Test to create Warrior subclass of species Tiny.
     */
    @Test
    public void createWarriorTiny() {
        Bee bee1 = BeeFactory.getBee("Warrior", 1, 5, BeeSpeciesF.Tiny);
        assertTrue(bee1.getType().equals("Warrior"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Tiny);
    }
    
    /**
     * Test to create Warrior subclass of species Super and make sure stats update.
     */
    @Test
    public void createWarriorSuper() {
        Bee bee1 = BeeFactory.getBee("Warrior", 1, 5, BeeSpeciesF.Super);
        assertTrue(bee1.getType().equals("Warrior"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Super);
        assertTrue(bee1.getAttack() == 24);
        assertTrue(bee1.getHealth() == 24);
        assertTrue(bee1.getStamina() == 18);
    }
    
    /**
     * Test Warrior subclass starting action.
     */
    @Test
    public void actionWarriorStart() {
        Bee bee1 = BeeFactory.getBee("Warrior", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1.doAction().equals("Nothing"));
    }
    
    /**
     * Test Warrior subclass second action.
     */
    @Test
    public void actionWarriorSecond() {
        Bee bee1 = BeeFactory.getBee("Warrior", 1, 5, BeeSpeciesF.Honey);
        bee1.doAction();
        assertTrue(bee1.doAction().equals("search"));
    }
    
    /**
     * Test Warrior subclass attack action.
     */
    @Test
    public void actionWarriorAttack() {
        Bee bee1 = BeeFactory.getBee("Warrior", 1, 5, BeeSpeciesF.Honey);
        bee1.setState(BeeState.Attack);
        assertTrue(bee1.doAction().equals("attack"));
    }
        
    /**
     * Test Warrior subclass return action.
     */
    @Test
    public void actionWarriorReturns() {
        Bee bee1 = BeeFactory.getBee("Warrior", 1, 5, BeeSpeciesF.Honey);
        bee1.setState(BeeState.Return);
        assertTrue(bee1.doAction().equals("return"));
    }
    
    /**
     * Test Warrior subclass rest action.
     */
    @Test
    public void actionWarriorRest() {
        Bee bee1 = BeeFactory.getBee("Warrior", 1, 5, BeeSpeciesF.Honey);
        bee1.setState(BeeState.Rest);
        assertTrue(bee1.doAction().equals("-food"));
    }
    
    /**
     * Test Warrior subclass invalid set state.
     */
    @Test
    public void setInvalidWarriorState() {
        Bee bee1 = BeeFactory.getBee("Warrior", 1, 5, BeeSpeciesF.Honey);
        bee1.setState(BeeState.Rest);
        assertTrue(bee1.getCurrentState() == BeeState.Rest);
        bee1.setState(BeeState.Hatch);
        assertTrue(bee1.getCurrentState() == BeeState.Rest);
    }
    
    // Drone Subclass specific tests
    
    /**
     * Test to create Drone subclass of species Honey.
     */
    @Test
    public void createDroneHoney() {
        Bee bee1 = BeeFactory.getBee("Drone", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1.getType().equals("Drone"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Honey);
    }
    
    /**
     * Test to create Drone subclass of species Killer.
     */
    @Test
    public void createDroneKiller() {
        Bee bee1 = BeeFactory.getBee("Drone", 1, 5, BeeSpeciesF.Killer);
        assertTrue(bee1.getType().equals("Drone"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Killer);
    }
    
    /**
     * Test to create Drone subclass of species Carpenter.
     */
    @Test
    public void createDroneCarpenter() {
        Bee bee1 = BeeFactory.getBee("Drone", 1, 5, BeeSpeciesF.Carpenter);
        assertTrue(bee1.getType().equals("Drone"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Carpenter);
    }
    
    /**
     * Test to create Drone subclass of species Bumble.
     */
    @Test
    public void createDroneBumble() {
        Bee bee1 = BeeFactory.getBee("Drone", 1, 5, BeeSpeciesF.Bumble);
        assertTrue(bee1.getType().equals("Drone"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Bumble);
    }
    
    /**
     * Test to create Drone subclass of species Tiny.
     */
    @Test
    public void createDroneTiny() {
        Bee bee1 = BeeFactory.getBee("Drone", 1, 5, BeeSpeciesF.Tiny);
        assertTrue(bee1.getType().equals("Drone"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Tiny);
    }
    
    /**
     * Test to create Drone subclass of species Super and make sure stats update.
     */
    @Test
    public void createDroneSuper() {
        Bee bee1 = BeeFactory.getBee("Drone", 1, 5, BeeSpeciesF.Super);
        assertTrue(bee1.getType().equals("Drone"));
        assertTrue(bee1.getSpecies() == BeeSpeciesF.Super);
        assertTrue(bee1.getAttack() == 7);
        assertTrue(bee1.getHealth() == 7);
        assertTrue(bee1.getStamina() == 36);
    }
    
    /**
     * Test Drone subclass starting action.
     */
    @Test
    public void actionDroneStart() {
        Bee bee1 = BeeFactory.getBee("Drone", 1, 5, BeeSpeciesF.Honey);
        assertTrue(bee1.doAction().equals("Nothing"));
    }
    
    /**
     * Test Drone subclass second action.
     */
    @Test
    public void actionDroneSecond() {
        Bee bee1 = BeeFactory.getBee("Drone", 1, 5, BeeSpeciesF.Honey);
        bee1.doAction();
        assertTrue(bee1.doAction().equals("search"));
    }
    
    /**
     * Test Drone subclass forage action.
     */
    @Test
    public void actionDroneBuild() {
        Bee bee1 = BeeFactory.getBee("Drone", 1, 5, BeeSpeciesF.Honey);
        bee1.setState(BeeState.Forage);
        assertTrue(bee1.doAction().equals("+food"));
    }
        
    /**
     * Test Drone subclass return action.
     */
    @Test
    public void actionDroneReturns() {
        Bee bee1 = BeeFactory.getBee("Drone", 1, 5, BeeSpeciesF.Honey);
        bee1.setState(BeeState.Return);
        assertTrue(bee1.doAction().equals("return"));
    }
    
    /**
     * Test Drone subclass rest action.
     */
    @Test
    public void actionDroneRest() {
        Bee bee1 = BeeFactory.getBee("Drone", 1, 5, BeeSpeciesF.Honey);
        bee1.setState(BeeState.Rest);
        assertTrue(bee1.doAction().equals("-food"));
    }
    
    /**
     * Test Drone subclass invalid set state.
     */
    @Test
    public void setInvalidDroneState() {
        Bee bee1 = BeeFactory.getBee("Drone", 1, 5, BeeSpeciesF.Honey);
        bee1.setState(BeeState.Rest);
        assertTrue(bee1.getCurrentState() == BeeState.Rest);
        bee1.setState(BeeState.Attack);
        assertTrue(bee1.getCurrentState() == BeeState.Rest);
    }
    
}
