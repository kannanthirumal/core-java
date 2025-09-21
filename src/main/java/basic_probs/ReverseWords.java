package basic_probs;

public class ReverseWords {
    public static void main(String[] args) {
        //reverse the words in a sentence

        String s = "I Love Japan";

        String[] st = s.split(" ");

        StringBuilder ans = new StringBuilder();

        for(String x: st) {
            String reverse = new StringBuffer(x).reverse().toString();
            ans.append(reverse);
            ans.append(" ");
        }

        System.out.println(ans.toString().trim());
    }
}
