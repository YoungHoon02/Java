public class MyCounterTest {
    
    public static void main(String[] args) {
        
        MyCounter obj = new MyCounter();
        MyCounter obj2 = new MyCounter();

        //기초형 변수, 참조형 변수

        obj.value = 10;
        obj2.inc(obj);

        System.out.println("x="+obj.value);
    }
}
