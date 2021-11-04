import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class DriverMH {

     /**
    * Reads 100 integers from a file, could be named "data.txt".
    * @param fileName The name of the file where the integers are.
    * @return Returns an integer array
     * @throws FileNotFoundException
    */
    public static Integer[] read100Integers(String fileName) throws FileNotFoundException {

        File myfile = new File(fileName);
        Scanner scan = new Scanner(myfile);
        Integer[] result = new Integer[100];
        
        int i = 0;
        int tempInt = 0;

        while(scan.hasNextInt()){

            tempInt = scan.nextInt();
            result[i] = Integer.valueOf(tempInt);
            i++;
       }

        scan.close();
        return result;


    }

    /**
     * Outputs first 10 integers of heap array, after heap creation, into output file.
     * @param heap The MaxHeap object, used to access the heap array values.
     * @throws IOException
     */
    public static void print10Num_Creation(MaxHeap<Integer> heap, String fileName) throws IOException {
        boolean optimalMethod = heap.getMethod();

        File myFile = new File(fileName);

        // Assuming that file exists
        FileWriter appendFile = new FileWriter(fileName, true);
        PrintWriter outputFile = new PrintWriter(appendFile);
        
        if (optimalMethod) {
    
            outputFile.print("Heap built using optimal method: ");
            for(int i = 1; i < heap.getSize(); i++) {
                outputFile.print(heap.getData(i) + " ");
                if (i % 30 == 0) {
                    outputFile.println();
                }
            }
            outputFile.println();

        } else {

        }

        
        outputFile.close();

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


    // creates a file with the given name, and returns PrintWriter object
    public static void MakeAFile(String fileName) throws FileNotFoundException {
        PrintWriter outputFile = new PrintWriter(fileName);
        outputFile.close();
    }


    public static void main(String []args) throws IOException {

        String inputFileName = "data_sorted.txt";
        String outputFileName = "data.txt";
        //Integer[] valueArray = {20,40,30,10,90,70};

        // create output file "data.txt"
        MakeAFile(outputFileName);

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

        smartHeap.printHeap();



    }

}
