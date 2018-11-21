package test.java;

import static org.junit.Assert.assertTrue;

import main.java.singleton.BeeHive;

import org.junit.Test;

public class TestBeeHive {
    
    /**
     * Test to make sure dummy beehive class works.
     */
    @Test
    public void hivesTest() {
        BeeHive hive1 = new BeeHive(1);
        BeeHive hive2 = new BeeHive(2);
        assertTrue(hive1.getId() == 1);
        assertTrue(hive2.getId() == 2);
    }
}
