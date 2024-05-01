package misc;

import java.math.BigDecimal;

public class StripTrailingZeros
{
	public static void main(String[] args)
	{
		System.out.println(getScale(1.12300));
		System.out.println(getScale(1.123001));
		System.out.println(getScale(1.0));
		System.out.println(getScale(1.0000000));
		System.out.println(getScale(1.));
		System.out.println(getScale(1));
		System.out.println(getScale(-1));
		System.out.println(getScale(-1.));
		System.out.println(getScale(-1.0));
	}

	static int getScale(double d)
	{
		return BigDecimal.valueOf(d).stripTrailingZeros().scale();
	}
}
