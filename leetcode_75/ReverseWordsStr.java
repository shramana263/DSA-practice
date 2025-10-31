public class ReverseWordsStr {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String s = "  Hello   World  ";
        System.out.println("Original String: \"" + s + "\"");
        ReverseWordsStr reverser = new ReverseWordsStr();
        String reversed = reverser.reverseWords(s);
        System.out.println("Reversed Words: \"" + reversed + "\"");
    }
}
