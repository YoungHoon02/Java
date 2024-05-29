import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WordManager extends JFrame implements ActionListener {
    private JTextField enWordField;
    private JTextField krMeaningField;
    private JTextField pushDateField;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton loadButton;
    private JList<String> wordList;
    private DefaultListModel<String> listModel;
    private List<Word> words;

    private WordFileManager fileManager;

    public WordManager(WordFileManager fileManager) {
        this.fileManager = fileManager;
        words = new ArrayList<>();

        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(3, 2)); //입력부
        JPanel buttonPanel = new JPanel(new FlowLayout()); //버튼부

        //입력 필드
        JLabel enWordLabel = new JLabel("영단어: ");
        enWordField = new JTextField(25);
        inputPanel.add(enWordLabel);
        inputPanel.add(enWordField);

        JLabel krMeaningLabel = new JLabel("뜻: ");
        krMeaningField = new JTextField(12);
        inputPanel.add(krMeaningLabel);
        inputPanel.add(krMeaningField);

        JLabel pushDateLabel = new JLabel("등록일: ");
        pushDateField = new JTextField(10);
        pushDateField.setText(getCurrentDate()); //현재 날짜로 지정
        pushDateField.setEditable(false); //수정 불가능한 항목
        inputPanel.add(pushDateLabel);
        inputPanel.add(pushDateField);

        //버튼들
        addButton = new JButton("추가");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        deleteButton = new JButton("삭제");
        deleteButton.addActionListener(this);
        buttonPanel.add(deleteButton);

        updateButton = new JButton("수정");
        updateButton.addActionListener(this);
        buttonPanel.add(updateButton);

        loadButton = new JButton("불러오기");
        loadButton.addActionListener(this);
        buttonPanel.add(loadButton);

        //단어 리스트
        listModel = new DefaultListModel<>();
        wordList = new JList<>(listModel);
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
        if (e.getSource() == addButton) {
            addWord();
        } else if (e.getSource() == deleteButton) {
            deleteWord();
        } else if (e.getSource() == updateButton) {
            updateWord();
        } else if (e.getSource() == loadButton) {
            loadWordsFromFile();
        }
    }

    private void addWord() {
        String enWord = enWordField.getText();
        String krMeaning = krMeaningField.getText();
        String pushDate = pushDateField.getText();
        String checkDate = ""; //초기 확인일은 공백

        Word word = new Word(enWord, krMeaning, pushDate, checkDate);
        words.add(word);
        fileManager.saveWords(words);
        refreshWordList();

        //입력 필드 초기화
        enWordField.setText("");
        krMeaningField.setText("");
    }

    private void deleteWord() {
        String selectedWord = enWordField.getText();
        words.removeIf(word -> word.getEnWord().equals(selectedWord));

        fileManager.saveWords(words);
        refreshWordList();

        enWordField.setText("");
        krMeaningField.setText("");
    }

    private void updateWord() {
        String selectedWord = enWordField.getText();
        String newMeaning = krMeaningField.getText();
        for (Word word : words) {
            if (word.getEnWord().equals(selectedWord)) {
                word.setKrMeaning(newMeaning);
                fileManager.saveWords(words);
                refreshWordList();
                break;
            }
        }
    }

    private void refreshWordList() {
        listModel.clear();
        for (Word word : words) {
            listModel.addElement(word.toString());
        }
    }

    private String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDate.format(formatter);
    }

    private void loadWordsFromFile() {
        words.clear(); //리스트 비움
        List<Word> loadedWords = fileManager.loadWords();
        if (loadedWords != null) { //파일이 공백이 아닌지 검사
            for (Word word : loadedWords) {
                if (word != null) { //단어가 공백이 아닌지 검사
                    words.add(word); 
                }
            }
        }
        refreshWordList(); //갱신
    }

    public static void main(String[] args) {
        WordFileManager fileManager = new WordFileManager();
        new WordManager(fileManager);
    }
}