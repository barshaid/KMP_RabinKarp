package matala2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class main {

	public static void main(String[] args) throws Exception {
		int arr[] = new int[100];
		String str = "";
		long buff = 9;

		int q = 7103;// arbitrary prime

		boolean print = false;// check true to print each index found

		double start, end, kpmTime, rabinKarpTime; // timers

		// creating a large string and patterns to search
		for (int i = 0,count=0; i < 10; i++) {
			for (int j = 0; j < 10; j++) 
				arr[count++] = (int) ((Math.random() * buff) + 1);

			
			buff *= 10;
			buff += 9;
		}
		
		for(int i=0; i<1200; i++)
			str += (int) (Math.random() * Integer.MAX_VALUE);
		System.out.println(str);

		// writing file
		FileWriter fw = new FileWriter("text.txt");
		for (int i = 0; i < str.length(); i++)
			fw.write(str.charAt(i));
		System.out.println("Writing successful");
		fw.close();

		String data = readFileAsString("text.txt");

		// Rabin-Karp loop
		start = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++) {
			rabinKarp.rabinKarp(Long.toString(arr[i]), data, q, print);
		}
		end = System.currentTimeMillis();
		rabinKarpTime = (end - start) / 100;
		System.out.println((rabinKarpTime) + "ms");

		// KMP loop
		for (int i = 0; i < arr.length; i++) {
			KMP.KMP(Long.toString(arr[i]), data, print);
		}
		end = System.currentTimeMillis();
		kpmTime = (end - start) / 100;
		System.out.println((kpmTime) + "ms");

		System.out.println(
				kpmTime + "ms(KPM Time)-" + rabinKarpTime + "ms(Rabin Karp Time)=" + (kpmTime - rabinKarpTime) + "ms");
	}

	public static String readFileAsString(String fileName) throws Exception {
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(fileName)));
		return data;
	}

}
