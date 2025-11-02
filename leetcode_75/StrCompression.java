

public class StrCompression {

    public int compress(char[] chars) {
        if(chars.length==0){
            return 0;
        }
        StringBuilder sb= new StringBuilder();
        int i=0;
        int count=1;
        for(int j=i+1;j<chars.length;j++){
            if(chars[i]!=chars[j]){
                sb.append(chars[i]);
                if(count>1){

                    sb.append(count);
                }
                count=1;
                i=j;
            }
            else{
                count++;
            }
            

        }
        sb.append(chars[i]);
        sb.append(count);

        String s= sb.toString();
        System.out.println(s);

        for(int k=0;k<s.length();k++){
            chars[k]=s.charAt(k);
        }

        return sb.length();
    }

    public static void main(String[] args){
        char[] a = {'a','a','a','a','b','b','b','b','b','b','b','c','c','c','c','a','a','a','a'};
        StrCompression obj = new StrCompression();
        int compressedLength = obj.compress(a);
        System.out.println("Compressed length: " + compressedLength);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
