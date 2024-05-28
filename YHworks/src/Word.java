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

    //get, set 구현
    public String getEnWord() {
        return enWord;
    }

    public String getKrMeaning() {
        return krMeaning;
    }

    public String getPushDate() {
        return pushDate;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setKrMeaning(String krMeaning) {
        this.krMeaning = krMeaning;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    @Override
    public String toString() { //CSV형식과 비슷하게 반환(저장하기 편하게)
        return enWord + "," + krMeaning + "," + pushDate + "," + checkDate;
    }
}