// time complexity : O(n)
//  space complexity : O(n)
public class IsArrayIncreasing {
    public static void main( String [ ] args){
        int  arr[] = {1,3,4,5,6,7,9,7,8};
        System.out.println(isArrayIncreasing( arr, 0 , 0));
    }
    static boolean isArrayIncreasing( int [ ] arr, int prev , int current){ //tail recursive functio with parameters array , prev: previous element , current : current element  
        if(current == arr.length)             // check if the base conditon when current value is outofbound of array 
            if(arr.length >0) return true;    // if arr.length>0 means the array have element and reached the last element return true
            else return false;                // if the array doesnt have any element then it will return false
        
        if(arr[current]<prev){   //check array is sctrictly increasing or not
            return false;
        }
        return isArrayIncreasing(arr , arr[current], current+1); // eachtime update the value of current  to current +1 and prev = arr[current]
    }     
}
