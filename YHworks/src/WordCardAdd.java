import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCardAdd extends JFrame {
    private JTextField Word;
    private JTextField Meaning;
    private JTextField lastDate;
    private JButton AddButton;

    public WordCardAdd() {
        JPanel panel = new JPanel();

        JPanel panel1 = new JPanel();
        panel.add(panel1);
        JPanel panel2 = new JPanel();
        panel.add(panel2);
        JPanel panel3 = new JPanel();
        panel.add(panel3);


        //panel1
        JLabel label1 = new JLabel("영단어: ");
        Word = new JTextField(25);
        panel1.add(label1);
        panel1.add(Word);

        //panel2
        JLabel label2 = new JLabel("뜻: ");
        Meaning = new JTextField(12);
        panel2.add(label2);
        panel2.add(Meaning);

        JLabel label3 = new JLabel("등록일: ");
        lastDate = new JTextField(10);
        panel2.add(label3);
        panel2.add(lastDate);

        //panel3(Button)
        AddButton = new JButton("추가");
        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 단어 추가 코드를 여기에 작성하세요.
            }
        });
        panel3.add(AddButton);

        this.add(panel);

        setTitle("낱말 카드 생성");
        setSize(420, 160);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}