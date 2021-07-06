package com.tsg.unittesting;

import org.junit.jupiter.api.Test;

import static com.tsg.unittesting.HappyLlamas.areTheLlamasHappy;
import static org.junit.jupiter.api.Assertions.*;

public class HappyLlamasTest {

    public HappyLlamasTest(){
    }

    @Test //όλα τα τεστ ειναι public void
    public void testSomeMethod() {
    }

    @Test // This one checks the (false, 10) case.
    public void testNormalTrampoline10 () {
        // ARRANGE - we put the code in a known good state and create/arrange all necessary test data
        // ARRANGE - for simple methods, this means setting up the parameters
        boolean isNasaFabric = false;
        int numTrampolines = 10;

        // ACT - we write a test that acts – this test uses the arranged data to execute the code we are testing
        // ACT - for simple methods, this generally means calling the method under test
        // and then capturing its return to assert on
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);

        // ASSERT - we assert that the results are what we expect
        // ASSERT - basically just a conditional that proves the result is what
        //        // you expect it to be, plus an extra message to display if it doesn't match.
        //        //
        //        // There are a wide variety of assert types, here we
        //        // just want to assert that it returned false. But we could have also used
        //        // assertEquals and passed in a false value.
        //
       assertFalse( result , "10 Llamas w/ Normal Trampolines should be Unhappy!" );
    }

    @Test
    public void testNormalTrampoline24(){
        // ARRANGE - setting up the parameters
        boolean inNasaFabric = false;
        int numTrampolines = 24;

        // ACT - calling the method under test and capturing its return
        boolean result = areTheLlamasHappy(inNasaFabric,numTrampolines);

        // ASSERT - checking if we have the desirable result
        assertTrue( result , "24 Llamas w/ Normal Trampolines should be Happy ");
    }

    @Test
    public void testNormalTrampoline30() {
        // ARRANGE
        boolean isNasaFabric = false;
        int numTrampolines = 30;

        // ACT
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);

        // ASSERT

        assertTrue(result, "30 Llamas w/ Normal Trampolines should be Happy!");
    }


    @Test
    public void testNormalTrampoline42(){
        // ARRANGE - setting up the parameters
        boolean inNasaFabric = false;
        int numTrampolines = 42;

        // ACT - calling the method under test and capturing its return
        boolean result = areTheLlamasHappy(inNasaFabric,numTrampolines);

        // ASSERT - checking if we have the desirable result
        assertTrue( result , "42 Llamas w/ Normal Trampolines should be Happy ");
    }


    @Test
    public void testNormalTrampoline50() {
        // ARRANGE - setting up the parameters
        boolean inNasaFabric = false;
        int numTrampolines = 50;

        // ACT - calling the method under test and capturing its return
        boolean result = areTheLlamasHappy(inNasaFabric,numTrampolines);

        // ASSERT - checking if we have the desirable result
        assertFalse( result , "50 Llamas w/ Normal Trampolines should be Unappy ");
    }

    @Test
    public void testUltraBouncyTrampoline10() {
        // ARRANGE
        boolean isNasaFabric = true;
        int numTrampolines = 10;

        // ACT
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);

        // ASSERT
        assertFalse(result, "10 Llamas w/ UltraBouncy Trampolines should be Unhappy!");
    }

    @Test
    public void testUltraBouncyTrampoline24() {
        // ARRANGE
        boolean isNasaFabric = true;
        int numTrampolines = 24;

        // ACT
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);

        // ASSERT
        assertTrue(result, "50 Llamas w/ UltraBouncy Trampolines should be Happy!");
    }

    @Test
    public void testUltraBouncyTrampoline30() {
        // ARRANGE
        boolean isNasaFabric = true;
        int numTrampolines = 30;

        // ACT
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);

        // ASSERT
        assertTrue(result, "30 Llamas w/ UltraBouncy Trampolines should be Happy!");
    }

    @Test
    public void testUltraBouncyTrampoline42() {
        // ARRANGE
        boolean isNasaFabric = true;
        int numTrampolines = 42;

        // ACT
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);

        // ASSERT
        assertTrue(result, "42 Llamas w/ UltraBouncy Trampolines should be Happy!");
    }

    @Test
    public void testUltraBouncyTrampoline50() {
        // ARRANGE
        boolean isNasaFabric = true;
        int numTrampolines = 50;

        // ACT
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);

        // ASSERT
        assertTrue(result, "50 Llamas w/ UltraBouncy Trampolines should be Happy!");
    }
}