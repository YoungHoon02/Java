import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//단어 GUI
public class WordManager extends JFrame implements ActionListener {
    private JTextField enWordField; //영단어 입력 필드
    private JTextField krMeaningField; //한글 뜻 입력 필드
    private JTextField pushDateField; //저장한 날짜 입력 필드
    private JButton addButton; //추가 버튼
    private JButton deleteButton; //삭제 버튼
    private JButton updateButton; //수정 버튼
    private JButton loadButton; //불러오기 버튼
    private JList<String> wordList; //단어장 리스트
    private DefaultListModel<String> wordListData; //단어장을 불러오는 리스트 모델(리스트 내용을 추가/수정/삭제)
    private List<Word> words; //단어 리스트
    private WordFileManager fileManager; //파일 관리 객체

    public WordManager(WordFileManager fileManager) {
        this.fileManager = fileManager;
        words = new ArrayList<>();

        JPanel panel = new JPanel(new BorderLayout()); //패널
        JPanel inputPanel = new JPanel(new GridLayout(3, 2)); //입력부
        JPanel buttonPanel = new JPanel(new FlowLayout()); //버튼부

        //영단어 입력 레이블 및 필드 생성
        JLabel enWordLabel = new JLabel("영단어: ");
        enWordField = new JTextField(25);
        inputPanel.add(enWordLabel);
        inputPanel.add(enWordField);

        //한글뜻 입력 레이블 및 필드 생성
        JLabel krMeaningLabel = new JLabel("뜻: ");
        krMeaningField = new JTextField(12);
        inputPanel.add(krMeaningLabel);
        inputPanel.add(krMeaningField);

        //단어 등록일 입력 레이블 및 필드 생성
        JLabel pushDateLabel = new JLabel("등록일: ");
        pushDateField = new JTextField(10);
        pushDateField.setText(getCurrentDate()); //현재 날짜로 지정
        pushDateField.setEditable(false); //수정 불가능한 항목
        inputPanel.add(pushDateLabel);
        inputPanel.add(pushDateField);

        //추가 버튼 생성
        addButton = new JButton("추가");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        //삭제 버튼 생성
        deleteButton = new JButton("삭제");
        deleteButton.addActionListener(this);
        buttonPanel.add(deleteButton);

        //수정 버튼 생성
        updateButton = new JButton("수정");
        updateButton.addActionListener(this);
        buttonPanel.add(updateButton);

        //불러오기 버튼 생성
        loadButton = new JButton("불러오기");
        loadButton.addActionListener(this);
        buttonPanel.add(loadButton);

        //단어장 리스트 생성
        wordListData = new DefaultListModel<>();
        wordList = new JList<>(wordListData);
        JScrollPane listScrollPane = new JScrollPane(wordList);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(listScrollPane, BorderLayout.SOUTH);

        this.add(panel);

        fileManager.loadWords();
        setTitle("단어 관리");
        setSize(500, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) { //추가 버튼 클릭
            addWord();
        } else if (e.getSource() == deleteButton) { //제거 버튼 클릭
            deleteWord();
        } else if (e.getSource() == updateButton) { //수정 버튼 클릭
            updateWord();
        } else if (e.getSource() == loadButton) { //불러오기 버튼 클릭
            loadWordsFromFile();
        }
    }

    //단어를 생성하는 메소드
    private void addWord() {
        String enWord = enWordField.getText();
        String krMeaning = krMeaningField.getText();
        String pushDate = pushDateField.getText();
        String checkDate = ""; //초기 확인일은 공백

        Word word = new Word(enWord, krMeaning, pushDate, checkDate);
        words.add(word);
        fileManager.saveWords(words);
        refreshWordList(); //단어 리스트 갱신

        //입력 필드 초기화
        enWordField.setText("");
        krMeaningField.setText("");
    }

    //단어를 삭제하는 메소드
    private void deleteWord() {
        String selectedWord = enWordField.getText();
        words.removeIf(word -> word.getEnWord().equals(selectedWord));

        fileManager.saveWords(words);
        refreshWordList(); //단어 리스트 갱신

        enWordField.setText("");
        krMeaningField.setText("");
    }

    //단어를 수정하는 메소드
    private void updateWord() {
        //사용자가 입력한 텍스트필드에 영단어,한글뜻을 읽어옴
        String selectedWord = enWordField.getText();
        String newMeaning = krMeaningField.getText();
        for (Word word : words) {
            if (word.getEnWord().equals(selectedWord)) {
                word.setKrMeaning(newMeaning);
                fileManager.saveWords(words);
                refreshWordList(); //단어 리스트 갱신
                break;
            }
        }
    }

    //단어 리스트를 갱신하는 메소드
    private void refreshWordList() {
        wordListData.clear(); 
        for (Word word : words) { 
            wordListData.addElement(word.toString());
        }
    }

    //현재 날짜를 반환하는 메소드
    private String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDate.format(formatter);
    }

    //csv파일 내부에서 단어 가져오는 메소드
    private void loadWordsFromFile() {
        words.clear();
        List<Word> loadedWords = fileManager.loadWords();
        if (loadedWords != null) { //파일이 공백이 아닌지 검사
            for (Word word : loadedWords) {
                if (word != null) { //단어가 공백이 아닌지 검사
                    words.add(word); 
                }
            }
        }
        refreshWordList(); //단어 리스트 갱신
    }

    //테스트용 메소드
    public static void main(String[] args) {
        WordFileManager fileManager = new WordFileManager();
        new WordManager(fileManager);
    }
}