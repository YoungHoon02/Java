import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordTest extends JFrame {
    private JTextField Meaning;
    private JTextField lastDate;
    private JButton Button;

    public WordTest() {
        JPanel panel = new JPanel();

        JPanel panel1 = new JPanel();
        panel.add(panel1);
        JPanel panel2 = new JPanel();
        panel.add(panel2);
        JPanel panel3 = new JPanel();
        panel.add(panel3);


        //panel1
        JLabel label1 = new JLabel("영단어: Word"); //여기서 Word에 Word데이터를 불러옴
        panel1.add(label1);


        //panel2
        JLabel label2 = new JLabel("뜻: ");
        Meaning = new JTextField(12);
        panel2.add(label2);
        panel2.add(Meaning);

        //panel3(Button)
        Button = new JButton("제출");
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if (데이터 기준) 영단어의 Word == 사용자가 입력한 뜻, 참이면 해당 데이터의 lastDate를 오늘 날짜로 갱신
            }
        });
        panel3.add(Button);

        this.add(panel);

        setTitle("낱말 카드");
        setSize(420, 160);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}