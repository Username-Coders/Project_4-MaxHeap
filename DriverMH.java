import java.util.Scanner;

public class DriverMH {

     /**
    * Reads 100 integers from a file, could be named "data.txt".
    * @param fileName The name of the file where the integers are.
    * @return Returns an integer array
    */

    public static Integer[] read100Integers(String fileName) {
        Scanner scan = new Scanner(fileName);
        Integer[] result = new Integer[100];
        
        for (int i = 0 ; i < result.length; i++)
            result[i] = scan.nextInt();
   
         return result;
        
    }
    
    /**
     * Outputs first 10 integers of heap array, after heap creation, into output file.
     * @param heap The MaxHeap object, used to access the heap array values.
     */
    public static void print10Num_Creation(MaxHeap<Integer> heap, String fileName) {

    }

    /**
     * Outputs number of swaps performed, after heap creation, into output file.
     * @param heap The MaxHeap object, used to access the swaps value.
     */
    public static void printSwaps(MaxHeap<Integer> heap, String fileName) {

    }

    /**
     * Performs 10 removals on the given heap.
     * @param heap The MaxHeap object from which to perform 10 removals.
     */
    public static void perform10Removals(MaxHeap<Integer> heap) {

    }

    /**
     * Output the first 10 integers of heap array, after 10 removals, into output file.
     * @param heap 
     */
    public static void print10Num_Removal(MaxHeap<Integer> heap, String fileName) {

    }

    



    public static void main(String []args) {

        String inputFileName = "data_sorted.txt";
        String outputFileName = "data.txt";
        //Integer[] valueArray = {20,40,30,10,90,70};

        Integer[] heapValues = read100Integers(inputFileName);

        // Creating heap the sequential way
        MaxHeap<Integer> sequenHeap = new MaxHeap<>();
        sequenHeap.createHeap_Sequential(heapValues);

        // Print first 10 integers to output file, after



        // Creating heap the smart way
        MaxHeap<Integer> smartHeap = new MaxHeap<>();
        smartHeap.createHeap_SmartWay(heapValues);

        // Print first 10 integers to output file, after creation of heap
        print10Num_Creation(smartHeap, outputFileName);

        // Print number of swaps performed to output file
        printSwaps(smartHeap, outputFileName);

        // Perform 10 removals on the heap
        perform10Removals(smartHeap);

        // Print first 10 integers of heap array after 10 removals
        print10Num_Removal(smartHeap, outputFileName);

        //smartHeap.printHeap();


        
    }

}
