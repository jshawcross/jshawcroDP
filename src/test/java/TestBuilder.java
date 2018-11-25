package test.java;

import static org.junit.Assert.assertTrue;

import main.java.builder.BeeHive;
import main.java.builder.BeeHive.BeeSpecies;

import org.junit.Test;

public class TestBuilder {

    /**
     * Test creation of a hive object.
     */
    @Test
    public void defaultHive() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).build();
        assertTrue(hive.toString().equals("BeeHive id: 1\n"
                + "Location: 2, 3\n"
                + "Species: Honey\n"
                + "Rooms: 3\n"
                + "Work until new room: 100\n"
                + "Food: 10/30\n"
                + "Eggs: 0/6\n"
                + "Space for resting: 18"));
    }
    
    /**
     * Test getId method.
     */
    @Test
    public void getIdTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).build();
        assertTrue(hive.getId() == 1);
    }
    
    /**
     * Test getLocationX method.
     */
    @Test
    public void getIdLocationXTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).build();
        assertTrue(hive.getLocationX() == 2);
    }
    
    /**
     * Test getLocationY method.
     */
    @Test
    public void getIdLocationYTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).build();
        assertTrue(hive.getLocationY() == 3);
    }
    
    /**
     * Test getType method.
     */
    @Test
    public void getTypeTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).build();
        assertTrue(hive.getSpecies() == BeeSpecies.Honey);
    }
    
    /**
     * Test getFoodAmount method.
     */
    @Test
    public void getFoodAmountTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).build();
        assertTrue(hive.getFoodAmount() == 10);
    }
    
    /**
     * Test getEggAmount method.
     */
    @Test
    public void getEggAmountTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).build();
        assertTrue(hive.getEggAmount() == 0);
    }
    
    /**
     * Test getRoomAmount method.
     */
    @Test
    public void getRoomAmountTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).build();
        assertTrue(hive.getRoomAmount() == 3);
    }
    
    /**
     * Test getWorkRequired method.
     */
    @Test
    public void getWorkRequiredTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).build();
        assertTrue(hive.getWorkRequired() == 100);
    }
    
    /**
     * Test getFoodCapacity method.
     */
    @Test
    public void getFoodCapacityTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).build();
        assertTrue(hive.getFoodCapacity() == 30);
    }
    
    /**
     * Test getEggCapacity method.
     */
    @Test
    public void getEggCapacityTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).build();
        assertTrue(hive.getEggCapacity() == 6);
    }
    
    /**
     * Test getRestCapacity method.
     */
    @Test
    public void getRestCapacityTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).build();
        assertTrue(hive.getRestCapacity() == 18);
    }
    
    /**
     * Test getFoodModifier method.
     */
    @Test
    public void getFoodModifierTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).build();
        assertTrue(hive.getFoodModifier() == 0);
    }
    
    /**
     * Test getEggModifier method.
     */
    @Test
    public void getEggModifierTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).build();
        assertTrue(hive.getEggModifier() == 0);
    }
    
    /**
     * Test getFoodModifier method.
     */
    @Test
    public void getRestModifierTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).build();
        assertTrue(hive.getRestModifier() == 0);
    }
    
    /**
     * Test creation of a hive object using the setFoodAmount method.
     */
    @Test
    public void setFoodAmountTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).setFoodAmount(20).build();
        assertTrue(hive.getFoodAmount() == 20);        
    }
    
    /**
     * Test creation of a hive object using the setFoodAmount method.
     */
    @Test
    public void setEggAmountTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).setEggAmount(5).build();
        assertTrue(hive.getEggAmount() == 5);        
    }
    
    /**
     * Test creation of a hive object using the setRoomAmount method.
     */
    @Test
    public void setRoomAmountTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).setRoomAmount(6).build();
        assertTrue(hive.getRoomAmount() == 6);
        assertTrue(hive.getFoodCapacity() == 60);
        assertTrue(hive.getEggCapacity() == 12);
        assertTrue(hive.getRestCapacity() == 36);
    }
    
    /**
     * Test creation of a hive object using the setWorkRequired method.
     */
    @Test
    public void setWorkRequiredTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).setWorkRequired(50).build();
        assertTrue(hive.getWorkRequired() == 50);        
    }
    
    /**
     * Test creation of a hive object using the setType method.
     */
    @Test
    public void setTypeTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3).setSpecies(BeeSpecies.Super).build();
        assertTrue(hive.getSpecies() == BeeSpecies.Super); 
        assertTrue(hive.getFoodModifier() == 2);
        assertTrue(hive.getEggModifier() == 1);
        assertTrue(hive.getRestModifier() == 1);
        assertTrue(hive.getFoodCapacity() == 36);
        assertTrue(hive.getEggCapacity() == 9);
        assertTrue(hive.getRestCapacity() == 21);
    }
    
    /**
     * Test creation of a hive object using all builder set methods.
     */
    @Test
    public void allBuilderSetTest() {
        BeeHive hive = new BeeHive.BeeHiveBuilder(1, 2, 3)
                .setSpecies(BeeSpecies.Tiny)
                .setFoodAmount(20)
                .setEggAmount(2)
                .setRoomAmount(5)
                .setWorkRequired(25)
                .build();
        assertTrue(hive.toString().equals("BeeHive id: 1\n"
                + "Location: 2, 3\n"
                + "Species: Tiny\n"
                + "Rooms: 5\n"
                + "Work until new room: 25\n"
                + "Food: 20/35\n"
                + "Eggs: 2/5\n"
                + "Space for resting: 40"));
    }
}
