import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

//데이터(단어)가 파일과 상호작용하는 클래스
public class WordFileManager {
    private static final String WORDS_FILE = "words.csv"; //상수 선언(단어장)

    //파일에서 데이터를 개방
    public List<Word> loadWords() {
    List<Word> words = new ArrayList<>();
    try {
        Scanner scanner = new Scanner(new File(WORDS_FILE));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Word word = createWords(line);

            if (word != null) {
                words.add(word);
            }
        }
        scanner.close();
    } 
    catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null, WORDS_FILE + "파일이 없습니다. 데이터를 추가하세요.", "에러", JOptionPane.ERROR_MESSAGE);
    }
    return words;
}

    //데이터 생성함수
    private Word createWords(String line) {
        String[] node = line.split(",");
        if (node.length >= 3) {
            String enWord = node[0];
            String krMeaning = node[1];
            String pushDate = node[2];
            String checkDate = (node.length > 3) ? node[3] : ""; //공백일경우 ""처리
            
            return new Word(enWord, krMeaning, pushDate, checkDate);
        }
        //예기치 못한 상황에 null 대신 공백으로 저장
        return new Word("", "", "", "");
    }

    //데이터를 파일에 저장
    public void saveWords(List<Word> words) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(WORDS_FILE, false))) {
            for (Word word : words) {
                writer.println(word.toString());
            }
        } 
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, WORDS_FILE + "에 데이터를 추가하는데 실패했습니다. 양식이 맞는지 확인해주세요.", "에러", JOptionPane.ERROR_MESSAGE);
        }
    }

    //총 단어의 갯수
    public int getWordsCount() {
        return loadWords().size();
    }

    //단어 시험 결과 저장
    public void saveTestResult(String currentDate, int questsCount, int passCount, int failCount) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("testResult.csv", true))) {
            writer.println("응시날짜: " + currentDate + "," + "문항 수: " + questsCount + "," + "정답 수: " + passCount + "," + "오답 수: " + failCount);
        } 
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "시험 결과 정보를 저장하는데에 실패했습니다.", "에러", JOptionPane.ERROR_MESSAGE);
        }
    }

    //단어 시험 결과 불러오기
    public String loadTestResult() {
    String result = "";
    try {
        result = Files.readString(Paths.get("testResult.csv"));
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "시험 결과 정보를 불러오는데에 실패했습니다.", "에러", JOptionPane.ERROR_MESSAGE);
    }
    return result;
}

}