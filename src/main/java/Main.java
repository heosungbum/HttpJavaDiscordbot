import kr.co.intteam.discord.botLib.ChatBotConnect;
import kr.co.intteam.discord.botLib.ChatBotRunThread;
import kr.co.intteam.discord.botLib.resources.Channel;
import kr.co.intteam.discord.botLib.resources.Guild;

import java.io.IOException;

public class Main {
    public static void main(String args[]){
        Channel c = new Channel();
        final String[] prefix = {"테스트", "test"};
        ChatBotRunThread con = new ChatBotRunThread("NzM4NzIwODkzNTIxMzYzMDA2.XyQBcQ.FnIBIAqJHlBcm5ToAmTm5m14nyg", prefix);
        con.start();
        try {
            System.in.read();
        } catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
