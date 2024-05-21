import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorFrame extends JFrame implements ActionListener{

    private JPanel panel;
    private JButton button1;
    private JButton button2;

    public ColorFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLocation(screenSize.width / 2 - 300/2, screenSize.height / 2 - 200/2); //창 표시 위치 지정

        setSize(300, 200); //프레임 사이즈
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료시 작동방법
        setTitle("MyFrame Test"); //프레임 타이틀
        setResizable(true); //창 크기 재조정 여부

        panel = new JPanel();
        add(panel);

        button1 = new JButton("분홍색");
        button2 = new JButton("노란색");
        
        panel.add(button1);
        button1.addActionListener(this);
        panel.add(button2);
        button2.addActionListener(this);

        panel.setBackground(Color.RED);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.err.println("이벤트 발생");

        if(e.getSource() == button1) {
            panel.setBackground(Color.PINK);
        }
        if(e.getSource() == button2) {
            panel.setBackground(Color.YELLOW);
        }
    }

    public static void main(String[] args) {
        
        new ColorFrame();
    }
}
