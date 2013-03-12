import java.io.IOException;

public class JGenerator 
{
	private static final String IP			= "192.168.1.100";
	private static final String PORT		= "8080";
	private static final String URL			= IP + ":" + PORT;

	private static final int DURATION		= 30;

	private static final int NPS			= 0;
	private static final int NPP			= 1;
	private static final int PWP			= 2;
	private static final int PWOP			= 3;

	private static int rate;
	private static int connType;
	
	public static void main(String[] args) throws IOException 
	{
		if(args.length != 2)
			printUsage();
		else
		{
			boolean validInput = determineConnectionType(args);
			if(!validInput)
				printUsage();
			else
				generateTraffic(connType, rate);
		}
	}
	
	public static void generateTraffic(int connType, int rate)
	{
		// Plop Code Here
	}
	
	public static void printUsage()
	{
		System.out.println("Usage: java JGenerator <mode> <rate>");
		System.out.println("          Modes:");
		System.out.println("             -nps (Non-Persistent Serial)");
		System.out.println("             -npp (Non-Persistent Parallel)");
		System.out.println("             -pwp (Persistent with Pipe)");
		System.out.println("             -pwop (Persistent without Pipe)");
		System.out.println("");
		System.out.println("          Rate: (Requests/Second)");
		System.out.println("             E.g. 1");
	}
	
	public static boolean determineConnectionType(String[] v)
	{
		if(v[0].equals("nps"))
			connType = NPS;
		else if(v[0].equals("npp"))
			connType = NPP;
		else if(v[0].equals("pwp"))
			connType = PWP;
		else if(v[0].equals("pwop"))
			connType = PWOP;
		else
			return false;
		
		try					{ rate = Integer.parseInt(v[1]);	}
		catch (Exception e)	{ return false;						}
		
		return true;
	}
}