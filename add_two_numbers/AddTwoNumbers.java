class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    // ListNode head;
}

public class AddTwoNumbers {

//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.

// Example 2:
// Input: l1 = [0], l2 = [0]
// Output: [0]

// Example 3:
// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]

    public ListNode addTwoNumbers(ListNode L1, ListNode L2){

        int carry = 0;
        
        if(L1 == null && L2 == null){
            return null;
        }
        
        ListNode result= new ListNode();
        ListNode p1 = L1;
        ListNode p2 = L2;
        while(p1 != null || p2 != null || carry != 0){
            int sum = carry;
            if(p1 != null){
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            // Append newNode to result list
            if(result == null){
                result = newNode;
            } else {
                ListNode temp = result;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }
        return result.next;
    }

    public static void main(String[] args){
        AddTwoNumbers atn= new AddTwoNumbers();
        ListNode L1= new ListNode();
        L1= new ListNode(2);
        L1.next= new ListNode(5);
        L1.next.next= new ListNode(5);
        ListNode L2= new ListNode();
        L2= new ListNode(3);
        L2.next= new ListNode(6);
        L2.next.next= new ListNode(0);
        ListNode result= atn.addTwoNumbers(L1, L2);
        ListNode temp= result;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
    
}
