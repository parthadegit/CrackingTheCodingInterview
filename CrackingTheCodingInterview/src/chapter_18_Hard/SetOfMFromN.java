/*
 * Question: 
 * 			Write a method to randomly generates set of m integers from an array of size n. Each element must have equal probability of being chosen
*/

package chapter_18_Hard;

import java.util.Random;

public class SetOfMFromN {

	public static void main(String[] args) {
		int m = 5;
		int n = 100;
		if(m>n || m<=0 || n<=0){
			System.out.println("m must be smaller or equal to n. Both m and n must be positive.");
		}
		else{
			int[] data = new int[n];
			for(int i=0;i<data.length;i++){
				data[i]=i+1;
			}
			int[] res = generateMElemsFromNSizedArray(data,m);
			printResult(res);
		}

	}

	private static void printResult(int[] res) {
		for(int i=0;i<res.length;i++){
			System.out.print(res[i]+",");
		}
		
	}

	private static int[] generateMElemsFromNSizedArray(int[] data,int m) {
		int[] result=new int[m];
		for(int i=0;i<m;i++){
			result[i]=data[i];
		}
		Random rand = new Random();
		for(int i=m;i<data.length;i++){
			int loc = rand.nextInt(i);
			if(loc<m){
				result[loc] = data[i];
			}
		}
		return result;
	}

}
