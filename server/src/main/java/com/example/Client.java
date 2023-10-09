package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    
    public void ciccio() {
        try {
        Socket s = new Socket("localhost", 3000);
       
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
       
        out.writeBytes("ciao a tutti");
        String r = in.readLine();
       
        System.out.println("Il server ha risporso:" + r);
        s.close();
       
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
        }
}
