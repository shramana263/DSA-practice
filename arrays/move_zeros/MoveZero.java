public class MoveZero {

    public void moveZeroes(int[] nums) {
        int i=0;
        while(i<nums.length && nums[i]!=0){
            i++;
        }
        for(int j=i+1;j<nums.length;j++){
            System.out.println("Inside func");
            if(nums[j]==0){
                System.out.println("Number is 0");
                continue;
            }
            System.out.println("number swap");
            nums[i]=nums[j];
            i++;
        }
        System.out.println("outside func");
        while(i<nums.length){
            nums[i]=0;
            i++;
        }
        System.out.println("print");
        for(int a=0;a<nums.length;a++){
            System.out.print(nums[a]+" ");
        }

    }

    public static void main(String[] args)
    {
        int[] nums= {1,0,0,0,0};
        MoveZero obj= new MoveZero();
        obj.moveZeroes(nums);

    }
}
