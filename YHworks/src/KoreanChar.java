public class KoreanChar {
    
    public static void main(String[] args) {
        
        char front = '가';
        char back = '힣';

        int headchar = -1; //아무것도 출력하지 않은 상태로 초기화

        do {

            //초성 19개, 중성 21개, 종성 28개. temp의 역할은 초성탐지이므로 21*28
            int temp = (front - '가') / (21 * 28); //문자 초성을 탐지. 가 = 0

            //'나' 가 시작될 경우 '가'에서 21*28만큼 차이나기 때문에 초성이 바뀔 때 temp의 몫이 생기게 되어 값이 변함
            if(temp != headchar) {
                if(headchar != -1) //-1 즉슨 '가' 시작 이전에 구분선을 출력할 필요가 없다
                    System.out.println("--...--");
                
                headchar = temp; //temp 값을 넣어줘 초성이 바뀐걸 저장해준다
            }
            
            System.out.println(front);
            front++;
            
        } while (front <= back); //힣까지 출력할 동안 반복
    }
}
