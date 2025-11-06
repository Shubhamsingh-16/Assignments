import java.util.*;

public class StackMidEle {

    static void middle(Stack<Integer> st, int i, int size) {
        
        if (i == size / 2) {
            st.pop();  
            return;
        }

        int top = st.pop();
        middle(st, i + 1, size);

        
        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);

        System.out.println("Original stack: " + st);

        int size = st.size();   // store original size
        middle(st, 0, size);

        System.out.println("After deleting middle: " + st);
    }
}