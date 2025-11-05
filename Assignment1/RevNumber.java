public class RevNumber {
    public static void main(String [] args){
         int num =10;
         StringBuilder sb = new StringBuilder();
         System.out.println( revNumber(num, sb));
    }
    static StringBuilder revNumber (int num , StringBuilder sb){
        if(num == 0)
            return sb;
        sb.append( ""+(num%10));
        return revNumber(num/10, sb);
    }
}
