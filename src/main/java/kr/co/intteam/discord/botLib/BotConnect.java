package kr.co.intteam.discord.botLib;

import com.google.gson.Gson;
import kr.co.intteam.discord.botLib.resources.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.nio.charset.StandardCharsets;



public class BotConnect {
    private String token;

    public BotConnect(String token){
        this.token = token;
        getInfo("users/@me");
    }

    public void sendMessage(String msg, String channel){
        try{
            String sendMsg = "{\"content\": \""+msg+"\",\"tts\": false}";
            byte[] out = sendMsg.getBytes(StandardCharsets.UTF_8.name());

            URL url = new URL("https://discord.com/api/channels/"+channel+"/messages");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.addRequestProperty("Authorization","Bot " + token);
            con.addRequestProperty("Content-Type", "application/json");
            con.setFixedLengthStreamingMode(out.length);

            con.addRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            OutputStream os = con.getOutputStream();
            os.write(out, 0, out.length);

            int code=con.getResponseCode();
            System.out.println(code);
            System.out.println(con.getResponseMessage());



            if(code==200){
                System.out.println("Success");
            }

        } catch (IOException e){
            System.err.println(e.toString());
        }
    }

    public void getInfo(String info){
        try{
            URL url = new URL("https://discord.com/api/"+info);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.addRequestProperty("Authorization","Bot " + token);
            con.addRequestProperty("Accept", "application/json");
            int code=con.getResponseCode();
            System.out.println(code);
            System.out.println(con.getResponseMessage());
            if(code==200){
                //System.out.print(con.getRequestProperties().toString());
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
                StringBuffer result = new StringBuffer();
                while((line=br.readLine())!=null){
                    result.append(line);
                }
                br.close();

                System.out.println(result.toString());
            }
        } catch (IOException e){
            System.err.println(e.toString());
        }
    }

    public DiscordMessage getInfoMessage(String channel, String message) throws Exception{
        try{
            URL url = new URL("https://discord.com/api/channels/"+channel+"/messages/"+message);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.addRequestProperty("Authorization","Bot " + token);
            con.addRequestProperty("Accept", "application/json");
            int code=con.getResponseCode();
            System.out.println(code);
            System.out.println(con.getResponseMessage());
            if(code==200){
                //System.out.print(con.getRequestProperties().toString());
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
                StringBuffer result = new StringBuffer();
                while((line=br.readLine())!=null){
                    result.append(line);
                }
                br.close();
                Gson g = new Gson();
                DiscordMessage a = g.fromJson(result.toString(), DiscordMessage.class);
                return a;
            }
        } catch (IOException e){
            System.err.println(e.toString());
        }
        return null;
    }

    public DiscordMessage[] getInfoMessages(String info){
        try{
            URL url = new URL("https://discord.com/api/channels/"+info+"/messages");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.addRequestProperty("Authorization","Bot " + token);
            con.addRequestProperty("Accept", "application/json");
            int code=con.getResponseCode();
            System.out.println(code);
            System.out.println(con.getResponseMessage());
            if(code==200){
                //System.out.print(con.getRequestProperties().toString());
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
                StringBuffer result = new StringBuffer();
                while((line=br.readLine())!=null){
                    result.append(line);
                }
                br.close();
                Gson g = new Gson();
                DiscordMessage[] a = g.fromJson(result.toString(), DiscordMessage[].class);
                return a;
            }
        } catch (IOException e){
            System.err.println(e.toString());
        }
        return null;
    }

    public Guild[] getInfoUserGuilds(String info){
        try{
            URL url = new URL("https://discord.com/api/users/"+info+"/guilds");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.addRequestProperty("Authorization","Bot " + token);
            con.addRequestProperty("Accept", "application/json");
            int code=con.getResponseCode();
            System.out.println(code);
            System.out.println(con.getResponseMessage());
            if(code==200){
                //System.out.print(con.getRequestProperties().toString());
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
                StringBuffer result = new StringBuffer();
                while((line=br.readLine())!=null){
                    result.append(line);
                }
                br.close();
                Gson g = new Gson();
                Guild[] a = g.fromJson(result.toString(), Guild[].class);
                return a;
            }
        } catch (IOException e){
            System.err.println(e.toString());
        }
        return null;
    }

    public Channel[] getInfoGuildChannels(String info){
        try{
            URL url = new URL("https://discord.com/api/guilds/"+info+"/channels");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.addRequestProperty("Authorization","Bot " + token);
            con.addRequestProperty("Accept", "application/json");
            int code=con.getResponseCode();
            System.out.println(code);
            System.out.println(con.getResponseMessage());
            if(code==200){
                //System.out.print(con.getRequestProperties().toString());
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
                StringBuffer result = new StringBuffer();
                while((line=br.readLine())!=null){
                    result.append(line);
                }
                br.close();
                Gson g = new Gson();
                Channel[] a = g.fromJson(result.toString(), Channel[].class);
                return a;
            }
        } catch (IOException e){
            System.err.println(e.toString());
        }
        return null;
    }
    /*public GuildMember[] getInfoGuildUsers(String info){
        try{
            URL url = new URL("https://discord.com/api/guilds/"+info+"/members");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.addRequestProperty("Authorization","Bot " + token);
            con.addRequestProperty("Accept", "application/json");
            int code=con.getResponseCode();
            System.out.println(code);
            System.out.println(con.getResponseMessage());
            if(code==200){
                //System.out.print(con.getRequestProperties().toString());
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
                StringBuffer result = new StringBuffer();
                while((line=br.readLine())!=null){
                    result.append(line);
                }
                br.close();
                Gson g = new Gson();
                GuildMember[] a = g.fromJson(result.toString(), GuildMember[].class);
                return a;
            }
        } catch (IOException e){
            System.err.println(e.toString());
        }
        return null;
    }*/
}