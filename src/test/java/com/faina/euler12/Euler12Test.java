package com.faina.euler12;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.math.BigInteger;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * CONSLUSIONS:
 *
 * 1. For returned collection, the test should check both collection size and collection content
 * 2. For multiple behaviours: each test should check one behavior only, the test name should explain clear which behaviour is tested
 * 3. Tests are mandatory for code development, refactoring and improvement
 * 4. Benchmark test shows if code improvement really made the code more efficient - MUST
 * 5. If tests are written before the code is created, then the code will be born testable
 * 6. Each method should be tested
 * 7. Know more about JUnit: @Rule, how @Test annotation works, how objects/packages/classes are accessed
 * 8. A test never should call another test
 * 9. Know more about CoreMatchers API
 * 10. Test can prove my code's efficiency
 */

public class Euler12Test {

    @Rule
    public TestName testName = new TestName();

    /**
     * tests that 28 is the 1st triangle number having over 5 divisors
     * uses the brute force calculation
     */
    @Test
    public void SmallValueTest()    {

        assertEquals(new BigInteger("28"), Main.getTriangleNumber(5, false));
    }

    /**
     * tests that 28 is the 1st triangle number having over 5 divisors
     * uses the upgraded calculation
     */
    @Test
    public void SmallValueUpgradedTest()    {

        assertEquals(new BigInteger("28"), Main.getTriangleNumber(5, true));
    }


    @Test
    public void BenchmarkGetFirstTriangleNumWithDividersTest() {

        Long runtime, meanRuntimeUpgraded;
        Long maxCount = 1000L;
        int maxDivisorsCount = 30;

        //TODO: find out how to work with Java 8-9-10 Date API
        Long start = System.currentTimeMillis();

        for (int i=0; i<maxCount; i++)  {
            Main.getTriangleNumber(maxDivisorsCount, false);
        }

        Long stop = System.currentTimeMillis();
        runtime = getTotalRuntime(maxCount, start, stop);

        start = System.currentTimeMillis();
        for (int i=0; i<maxCount; i++)  {
            Main.getTriangleNumber(maxDivisorsCount, true);
        }

        stop = System.currentTimeMillis();

        meanRuntimeUpgraded = getTotalRuntime(maxCount, start, stop);

        System.out.println(testName.getMethodName()+": runtime: "+runtime+", runtime upgraded: "+meanRuntimeUpgraded);

        assertTrue (meanRuntimeUpgraded < runtime);

    }


    /**
     * calculates a mean runtime
     * @param maxCount
     * @param start
     * @param stop
     * @return
     */
    private Long getTotalRuntime(Long maxCount, Long start, Long stop) {
        //TODO: why I failed to calculate a mean runtime? How the cast for (stop-start)/maxCount works?
        return (stop-start);
    }


}
