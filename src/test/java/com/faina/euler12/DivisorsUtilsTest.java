package com.faina.euler12;

import com.faina.euler12.utils.DivisorUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertThat;

public class DivisorsUtilsTest {

    @Test
    public void SmallValueDivisorsTest()    {

        assertThat(DivisorUtils.getDivisorsPlain(new BigInteger("28")), CoreMatchers.hasItems(BigInteger.ONE,BigInteger.TWO,new BigInteger("7"),new BigInteger("14"),new BigInteger("28")));

    }


    @Test
    public void SmallValueDivisorsUpgradedTest()    {

        assertThat(DivisorUtils.getDivisorsUpgraded(new BigInteger("28")), CoreMatchers.hasItems(BigInteger.ONE,BigInteger.TWO,new BigInteger("7"),new BigInteger("14"),new BigInteger("28")));

    }
}
