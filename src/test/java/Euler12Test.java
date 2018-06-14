import com.faina.test.Euler12;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
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

    @Test
    public void SmallValueTest()    {

        assertEquals(28, Euler12.getFirstTriangleNumWithDividers(5, false));
    }

    @Test
    public void SmallValueUpgradedTest()    {

        assertEquals(28, Euler12.getFirstTriangleNumWithDividers(5, true));
    }

    @Test
    public void SmallValueDivisorsTest()    {

        assertThat(Euler12.getDivisors(28), CoreMatchers.hasItems(1,2,4,7,14,28));

    }


    @Test
    public void SmallValueDivisorsUpgradedTest()    {

        assertThat(Euler12.getDivisorsUpgraded(28), CoreMatchers.hasItems(1,2,4,7,14,28));
    }

    @Test
    public void BenchmarkGetDivisorsTest() {

        Long runtime, runtimeUpgraded;
        Long maxCount = 100L;
        int testNum = 10000001;

        //TODO: find out how to work with Java 8-9-10 Date API
        Long start = System.currentTimeMillis();

        for (int i=0; i<maxCount; i++)  {
            Euler12.getDivisors(testNum);
        }

        Long stop = System.currentTimeMillis();
        runtime = getTotalRuntime(maxCount, start, stop);

        start = System.currentTimeMillis();
        for (int i=0; i<maxCount; i++)  {
            Euler12.getDivisorsUpgraded(testNum);
        }

        stop = System.currentTimeMillis();

        runtimeUpgraded = getTotalRuntime(maxCount, start, stop);

        System.out.println(testName.getMethodName()+": runtime: "+runtime+", runtime upgraded: "+runtimeUpgraded);

        assertTrue (runtimeUpgraded < runtime);

    }

    @Test
    public void BenchmarkGetFirstTriangleNumWithDividersTest() {

        Long runtime, meanRuntimeUpgraded;
        Long maxCount = 1000L;
        int maxDivisorsCount = 10;

        //TODO: find out how to work with Java 8-9-10 Date API
        Long start = System.currentTimeMillis();

        for (int i=0; i<maxCount; i++)  {
            Euler12.getFirstTriangleNumWithDividers(maxDivisorsCount, false);
        }

        Long stop = System.currentTimeMillis();
        runtime = getTotalRuntime(maxCount, start, stop);

        start = System.currentTimeMillis();
        for (int i=0; i<maxCount; i++)  {
            Euler12.getFirstTriangleNumWithDividers(maxDivisorsCount, true);
        }

        stop = System.currentTimeMillis();

        meanRuntimeUpgraded = getTotalRuntime(maxCount, start, stop);

        System.out.println(testName.getMethodName()+": runtime: "+runtime+", runtime upgraded: "+meanRuntimeUpgraded);

        assertTrue (meanRuntimeUpgraded < runtime);

    }


    //TODO: why I failed to calculate a mean runtime? How the cast for (stop-start)/maxCount works?
    private Long getTotalRuntime(Long maxCount, Long start, Long stop) {
        return (stop-start);
    }

}
