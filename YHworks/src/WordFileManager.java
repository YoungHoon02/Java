import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordFileManager {
    private static final String FILE_PATH = "words.txt";

    //파일에서 데이터를 개방
    public List<Word> loadWords() {
        List<Word> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                //enWord,krMeaning,pushDate,checkDate 데이터 형식을 ,단위로 split
                String[] node = line.split(",");
                if (node.length == 4) {
                    String enWord = node[0];
                    String krMeaning = node[1];
                    String pushDate = node[2];
                    String checkDate = node[3];
                    words.add(new Word(enWord, krMeaning, pushDate, checkDate));
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    //데이터를 파일에 저장
    public void saveWords(List<Word> words) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            for (Word word : words) {
                writer.println(word.toString());
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}