public class OddNumInInterval {
    // public int countOdds(int low, int high) {
    //     int count=0;
    //     if(low%2==0){
    //         for(int i=low+1;i<=high;i+=2){
    //             count++;
    //         }
    //     }
    //     else{
    //         for(int i=low;i<=high;i+=2){
    //             count++;
    //         }
    //     }
    //     return count;

    // }

    //most efficient
    public int countOdds(int low, int high) {
        if(low%2==0){
            low++;
        }
        if(low>high){
            return 0;
        }
            
            
        return (high - low) / 2 + 1;

    }
}
