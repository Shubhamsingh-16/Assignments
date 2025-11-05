// time complexity : O(n)
// space Complexity : O(n)
public class NumberOfZeros {
    public static void main(String [] args){ 
        int num = 102030;
        System.out.println(numberOfZeros(num , 0));
    }

    static int numberOfZeros(int num , int zeros){ //recursive function with num = number , zeros= number of zeros counted yet 
        if(num == 0) return zeros; // if num ==0 means number is fully iterarted now return no. of zeros 
        if(num%10 ==0)                  // check the last digit is zero or not
            return numberOfZeros(num/10 , zeros+1);   // call numberOfzeros again with incremented value of zeros
        return numberOfZeros(num/10, zeros);  // call numberOfZeros with the same zeros
    }    
}
