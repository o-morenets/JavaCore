package _03_operations._02_bit._00_bit_logic;

/**
 * Bit operations
 * Created by Oleksii on 21.07.2017.
 */
public class BitLogic {

    public static void main(String[] args) {

    	String[] binary = {
    			"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
    			"1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"
    	};
    	
    	int a = 3; // 0b0011
    	int b = 6; // 0b0110
    	int c = a | b; // 0b0111 (7)
    	int d = a & b; // 0b0010 (2)
    	int e = a ^ b; // 0b0101 (5)
    	int f = (~a & b) | (a & ~b); // 0b0101 (5)
    	int g = ~a & 0x0f; // 0b1100 (12); & 0x0f - only last 4 bits
    	
    	System.out.println("a = " + binary[a]) ;
    	System.out.println("b = " + binary[b]) ;
    	System.out.println("a | b = " + binary[c]) ;
    	System.out.println("a & b = " + binary[d]) ;
    	System.out.println("a ^ b = " + binary[e]) ;
    	System.out.println("~a & b | a & ~b = " + binary[f]) ;
    	System.out.println("~a = " + binary[g]) ;
    }
}
