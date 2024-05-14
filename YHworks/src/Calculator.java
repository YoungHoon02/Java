import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator extends JFrame implements ActionListener{
    
    int a = 0, b = 0, result = 0;

    JButton[] NumpadButtons;
    JButton[] FunctionButtons;
    JTextField Output;

    String[] buttonNumpadScales = { //배열에 이름값을 미리 정의
        "Backspace", "","", 
        "7", "8", "9",
        "4", "5", "6",
        "1", "2", "3",
        "0", "+/-", "."};

    String[] buttonFunctionScales = { //배열에 이름값을 미리 정의
        "CE", "C",
        "/", "sqrt",
        "*", "%",
        "-", "1/x",
        "+", "="};

    public Calculator() {

        JPanel panel = new JPanel();

        add(panel);

        JPanel panel1 = new JPanel(); //output
        panel.add(panel1);
        JPanel panel2 = new JPanel(); //Numpad
        panel.add(panel2);
        JPanel panel3 = new JPanel(); //Function
        panel.add(panel3);

        //panel1
        Output = new JTextField("",30);
        //Output.setEditable(false); 
        panel1.add(Output);

        //panel2
        panel2.setLayout(new GridLayout(5,3,3,3));
        NumpadButtons = new JButton[15]; //버튼 배열 생성
        for (int i=0; i<15; i++) {
            NumpadButtons[i] = new JButton();
            NumpadButtons[i].setText(""+buttonNumpadScales[i]);
            NumpadButtons[i].addActionListener(this);
            NumpadButtons[i].setForeground(Color.BLUE);
            panel2.add(NumpadButtons[i]);
        }
        

        //panel3
        panel3.setLayout(new GridLayout(5,2,3,3));
        FunctionButtons = new JButton[15]; //버튼 배열 생성
        for (int i=0; i<10; i++) {
            FunctionButtons[i] = new JButton();
            FunctionButtons[i].setText(""+buttonFunctionScales[i]);
            FunctionButtons[i].addActionListener(this);
            FunctionButtons[i].setForeground(Color.RED);
            panel3.add(FunctionButtons[i]);
        }
        

        setSize(480, 240); //프레임 사이즈
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료시 작동방법
        setTitle(null); //프레임 타이틀
        setResizable(false);
        setVisible(true);
    }

    int functionActionType = 1;

    @Override
    public void actionPerformed(ActionEvent e) {
        //숫자 버튼
        for(int i=0; i<15; i++) {
            if(e.getSource() == NumpadButtons[i]) {
                Output.setText(Output.getText() + NumpadButtons[i].getText());
            }
        }
    
        //연산자 버튼
        for(int i=0; i<10; i++) {
            if(e.getSource() == FunctionButtons[i]) {
                
                if (i != 9) { //계산 버튼 제외
                    a = Integer.parseInt(Output.getText());
                    functionActionType = i;
                    Output.setText("");
                }
            }
        }
    
        //초기화 버튼 (C)
        if(e.getSource() == FunctionButtons[1]) {
            result = 0; a = 0; b = 0; functionActionType = -1;
            Output.setText("");
        }
    
        //계산 버튼
        if(e.getSource() == FunctionButtons[9]) {
            b = Integer.parseInt(Output.getText());
    
            switch (functionActionType) {
                case 6: // 빼기
                    result = a - b;
                    break;
                case 8: // 더하기
                    result = a + b;
                    break;
                default:
                    result = b;
                    break;
            }
    
            Output.setText("" + result);
            functionActionType = -1; //계산 후 연산자 초기화
        }
    }

    public static void main(String[] args) {
        
        new Calculator();
    }
}
