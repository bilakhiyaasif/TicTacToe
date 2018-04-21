/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Bilakhiya
 */
public class TCP_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        // TODO code application logic here
       ServerSocket ss=new ServerSocket(7777);
       Socket s=ss.accept();
       
        DataInputStream dis=new DataInputStream(s.getInputStream());
        DataOutputStream dos=new DataOutputStream(s.getOutputStream());
        String str=null;
       //(String)dis.readUTF();
        String r=new String("h");
       // System.out.println("message="+str);
        Scanner sc=new Scanner(System.in);
        while(true)
        {
           
            
            r=dis.readUTF();
            System.out.println("Client says:"+r);  
            if(r.equals("quit"))
            {
                break;
            }
            
             str=sc.nextLine();
            dos.writeUTF(str);
            
        }
       
                
                s.close();
                ss.close();
      //  ss.close();
    }
    
}
