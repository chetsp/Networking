import java.io.*;
import java.net.*;

public class tcpfs
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket myserver=new ServerSocket(3333);
			Socket clientsocket=new Socket();
			clientsocket=myserver.accept();
			DataInputStream d=new DataInputStream(System.in);
			DataInputStream is=new DataInputStream(clientsocket.getInputStream());
			PrintStream os=new PrintStream(clientsocket.getOutputStream());
			String sr=new String();
			String cr=new String();
			while(true)
			{
				cr=is.readLine();
				if((cr.indexOf("exit"))!=-1)
				{
					System.out.println("Client-server Exit");
					break;
				}
				if(cr!=null)
				{
					System.out.println("Client Msg: "+cr);
				}
				System.out.println("Enter The Msg :");
				sr=d.readLine();
				if(sr!=null)
				{
					os.println(sr);
				}
				
			}

			
		}
		catch(Exception e)
		{
			System.out.println("Error  :"+e);
		}
	}
}
