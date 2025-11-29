import java.util.Arrays;

public class Cookie {
     public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChildren = 0;
        int cookieIndex = 0;
        while (cookieIndex < s.length && contentChildren < g.length) {
            if (s[cookieIndex] >= g[contentChildren]) {
                contentChildren++;
            }
            cookieIndex++;
        }
        return contentChildren;
    }
    public static void main(String[] args){
        int[] g={10,9,8,7};
        int[] s={5,6,7,8};
        Cookie obj = new Cookie();
        System.out.println(obj.findContentChildren(g, s));
    }
}

