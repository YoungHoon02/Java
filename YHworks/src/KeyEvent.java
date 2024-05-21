import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyListener;

import javax.swing.*;

public class KeyEvent extends JFrame implements KeyListener {

    private JPanel panel;
    private JTextField field;
    private JTextArea area;

    public KeyEvent() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLocation(screenSize.width / 2 - 400/2, screenSize.height / 2 - 200/2); //창 표시 위치 지정

        setSize(400, 200); //프레임 사이즈
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료시 작동방법
        setTitle("Key Event"); //프레임 타이틀
        setResizable(true); //창 크기 재조정 여부

        //panel
        panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("문자를 입력하시오: "));
        
        field = new JTextField(10);
        panel.add(field);
        
        add(panel, BorderLayout.NORTH);

        //field(KeyListener)
        field.addKeyListener(this);

        //area
        area = new JTextArea(3, 30);
        add(area, BorderLayout.CENTER);


        setVisible(true); //항상 컴포넌트 추가 맨 마지막에
    }

    public static void main(String[] args) {
        new KeyEvent();
    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
        System.out.println("Key typed");
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        System.out.println("Key pressed");
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        System.out.println("Key released");
    }
}
