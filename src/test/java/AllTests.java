package test.java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestBuilderBeeHive.class, TestFactory.class, 
    TestSingletonApiary.class, TestSingletonBeeHive.class })

public class AllTests {

}
