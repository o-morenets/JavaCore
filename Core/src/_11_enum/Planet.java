package _11_enum;

/**
 * Created by MaximVL on 04.04.2016.
 */
public enum Planet {

	MERCURY(3.303e+23, 2.4397e6),
	VENUS(4.869e+24, 6.0518e6),
	EARTH(5.976e+24, 6.37814e6),
	MARS(6.421e+23, 3.3972e6),
	JUPITER(1.9e+27, 7.1492e7),
	SATURN(5.688e+26, 6.0268e7),
	URANUS(8.686e+25, 2.5559e7),
	NEPTUNE(1.024e+26, 2.4746e7);

	private final double mass;
	private final double radius;

	Planet(double mass, double radius) {
		System.out.println("Initializing element " + ordinal() + "...");
		this.mass = mass;
		this.radius = radius;
	}

	public double mass() {
		return mass;
	}

	public double radius() {
		return radius;
	}

	public static final double G = 6.67300E-11;

	double surfaceGravity() {
		return G * mass / (radius * radius);
	}

	double surfaceWeight(double otherMass) {
		return otherMass * surfaceGravity();
	}

	@Override
	public String toString() {
		return Planet.this.name() + " {" +
				"mass=" + mass +
				", radius=" + radius +
				'}';
	}
}
