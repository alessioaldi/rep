package com.example;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        String stringa=null;
        while(stringa.equals("q")==false){
            try {
                System.out.println("Server avviato");
                ServerSocket server = new ServerSocket(3000);
                Socket s = server.accept();

                System.out.println("in client si è ocnnesso");
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                String stringaRicevuta = in.readLine();
                stringa = stringaRicevuta;
                System.out.println("il client ha inviato" + stringaRicevuta);
                String stringaModificata = stringaRicevuta.toUpperCase();
                if(stringa.equals("q")){
                    out.writeBytes("yes");
                } else{
                out.writeBytes(stringaModificata + "\n");
                }
                server.close();
                s.close();
            
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
    }
}
