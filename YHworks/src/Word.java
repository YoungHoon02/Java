public class Word {
    private String enWord; //영단어
    private String krMeaning; //한글뜻
    private String pushDate; //추가한날짜
    private String checkDate; //맞춘날짜

    //단어 Word 객체 생성자
    public Word(String enWord, String krMeaning, String pushDate, String checkDate) {
        this.enWord = enWord;
        this.krMeaning = krMeaning;
        this.pushDate = pushDate;
        this.checkDate = checkDate;
    }

    //영어 단어를 반환
    public String getEnWord() {
        return enWord;
    }

    //한글 뜻을 반환
    public String getKrMeaning() {
        return krMeaning;
    }

    //단어 추가한 날짜 반환
    public String getPushDate() {
        return pushDate;
    }

    //단어 마지막으로 맞춘 날짜 반환
    public String getCheckDate() {
        return checkDate;
    }

    //한글 뜻을 설정
    public void setKrMeaning(String krMeaning) {
        this.krMeaning = krMeaning;
    }

    //날짜를 설정
    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    @Override
    public String toString() { //CSV형식
        return enWord + "," + krMeaning + "," + pushDate + "," + checkDate;
    }
}