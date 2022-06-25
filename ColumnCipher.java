import java.util.*;

public class ColumnCipher {

	static Scanner sc = new Scanner(System.in);

	static void encrypt(String pt, int col, int key[]) {
		char[] a = pt.toCharArray();
		int len = a.length;
		int row = len / col;
		int count = 0;
		char ct[][] = new char[row][col];
		if (len % col != 0) {
			System.out.println("Error");
		} else {

			char arr[][] = new char[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					arr[i][j] = a[count];
					count++;
				}
			}

			/*
			 * for (int i = 0; i < row; i++) { for (int j = 0; j < col; j++)
			 * System.out.print(arr[i][j] + " "); System.out.println(); }
			 */
			int k = 0, v = 0;
			for (int i = 0; i < col; i++) {
				v = key[i] - 1;
				for (int j = 0; j < row; j++) {
					ct[j][v] = arr[j][k];
				}
				k++;
			}
		}
		System.out.println("The encrypted text is ");
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++)
				System.out.print(ct[j][i]);
		}
		System.out.println();
	}

	static void decrypt(String ct, int col1, int key1[]) {
		char a1[] = ct.toCharArray();
		int row1 = a1.length / col1;
		int count = 0;
		char arr1[][] = new char[row1][col1];
		char pt[][] = new char[row1][col1];
		for (int i = 0; i < col1; i++) {
			for (int j = 0; j < row1; j++) {
				arr1[j][i] = a1[count];
				count++;
			}
		}
		/*
		 * for (int i = 0; i < row1; i++) { for (int j = 0; j < col1; j++)
		 * System.out.print(arr1[i][j] + " "); System.out.println(); }
		 */
		int k1 = 0, v1 = 0;
		for (int i = 0; i < col1; i++) {
			v1 = key1[i] - 1;
			for (int j = 0; j < row1; j++) {
				pt[j][k1] = arr1[j][v1];
			}
			k1++;
		}
		for (int i = 0; i < row1; i++) {
			for (int j = 0; j < col1; j++)
				System.out.print(pt[i][j]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("Enter the string for encryption");
		String pt = sc.next();
		System.out.println("Enter the number of columns");
		int col = sc.nextInt();
		System.out.println("Enter the key");
		int key[] = new int[col];
		for (int i = 0; i < col; i++)
			key[i] = sc.nextInt();
		encrypt(pt, col, key);
		System.out.println("Enter the string for decryption");
		String ct = sc.next();
		System.out.println("Enter the number of columns");
		int col1 = sc.nextInt();
		System.out.println("Enter the key");
		int key1[] = new int[col1];
		for (int i = 0; i < col1; i++)
			key1[i] = sc.nextInt();
		decrypt(ct, col1, key1);
	}
}

Output:

Enter the string for encryption
matchpostponeduntilnotice
Enter the number of columns
5
Enter the key
5 4 1 2 3 
The encrypted text is 
tseiictdlchpuneaonttmpono
Enter the string for decryption
tseiictdlchpuneaonttmpono
Enter the number of columns
5
Enter the key
5 4 1 2 3
matchpostponeduntilnotice
