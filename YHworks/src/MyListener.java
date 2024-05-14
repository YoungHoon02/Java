import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e) {
        System.out.println("버튼 눌림");

        JButton button = (JButton) e.getSource(); //button포인터가 getSource를 통해 버튼의 객체를 받는다
        if(button.getText() == "변환") {
            button.setText("변환중");
        }
        else {
            button.setText("변환");
        }
        System.out.println(button.getText());
    }
}
