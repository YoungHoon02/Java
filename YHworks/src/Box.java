public class Box {
    
    private int width;
    private int length;
    private int height;

    public Box(int wid, int len, int hei) {

        width = wid;
        length = len;
        height = hei;
    }


    public boolean isSameBox(Box obj) {

        if(width == obj.width || length == obj.length || height == obj.height)
            return true;
        else
            return false;
    }
}
