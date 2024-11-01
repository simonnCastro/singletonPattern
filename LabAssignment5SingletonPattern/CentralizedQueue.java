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
            queueNumber.add(queueNumber.getLast() + 1);
        }
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
    
    public synchronized void reset(int num){
        int firstIndex;
        int lastIndex = queueNumber.size();
        int count;
        
        
        if(queueNumber.isEmpty()){
            System.out.println("Can't reset, queue is empty.");
        }
        else if (num > addCounter) {
            System.out.println("Queue number doesn't exist");
        }
        else{
            queueNumber.subList(firstIndex, lastIndex).clear();
            for(int i = 0; i < count; i++){
                queueNumber.add(firstIndex + i, num + i);
            }
        }
    }

    // List current queued number
    public synchronized void currentQueuedNumber(){
        System.out.println(queueNumber.toString());

    }
}