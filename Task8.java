import java.util.Scanner;

public class Task8 {
	public static String overflowFormula(int n) {
		if (n == 1) {
			return "((A0|B0)|(A0|B0))";
		} else {
			String nMinusOne = Integer.toString(n - 1);
			String previousOverflow = overflowFormula(n - 1);
			String A = "A" + nMinusOne;
			String B = "B" + nMinusOne;
			/* String lastBitsDisjunction = "("+lastBitA+"|"+lastBitA+")|("+lastBitB+"|"+lastBitB+")";
			String lastBitsConjunction = "("+lastBitA+"|"+lastBitB+")|("+lastBitA+"|"+lastBitB+")";
			String xAB = "("+previousOverflow+"|"+lastBitsDisjunction+")|("+previousOverflow+"|"+lastBitsDisjunction+")";
			String result = "("+xAB+"|"+xAB+")|("+lastBitsConjunction+"|"+lastBitsConjunction+")";
			return result; */
			
			String result = "(("+previousOverflow+"|(("+A+"|"+A+")|("+B+"|"+B+")))|("+A+"|"+B+"))";
			return result;
		}		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(overflowFormula(n));
		sc.close();
	}
}