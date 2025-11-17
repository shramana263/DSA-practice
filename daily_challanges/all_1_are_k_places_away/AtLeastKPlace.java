public class AtLeastKPlace {
    public boolean kLengthApart(int[] nums, int k) {
        int n= nums.length;
        int count=0;

        int i=0;
        while(nums[i]!=1 && i<n){
            i++;
            if(i==n-1){
                return true;
            }
        }
        i++;
        while(i<n){
            if(nums[i]==1){
                if(count<k){
                    return false;
                }
                count=0;
            }
            else{
                count++;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args){
        int[] nums={1,0,0,0,1,0,0,1};
        int k=2;
        AtLeastKPlace obj = new AtLeastKPlace();
        System.out.println(obj.kLengthApart(nums, k)?"true":"false");
    }

}
