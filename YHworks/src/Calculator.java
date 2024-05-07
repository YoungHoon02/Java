import java.awt.*;
import javax.swing.*;

public class Calculator {
    
    public static void main(String[] args) {
        
        JFrame f = new JFrame();
        JPanel panel = new JPanel();

        f.add(panel);

        JPanel panel1 = new JPanel(); //output
        panel.add(panel1);
        JPanel panel2 = new JPanel(); //Numpad
        panel.add(panel2);
        JPanel panel3 = new JPanel(); //Function
        panel.add(panel3);

        //panel1
        JTextField Output = new JTextField("0",30);
        //Output.setEditable(false); 
        panel1.add(Output);

        //panel2
        panel2.setLayout(new GridLayout(5,3,3,3));
        String[] buttonNumpadScales = { //배열에 이름값을 미리 정의
        "Backspace", "","", 
        "7", "8", "9",
        "4", "5", "6",
        "1", "2", "3",
        "0", "+/-", "."};
        JButton[] NumpadButtons = new JButton[15]; //버튼 배열 생성
        for (int i=0; i<15; i++) {
            NumpadButtons[i] = new JButton(buttonNumpadScales[i]);
            NumpadButtons[i].setForeground(Color.BLUE);
            panel2.add(NumpadButtons[i]);
        }
        

        //panel3
        panel3.setLayout(new GridLayout(5,2,3,3));
        String[] buttonFunctionScales = { //배열에 이름값을 미리 정의
        "CE", "C",
        "/", "sqrt",
        "*", "%",
        "-", "1/x",
        "+", "="};
        JButton[] FunctionButtons = new JButton[15]; //버튼 배열 생성
        for (int i=0; i<10; i++) {
            FunctionButtons[i] = new JButton(buttonFunctionScales[i]);
            FunctionButtons[i].setForeground(Color.RED);
            panel3.add(FunctionButtons[i]);
        }
        

        f.setSize(480, 240); //프레임 사이즈
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료시 작동방법
        f.setTitle(null); //프레임 타이틀
        f.setResizable(false);
        f.setVisible(true);
    }
}
