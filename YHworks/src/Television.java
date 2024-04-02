public class Television {

    private int channel; //변수 앞에 기본적으로 참조가능한 public이 붙음
    private int volume; //c언어의 static기능을 하는것이 private
    private boolean onOff;

    //오버로딩
    public Television() {

        /*channel = c;
        volume = v;
        onOff = o; */
        this(1,1,false);
    }

    public Television(int c) {

        this(c,1,false);
    }

    public Television(int c, int v) {

        this(c,v,false);
    }

    //==========================================

    //생성자 코드 추가 (int c, int v, boolean o)
    public Television(int c, int v, boolean o) {

        this.channel = c;
        this.volume = v;
        onOff = o;
    }

    void print() {

        System.out.println("채널은 "+channel+"이고 볼륨은 "+volume+"입니다.");
    }

    int getChannel() {

        return channel;
    }

    void setChannel(int newChannel) {

        if(newChannel < 1)
            newChannel = 7;
        
        channel = newChannel;
    }
}

