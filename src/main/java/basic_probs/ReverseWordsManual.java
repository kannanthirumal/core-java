package basic_probs;

public class ReverseWordsManual {
    public static void main(String[] args) {
        //reverse the words in a sentence
        String s = "   I Love Japan";
        s = s.trim();

        char[] st = s.toCharArray();

        int start = 0;
        int end = -1;

        for(int i = 0; i <= st.length; i++){

            if(i == st.length || st[i] == ' '){
                end = i - 1;
                reverseWords(st, start, end);
                start = i + 1;
            }
        }

        System.out.println(new String(st));
    }

    private static void reverseWords(char[] A, int start, int end) {
        while(start < end) {
            char temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }
}
