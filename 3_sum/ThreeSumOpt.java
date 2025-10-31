import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumOpt {

    //time complexity O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        int i=0,j=0,k=0;
        int n= nums.length;
        int[] sortedNums= nums.clone();
        Arrays.sort(sortedNums);
        for(i=0;i<n;i++){
            if(i!=0 && sortedNums [i]==sortedNums[i-1]){
                continue;
            }
            j=i+1;
            k=n-1;
            while(j<k){
                int sum= sortedNums[i]+sortedNums[j]+sortedNums[k];
                if(sum>0){
                    k--;
                    while(j<k && sortedNums[k]==sortedNums[k+1]){
                        k--;
                    }
                }
                else if(sum<0){
                    j++;
                    while(j<k && sortedNums[j]==sortedNums[j-1]){
                        j++;
                    }

                }
                else{
                    result.add(Arrays.asList(sortedNums[i],sortedNums[j],sortedNums[k]));
                    k--;
                    j++;
                    while(j<k && sortedNums[j]==sortedNums[j-1]){
                        j++;
                    }
                    while(j<k && sortedNums[k]==sortedNums[k+1]){
                        k--;
                    }

                }
            }
            
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        ThreeSumOpt obj= new ThreeSumOpt();
        System.out.println(obj.threeSum(nums));
    }
}
