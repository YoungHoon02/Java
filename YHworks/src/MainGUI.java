import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame implements ActionListener{
    
    private JButton WordManagerButton;
    private JButton WordTestButton;
    private JTextArea result;
    private WordFileManager fileManager;
    
    public MainGUI() {
        
        fileManager = new WordFileManager();

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
            new WordManager(fileManager);
        }
    }
}