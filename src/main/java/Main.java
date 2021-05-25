import kr.co.intteam.discord.botLib.ChatBotConnect;
import kr.co.intteam.discord.botLib.ChatBotRunThread;
import kr.co.intteam.discord.botLib.resources.Channel;
import kr.co.intteam.discord.botLib.resources.Guild;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Channel c = new Channel();
        Scanner scanner = new Scanner(System.in);
        test(scanner.nextLine());
    }

    private static void test(String token){
        final String[] prefix = {"테스트", "test"};
        ChatBotRunThread con = new ChatBotRunThread(token, prefix);
        con.start();
        try {
            System.in.read();
        } catch (IOException e){
            System.out.println(e.toString());
        }
    }
}