import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame implements ActionListener{
    // 단어 확인 클래스를 여기에 추가하세요.
    
    // 낱말 카드 GUI를 여기에 추가하세요.
    
    // 영어 단어 테스트 GUI를 여기에 추가하세요.
    
    // 단어 관리 GUI를 여기에 추가하세요.
    
    private JButton WordManagerButton;
    private JButton WordTestButton;
    private JTextArea result;
    
    public MainGUI() {
        
        //WordManagerButton
        WordManagerButton = new JButton("단어 관리");
        WordManagerButton.addActionListener(this);
        
        //WordTest
        WordTestButton = new JButton("영어 단어 암기 test");
        WordTestButton.addActionListener(this);
        
        //최근 결과 areafield
        result = new JTextArea();
        result.setEditable(false);
        
        //main panel
        JPanel panel = new JPanel();
        panel.add(WordManagerButton);
        panel.add(WordTestButton);
        
        add(panel, BorderLayout.NORTH);
        add(result, BorderLayout.CENTER);
        
        setTitle("영단어 암기 프로그램");
        setSize(380, 280);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == WordManagerButton) { //WordManagerButton 작동시 단어 관리페이지 오픈
            new WordManager();
        }
    }
}