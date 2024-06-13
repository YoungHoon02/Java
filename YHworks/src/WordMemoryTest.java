import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

// 영어 단어 암기 테스트 GUI
public class WordMemoryTest extends JFrame implements ActionListener {
    private JTextField[] Meanings; //한글뜻 정답 입력 필드의 배열
    private JButton DoneButton; //제출하기 버튼
    private Word[] RandomWords; //랜덤으로 단어 선택하는 배열
    private WordFileManager fileManager; //파일 관리 객체
    private List<Word> words; //단어 리스트
    private int questsCount = 10; //문제 갯수 (10이 기본값)

    public WordMemoryTest(WordFileManager fileManager) {
        this.fileManager = fileManager;
        this.words = fileManager.loadWords();

        //문제 갯수 입력 다이얼로그
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

        //문제 갯수만큼 랜덤 단어 뽑기 및 시험창에 띄움
        for (int i = 0; i < questsCount; i++) {
            JPanel wordPanel = new JPanel();

            RandomWords[i] = getRandomWord();

            //addedWords 스택에 들어오는 RandomWords 영단어의 중복을 방지
            while (addedWords.contains(RandomWords[i].getEnWord())) {
                RandomWords[i] = getRandomWord();
            }
            addedWords.add(RandomWords[i].getEnWord());

            //단어를 표시하는 패널 생성
            JLabel label1 = new JLabel(RandomWords[i].getEnWord()); //여기서 RandomWord에 무작위 Word 데이터를 불러옴

            label1.setHorizontalAlignment(JLabel.CENTER);
            wordPanel.add(label1);

            //답지 패널 생성
            JLabel label2 = new JLabel("뜻: ");
            Meanings[i] = new JTextField(12);
            wordPanel.add(label2);
            wordPanel.add(Meanings[i]);

            panel.add(wordPanel);
        }

        //제출 버튼 생성
        DoneButton = new JButton("제출");
        DoneButton.addActionListener(this);
        panel3.add(DoneButton);

        this.add(panel, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.SOUTH);

        setTitle("영어 단어 암기 테스트");
        setSize(420, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == DoneButton) {
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

    //정답맞춘 날짜 갱신하는 메소드
    private void updateLastDate(Word word) {
        word.setCheckDate(getCurrentDate());
        fileManager.saveWords(words);
    }

    //현재 날짜를 반환하는 메소드
    private String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDate.format(formatter);
    }

    //테스트용 메소드
    public static void main(String[] args) {
        WordFileManager fileManager = new WordFileManager();
        new WordMemoryTest(fileManager);
    }
}