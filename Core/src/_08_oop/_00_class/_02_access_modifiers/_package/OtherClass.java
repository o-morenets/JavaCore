package _08_oop._00_class._02_access_modifiers._package;

/**
 * Created by Maxim on 26.10.2016.
 */
public class OtherClass {

	private int intValue;

	ParentClass parentClass = new ParentClass();

	public void setPublicValue() {
		this.intValue = parentClass.publicValue;
	}

	public void setProtectedValue() {
		this.intValue = parentClass.protectedValue;
	}

	public void setDefaultValue() {
		this.intValue = parentClass.defaultValue;
	}

	public void setPrivateValue() {
		// this.intValue = parentClass.privateValue;
		intValue = parentClass.getPrivateValue();
	}
}
