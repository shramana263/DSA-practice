public class LastZero {
    public boolean isOneBitCharacter(int[] bits) {
        int n= bits.length;
        int flag=0;
        int i=0;
        while(i<n){
            if(i+1<n && ((bits[i]==1 && bits[i+1]==0) || (bits[i]==1 && bits[i+1]==1))){
                flag=1;
                i+=2;
            }
            else{
                flag=0;
                i++;
            }
        }
        if(flag==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums= {1,0,0};
        LastZero obj = new LastZero();
        System.out.println(obj.isOneBitCharacter(nums)?"true":"false");
    }
}
