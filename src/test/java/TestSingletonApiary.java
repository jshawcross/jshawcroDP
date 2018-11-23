package test.java;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import main.java.singleton.Apiary;
import main.java.singleton.BeeHive;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for testing apiary class.
 * 
 * @author Jason Shawcross
 *
 */
public class TestSingletonApiary {
    
    /**
     * Method runs before each test to make sure that the singleton is reset.
     * 
     * @throws SecurityException Exception
     * @throws NoSuchFieldException Exception
     * @throws IllegalArgumentException Exception
     * @throws IllegalAccessException Exception
     */
    @Before
    public void resetSingleton() throws SecurityException, NoSuchFieldException, 
            IllegalArgumentException, IllegalAccessException {
        Field instance = Apiary.class.getDeclaredField("apiaryInstance");
        instance.setAccessible(true);
        instance.set(null, null);
    }
    
    /**
     * Test to make sure a single instance is created.
     */
    @Test
    public void apiarySingle() {
        Apiary testApiary = Apiary.getInstance("Test");
        Apiary testApiary2 = Apiary.getInstance("Test2");
        assertTrue(testApiary.getName().equals("Test"));
        assertTrue(testApiary2.getName().equals("Test"));
    }
    
    /**
     * Test to make sure a change affects all references to instance.
     */
    @Test
    public void apiaryChange() {
        Apiary testApiary = Apiary.getInstance("Test");
        Apiary testApiary2 = Apiary.getInstance("Test2");
        testApiary.setName("Test3");
        assertTrue(testApiary.getName().equals("Test3"));
        assertTrue(testApiary2.getName().equals("Test3"));
    }
    
    /**
     * Test for getting the name of an apiary.
     */
    @Test
    public void apiaryGetName() {
        Apiary testApiary = Apiary.getInstance("Test");
        assertTrue(testApiary.getName().equals("Test"));
    }
    
    /**
     * Test for setting the name of an apiary.
     */
    @Test
    public void apiarySetName() {
        Apiary testApiary = Apiary.getInstance("Test");
        testApiary.setName("Test2");
        assertTrue(testApiary.getName().equals("Test2"));
    }
    
    /**
     * Test for adding a hive.
     */
    @Test
    public void addHive() {
        Apiary testApiary = Apiary.getInstance("Test");
        BeeHive hive1 = new BeeHive(1);
        assertTrue(testApiary.addBeeHive(hive1));
    }
    
    /**
     * Test for adding multiple hives.
     */
    @Test
    public void add2Hives() {
        Apiary testApiary = Apiary.getInstance("Test");
        BeeHive hive1 = new BeeHive(1);
        BeeHive hive2 = new BeeHive(2);
        assertTrue(testApiary.addBeeHive(hive1));
        assertTrue(testApiary.addBeeHive(hive2));
    }
    
    /**
     * Test for adding duplicate hive.
     */
    @Test
    public void addDupHive() {
        Apiary testApiary = Apiary.getInstance("Test");
        BeeHive hive1 = new BeeHive(1);
        testApiary.addBeeHive(hive1);
        assertTrue(!testApiary.addBeeHive(hive1));
    }
    
    /**
     * Test for removing a hive.
     */
    @Test
    public void removeHive() {
        Apiary testApiary = Apiary.getInstance("Test");
        BeeHive hive1 = new BeeHive(1);
        BeeHive hive2 = new BeeHive(2);
        testApiary.addBeeHive(hive1);
        testApiary.addBeeHive(hive2);
        assertTrue(testApiary.removeBeeHive(1));
    }
    
    /**
     * Test for removing a hive that doesn't exist.
     */
    @Test
    public void removeHiveNoExist() {
        Apiary testApiary = Apiary.getInstance("Test");
        BeeHive hive1 = new BeeHive(1);
        BeeHive hive2 = new BeeHive(2);
        testApiary.addBeeHive(hive1);
        testApiary.addBeeHive(hive2);
        assertTrue(!testApiary.removeBeeHive(4));
    }
    
    /**
     * Test for counting the number of hives.
     */
    @Test
    public void countHives() {
        Apiary testApiary = Apiary.getInstance("Test");
        BeeHive hive1 = new BeeHive(1);
        BeeHive hive2 = new BeeHive(2);
        testApiary.addBeeHive(hive1);
        testApiary.addBeeHive(hive2);
        assertTrue(testApiary.countBeeHives() == 2);
    }
    
    /**
     * Test getting a hive object from apiary.
     */
    @Test
    public void getHive() {
        Apiary testApiary = Apiary.getInstance("Test");
        BeeHive hive1 = new BeeHive(1);
        testApiary.addBeeHive(hive1);
        BeeHive hive2 = testApiary.getBeeHive(1);
        assertTrue(hive2.toString().equals("Beehive id: 1"));
    }
    
    /**
     * Test getting a hive object from apiary that doesn't exist.
     */
    @Test
    public void getHiveNoExist() {
        Apiary testApiary = Apiary.getInstance("Test");
        BeeHive hive1 = new BeeHive(1);
        testApiary.addBeeHive(hive1);
        BeeHive hive2 = testApiary.getBeeHive(4);
        //System.out.println(hive2.toString());
        assertTrue(hive2 == null);
    }
    
    /**
     * Test the apiary toString method.
     */
    @Test
    public void testToString() {
        Apiary testApiary = Apiary.getInstance("Test");
        BeeHive hive1 = new BeeHive(1);
        BeeHive hive2 = new BeeHive(2);
        testApiary.addBeeHive(hive1);
        testApiary.addBeeHive(hive2);
        System.out.println(testApiary.toString());
        assertTrue(testApiary.toString().equals("Apiary name: Test\nCurrent Beehives:\n"
                + "Beehive id: 1\nBeehive id: 2\n"));
    }
}
