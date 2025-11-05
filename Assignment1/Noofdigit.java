// time complexity : O(n)
// Space complexity : O(n)
public class Noofdigit {
    public static void main(String [] args){
        int num = 10;
        System.out.println(noofdigits(num , 0));
    }
    static int noofdigits(int num , int ans){   //a tail recursion method with number and ans is the number of digit in it 
        if(num/10 == 0) return ans+1;           //checking the base condition : when number has only one digit it will return ans+1 
        return noofdigits(num/10,ans+1);        // eachtime increase the value of ans+1 for the digit removed from the num using num/10;
    }
}
