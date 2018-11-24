package test.java;

import static org.junit.Assert.assertTrue;

import main.java.singleton.BeeHiveS;

import org.junit.Test;

public class TestSingletonBeeHive {
    
    /**
     * Test to make sure dummy beehive class works.
     */
    @Test
    public void hivesTest() {
        BeeHiveS hive1 = new BeeHiveS(1);
        BeeHiveS hive2 = new BeeHiveS(2);
        assertTrue(hive1.getId() == 1);
        assertTrue(hive2.getId() == 2);
    }
}
