import java.util.*;
import java.io.*;

public class Sequencer{
	public static void main(String[] args){
		System.out.println("Starting DNA Sequencer!");
		Map<String, String[]> dict = create_dict();
		
		String[] codons = dict.get("F");
		System.out.println(Arrays.asList(codons).contains("TTT"));

		String t = get_reverse_complement("ATATAT");
		System.out.println(t);
	}

	public static Map<String, String[]> create_dict(){
		Map<String, String[]> map = new HashMap<String, String[]>();
		try{
			FileReader input = new FileReader("codons.txt");
			BufferedReader bufRead = new BufferedReader(input);
			String myLine = null;
			while ( (myLine = bufRead.readLine()) != null){    
			    String aa = myLine.split(" = ")[0];
			    String[] codons = myLine.split(" = ")[1].split(", ");
			    map.put(aa, codons);
			}
			return map;
		}
		catch(Exception e){
			return null;
		}
	}

	public static String get_reverse_complement(String dna){
		String out_dna = "";
		char[] chr_arr = dna.toCharArray();

		for(char cur_char : chr_arr){
			switch (cur_char){
				case 'A':
					out_dna += "T";
					break;
				case 'T':
					out_dna += "A";
					break;
				case 'G':
					out_dna += "C";
					break;
				case 'C':
					out_dna += "G";
					break;
				default:
					System.out.println("Wrong character");
			}
		}
		return out_dna;
	}
}