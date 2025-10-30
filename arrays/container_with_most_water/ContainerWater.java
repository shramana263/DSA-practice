public class ContainerWater {


    //     You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

    // Find two lines that together with the x-axis form a container, such that the container contains the most water.

    // Return the maximum amount of water a container can store.

    // Notice that you may not slant the container.

    

    // Example 1:
    //Input: height = [1,8,6,2,5,4,8,3,7]
    // Output: 49
    // Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
    // Example 2:

    // Input: height = [1,1]
    // Output: 1

    //time complexity O(n^2)
    public int maxArea(int[] height) {
        int maxArea=0;
        if(height.length==0) return 0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                if(height[i]<height[j]){
                    maxArea=Math.max(maxArea,height[i]*(j-i));
                }
                else{
                    maxArea=Math.max(maxArea,height[j]*(j-i));
                }

            }

        }
        return maxArea;
    }

    public static void main(String[] args){
        int[] height={1,1};
        ContainerWater containerWater=new ContainerWater();
        System.out.println(containerWater.maxArea(height));
    }
}
