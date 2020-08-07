import java.util.Scanner;
import java.io.*;
public class TextAnalysis {
	public static void main(String[] args) throws FileNotFoundException {

		//ask the user for the name of the file to open
		System.out.print("What file would you like to open? ");
		Scanner input = new Scanner(System.in);
		String file_name = input.nextLine();

		//ask the user for the word needed to be searched
		System.out.print("What words would you like to search for? ");
		String search = input.nextLine();

		String[] tics = search.split(", ");


		//count the number of different tics in the text
		int[] tics_count= new int[tics.length];

		int total = 0;
		//System.out.println(tics_count.length);
		for (int i=0; i<tics.length; i++) {
			tics_count[i]=0;

			//use Scanner to read the file
			Scanner file = new Scanner (new File (file_name));
			while(file.hasNextLine()) {
				String line = file.nextLine();
				
				String[] words = line.split("[ :“”,!?.-]");

				for (int m=0; m< words.length; m++) {
					if (!words[m].equals(""))
						total+=1;
				}

				int find = -1;
				do {
					find = line.indexOf(tics[i], find+1);
					tics_count[i]++;
				} while (find != -1);
				tics_count[i] --;
				
			}
		}

		int total_words = total/tics.length;

		int sum = 0;
		//count the total number of tics in the text
		for (int i=0; i<tics_count.length; i++)
			sum += tics_count[i];

		//format and display content
		System.out.println();

		for (int i=0; i<21; i++)
			System.out.print(".");

		System.out.print("Analyzing text");

		for (int i=0; i<21; i++)
			System.out.print(".");
		
		System.out.println();
		System.out.println();


		System.out.print("Total number of tics: ");
		System.out.println(sum);

		double density = sum/(total_words * 1.0);

		System.out.print("Density of tics: ");
		System.out.println((int)(density * 100) / 100.0);
		System.out.println();
		for (int i=0; i<21; i++)
			System.out.print(".");

		System.out.print("Tic breakdown");

		for (int i=0; i<22; i++)
			System.out.print(".");

		System.out.println();
		System.out.println();


		for (int i=0; i<tics.length; i++){
			System.out.printf("%-11s",tics[i]);
			System.out.print("/  ");
			System.out.print(tics_count[i] + " occurrences  /  ");
			System.out.printf("%3d",(int)(tics_count[i] * 100.0 / sum));
			System.out.print("% " + "of all tics");
			System.out.println();

		}

	}
}

	

