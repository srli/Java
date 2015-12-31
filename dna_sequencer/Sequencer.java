import java.util.*;
import java.io.*;

public class Sequencer{
	public static void main(String[] args){
		System.out.println("Starting DNA Sequencer!");
		Map<String, String> dict = create_dict();
		
		//String coding_strand = get_reverse_complement("ATGTATGCTGAT");
		String[] coding_strand = dna_to_orfs("ATGTCCTGA");
		System.out.println(Arrays.toString(coding_strand));
		//String aa_string = codon_to_aa(coding_strand, dict);
	}

	public static Map<String, String> create_dict(){
		Map<String, String> map = new HashMap<String, String>();
		try{
			FileReader input = new FileReader("codons.txt");
			BufferedReader bufRead = new BufferedReader(input);
			String myLine = null;
			while ( (myLine = bufRead.readLine()) != null){    
			    String aa = myLine.split(" = ")[0];
			    String[] codons = myLine.split(" = ")[1].split(", ");
			    for (String codon : codons){
			    	map.put(codon, aa);
			    }
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

	public static String codon_to_aa(String dna, Map<String, String> dict){
		String codon = "";
		String aa = "";
		int i = 0;
		while(i < dna.length()){
			codon = dna.substring(i, i+3);
			aa += dict.get(codon);
			i += 3;

		}
		System.out.println(aa);
		return aa;

	}

	public static String[] dna_to_orfs(String dna){
		List<String> cur_orfs = new ArrayList<String>();

		String codon = "";
		String[] stop_codons = {"TAG", "TAA", "TGA"};

		Boolean in_orf = false;
		int start_index = 0;
		int i = 0;
		while(i < dna.length()){
			codon = dna.substring(i, i+3);
			if(codon.equals("ATG") && in_orf == false){
				in_orf = true;
				start_index = i+3;
				System.out.println("starting codon");
			}
			else if (Arrays.asList(stop_codons).contains(codon) && in_orf == true){
				in_orf = false;
				cur_orfs.add(dna.substring(start_index, i+3));
			}
			i += 3;
		}

		String[] res = new String[cur_orfs.size()];
		cur_orfs.toArray(res);
		return res;

	}
}