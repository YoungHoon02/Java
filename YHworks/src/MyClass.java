import java.awt.event.ActionEvent; //패키지
import java.awt.event.ActionListener;
//import java.awt.* awt폴더 내부의 패키지를 전부 가져옴

public class MyClass implements ActionListener{ //MyClass 메서드는 사실상 더미코드의 역할
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("beep");
    }
}
