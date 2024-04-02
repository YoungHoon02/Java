public class SafeArrayTest {
    
    public static void main(String[] args) {
            
        SafeArray array = new SafeArray(3);

        for(int i=0; i < (array.length + 1); i++) { //.length + x 할때 x번 반복 인덱스 출력

            array.put(i, i*10);
        }
    }
}
