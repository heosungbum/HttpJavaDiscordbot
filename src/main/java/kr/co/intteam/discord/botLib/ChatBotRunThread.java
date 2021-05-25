package kr.co.intteam.discord.botLib;

import kr.co.intteam.discord.botLib.resources.*;

public class ChatBotRunThread extends Thread{
    private String token;
    private String[] prefix={"!", null,};

    private Channel[][] channels=new Channel[100][1000];
    private Guild[] guilds;
    private ChatBotConnect con;

    public void getGuildsAndChannels(){
        guilds = con.getInfoUserGuilds("@me");

        for(int i=0; i<guilds.length; i++){
            System.out.println(guilds[i].name+"\r\n");
            channels[i] = con.getInfoGuildChannels(guilds[i].id);
            for(int j=0; j<channels[i].length; j++){
                System.out.println(channels[i][j].name);
            }
        }
    }

    public void findCommand(){
        for(int i=0;i<guilds.length;i++){
            for(int j=0; j<channels[i].length; j++){
                if(channels[i][j].last_message_id == null){
                    continue;
                }
                try {
                    DiscordMessage conMessage = con.getInfoMessage(channels[i][j].id, channels[i][j].last_message_id);
                    if(conMessage!=null && !conMessage.author.bot){
                        String[] arr = conMessage.content.split(" ");
                        for(int k=0; k<prefix.length; k++){
                            if(arr[0].equals(prefix[k])){
                                System.out.println(arr[1]);
                            }
                        }
                    }
                    else{
                        System.out.println("It is null message or bot's message.");
                    }
                } catch(Exception e){
                    System.out.println(e.toString());
                }
            }
        }
    }

    public void getLastMessageGuild(){
        for(int i=0;i<guilds.length;i++){
            for(int j=0; j<channels[i].length; j++){
                if(channels[i][j].last_message_id == null){
                    continue;
                }
                System.out.println("\n"+channels[i][j].name);
                try {
                    DiscordMessage conMessage = con.getInfoMessage(channels[i][j].id, channels[i][j].last_message_id);
                    if(conMessage!=null)System.out.println(conMessage.content);
                    else{
                        System.out.println("It is null");
                    }
                } catch(Exception e){
                    System.out.println(e.toString());
                }
            }
        }
    }

    public ChatBotRunThread(String token, String[] prefix){
        this.token = token;
        this.prefix = prefix;
    }

    public void run(){
        con = new ChatBotConnect(token, prefix);

        getGuildsAndChannels();
        findCommand();
        // getLastMessageGuild();
    }
}
