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
     * Outputs 100 integers of heap array, after heap creation, into output file.
     * @param heap The MaxHeap object, used to access the heap array values.
     * @throws IOException
     */
    public static void print100Num_Creation(MaxHeap<Integer> heap, String fileName) throws IOException {
        boolean optimalMethod = false;
        File myFile = new File(fileName);
        
        if (heap != null && myFile.exists()) {
            
            optimalMethod = heap.getMethod();
            
            FileWriter appendFile = new FileWriter(fileName, true);
            PrintWriter outputFile = new PrintWriter(appendFile);
            
            // Heap was created using the smart method
            if (optimalMethod) {
        
                outputFile.print("Heap built using optimal method: ");
                for(int i = 1; i < heap.getSize() + 1; i++) {
                    outputFile.print(heap.getHeapValue_atIndex(i) + ",");
                    if (i == 30) {
                        outputFile.println();
                    } else if (i == 70) {
                        outputFile.println();
                    }
                }
                outputFile.println();

            // Heap was created using sequential insertion
            } else {

                outputFile.print("Heap built using sequential insertions: ");
                for (int i = 1; i < heap.getSize() + 1; i++) {
                    outputFile.print(heap.getHeapValue_atIndex(i) + ",");
                    if (i == 30) {
                        outputFile.println();
                    } else if (i == 70) {
                        outputFile.println();
                    }
                }
                outputFile.println();

            }
            outputFile.close();
        }
    }

    /**
     * Outputs number of swaps performed, after heap creation, into output file.
     * @param heap The MaxHeap object, used to access the swaps value.
     * @throws IOException
     */
    public static void printSwaps(MaxHeap<Integer> heap, String fileName) throws IOException {
        
        File myFile = new File(fileName);

        if (heap != null && myFile.exists()) {
            int numSwaps = heap.getSwaps();

            FileWriter appendFile = new FileWriter(fileName, true);
            PrintWriter outputFile = new PrintWriter(appendFile);

            outputFile.println("Number of swaps in the heap creation: " + numSwaps);

            outputFile.close();

        }

    }

    /**
     * Performs 10 removals on the given heap.
     * @param heap The MaxHeap object from which to perform 10 removals.
     */
    public static void perform10Removals(MaxHeap<Integer> heap) {
        for (int i = 0; i < 10;i++) {
            heap.removeMax();
        }
    }

    /**
     * Output the 100 integers of heap array, after 10 removals, into output file.
     * @param heap
     * @throws IOException
     */
    public static void print100Num_Removal(MaxHeap<Integer> heap, String fileName) throws IOException {
        File myFile = new File(fileName);
        
        if (heap != null && myFile.exists()) {
            
            FileWriter appendFile = new FileWriter(fileName, true);
            PrintWriter outputFile = new PrintWriter(appendFile);
        
                outputFile.print("Heap after 10 removals: ");
                for(int i = 1; i < heap.getSize() + 1; i++) {
                    outputFile.print(heap.getHeapValue_atIndex(i) + ",");
                    if (i == 30) {
                        outputFile.println();
                    } else if (i == 70) {
                        outputFile.println();
                    }
                }
                outputFile.println();
           
            outputFile.close();
        }

    }

    public static void printOutputBorder(String fileName) throws IOException {
        File myFile = new File(fileName);

        if (myFile.exists()) {
            FileWriter appendFile = new FileWriter(fileName, true);
            PrintWriter outputFile = new PrintWriter(appendFile);  
            outputFile.println("=====================================================================");
            outputFile.close();
        }

    }

    public static void printOutputToFile(MaxHeap<Integer> heap, String fileName) throws IOException {
        File myFile = new File(fileName);

        if (myFile.exists()) {

            print100Num_Creation(heap, fileName);

            printSwaps(heap, fileName);

            perform10Removals(heap);

            print100Num_Removal(heap, fileName);


        }

    }

    // creates a file with the given name
    public static void MakeAFile(String fileName) throws FileNotFoundException {
        PrintWriter outputFile = new PrintWriter(fileName);
        outputFile.close();
    }


    public static void main(String []args) throws IOException {

        

        String inputFileName1 = "data_sorted.txt";
        String inputFileName2 = "data_random.txt";
        String outputFileName = "data.txt";

        // create output file "data.txt"
        MakeAFile(outputFileName);

        // Read 100 integers from input files
        Integer[] heapSorted = read100Integers(inputFileName1);
        Integer[] heapRandom = read100Integers(inputFileName2);

        // Creating heap the sequential way using "data_sorted.txt" values
        MaxHeap<Integer> sequenHeap1 = new MaxHeap<>();
        sequenHeap1.createHeap_Sequential(heapSorted);

        // Creating heap the smart way using "data_sorted.txt" values
        MaxHeap<Integer> smartHeap1 = new MaxHeap<>();
        smartHeap1.createHeap_SmartWay(heapSorted);

        printOutputBorder(outputFileName);
        printOutputToFile(sequenHeap1, outputFileName);

        File myFile1 = new File(outputFileName);
        if (myFile1.exists()) {
            FileWriter appendFile = new FileWriter(outputFileName, true);
            PrintWriter outputFile = new PrintWriter(appendFile);
            outputFile.println();
            outputFile.close();
        }

        printOutputToFile(smartHeap1, outputFileName);
        printOutputBorder(outputFileName);

        // Creating heap the sequential way using "data_random.txt" values
        MaxHeap<Integer> sequenHeap2 = new MaxHeap<>();
        sequenHeap2.createHeap_Sequential(heapRandom);

        // Creating heap the smart way using "data_sorted.txt" values
        MaxHeap<Integer> smartHeap2 = new MaxHeap<>();
        smartHeap2.createHeap_SmartWay(heapRandom);

        printOutputBorder(outputFileName);
        printOutputToFile(sequenHeap2, outputFileName);

        File myFile2 = new File(outputFileName);
        if (myFile2.exists()) {
            FileWriter appendFile = new FileWriter(outputFileName, true);
            PrintWriter outputFile = new PrintWriter(appendFile);
            outputFile.println();
            outputFile.close();
        }

        printOutputToFile(smartHeap2, outputFileName);
        printOutputBorder(outputFileName);


        Integer[] testValues = {20,40,30,10,90,70};

        MaxHeap<Integer> testHeap = new MaxHeap<>();
        testHeap.createHeap_SmartWay(testValues);

        

        Integer[] heapValues = {20,40,30,10,90,70};

        MaxHeap<Integer> smartHeap = new MaxHeap<>();
        smartHeap.createHeap_SmartWay(heapValues);

    }

}
