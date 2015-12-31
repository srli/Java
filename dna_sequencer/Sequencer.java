public class Sequencer{
	public static void main(String[] args){
		System.out.println("Starting DNA Sequencer!");
		String t = get_reverse_complement("ATATAT");
		System.out.println(t);
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