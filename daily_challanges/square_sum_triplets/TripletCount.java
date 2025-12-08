public class TripletCount {
    public int countTriples(int n) {
        int count=0;
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                // int sum=;
                // System.out.print("sum= "+sum);
                double sqrtResult = Math.sqrt((i*i)+(j*j));
                // System.out.println("  sum sqrt= "+ sqrtResult + " "+ (int)sqrtResult + " "+ (sqrtResult==(int)sqrtResult?"true":"false"));
                if(sqrtResult==(int)sqrtResult){
                    if((int)sqrtResult<=n){

                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        int n= 18;
        TripletCount obj = new TripletCount();
        System.out.println(obj.countTriples(n));
    }
}
