public class DeskStation{
    public static void main(String[] args){
        CentralizedQueue deskStation1 = CentralizedQueue.getInstance();
        CentralizedQueue deskStation2 = CentralizedQueue.getInstance();
        CentralizedQueue deskStation3 = CentralizedQueue.getInstance();

        deskStation1.obtainQueueNumber();
        deskStation1.obtainQueueNumber();
        deskStation1.obtainQueueNumber();
        deskStation2.obtainQueueNumber();
        deskStation2.obtainQueueNumber();
        deskStation3.obtainQueueNumber();
        
        deskStation3.removeQueueNumber(3);
        deskStation3.removeQueueNumber(4);
        //deskStation3.removeQueueNumber(5);
        //deskStation3.removeQueueNumber(6);
        deskStation2.reset(6);

        
        deskStation3.obtainQueueNumber();
        
        //System.out.println(deskStation1.getAddCounter());
        //System.out.println(deskStation2.getRemoveCounter());

        deskStation1.currentQueuedNumber();
        deskStation2.currentQueuedNumber();
        deskStation3.currentQueuedNumber();
    }
}