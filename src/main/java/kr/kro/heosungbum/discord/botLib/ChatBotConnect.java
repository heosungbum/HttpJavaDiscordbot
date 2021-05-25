package kr.kro.heosungbum.discord.botLib;

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
}
