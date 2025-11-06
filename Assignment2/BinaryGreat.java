public class BinaryGreat {

    
    static void generate(String s, int n, int ones, int zeros) {
        
        if (s.length() == n) {
            if (ones > zeros) {  
                System.out.println(s);
            }
            return;
        }

        
        generate(s + "1", n, ones + 1, zeros);

        
        generate(s + "0", n, ones, zeros + 1);
    }

    public static void main(String[] args) {
        int n = 3;  
        generate("", n, 0, 0);
    }
}
