package com.xieyupeng.springboot.studys.Others;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {

    public static void main(String[] args) {
        try {
            //监听一个端口
            ServerSocket serverSocket = new ServerSocket(9000);
            //阻塞获取浏览器请求
            Socket socket = serverSocket.accept();
            //Request
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes)!=-1){
                System.out.println(new String(bytes));
            }
            //Response
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello,i'm xieyupeng!".getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        System.exit(0);
    }

}
