public class TelevisionTest {
    
    public static void main(String[] args) {
        
        Television myTv = new Television();

        myTv.setChannel(7);
        myTv.volume = 4;
        myTv.onOff = true;

        Television yourTv = new Television();

        yourTv.setChannel(-1);
        yourTv.volume = 12;
        yourTv.onOff = true;

        myTv.print();
        yourTv.print();
    
    }
}
