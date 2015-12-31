import java.util.*;
import java.io.*;

public class Sequencer{
	public static void main(String[] args){
		System.out.println("Starting DNA Sequencer!");
		Map<String, String[]> dict = create_dict();
		
		String coding_strand = get_reverse_complement("ATATAT");
		String aa_string = codon_to_aa(coding_strand, dict);
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
			System.out.println("Error, file not found");
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

	public static String codon_to_aa(String dna, Map<String, String[]> dict){
		String codon = "";
		int i = 0;
		while(i < dna.length()){
			codon = dna.substring(i, i+3);
			i += 3;
			

		}
		// String[] codons = dict.get("F");
		// System.out.println(Arrays.asList(codons).contains("TTT"));
		return codon;

	}
}