import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyPizza extends JFrame implements ActionListener{

    JLabel label, amountLabel;
    JButton button1, button2, button3;
    JTextField amountTextField;

    int numPizza = 0;

    public MyPizza(){
        JPanel panel = new JPanel();

        add(panel);

        JPanel panel1 = new JPanel();
        panel.add(panel1);
        JPanel panel2 = new JPanel();
        panel.add(panel2);

        label = new JLabel("자바 피자에 오신 것을 환영합니다. 피자의 종류를 선택하시오.");
        panel1.add(label);

        button1 = new JButton("콤보 피자");
        button1.addActionListener(e -> { //람다식 정의
            button1.setText("콤보 피자");
            numPizza++;
            amountTextField.setText(""+numPizza);
        });

        button2 = new JButton("포테이토 피자");
        button2.addActionListener(this);
        button3 = new JButton("불고기 피자");
        button3.addActionListener(this);
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);

        amountLabel = new JLabel("개수");
        amountTextField = new JTextField(5);
        amountTextField.setText(""+numPizza);
        panel2.add(amountLabel);
        panel2.add(amountTextField);

        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MyPizza");
        setVisible(true);
    }
    public static void main(String[] args) {
        
        MyPizza obj = new MyPizza();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("이벤트");

        if(e.getSource() == button2) {
            button2.setText("포테이토 피자");
            numPizza++;
            amountTextField.setText(""+numPizza);
        }
        else if(e.getSource() == button3) {
            button3.setText("불고기 피자");
            numPizza++;
            amountTextField.setText(""+numPizza);
        }
    }
}
