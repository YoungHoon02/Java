import javax.swing.*;

import java.awt.*;

public class MyFrame extends JFrame{
    
    public MyFrame(String title) {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLocation(screenSize.width / 2 - 300/2, screenSize.height / 2 - 200/2); //창 표시 위치 지정

        setSize(300, 200); //프레임 사이즈
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료시 작동방법
        setTitle("MyFrame Test"); //프레임 타이틀
        setResizable(true); //창 크기 재조정 여부

        setLayout(new BorderLayout());

        JButton button = new JButton("첫문단");
        add(button, BorderLayout.PAGE_START); //NORTH도 가능

        JButton button2 = new JButton("끝문단");
        add(button2, BorderLayout.SOUTH); //PAGE_END도 가능

        JPanel panel2 = new JPanel();
        JButton button3 = new JButton("123");
        JButton buttonBefore = new JButton("<");
        JButton buttonAfter = new JButton(">");
        panel2.add(button3);
        panel2.add(buttonBefore, BorderLayout.LINE_START);
        panel2.add(buttonAfter, BorderLayout.LINE_END);

        setVisible(true); //윈도우에 표시
    }

    /*
    setLocation(x, y) , setBounds(x, y, width, height), setSize(width, height)
    프레임의 위치와 크기를 설정한다.

    setIconImage(IconImage)
    윈도우 시스템에 타이틀 바, 태스크 스위처에 표시할 아이콘을 알려준다.

    setTitle()
    타이틀 바의 제목을 변경한다.

    setResizable(boolean)
    사용자가 크기를 조절할 수 있는지를 설정한다.
    */

    public static void main(String[] args) { //MyFrame 독자적 테스트 코드
        
        MyFrame f = new MyFrame(null);
    }

}
