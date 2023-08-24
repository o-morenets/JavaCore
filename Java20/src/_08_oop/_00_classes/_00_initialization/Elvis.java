package _08_oop._00_classes._00_initialization;

public class Elvis {

	public static final Elvis ELVIS = new Elvis();

	private Elvis() {
	}

	public static final Boolean LIVING = true;
//	public static final boolean LIVING = true; // use primitive to fix NPE

	private final Boolean alive = LIVING;

	public final Boolean lives() {
		return alive;
	}

	public static void main(String[] args) {
		System.out.println(ELVIS.lives() ? "Hound Dog" : "Heartbreak Hotel"); // NPE
	}
}
