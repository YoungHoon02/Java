import java.awt.event.ActionListener;
import javax.swing.Timer;

public class CallBackTest {
    
    public static void main(String[] args) {
        
        ActionListener obj = new MyClass();
        Timer time = new Timer(1000, obj);
        //new Timer(1000, event -> {System.out.println("beep")}); <람다식 무명클래스 메소드, MyClass호출 필요x>
        time.start();

        try {
            Thread.sleep(100000);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
