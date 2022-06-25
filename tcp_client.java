import java.io.*;
import java.net.*;

public class tcpf
{
	public static void main(String[] args)
	{
		try
		{
			
			Socket clientsocket=new Socket("127.0.0.1",3333);
			DataInputStream d=new DataInputStream(System.in);
			DataInputStream is=new DataInputStream(clientsocket.getInputStream());
			PrintStream os=new PrintStream(clientsocket.getOutputStream());
			String cr=new String();
			String sr=new String();
			while(true)
			{
				System.out.println("Enter The Msg:");
				cr=d.readLine();
				if((cr.indexOf("exit"))!=-1)
				{
					System.out.println("Client Exit...");
					break;
				}
				if(cr!=null)
				{
					os.println(cr);
				}
				sr=is.readLine();
				if(sr!=null)
				{
					System.out.println("Server Response : "+sr);
				}
			}
			clientsocket.close();
		}
		catch(Exception e)
		{
			System.out.println("Error :"+e);
		}
	}
}

