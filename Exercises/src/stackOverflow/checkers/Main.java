package stackOverflow.checkers;

public class Main {

    public static final short MASK_SINGLE_PIECE = 0b111111111; // 9 bits
    public static final byte MASK_POSITION_X = 0b111;           // bits 0..2 (right-to-left)
    public static final byte MASK_POSITION_Y = 0b111000;        // bits 3..5 (right-to-left)

    public static void main(String[] args) {
        long whitePieces1 = 0b0000000000_100001010_100001000_100000111_100000101_100000011_100000001L;

        System.out.println(getPiecePosX(whitePieces1, 0) + "," + getPiecePosY(whitePieces1, 0));
        System.out.println(getPiecePosX(whitePieces1, 1) + "," + getPiecePosY(whitePieces1, 1));
        System.out.println(getPiecePosX(whitePieces1, 2) + "," + getPiecePosY(whitePieces1, 2));
        System.out.println(getPiecePosX(whitePieces1, 3) + "," + getPiecePosY(whitePieces1, 3));
        System.out.println(getPiecePosX(whitePieces1, 4) + "," + getPiecePosY(whitePieces1, 4));
        System.out.println(getPiecePosX(whitePieces1, 5) + "," + getPiecePosY(whitePieces1, 5));
    }

    public static byte getPiecePosX(long piecesBits, int pieceNumber) {
        long bitsForPiece = piecesBits >> (pieceNumber * 9);
        short pieceBits = (short) (bitsForPiece & MASK_SINGLE_PIECE);
        return (byte) (pieceBits & MASK_POSITION_X);
    }

    public static byte getPiecePosY(long piecesBits, int pieceNumber) {
        long bitsForPiece = piecesBits >> (pieceNumber * 9);
        short pieceBits = (short) (bitsForPiece & MASK_SINGLE_PIECE);
        return (byte) ((pieceBits & MASK_POSITION_Y) >> 3);
    }
}
