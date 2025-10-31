

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SortedArrToBST {
    //time complexity: O(n)
    //space complexity: O(log n) for the recursion stack
    public TreeNode constructBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = constructBST(arr, start, mid - 1);
        node.right = constructBST(arr, mid + 1, end);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        
        return constructBST(nums, 0, nums.length - 1);
    }
    

    public static void main(String[] args){
        int[] arr={-10, -3, 0, 5, 9};
        TreeNode root=new SortedArrToBST().sortedArrayToBST(arr);
        // System.out.println("Root value of the BST: " + root.val);
        

        
    }
}
