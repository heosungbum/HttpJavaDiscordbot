package kr.co.intteam.discord.botLib;

import kr.co.intteam.discord.botLib.resources.DiscordMessage;

public class ChatBotConnect extends BotConnect{
    private String token;
    private String[] prefix={"!", null,};

    public ChatBotConnect(String token, String[] prefix){
        super(token);
        this.prefix = prefix;
    }

    public ChatBotConnect(String token){
        super(token);
        this.token = token;
    }

    public void setPrefix(String[] prefix) {
        this.prefix = prefix;
    }

    public void getMessage(){

    }

    public void getMessagesChannel(String channel){
        DiscordMessage[] m = getInfoMessages(channel);
    }
}
