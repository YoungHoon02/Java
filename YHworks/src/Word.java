public class Word {
    private String enWord; //영단어
    private String krMeaning; //한글뜻
    private String pushDate; //추가한날짜
    private String checkDate; //맞춘날짜

    public Word(String enWord, String krMeaning, String pushDate, String checkDate) {
        this.enWord = enWord;
        this.krMeaning = krMeaning;
        this.pushDate = pushDate;
        this.checkDate = checkDate;
    }

    //단어 getter
    public String getEnWord() {
        return enWord;
    }

    //뜻 getter
    public String getKrMeaning() {
        return krMeaning;
    }

    //단어 추가 날짜 getter
    public String getPushDate() {
        return pushDate;
    }

    //단어 맞춘 날짜 getter
    public String getCheckDate() {
        return checkDate;
    }

    //뜻 setter
    public void setKrMeaning(String krMeaning) {
        this.krMeaning = krMeaning;
    }

    //날짜 setter
    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    @Override
    public String toString() { //CSV형식
        return enWord + "," + krMeaning + "," + pushDate + "," + checkDate;
    }
}