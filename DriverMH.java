public class DriverMH {

     /**
    * Reads 100 integers from a file, could be named "data.txt".
    * @param fileName The name of the file where the integers are.
    * @return Returns an integer array
    */
    public int[] read100Integers(String fileName) {
        int[] result = new int[100];
   


        return result;
    }


    public static void main(String []args) {

        int node1 = 5;
        int node2 = 1;
        int node3 = 3;
        int node4 = 6;

        MaxHeap<Integer> heap1 = new MaxHeap<>();

        heap1.add(node1);
        heap1.add(node2);
        heap1.add(node3);
        heap1.add(node4);

        heap1.printHeap();



    }

}
