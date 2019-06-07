package com.arpaul.testandroid;

import com.arpaul.testandroid.TestableClasses.MyClass;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.atLeast;
import static org.mockito.internal.verification.VerificationModeFactory.atMost;

@RunWith(MockitoJUnitRunner.class)
public class MockSpy {
    @Mock
    private List<String> mockList;

    @Spy
    private List<String> spyList = new ArrayList();

    @Test
    public void testMockList() {
        //by default, calling the methods of mock object will do nothing
        mockList.add("test");
        assertNull(mockList.get(0));
    }

    @Test
    public void testSpyList() {
        //spy object will call the real method when not stub
        spyList.add("test");
        assertEquals("test", spyList.get(0));
    }

    @Test
    public void testMockWithStub() {
        //try stubbing a method
        String expected = "Mock 100";
        when(mockList.get(100)).thenReturn(expected);

        assertEquals(expected, mockList.get(100));
    }

    @Test
    public void testSpyWithStub() {
        //stubbing a spy method will result the same as the mock object
        String expected = "Spy 100";
        //take note of using doReturn instead of when
        doReturn(expected).when(spyList).get(100);

        assertEquals(expected, spyList.get(100));
    }

//    @Test
//    public void testVerify()  {
//        // create and configure mock
//        MyClass test = Mockito.mock(MyClass.class);
//        when(test.getUniqueId()).thenReturn(43);
//
//
//        // call method testing on the mock with parameter 12
//        test.testing(12);
//        test.getUniqueId();
//        test.getUniqueId();
//
//
//        // now check if method testing was called with the parameter 12
//        verify(test).testing(ArgumentMatchers.eq(12));
//
//        // was the method called twice?
//        verify(test, times(2)).getUniqueId();
//
//        // other alternatives for verifiying the number of method calls for a method
//        verify(test, never()).someMethod("never called");
//        verify(test, atLeastOnce()).someMethod("called at least once");
//        verify(test, atLeast(2)).someMethod("called at least twice");
//        verify(test, times(5)).someMethod("called five times");
//        verify(test, atMost(3)).someMethod("called at most 3 times");
//        // This let's you check that no other methods where called on this object.
//        // You call it after you have verified the expected method calls.
//        verifyNoMoreInteractions(test);
//    }
}
