public class Television {

    private int channel; //변수 앞에 기본적으로 참조가능한 public이 붙음
    public int volume; //c언어의 static기능을 하는것이 private
    public boolean onOff;

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

