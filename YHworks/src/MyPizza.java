import javax.swing.*;

public class MyPizza {
    public static void main(String[] args) {
        
        JFrame f = new JFrame();
        JPanel panel = new JPanel();

        f.add(panel);

        JPanel panel1 = new JPanel();
        panel.add(panel1);
        JPanel panel2 = new JPanel();
        panel.add(panel2);

        JLabel label = new JLabel("자바 피자에 오신 것을 환영합니다. 피자의 종류를 선택하시오.");
        panel1.add(label);

        JButton button1 = new JButton("콤보 피자");
        JButton button2 = new JButton("포테이토 피자");
        JButton button3 = new JButton("불고기 피자");
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);

        JLabel amountLabel = new JLabel("개수");
        JTextField amountTextField = new JTextField(5);
        panel2.add(amountLabel);
        panel2.add(amountTextField);

        f.setSize(600, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("MyPizza");
        f.setVisible(true);
    }
}
