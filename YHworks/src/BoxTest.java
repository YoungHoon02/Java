public class BoxTest {
    
        public static void main(String[] args) {
            
            Box obj1 = new Box(10,20,50);
            Box obj2 = new Box(10,20,50);

            //obj1.isSameBox() 함수의 obj2는 obj1의 Box Class내의 isSameBox에 객체 참조 변수가 된다
            System.out.println("obj1 == obj2 : " + obj1.isSameBox(obj2));
        }
}
