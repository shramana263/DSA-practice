public class MinOp {

    public int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }

    public int minOperations(int[] nums) {
        int n= nums.length;
        if(n==0){
            return -1;
        }
        int count=0;
        for(int num:nums){
            if(num==1){
                count++;
            }
        }

        if(count>0){
            return n-count;
        }

        int minArrSize= n+1;
        for(int i=0;i<n;i++){
            // System.out.print("hello");
            int curr=0;
            for(int j=i;j<n;j++){
                curr= gcd(curr,nums[j]);

                if(curr==1){
                    minArrSize=Math.min(minArrSize, j-i+1);
                    break;
                }
            }

        }
        if(minArrSize>n){
            return -1;
        }

        return (n-1)+(minArrSize-1);

    }

    public static void main(String[] args){
        int[] nums={2,3,6,4};
        MinOp obj= new MinOp();
        System.out.println(obj.minOperations(nums));
    }
}
