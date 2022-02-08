public class CountInv {

    public static void main(String[] args) {
        int[] array = {3,2,1,5,6};
        System.out.println();
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

        return numInv;
    }

    private static int countInv(int[] inputArray, int[] left, int[] right){
        int numInv = 0;

        return numInv;
    }

}
