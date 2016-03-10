package ua.stqa.java_testtry.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by sikretSSD on 10.03.2016.
 */
public class PrimeTests {

    @Test
    public void testPrimes(){
        Assert.assertTrue(Prime.isPrime(Integer.MAX_VALUE));
    }
    @Test
    public void testPrimesFast(){
        Assert.assertTrue(Prime.isPrimeFast(Integer.MAX_VALUE));
    }

    @Test(enabled = false)
    public void testPrimesLong(){
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Prime.isPrime(n));
    }
    @Test
    public void testNonPrimes(){
        Assert.assertFalse(Prime.isPrime(Integer.MAX_VALUE - 2));
    }
}
