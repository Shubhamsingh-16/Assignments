//time complexity = O(n)
// space complexity = O(n)
public class ContainDigit {
    public static void main(String [ ] args){
        String str = "10a";
        System.out.println(containDigit(str, 0));
        
    }
    static boolean containDigit(String str, int current){
        String s = "0123456789";                //a string of all digit from 0 to 9
        if(current==str.length()) return true; // check current reached the last element of string or not 
        char target = str.charAt(current);    // target is the next character of string to check weather string or not 
        if( s.indexOf(target) >-1)            // check if target in s then it is a digit   
            return containDigit(str, current+1);  // then check for current +1 character
        return false;   // if the character is not digit false will be returned
    }
}
