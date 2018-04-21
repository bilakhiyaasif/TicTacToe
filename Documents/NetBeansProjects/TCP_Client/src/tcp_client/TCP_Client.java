/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Bilakhiya
 */
public class TCP_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Socket s = new Socket("localhost", 7777);
        DataInputStream dis=new DataInputStream(s.getInputStream());
        DataOutputStream dos=new DataOutputStream(s.getOutputStream());
        
      //  dos.writeUTF("Hello server");
        String s2=new String("");
        Scanner sc=new Scanner(System.in);
        
        while(true)
        {
            s2=sc.nextLine();
            dos.writeUTF(s2);
            
            String s1=dis.readUTF();
            
            System.out.println(s1);
            if(s1.equals("quit"))
            {
               //
                
                break;
            }
            
           
             //dos.close();
             // dis.close();
                s.close();
            
            
        }
        
        
        
        
      //  dos.flush();
       // dos.close();
    }

}
