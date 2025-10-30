public class ContainerWaterOpt {
    
    //time complexity O(n)
    public int maxArea(int[] height) {
        int maxArea=0;
        if(height.length==0) return 0;
        int left =0;
        int right= height.length-1;
        while(left<right){
            int leftHeight=height[left];
            int rightHeight=height[right];

            int area=Math.min(leftHeight,rightHeight)*(right-left);
            maxArea=Math.max(maxArea,area);

            if(leftHeight<rightHeight){
                left++;
            }
            else{
                right--;
            }

        }
        return maxArea;
    }

    public static void main(String[] args){
        int[] height={1,8,6,2,5,4,8,3,7};
        ContainerWater containerWater=new ContainerWater();
        System.out.println(containerWater.maxArea(height));
    }
}
