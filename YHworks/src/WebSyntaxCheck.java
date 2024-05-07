import java.util.Scanner;

public class WebSyntaxCheck {
    
    public static void main(String[] args) {

        String webString = "www";
        String syntax;

        //Scanner->클래스, input->변수, new->객체생성
        Scanner input = new Scanner(System.in);
        
        while(true) {

            syntax = input.nextLine();

            //.equals로 c의 strcat과 같은 맥락
            if(syntax.equals("quit"))
                break;

            if(syntax.length() >= 3) {

                //.substring으로 문자열의 시작, 끝 인덱스와 equals로 '부분'일치하는지 비교
                if(syntax.substring(0,3).equals(webString))
                    System.out.println("www로 시작합니다.");

                else
                    System.out.println("www와는 다른 구문입니다.");
            }
            else
                System.out.println("www와는 다른 구문입니다.");
        }
    }
}
