import java.util.ArrayDeque;
import java.util.Deque;

public class TimeRquired {

    //this has got output limit exceeded eror----------------------------------
    // public int timeRequiredToBuy(int[] tickets, int k) {

    //     if(k>tickets.length || tickets.length<1){
    //         return 0;
    //     }

    //     Deque<Integer> queue = new ArrayDeque<>();
    //     for(int ticket:tickets){
    //         queue.addLast(ticket);
    //     }
    //     // int i=k;
    //     int count=0;
    //     while(k>=0){
    //         if(queue.peekFirst()==1){
    //             if(k==0){
    //                 // queue.removeFirst();
    //                 count++;
    //                 k--;
    //                 break;
    //             }
    //             else{
    //                 queue.removeFirst();
    //                 k--;
    //             }
    //         }
    //         else{
    //             if(k==0){
    //                 queue.addLast(queue.removeFirst()-1);
    //                 k=queue.size()-1;
    //             }
    //             else{
    //                 queue.addLast(queue.removeFirst()-1);
    //                 k--;
    //             }
    //         }
    //         System.out.println(queue +"  "+k);
    //         count++;
    //     }
    //     return count;
    // }

    //the above code got output limit exceeded errorrrr---------------------

    public int timeRequiredToBuy(int[] tickets, int k) {
        // A queue to store the pair: [ticketCount, originalIndex]
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < tickets.length; i++) {
            queue.addLast(new int[]{tickets[i], i});
        }

        int time = 0;

        while (true) {
            // 1. Check if the queue is empty (shouldn't happen with correct logic)
            if (queue.isEmpty()) {
                break;
            }

            // 2. Get the person at the front
            int[] currentPerson = queue.removeFirst();
            int currentTickets = currentPerson[0];
            int originalIndex = currentPerson[1];

            // 3. Process the transaction
            currentTickets--;
            time++;

            // 4. Check for the termination condition
            if (currentTickets == 0 && originalIndex == k) {
                // The person at index k has finished buying their last ticket.
                break;
            }

            // 5. If the person still needs tickets, add them back to the queue
            if (currentTickets > 0) {
                currentPerson[0] = currentTickets; // Update the ticket count
                queue.addLast(currentPerson);      // Add back to the end
            }
        }

        return time;
    }

    public static void main(String[] args){
        int[] tickets={2,3,2};
        int k=5;
        TimeRquired obj = new TimeRquired();
        System.out.println(obj.timeRequiredToBuy(tickets, k));    
    }
}
