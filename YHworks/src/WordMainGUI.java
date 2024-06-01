import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//단어장의 기본 메인페이지 역할 GUI
public class WordMainGUI extends JFrame implements ActionListener{
    
    private JButton WordManagerButton;
    private JButton WordTestButton;
    private JButton WordMemoryTestButton;
    private JTextArea result;
    private WordFileManager fileManager;
    
    public WordMainGUI() {
        
        fileManager = new WordFileManager();

        //WordManagerButton
        WordManagerButton = new JButton("단어 관리");
        WordManagerButton.addActionListener(this);
        
        //WordTestButton
        WordTestButton = new JButton("낱말 카드");
        WordTestButton.addActionListener(this);

        //WordMemoryTestButton
        WordMemoryTestButton = new JButton("단어 암기");
        WordMemoryTestButton.addActionListener(this);
        
        //최근 결과 areafield
        result = new JTextArea();
        result.setText(fileManager.loadTestResult());
        result.setEditable(false);

        //단어 갯수 field
        JLabel wordsCount = new JLabel("단어 갯수:" + fileManager.getWordsCount());
        
        //main panel
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
        else if (e.getSource() == WordTestButton) {
            new WordTest(fileManager);
        }
        else if (e.getSource() == WordMemoryTestButton) {
            new WordMemoryTest(fileManager);
        }
    }
}