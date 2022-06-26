package jnpLab; import java.net.*; import java.io.*;
public class UDPDiscardServer { public final static int PORT = 2022; public final static int MAX_PACKET_SIZE = 65507; public static void main(String[] args) {
byte[] buffer = new byte[MAX_PACKET_SIZE];
byte[] send=new byte[MAX_PACKET_SIZE];
try (DatagramSocket server = new DatagramSocket(PORT))
{
DatagramPacket packet = newDatagramPacket(buffer, buffer.length); 
  DatagramPacket packetS; BufferedReader userInput= new BufferedReader(new InputStreamReader(System.in)); 
SocketAddress address = new InetSocketAddress("127.0.0.1", 9999); while (true) {
try {
System.out.println("Let the client start communication");
server.receive(packet);
String s = new String(packet.getData(), 0, packet.getLength(), "8859_1"); System.out.println("Client "+packet.getAddress() + " at port "
+ packet.getPort() + " says " + s);
// reset the length for the next packet packet.setLength(buffer.length);
String theLine = userInput.readLine();
if (theLine.equals(".")) break;
send = theLine.getBytes();
packetS=new DatagramPacket(send, send.length,address); server.send(packetS);
} catch(UnknownHostException e)

{
System.out.println("Inside catch"); }
catch (IOException ex) { System.err.println(ex);
}
} // end while
}
catch (SocketException ex) { System.err.println(ex);
}
}
}
