import java.util.ArrayList;

public class DNAProcessor {

    public static ArrayList<String> DNAToCodons(String dna) {
        ArrayList<String> codons = new ArrayList<>();

        for (int i = 0; i <= dna.length() - 3; i += 3) {
            codons.add(dna.substring(i, i + 3));
        }

        return codons;
    }

    public static String CodonToAminoAcid(String codon) {
        switch (codon) {

            case "TTT":
            case "TTC":
                return "F";

            case "TTA":
            case "TTG":
            case "CTT":
            case "CTC":
            case "CTA":
            case "CTG":
                return "L";

            case "ATT":
            case "ATC":
            case "ATA":
                return "I";

            case "ATG":
                return "M";

            case "GTT":
            case "GTC":
            case "GTA":
            case "GTG":
                return "V";

            case "TAA":
            case "TAG":
            case "TGA":
                return "Stop";

            default:
                return "X";
        }
    }

    public static ArrayList<String> dna_to_amino_acid(String dna) {
        ArrayList<String> amino = new ArrayList<>();
        ArrayList<String> codons = DNAToCodons(dna);

        for (String codon : codons) {
            amino.add(CodonToAminoAcid(codon));
        }

        return amino;
    }

    public static boolean is_match(ArrayList<String> seq1, ArrayList<String> seq2) {
        return seq1.equals(seq2);
    }

    public static void main(String[] args) {

        String DNA1 = "CTGATATTGTATCCGGCCGAA";
        String DNA2 = "CTAGCCGGTGGTTATTAATAGTAAACTATTCCA";
        String DNA3 = "TTAATCCTCTACCCCGCAGAG";

        ArrayList<String> amino1 = dna_to_amino_acid(DNA1);
        ArrayList<String> amino2 = dna_to_amino_acid(DNA2);
        ArrayList<String> amino3 = dna_to_amino_acid(DNA3);

        System.out.println("DNA1 vs DNA2: " + is_match(amino1, amino2));
        System.out.println("DNA1 vs DNA3: " + is_match(amino1, amino3));
        System.out.println("DNA2 vs DNA3: " + is_match(amino2, amino3));
    }
}
