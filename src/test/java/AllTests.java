package test.java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestBuilder.class, TestFactory.class, TestSingleton.class, TestBeeState.class})

public class AllTests {

}
