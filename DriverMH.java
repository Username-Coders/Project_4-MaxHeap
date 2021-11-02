import java.util.Scanner;

public class DriverMH {

     /**
    * Reads 100 integers from a file, could be named "data.txt".
    * @param fileName The name of the file where the integers are.
    * @return Returns an integer array
    */
    public Integer[] read100Integers(String fileName) {
        Scanner scan = new Scanner(fileName);
        Integer[] result = new Integer[100];
        
        for (int i = 0 ; i < result.length; i++)
            result[i] = scan.nextInt();
   
         return result;
        
    }



    public static void main(String []args) {

        Integer[] valueArray = {20,40,30,10,90,70};

        MaxHeap<Integer> heap1 = new MaxHeap<>();

        heap1.add(valueArray[0]);
        heap1.add(valueArray[1]);
        heap1.add(valueArray[2]);
        heap1.add(valueArray[3]);
        heap1.add(valueArray[4]);
        heap1.add(valueArray[5]);

        heap1.printHeap();

        MaxHeap<Integer> heap2 = new MaxHeap<>();

        heap2.createHeap_SmartWay(valueArray);

        heap2.printHeap();


    }

}
