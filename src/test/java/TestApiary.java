package test.java;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

import main.java.singleton.Apiary;

/**
 * @author user
 *
 */
public class TestApiary {
    
    /**
     * Method runs before each test to make sure that the singleton is reset
     * 
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    @Before
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
       Field instance = Apiary.class.getDeclaredField("apiaryInstance");
       instance.setAccessible(true);
       instance.set(null, null);
    }
    
    /**
     * Test to make sure a single instance is created
     */
    @Test
    public void apiarySingle() {
        Apiary testApiary = Apiary.getInstance("Test");
        Apiary testApiary2 = Apiary.getInstance("Test2");
        assertTrue(testApiary.getName().equals("Test"));
        assertTrue(testApiary2.getName().equals("Test"));
    }
    
    /**
     * Test to make sure a change affects all references to instance
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
     * Test for getting the name of an apiary
     */
    @Test
    public void apiaryGetName() {
        Apiary testApiary = Apiary.getInstance("Test");
        assertTrue(testApiary.getName().equals("Test"));
    }
    
    /**
     * Test for setting the name of an apiary
     */
    @Test
    public void apiaryCon() {
        Apiary testApiary = Apiary.getInstance("Test");
        testApiary.setName("Test2");
        assertTrue(testApiary.getName().equals("Test2"));
    }
}
