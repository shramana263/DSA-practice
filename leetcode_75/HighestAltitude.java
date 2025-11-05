
import java.util.Arrays;

public class HighestAltitude {

    public int largestAltitude(int[] gain) {
        if(gain.length<1){
            return 0;
        }
        int csum=0;
        int large=0;
        for(int i=0;i<gain.length;i++){
            csum+=gain[i];
            // System.out.print("csum= "+csum);
            if(csum>large){
                large=csum;
            }
            gain[i]=csum;
            // System.out.println(" gain value = "+gain[i]);
        }
        // for(int i=0;i<gain.length;i++){
        //     System.out.print(gain[i]+" ");
        // }
        // Arrays.sort(gain);
        // for(int i=0;i<gain.length;i++){
        //     System.out.print(gain[i]+" ");
        // }
        return Math.max(0,large);
    }

    public static void main(String[] args){
        int[] gain={-5,1,5,0,-7};
        HighestAltitude obj= new HighestAltitude();
        System.out.println(obj.largestAltitude(gain));
    }
}
