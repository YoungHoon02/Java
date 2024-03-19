import java.util.Scanner;

public class MedianFive {
    
    public static void main(String[] args) {
        
        int[] num;
        num = new int[5];

        Scanner input = new Scanner(System.in);

        for(int i=0; i<num.length; i++) {

            System.out.print((i+1)+" 번째 숫자를 입력하시오: ");
            num[i] = input.nextInt();
            System.out.println();
        }

        //Arrays.sort(num); Arrays 라이브러리를 사용해서 순차적 정렬 가능

        //버블정렬
        for(int a=0; a<num.length-1; a++) {
            for(int b=0; b<num.length-1; b++) {

                if(num[b] > num[b+1]) {
                    int temp = num[b];
                    num[b] = num[b+1];
                    num[b+1] = temp;
                }
            }
        }

        //배열이 순차적으로 정렬 되었으므로 가운대에 위치한 배열 호출 
        System.out.println(num[2]);

    }
}
