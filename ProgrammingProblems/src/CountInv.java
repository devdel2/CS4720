import java.util.Arrays;

public class CountInv {

    public static void main(String[] args) {
        int[] array = {54044,14108,79294,29649,25260,60660,2995,53777,49689,9083};
        printArray(array);
        System.out.println();
        System.out.println("The number of inversions is: " + sortAndCount(array, 0, array.length-1));
        System.out.println();
        printArray(array);
    }

    //count and merge function
    static int countAndMerge(int[] array, int start, int end, int mid){

        //declare number of inversions
        int numInv = 0;

        //copy the left half of the incoming array
        int[] leftHalf = Arrays.copyOfRange(array, start, mid+1);

        //copy the right half of the incoming array
        int[] rightHalf = Arrays.copyOfRange(array,mid+1, end+1);

        //declare iterator variables
        int i = 0;
        int j = 0;
        int k = start;

        //merge step
        while(i < leftHalf.length && j < rightHalf.length){

            //if the current value in the left array is less than the current value
            //in the right array, merge the left side into the original array.
            if(leftHalf[i] <= rightHalf[j]){
                array[k] = leftHalf[i];
                i++;
                k++;
            }

            //else if the value in the right array is greater than the element in the left array
            //we merge the value from the right side and iterate the number of inversions by the
            //current midpoint - the current i position
            else{
                array[k] = rightHalf[j];
                k++;
                j++;
                numInv += (mid+1) - (start+i);
            }
        }

        //fills in the rest of the values from the left half
        while(i < leftHalf.length){
            array[k] = leftHalf[i];
            k++;
            i++;
        }

        //fills in the rest of the values from the right half
        while(j < rightHalf.length){
            array[k] = rightHalf[j];
            k++;
            j++;
        }

        //return the number of inversions from this call
        return numInv;

    }

    //merge sort, and count the number of inversions
    private static int sortAndCount(int[] inputArray, int start, int end){
        int numInv = 0;

        //checks to see if array size is has more than one element
        if(start < end){

            //if more than one element, calc new midpoint and recurse down each side
            int mid = (start + end)/2;

            //finds left inversions
            numInv += sortAndCount(inputArray, start, mid);

            //finds right inversions
            numInv += sortAndCount(inputArray, (mid+1), end);

            //finds split inversions
            numInv += countAndMerge(inputArray, start, end, mid);
        }

        //return the number of inversions;
        return numInv;
    }

    //print array
    private static void printArray(int[] array){
        for(int i =0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

}
