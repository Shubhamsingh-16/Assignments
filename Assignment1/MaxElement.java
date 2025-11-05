// time complexity : O(n)
// Space Complexity :O(n)
public class MaxElement {
    public static void main(String [] args){
        int arr [] = {1,4,5,6,7,8};
        System.out.println(maxElement(arr, 0 , arr[0]));
    }
    static int maxElement(int []arr, int current ,int max){ //tail recursion : arr is the array , current is the index which is to be checked intially it is 0 ; max represent the max value yet encountered, max default value is arr[0] 
        if(current == arr.length) return max; //check if the arr is fully traverrsed return the max element
        if(arr[current]>max) max = arr[current]; // compare current value with max, if arr[current] > max , swap them 
        return maxElement (arr , current+1 , max); // eachtime increase the value of current, and provide max element
    }

}
