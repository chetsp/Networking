package jnpLab; import java.net.*; import java.io.*;
public class UDPDiscardClient { public final static int PORT = 2022; public final static int MAX_PACKET_SIZE = 65507; public static void main(String[] args)

{
String hostname = "localhost";
byte[] buffer = new byte[MAX_PACKET_SIZE];
byte[] data=new byte[MAX_PACKET_SIZE]; SocketAddress address = new InetSocketAddress("127.0.0.1", 9999); try (DatagramSocket theSocket = new DatagramSocket(address))
{InetAddress server = InetAddress.getByName(hostname); BufferedReader userInput= new BufferedReader(new InputStreamReader(System.in)); DatagramPacket packetR = new DatagramPacket(buffer, buffer.length); DatagramPacket packetS;
while (true)
{
String theLine = userInput.readLine();
if (theLine.equals(".")) break;
data = theLine.getBytes();
packetS = new DatagramPacket(data,data.length,server, PORT);
theSocket.send(packetS); theSocket.receive(packetR);
String s = new String(packetR.getData(), 0, packetR.getLength(), "8859_1"); System.out.println("Server"+packetR.get Address() + " at port "
+ packetR.getPort() + " says " + s);
// reset the length for the next packet packetR.setLength(buffer.length);
} // end while
}
catch (IOException ex)
{
System.err.println(ex);
}
}
}
