public class ColName {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber>0){
            int rem= columnNumber%26;

            if(rem==0){
                sb.append('Z');
                columnNumber=(columnNumber/26)-1;
            }
            else{
                sb.append((char)((rem-1)+'A'));
                columnNumber=columnNumber/26;
            }

        }
        return sb.reverse().toString();
    }


    public static void main(String[] args){
        int num= 1;
        ColName obj= new ColName();
        System.out.println(obj.convertToTitle(num));
    }
}
