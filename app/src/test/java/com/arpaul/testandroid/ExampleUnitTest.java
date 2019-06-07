package com.arpaul.testandroid;

import android.content.Context;

import com.arpaul.testandroid.TestableClasses.Calculator;
import com.arpaul.testandroid.TestableClasses.ClassUnderTest;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private static final String TEST_STRING = "HELLO WORLD";

    @Mock
    Context mContext;

    @Test
    public void readStringFromContext() {
        mContext = mock(Context.class);
        //Returns the TEST_STRING when getString(R.string.hello_world) is called
        when(mContext.getString(R.string.hello_world)).thenReturn(TEST_STRING);

        //Creates an object of the ClassUnderTest with the mock context
        ClassUnderTest objectUndrTest = new ClassUnderTest(mContext);

        //Stores the return value of getHelloWorldString() in result
        String result = objectUndrTest.getHelloWorldString();

        //Asserts that result is the value of TEST_STRING
        assertThat(result, is(TEST_STRING));
    }

    @Test
    public void testMockMethod(){
        List mockList = Mockito.mock(ArrayList.class);
        mockList.add("hello world");
        Mockito.verify(mockList).add("hello world");
        assertEquals(0, mockList.size());
    }
    @Test
    public void testSpyMethod(){
        List spyList = Mockito.spy(new ArrayList());
        spyList.add("hello world");
        Mockito.verify(spyList).add("hello world");
        assertEquals(1, spyList.size());
    }

    @Test
    public void testThenReturn(){
        //Create a mock object of the class Calculator
        Calculator mockCalculator = Mockito.mock(Calculator.class);
        //Return the value of 30 when the add method is called with the arguments 10 and 20
        Mockito.when(mockCalculator.add(10, 20)).thenReturn(30);
        //Asserts that the return value of add method with arguments 10 and 20 is 30
        assertEquals(mockCalculator.add(10, 20), 30);
    }
    @Test
    public void testDoReturn(){
        //Create a spy object of the class Calculator
        Calculator mockCalculator = Mockito.spy(new Calculator());
        //Return the value of 30 when the add method is called on the spied object with the arguments 10 and 20
        Mockito.doReturn(30).when(mockCalculator).add(10, 20);
        //Asserts that the return value of add method with arguments 10 and 20 is 30
        assertEquals(mockCalculator.add(10, 20), 30);
    }
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}