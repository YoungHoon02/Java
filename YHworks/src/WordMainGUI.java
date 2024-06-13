import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//단어장의 기본 메인페이지 역할 GUI
public class WordMainGUI extends JFrame implements ActionListener{
    
    private JButton WordManagerButton; //단어 관리 버튼
    private JButton WordTestButton; //낱말 카드 버튼
    private JButton WordMemoryTestButton; //단어 암기 시험 버튼
    private JTextArea result; //시험 결과 텍스트영역
    private WordFileManager fileManager; //파일 관리 객체
    
    public WordMainGUI() {
        
        fileManager = new WordFileManager();

        //단어 관리 버튼 생성
        WordManagerButton = new JButton("단어 관리");
        WordManagerButton.addActionListener(this);
        
        //낱말 카드 버튼 생성
        WordTestButton = new JButton("낱말 카드");
        WordTestButton.addActionListener(this);

        //단어 암기 시험 버튼 생성
        WordMemoryTestButton = new JButton("단어 암기");
        WordMemoryTestButton.addActionListener(this);
        
        //최근 결과 텍스트영역 생성
        result = new JTextArea();
        result.setText(fileManager.loadTestResult());
        result.setEditable(false);

        //총 보유중인 단어 갯수 레이블 생성
        JLabel wordsCount = new JLabel("단어 갯수:" + fileManager.getWordsCount());
        
        //메인 패널 생성
        JPanel panel = new JPanel();
        panel.add(WordManagerButton);
        panel.add(WordTestButton);
        panel.add(WordMemoryTestButton);
        
        add(panel, BorderLayout.NORTH);
        add(result, BorderLayout.CENTER);
        add(wordsCount, BorderLayout.SOUTH);
        
        setTitle("영단어 암기 프로그램");
        setSize(380, 280);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new WordMainGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == WordManagerButton) { //WordManagerButton 작동시 단어 관리페이지 오픈
            new WordManager(fileManager);
        }
        else if (e.getSource() == WordTestButton) { //WordTestButton 작동시 낱말 카드 오픈
            new WordTest(fileManager);
        }
        else if (e.getSource() == WordMemoryTestButton) { //WordMemoryTestButton 작동시 단어 시험페이지 오픈
            new WordMemoryTest(fileManager);
        }
    }
}