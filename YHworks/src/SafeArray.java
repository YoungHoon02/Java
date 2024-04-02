public class SafeArray {
    
    private int a[];
    public int length;
    public SafeArray(int size) {

        a = new int[size];
        length = size;
    }

    public void put(int index, int value) {

        if(index < length)
            a[index] = value;
        else
            System.out.println("잘못된 인덱스" + index);
    }

    public int get(int index) {

        if(index < length)
            return a[index];
        else
            return 0;
    }
}
