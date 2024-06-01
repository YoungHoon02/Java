import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

// 영어 단어 암기 테스트 GUI
public class WordMemoryTest extends JFrame implements ActionListener {
    private JTextField[] Meanings;
    private JButton Button;
    private Word[] RandomWords;
    private WordFileManager fileManager;
    private List<Word> words;
    private int questsCount = 10; //문제 갯수 입력

    public WordMemoryTest(WordFileManager fileManager) {
        this.fileManager = fileManager;
        this.words = fileManager.loadWords();

        //문제 갯수 입력
        String input = JOptionPane.showInputDialog(this, "문제 수", "10");
        if (!input.isEmpty()) {
            questsCount = Integer.parseInt(input);
        }

        //입력받은 단어보다 데이터가 적을때 종료
        if (questsCount > words.size()) {
            JOptionPane.showMessageDialog(this, "단어수 부족으로 인해 종료");

            dispose();
            return;
        }

        List<String> addedWords = new ArrayList<>();

        JPanel panel = new JPanel();

        JPanel panel1 = new JPanel();
        panel.add(panel1);
        JPanel panel2 = new JPanel();
        panel.add(panel2);
        JPanel panel3 = new JPanel();
        panel.add(panel3);

        Meanings = new JTextField[questsCount];
        RandomWords = new Word[questsCount];

        for (int i = 0; i < questsCount; i++) {
            JPanel wordPanel = new JPanel();

            RandomWords[i] = getRandomWord();

            //동일한 영어가 있으면 제외
            while (addedWords.contains(RandomWords[i].getEnWord())) {
                RandomWords[i] = getRandomWord();
            }
            addedWords.add(RandomWords[i].getEnWord());

            //panel1
            JLabel label1 = new JLabel(RandomWords[i].getEnWord()); //여기서 RandomWord에 무작위 Word 데이터를 불러옴

            label1.setHorizontalAlignment(JLabel.CENTER);
            wordPanel.add(label1);

            //panel2
            JLabel label2 = new JLabel("뜻: ");
            Meanings[i] = new JTextField(12);
            wordPanel.add(label2);
            wordPanel.add(Meanings[i]);

            panel.add(wordPanel);
        }

        //panel3(Button)
        Button = new JButton("제출");
        Button.addActionListener(this);
        panel3.add(Button);

        this.add(panel, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.SOUTH);

        setTitle("영어 단어 암기 테스트");
        setSize(420, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Button) {
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
        int passCount = 0; //정답 갯수
        int failCount = 0; //오답 갯수

        //리스트를 전부 순회
        for (int i = 0; i < questsCount; i++) {
            String pushMeaning = Meanings[i].getText();
            boolean correctTrigger = false; //정답 유무 트리거

            for (Word word : words) {
                if (word.getEnWord().equals(RandomWords[i].getEnWord()) && pushMeaning.equals(word.getKrMeaning())) {
                    correctTrigger = true;
                    break;
                }
            }

            if (correctTrigger == true) {
                JOptionPane.showMessageDialog(this, (RandomWords[i].getEnWord()) + "는 정답입니다.");
                passCount++;
                updateLastDate(RandomWords[i]);
            } 
            else {
                JOptionPane.showMessageDialog(this, (RandomWords[i].getEnWord()) + "는 틀렸습니다.");
                failCount++;
            }
        }

        fileManager.saveTestResult(getCurrentDate(), questsCount, passCount, failCount);
        dispose();
    }

    //정답맞춘 날짜 갱신
    private void updateLastDate(Word word) {
        word.setCheckDate(getCurrentDate());
        fileManager.saveWords(words);
    }

    private String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDate.format(formatter);
    }

    public static void main(String[] args) {
        WordFileManager fileManager = new WordFileManager();
        new WordMemoryTest(fileManager);
    }
}