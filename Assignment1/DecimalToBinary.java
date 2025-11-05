public class DecimalToBinary {
    public static void main(String [] args){
         int num =10;
         StringBuilder sb = new StringBuilder();
         System.out.println( decimalToBinary(num, sb));
    }
    static StringBuilder decimalToBinary (int num , StringBuilder sb){
        if(num<2)
            return (sb.insert(0,(""+ num)));
        sb.insert(0, ""+(num%2));
        return decimalToBinary(num/2, sb);
    }
}
