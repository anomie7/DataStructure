package section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Chaper1.MyPoint1;

public class Code10 {
	public static void main(String[] args){
		try{
			Scanner in = new Scanner(new File("polygon.txt"));
			int n = in.nextInt();
			OrthoPolygon thePolygon = new OrthoPolygon(n);
			for(int i = 0; i < n; i++)
				thePolygon.addVertex(in.nextInt(), in.nextInt());
			MyPoint1 p = new MyPoint1(in.nextInt(), in.nextInt());
			in.close();
			if(thePolygon.contains(p))
				System.out.println("Yes");
			else
				System.out.println("NO");
		}catch(FileNotFoundException e){
			System.out.println("No data file exists.");
			System.exit(1);
		}
	}
}
