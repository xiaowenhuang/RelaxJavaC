package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by sven on 2016/10/21.
 */
public class Client {
    public static void main(String[] args){
        String msg = "Client Data";
        try{
            //创建一个Socket，跟本机的8080端口连接
            Socket socket = new Socket("127.0.0.1",8080);
            //使用Socket创建PrintWriter和BufferReader进行读写数据
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //发送数据
            pw.println(msg);
            pw.flush();
            //accept data
            String line = is.readLine();
            System.out.println("从服务端传过来的数据是:"+line);
            //close resources
            pw.close();
            is.close();
            socket.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
