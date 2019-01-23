package com.faina.euler23;

import org.junit.Test;

import static com.faina._12_30.Main23.getAllAbundantNums;
import static com.faina._12_30.Main23.getAllNums;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.faina._12_30.Main23;

import java.util.List;
import java.util.Set;


public class Euler23Test {

    @Test
    public void isAbudantTest() {
        assertTrue(Main23.isAbundant(12));
    }

    @Test
    public void isNotAbudantTest() {
        assertFalse(Main23.isAbundant(9));
    }

    @Test
    public void canBeSumOfTwoAbudantNums()  {
        Set<Integer> abundantNums = getAllAbundantNums();

        //find all positive numbers which cannot be written as a sum of two abudant numbers
        List<Integer> nums = getAllNums(abundantNums);

        assertFalse(nums.contains(24));
    }

}
