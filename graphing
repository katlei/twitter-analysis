import java.io.FileReader;
import java.io.IOException;

public class Graph {
	
	public static int[] read(String filename) throws IOException {
		@SuppressWarnings("resource")
		FileReader inputStream = new FileReader(filename);
		int num = 0;
		int[] letters = new int[26];
		
		for(int i=0;i<letters.length;i++) {
			letters[i] = 0;
		}
		
		while((num = inputStream.read()) != -1) {
			if(num>=97 && num<=122) {//a to z
				letters[num-97]++;
			}else if(num>=65 && num<=90) {//A to Z
				letters[num-65]++;
			}
		}
		return letters;
	}
	
	public static void graph(int[] letterFreqArray) {
		double max = maxVal(letterFreqArray);
		char myChar = 'A';
		double newVal = 0;
		String lines = "";
		double[] doubleArray = new double[letterFreqArray.length];
		
		for(int i=0;i<letterFreqArray.length;i++){
			newVal = letterFreqArray[i]/max;
			doubleArray[i] = (int) (newVal*80);
			myChar = (char)(i+65);
			
			for(int j=0;j<doubleArray[i];j++){
				lines+="|";
			}
			if(letterFreqArray[i]!=0){
				System.out.println(myChar +" "+ lines+" ("+letterFreqArray[i]+")");
			}else{
				System.out.println(myChar +" (0)");
			}
			lines = "";
		}
	}
	
	private static int maxVal(int[] array){
		int currMax = array[0];
		for(int i=1;i<array.length;i++){
			if(array[i]>currMax){
				currMax = array[i];
			}
		}
		return currMax;
	}
	
	public static void main(String[] args) throws IOException {
		graph(read("textFile.txt"));
	}
}
