public class CountInv {

    public static void main(String[] args) {
        int[] array = {54044,14108,79294,29649,25260,60660,2995,53777,49689,9083};
        printArray(array);
        System.out.println();
        System.out.println(splitArray(array));
        System.out.println();
        printArray(array);
    }

    static int splitArray(int[] array){
        int numInv = 0;
        int mid = (array.length) / 2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[array.length-mid];

        //base case, there will be 0 inversions
        if(array.length == 0 || array.length == 1){
            return 0;
        }

        //copy left half of input array
        for(int i = 0; i < mid; i++){
            leftHalf[i] = array[i];
        }

        //copy right half of input array
        for(int i = mid; i < array.length; i++){
            rightHalf[i-mid] = array[i];
        }

        //continue to split array until base case reached
        splitArray(leftHalf);
        splitArray(rightHalf);

        //uses merge sort to count total number of inversions
        numInv += countInv(array, leftHalf, rightHalf);

        return numInv;
    }

    private static int countInv(int[] inputArray, int[] left, int[] right){
        int numInv = 0;
        int i = 0;
        int j = 0;
        int k = 0;

        //compare the elements in left and right half
        while(i < left.length && j < right.length){

            //if left array element is less than right array element, add to input array
            if(left[i] <= right[j]){
                inputArray[k] = left[i];
                i++;
            }

            //if right array element is greater than left array element, add right to input array
            //this means there was inversion, iterate inversion variable by 1
            else{
                inputArray[k] = right[j];
                j++;
                numInv++;
            }

            k++;

        }

        //if right array finished copying to input array before left side
        //each element in the remaining left side counts as an inversion
        //copy remaining elements and increment num of inversions
        while(i < left.length){
            inputArray[k] = left[i];
            i++;
            k++;
            numInv++;
        }

        //the remaining values in right side were the greatest and no inversions should be counted
        //copy remaining values to the input array
        while(j < right.length){
            inputArray[k] = right[j];
            j++;
            k++;
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
