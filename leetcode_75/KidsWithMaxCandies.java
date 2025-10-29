import java.util.ArrayList;
import java.util.List;

public class KidsWithMaxCandies {

// There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.

// Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.

// Note that multiple kids can have the greatest number of candies.

 

// Example 1:

// Input: candies = [2,3,5,1,3], extraCandies = 3
// Output: [true,true,true,false,true] 
// Explanation: If you give all extraCandies to:
// - Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
// - Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
// - Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
// - Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
// - Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
// Example 2:

// Input: candies = [4,2,1,1,2], extraCandies = 1
// Output: [true,false,false,false,false] 
// Explanation: There is only 1 extra candy.
// Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.
// Example 3:

// Input: candies = [12,1,12], extraCandies = 10
// Output: [true,false,true]

    //time complexity: O(n^2)-------------------------
    //space complexity: O(1)--------------------------
    // public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    //     List<Boolean> result = new ArrayList<>();

    //     int largest;
    //     int flag=0;
    //     for(int i=0;i<candies.length;i++){
    //         largest= candies[i]+extraCandies;
    //         for(int j=0;j<candies.length;j++){
    //             if(largest<candies[j] && i!=j){
    //                 // result.add(false);
    //                 flag=1;
    //                 break;
    //             }
    //         }
    //         if(flag==1){
    //             result.add(false);
    //             flag=0;
    //         }
    //         else{
    //             result.add(true);
    //         }
    //     }
    //     return result;
    // }

    //time complexity: O(n)----------------------------
    //space complexity: O(1)---------------------------
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max=0;
        for(int candy:candies){
            if(candy>max){
                max=candy;
            }
        }

        for(int candy:candies){
            if(candy+extraCandies>=max){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }

        return result;
    }


    public static void main(String[] args){
        int[] candies = new int[]{4,2,1,1,2};
        int extra=1;
        KidsWithMaxCandies obj= new KidsWithMaxCandies();
        List<Boolean> res= obj.kidsWithCandies(candies, extra);
        System.out.println(res);
    }
}
