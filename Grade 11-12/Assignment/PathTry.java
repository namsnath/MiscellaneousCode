import java.nio.file.*;
import java.util.Scanner;
public class PathTry
{
	public static void main(String args[])
	{
		Path path;
		Scanner s = new Scanner(System.in);
		
		String InputPath;
		
		System.out.println("Enter A Valid Path:");
		InputPath = s.nextLine();
		
		path = Paths.get(InputPath, null);
		
		System.out.println(path);
		
	}
}
