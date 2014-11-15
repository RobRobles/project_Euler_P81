import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class p81_Matrix {


	public static void main(String[] args) throws IOException {

		//This is for problem 81 
		File file = new File("matrix.txt");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(file);

		int row = 80; 
		int col = 80;
		int size = row*col; 
		int i = 0;
	
		//Final Matrix
		int[][] Matrix = new int[row][col]; 
		//temp arry for getting the numbers in text file
		Integer[] temp = new Integer[size];

		//putting the numbers from text file into array
		while(input.hasNext())
		{	
			temp[i] = input.nextInt();
			i++;
		}


		int a = 0;

		//putting the numbers from array into Matrix
		for(int b = 0; b < row; b++)
		{
			for(int c = 0; c < col; c++)
			{
				Matrix[b][c] = temp[a];
				a++;
			}
		}

		//printing to see if itw works. 
		for(int b = 0; b < row; b++)
		{
			for(int c = 0; c < col; c++)
			{
				System.out.print(Matrix[b][c] + " ");

			}
			System.out.println("");
		}
		
		//computing the minPath
		
		for(int x = Matrix.length - 1; x >= 0; x--)
		{
			for(int v = Matrix[x].length - 1; v >= 0; v--)
			{
				int Temp;
				if(x + 1 < Matrix.length && v + 1 < Matrix[x].length)
				{
					Temp = Math.min(Matrix[x + 1][v], Matrix[x][v + 1]);
				}
				else if(x + 1 < Matrix.length)
				{
					Temp = Matrix[x + 1][v];
				}
				else if(v + 1 < Matrix[x].length)
				{
					Temp = Matrix[x][v + 1];
				}
				else 
					Temp = 0; 
				
				Matrix[x][v] += Temp;
			}
		}
		
		System.out.println("This is the minPath: " + Integer.toString(Matrix[0][0]));


	}
}
