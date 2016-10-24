package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.Exception;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args){
        try{
            //创建一个ServerSocket监听器8080端口
            ServerSocket server = new ServerSocket(8080);
            //wait for request
            Socket socket = server.accept();
            //接收到请求后使用socket进行通信，创建BufferReader用于读取数据
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = is.readLine();
            System.out.println("从客户端接收到的数据是:"+line);
            //创建PrintWriter用于发送数据
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("服务端已收到您的数据:"+line);
            pw.flush();
            //close resources
            pw.close();
            is.close();
            socket.close();
            server.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}