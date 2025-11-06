public class Combination {


    static void combinations(String s, int n, int k, int i) {
        
        if (k == 0) {
            System.out.println(s.trim());
            return;
        }

        
        if (i > n) return;

        
        for (int j = i; j <= n; j++) {
            combinations(s + j + " ", n, k - 1, j + 1);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        combinations("", n, k, 1);
    }
}
