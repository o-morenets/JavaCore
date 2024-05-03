package _19_io._04_externalizable;

import java.io.*;

public class ExternalizableTest {

	private static final String OUTPUT_FILE = "country.ext";

	public static void main(String[] args) {
		Country c = new Country();
		c.setCode(374);
		c.setName("Swiss");

		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(OUTPUT_FILE))) {
			c.writeExternal(objectOutputStream);
			objectOutputStream.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(OUTPUT_FILE))) {
			Country c2 = new Country();
			c2.readExternal(objectInputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}

class Country implements Externalizable {

	private static final long serialVersionUID = 1L;

	private String name;
	private int code;

	// getters, setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(name);
		out.writeInt(code);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.name = in.readUTF();
		this.code = in.readInt();
	}
}