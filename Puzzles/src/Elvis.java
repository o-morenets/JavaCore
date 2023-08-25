import java.util.Calendar;

public class Elvis {
	public static final Elvis INSTANCE = new Elvis(); // at this step, static CURRENT_YEAR is not yet initialized (== 0)
	private final int beltSize;
	private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);

	private Elvis() {
		beltSize = CURRENT_YEAR - 1930;
	}

	public int beltSize() {
		return beltSize;
	}

	public static void main(String[] args) {
		System.out.println("Elvis wears a size " + INSTANCE.beltSize() + " belt."); // -1930
	}
}