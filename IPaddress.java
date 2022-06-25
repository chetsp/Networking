import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException; import java.net.URL;
import java.net.UnknownHostException;
public class address {
public InetAddress ipaddress() throws UnknownHostException
{
InetAddress a=null;
return a=InetAddress.getLocalHost();
}
public String hostname() throws UnknownHostException
{
InetAddress b=null;
b=ipaddress();
return b.getHostName();
}
public int port()
{
int a=0;
try {
URL u = new URL("http://www.java2novice.com:80/java_constructor_examples/?query=ok#header"); a=u.getPort();
} catch (MalformedURLException e) { // TODO Auto-generated catch block e.printStackTrace();
}
return a;
}
public static void main(String[] args) throws UnknownHostException {

// TODO Auto-generated method stub
address a= new address();
System.out.println("ip address "+a.ipaddress()); System.out.println("hostname "+a.hostname()); System.out.println("port "+a.port());
} }
output:
ip address LTSP/127.0.1.1
hostname LTSP
port 80
