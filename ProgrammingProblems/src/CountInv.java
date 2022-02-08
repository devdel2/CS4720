public class CountInv {

    public static void main(String[] args) {
        int[] array = {54044,14108,79294,29649,25260,60660,2995,53777,49689,9083};
        printArray(array);
        System.out.println();
        System.out.println(sortAndCount(array, 0, array.length-1));
        System.out.println();
        printArray(array);
    }

    static int countAndMerge(int[] array, int start, int end, int mid){
        int numInv = 0;
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

        int i = 0;
        int j = 0;
        int k = start;

        while(i < leftHalf.length && j < rightHalf.length){
            if(leftHalf[i] <= rightHalf[j]){
                array[k] = leftHalf[i];
                i++;
                k++;
            }
            else{
                array[k] = rightHalf[j];
                k++;
                j++;
                numInv += (mid+1) - (start +  i);
            }
        }

        while(i < leftHalf.length){
            array[k] = leftHalf[i];
            k++;
            i++;
        }

        while(j < rightHalf.length){
            array[k] = rightHalf[j];
            k++;
            j++;
        }

        return numInv;
    }

    private static int sortAndCount(int[] inputArray, int start, int end){
        int numInv = 0;


        if(start < end){
            int mid = (start + end)/2;
            numInv += sortAndCount(inputArray, start, mid);
            numInv += sortAndCount(inputArray, mid+1, end);
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
