import java.util.*;

public class CentralizedQueue{
    private static CentralizedQueue instance;
    private ArrayList<Integer> queueNumber= new ArrayList<>();
    private int addCounter;
    private int removeCounter;

    private CentralizedQueue(){

    }

    // get application instance
    public static synchronized CentralizedQueue getInstance() {
        if (instance == null)
                instance = new CentralizedQueue();
        return instance;
    }

    // Obtain queue number
    public synchronized void obtainQueueNumber(){
        if(queueNumber.isEmpty()){
            queueNumber.add(1);
        }
        else{
            queueNumber.add(queueNumber.get(queueNumber.size()-1) + 1);
        }
        System.out.println("Queue number " + queueNumber.get(queueNumber.size()-1) + " obtained.");
        addCounter++;
    }
    public synchronized void removeQueueNumber(int num){
        if(queueNumber.isEmpty()){
            System.out.println("Can't remove, queue is empty.");
        }
        else if(queueNumber.contains(num) == false){
            System.out.println("Queue number doesn't exist");
        }
        else{
            queueNumber.remove(Integer.valueOf(num));
            System.out.println("Queue number " + num + " removed.");
            removeCounter++;
        }
    }
    // Get overall amount of queued numbers
    public synchronized int getAddCounter(){
        return this.addCounter;
    }
    // Get overall amount of finished queued numbers
    public synchronized int getRemoveCounter(){
        return this.removeCounter;
    }
    private int firstIndex(int num){
        // If the queue contains 'num', return its index.
        if (queueNumber.contains(num)) {
            return queueNumber.indexOf(num);
        }
        // Otherwise, find the appropriate insertion point
        for (int i = 0; i < queueNumber.size(); i++) {
            if (queueNumber.get(i) > num) {
                return i; // Return the index before the first larger element
            }
        }
            // If no elements are larger, return the size of the queue (indicating the end)
        return queueNumber.size(); // Or alternatively, return -1 if you want to signal an invalid index
    }
    public synchronized void reset(int num){
        int firstIndex = firstIndex(num);
        int lastIndex = addCounter;
        int count = addCounter - num + 1;
        
        if (num <= 0) {
            return;
        }
        // Check if queue is empty
        if (queueNumber.isEmpty()) {
            System.out.println("Can't reset, queue is empty.");
            return;
        }
        
        // Check if num is greater than addCounter
        if (num > addCounter) {
            System.out.println("Queue number doesn't exist");
            return;
        }
    
        // Make sure firstIndex is valid for subList
        if (firstIndex < 0 || firstIndex >= queueNumber.size()) {
            //System.out.println("Invalid first index calculated: " + firstIndex);
            return;
        }
    
        // Make sure lastIndex is valid
        if (lastIndex > queueNumber.size()) {
            lastIndex = queueNumber.size();
        }
    
        // Clear the sublist and add new elements
        queueNumber.subList(firstIndex, lastIndex).clear();
        for (int i = 0; i < count; i++) {
            queueNumber.add(firstIndex + i, num + i);
        }
        System.out.println("Reset from queue " + num +  ".");
    }

    // List current queued number
    public synchronized void currentQueuedNumber(){
        System.out.println(queueNumber.toString());

    }
}