package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockingDetails;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class SampleTest {

    @Test
    public void testSnippet() {
        ArrayList<String> anotherData = new ArrayList<>();
        anotherData.add("someExampleDataForTesting");
        DataService dsm = Mockito.mock(DataService.class);
        Mockito.when(dsm.getAllData()).thenReturn(anotherData);
        assertEquals(1, dsm.getAllData().size());

    }

    @Test
    void getSquare() {
        DataService dsm = Mockito.mock(DataService.class);
        Mockito.doReturn(10).when(dsm).getSquare();
        assertEquals(10, dsm.getSquare());
    }

    @Test
    public void testGetSomeInnerClass() {
        DataService dsm = Mockito.mock(DataService.class);
        Mockito.when(dsm.getSomeInnerClass()).thenReturn(new DataService.SomeInnerClass());
    }

    @Test
    public void testEncoder() {
        PasswordEncoder mock = Mockito.mock(PasswordEncoder.class);

        when(mock.encode("a")).thenReturn("1");

        assertEquals("1", mock.encode("a"));

    }

    @Test
    public void testIterator() {
        Iterator<String> i = Mockito.mock(Iterator.class);

        Mockito.when(i.next()).thenReturn("Hello").thenReturn("World");

        String result = i.next() + " " + i.next() + " " + i.next();

        assertEquals("Hello World", result);

    }

    @Test
    public void testGetTextSum(){
        DataService dsm = Mockito.mock(DataService.class);

        Mockito.when(dsm.getTextSum(Mockito.anyInt(), Mockito.anyInt())).thenReturn("Privet");
        String result = dsm.getTextSum(-324, 4343);

        assertEquals("Privet", result);
    }

    @Test
    public void testGetSomeData(){
        DataService dsm = Mockito.mock(DataService.class);
        Mockito.when(dsm.getSomeData(
                Mockito.argThat(argument -> argument.startsWith("fu") &&
                                            argument.length()>=3)))
                .thenReturn(Arrays.asList("First", "Second"));

        assertEquals(2, dsm.getSomeData("fun").size());
        assertEquals(0, dsm.getSomeData("close").size());
    }

    @Test
    public void testVerifying(){
        DataService dsm = Mockito.mock(DataService.class);
        Mockito.when(dsm.getSquare()).thenReturn(1);

        assertEquals(1, dsm.getSquare());

        Mockito.verify(dsm, Mockito.times(1)).getSquare();
        Mockito.verify(dsm, Mockito.atLeast(1)).getSquare();
        Mockito.verify(dsm, Mockito.atLeastOnce()).getSquare();
        Mockito.verify(dsm, Mockito.only()).getSquare();
        Mockito.verify(dsm, Mockito.after(3000).atLeast(1)).getSquare();

    }

}
