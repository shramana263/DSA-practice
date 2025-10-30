public class ZigZagConversion {

    // The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

    // P   A   H   N
    // A P L S I I G
    // Y   I   R
    // And then read line by line: "PAHNAPLSIIGYIR"

    // Write the code that will take a string and make this conversion given a number of rows:

    // string convert(string s, int numRows);
    

    // Example 1:

    // Input: s = "PAYPALISHIRING", numRows = 3
    // Output: "PAHNAPLSIIGYIR"
    // Example 2:

    // Input: s = "PAYPALISHIRING", numRows = 4
    // Output: "PINALSIGYAHRPI"

    public String convert(String s, int numRows) {
        if(s.length()==0){
            return "";
        }
        if(numRows==1){
            return s;
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<numRows;i++){
            int deltasouth=2*(numRows-i-1);
            int deltanorth=2*i;
            int index=i;
            boolean gosouth=true;
            while(index<s.length()){
                sb.append(s.charAt(index));
                if(i==0){
                    index+=deltasouth;
                }
                else if(i==numRows-1){
                    index+=deltanorth;
                }
                else{
                    if(gosouth==true){
                        index+=deltasouth;
                    }
                    else{
                        index+=deltanorth;
                    }
                    gosouth=!gosouth;
                }
                
            }


        }
        return sb.toString();
    }

    public static void main(String[] args){
        String s= new String("PAYPALISHIRING");
        int numRows=3;
        ZigZagConversion obj= new ZigZagConversion();
        String result= obj.convert(s,numRows);
        System.out.println(result);
    }
}
