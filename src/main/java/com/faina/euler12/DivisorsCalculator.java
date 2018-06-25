package com.faina.euler12;



import java.math.BigInteger;
import java.util.List;


@FunctionalInterface
public interface DivisorsCalculator {

    List<BigInteger> getDivisors(BigInteger number);
}
