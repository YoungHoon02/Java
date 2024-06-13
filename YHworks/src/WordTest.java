import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

//무작위 단어 카드 GUI
public class WordTest extends JFrame implements ActionListener{
    private JTextField Meaning; //한글뜻 입력 필드
    private JButton DoneButton; //제출하기 버튼
    private Word RandomWord; //랜덤으로 단어 선택하는 객체
    private WordFileManager fileManager; //파일 관리 객체
    private List<Word> words; //단어 리스트

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

        //단어 패널 생성
        JLabel label1 = new JLabel("영단어: "+ RandomWord.getEnWord());
        panel1.add(label1);


        //한글뜻 패널 생성
        JLabel label2 = new JLabel("뜻: ");
        Meaning = new JTextField(12);
        panel2.add(label2);
        panel2.add(Meaning);

        //제출 버튼 생성
        DoneButton = new JButton("제출");
        DoneButton.addActionListener(this);
        panel3.add(DoneButton);

        this.add(panel);

        setTitle("낱말 카드");
        setSize(420, 160);
        setResizable(false); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == DoneButton) {
            checkAnswer();
        }
    }

    //무작위 단어 선택
    private Word getRandomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    //정답을 확인하는 메소드
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

    //정답맞춘 날짜 갱신하는 메소드
    private void updateLastDate(Word word) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        word.setCheckDate(currentDate.format(formatter));
        fileManager.saveWords(words);
    }

    //테스트용 메소드
    public static void main(String[] args) {
        WordFileManager fileManager = new WordFileManager();
        new WordTest(fileManager);
    }
}