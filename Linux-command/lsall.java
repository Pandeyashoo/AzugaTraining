import java.util.*;
import java.io.*;
import java.text.*;

class lsall {
	public static void main(String[] args)
	{
		File file = new File(System.getProperty("user.dir"));
		File[] folder = file.listFiles();
		Arrays.sort(folder);
		String ch = args[0];
		switch(ch)
			{


			case "ls":
			for(int i=0;i<folder.length;i++)
			{
				System.out.print(folder[i].getName()+" \t");
			}
			break;



			case "-a":
			for(int i=0;i<folder.length;i++)
			{
				if(folder[i].isHidden())
				{
					System.out.print(folder[i].getName()+" \t");
				}
			}	
			break;
			


			case "-l":
			for(int i=0;i<folder.length;i++)
	{
		if(folder[i].isHidden())
		{
			continue;
		}
		else
		{
		if(folder[i].isFile())
		{
			System.out.print("-");
		}
		if(folder[i].isDirectory())
		{
			System.out.print("d");
		}
		
		
		System.out.print("\t"+System.getProperty("user.name"));
		System.out.print("\t"+System.getProperty("owner.name")+"\t");
		System.out.print(folder[i].length() );
		System.out.print(("\t"+new Date(folder[i].lastModified())) + "\t");
		System.out.println(folder[i].getName());
		}
		
	}	

			break;


			case "-t":
			for (int i = 0; i < folder.length; i++)
  			{
    			  System.out.println(new Date(folder[i].lastModified())+"\t\t"+folder[i].getName());
 			 }
			break;


			case "-1":
			for(int i=0;i<folder.length;i++)
			{
				System.out.println(folder[i].getName());
			}
			break;


			case "-al":
				for(int i=0;i<folder.length;i++)
				{
					if(folder[i].isHidden())
					{
						if(folder[i].isFile())
						{
							System.out.print("-");
						}
						if(folder[i].isDirectory())
						{
							System.out.print("d");
						}
		
		
						System.out.print("\t"+System.getProperty("user.name"));
						System.out.print("\t"+System.getProperty("owner.name")+"\t");
                                                System.out.print(folder[i].length() );
                                                System.out.print(("\t"+new Date(folder[i].lastModified())) + "\t");
						System.out.println(folder[i].getName());
					}
						if(folder[i].isFile())
						{
							System.out.print("-");
						}
						if(folder[i].isDirectory())
						{
							System.out.print("d");
						}
		
		
							System.out.print("\t"+System.getProperty("user.name"));
							System.out.print("\t"+System.getProperty("owner.name")+"\t");
							System.out.print(folder[i].length() );
							System.out.print(("\t"+new Date(folder[i].lastModified())) + "\t");
							System.out.println(folder[i].getName());
					}
		

			break;


			case "-r":
			for(int i=folder.length-1;i>=0;i--)
			{
				System.out.println(folder[i].getName()+" \t");
			}
			break;

			default:
			System.out.println("Choose Correct options");
			}
	}
}