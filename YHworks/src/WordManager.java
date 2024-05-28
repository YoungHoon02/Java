import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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
    private static final String FILE_PATH = "words.txt";

    private WordFileManager fileManager;

    public WordManager(WordFileManager fileManager) {
        this.fileManager = fileManager;
        words = new ArrayList<>();

        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(3, 2)); //입력부
        JPanel buttonPanel = new JPanel(new FlowLayout()); //버튼부

        // 입력 필드
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

        // 버튼들
        addButton = new JButton("추가");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        deleteButton = new JButton("삭제");
        deleteButton.addActionListener(this);
        buttonPanel.add(deleteButton);

        updateButton = new JButton("수정");
        updateButton.addActionListener(this);
        buttonPanel.add(updateButton);

        loadButton = new JButton("보기");
        loadButton.addActionListener(this);
        buttonPanel.add(loadButton);

        // 단어 리스트
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

        refreshWordList();
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
        String checkDate = ""; //초기 확인일은 빈 문자열로 설정

        Word word = new Word(enWord, krMeaning, pushDate, checkDate);
        words.add(word);
        saveWords();
        refreshWordList();

        //입력 필드 초기화
        enWordField.setText("");
        krMeaningField.setText("");
    }

    private void deleteWord() {
        String selectedWord = enWordField.getText();
        words.removeIf(word -> word.getEnWord().equals(selectedWord));

        saveWords();
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
                saveWords();
                refreshWordList();
                break;
            }
        }
    }

    private void saveWords() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Word word : words) {
                writer.println(word.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
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
        List<Word> loadedWords = fileManager.loadWords();
        words.addAll(loadedWords); // 기존 단어 리스트에 새로운 단어들을 추가
    
        // 입력한 영단어를 가져와서 해당하는 단어를 찾음
        String inputWord = enWordField.getText();
        for (Word word : words) {
            if (word.getEnWord().equals(inputWord)) {
                // 해당 단어의 뜻을 텍스트 필드로 설정
                krMeaningField.setText(word.getKrMeaning());
                break; // 단어를 찾았으므로 더 이상 반복할 필요가 없음
            }
        }
    
        refreshWordList(); // 단어 리스트 갱신
    }

    public static void main(String[] args) {
        WordFileManager fileManager = new WordFileManager();
        new WordManager(fileManager);
    }
}