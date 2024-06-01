import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//데이터(단어)가 파일과 상호작용하는 클래스
public class WordFileManager {
    private static final String FILE_PATH = "words.csv"; //상수 선언(단어장)

    //파일에서 데이터를 개방
    public List<Word> loadWords() {
    List<Word> words = new ArrayList<>();
    try {
        Scanner scanner = new Scanner(new File(FILE_PATH));
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
        e.printStackTrace();
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
        //예기치 못한 상황에 null 대신 공백반환
        return new Word("", "", "", "");
    }

    //데이터를 파일에 저장
    public void saveWords(List<Word> words) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, false))) {
            for (Word word : words) {
                writer.println(word.toString());
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    //단어 시험 결과 불러오기
    public String loadTestResult() {
        String result = "";
        try (Scanner scanner = new Scanner(new File("testResult.csv"))) {
            while (scanner.hasNextLine()) {
                result = scanner.nextLine();
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

}