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

    public void getLastMessage(){
        for(int i=0;i<guilds.length;i++){
            for(int j=0; j<channels[i].length; j++){
                if(channels[i][j].last_message_id == null){
                    continue;
                }
                System.out.println("\r\n"+channels[i][j].name);
                try {
                    System.out.println(con.getInfoMessage(channels[i][j].id, channels[i][j].last_message_id).content);
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

        getLastMessage();


    }
}
