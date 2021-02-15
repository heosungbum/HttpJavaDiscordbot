package kr.co.intteam.discord.botLib;

import kr.co.intteam.discord.botLib.resources.DiscordMessage;
import kr.co.intteam.discord.botLib.resources.Guild;

public class ChatBotRunThread extends Thread{
    private String token;
    private String[] prefix={"!", null,};

    public ChatBotRunThread(String token, String[] prefix){
        this.token = token;
        this.prefix = prefix;
    }

    public void run(){
        ChatBotConnect con = new ChatBotConnect(token, prefix);

        Guild[] botGuilds = con.getInfoUserGuilds("@me");

        for(int i=0; i<botGuilds.length; i++){
            DiscordMessage[] messages = con.getInfoMessages(botGuilds[i].id);
        }
    }
}
