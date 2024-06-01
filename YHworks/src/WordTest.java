import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

//무작위 단어 카드 GUI
public class WordTest extends JFrame implements ActionListener{
    private JTextField Meaning;
    private JButton Button;
    private Word RandomWord;
    private WordFileManager fileManager;
    private List<Word> words;

    public WordTest(WordFileManager fileManager) {
        this.fileManager = fileManager;
        this.words = fileManager.loadWords();

        JPanel panel = new JPanel();

        JPanel panel1 = new JPanel();
        panel.add(panel1);
        JPanel panel2 = new JPanel();
        panel.add(panel2);
        JPanel panel3 = new JPanel();
        panel.add(panel3);

        RandomWord = getRandomWord();

        //panel1
        JLabel label1 = new JLabel("영단어: "+ RandomWord.getEnWord()); //여기서 RandomWord에 무작위Word데이터를 불러옴
        panel1.add(label1);


        //panel2
        JLabel label2 = new JLabel("뜻: ");
        Meaning = new JTextField(12);
        panel2.add(label2);
        panel2.add(Meaning);

        //panel3(Button)
        Button = new JButton("제출");
        Button.addActionListener(this);
        panel3.add(Button);

        this.add(panel);

        setTitle("낱말 카드");
        setSize(420, 160);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Button) {
            checkAnswer();
        }
    }

    //무작위 단어 선택
    private Word getRandomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    //단어 검사기
    private void checkAnswer() {
        String pushMeaning = Meaning.getText();
        boolean correctTrigger = false; //정답 유무 트리거

        //리스트를 전부 순회
        for (Word word : words) {
            if (word.getEnWord().equals(RandomWord.getEnWord()) && pushMeaning.equals(word.getKrMeaning())) {
                correctTrigger = true;
            }
        }
    
        if (correctTrigger == true) {
            JOptionPane.showMessageDialog(this, "정답입니다.");

            //다시 리스트를 순회해 EnWord가 전부 정답처리되어 날짜가 갱신됨
            for (Word word : words) {
                if (word.getEnWord().equals(RandomWord.getEnWord())) {
                    updateLastDate(word);
                }
            }
        } 
        else {
            JOptionPane.showMessageDialog(this, "틀렸습니다.");
        }
    
        dispose();
    }

    //정답맞춘 날짜 갱신
    private void updateLastDate(Word word) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        word.setCheckDate(currentDate.format(formatter));
        fileManager.saveWords(words);
    }

    public static void main(String[] args) {
        WordFileManager fileManager = new WordFileManager();
        new WordTest(fileManager);
    }
}