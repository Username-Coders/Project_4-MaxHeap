import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

public class MaxHeap_UnitTesting {

    @Test
    public void sequentialHeapTest() {

        Integer[] heapValues = {20,40,30,10,90,70};

        MaxHeap<Integer> sequenHeap = new MaxHeap<>();
        sequenHeap.createHeap_Sequential(heapValues);

        Integer[] result = new Integer[6];

        for (int i = 1; i < sequenHeap.getSize() + 1; i++) {
            result[i-1] = sequenHeap.getHeapValue_atIndex(i);
        }

        Integer[] expected = {90,40,70,10,20,30};

        assertArrayEquals(expected, result  );

        
    }

    @Test
    public void smartHeapTest() {

        Integer[] heapValues = {20,40,30,10,90,70};

        MaxHeap<Integer> smartHeap = new MaxHeap<>();
        smartHeap.createHeap_SmartWay(heapValues);

        Integer[] result = new Integer[6];

        for(int i = 1; i < smartHeap.getSize() + 1; i++) {
            result[i-1] = smartHeap.getHeapValue_atIndex(i);
        }

        Integer[] expected = {90,40,70,10,20,30};

        assertArrayEquals(expected, result);

    }

    @Test
    public void getMethodTest() {
        
        Integer[] heapValues = {20,40,30,10,90,70};

        // heap created using smart method
        MaxHeap<Integer> smartHeap = new MaxHeap<>();
        smartHeap.createHeap_SmartWay(heapValues);

        // heap created using sequential method
        MaxHeap<Integer> sequenHeap = new MaxHeap<>();
        sequenHeap.createHeap_Sequential(heapValues);

        assertTrue(smartHeap.getMethod());
        assertFalse(sequenHeap.getMethod());

    }

    @Test
    public void getSwapsTest() {

        Integer[] heapValues = {20,40,30,10,90,70};

        // heap created using smart method
        MaxHeap<Integer> smartHeap = new MaxHeap<>();
        smartHeap.createHeap_SmartWay(heapValues);

        // heap created using sequential method
        MaxHeap<Integer> sequenHeap = new MaxHeap<>();
        sequenHeap.createHeap_Sequential(heapValues);

        int expectedSmartSwaps = 4;
        int expectedSequentialSwaps = 4;

        assertEquals(expectedSmartSwaps, smartHeap.getSwaps());
        assertEquals(expectedSequentialSwaps, sequenHeap.getSwaps());

    }

    @Test
    public void readInputFileTest() throws IOException {
        String testFile = "data_sorted.txt";

        Integer[] result = DriverMH.read100Integers(testFile);

        Integer[] expected = new Integer[100];
        for (int i = 0; i < 100; i++) {
            expected[i] = Integer.valueOf(i + 10);
        }


        assertArrayEquals(expected, result);


    }

    @Test
    public void printAfterCreationTest() {

    }

    @Test
    public void printSwapsTest() {

    }

    @Test
    public void perform10RemovalsTest() {

    }

    @Test
    public void printAfterRemovalTest() {

    }

    @Test
    public void printOutputBorderTest() {

    }

    @Test
    public void makeFileTest() {
        
    }


}
