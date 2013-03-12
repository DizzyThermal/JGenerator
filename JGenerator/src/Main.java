import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class Main 
{

	public static void main(String[] args) throws IOException 
	{
		String urlString = "http://192.168.1.100:8080";
		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();

	}

}
