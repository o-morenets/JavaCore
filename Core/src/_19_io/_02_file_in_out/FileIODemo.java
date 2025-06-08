package _19_io._02_file_in_out;

import java.io.*;
import java.util.Arrays;

public class FileIODemo {

	public static void main(String[] args) throws IOException {

		// 1. FileInputStream / FileOutputStream

		// 1.1
		// Byte streams (FileInputStream / FileOutputStream)
		// Reading byte by byte
		try (InputStream fis = new FileInputStream(System.getProperty("user.dir") + "/Core/" + "1.txt");
			 OutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/Core/" + "1_1.txt")) {

			int oneByte;
			while ((oneByte = fis.read()) != -1) {
				// Since oneByte contains only 1 byte, only the first 128 characters of the ASCII table are displayed correctly:
				System.out.print((char) oneByte); // Cyrillic characters are displayed as ???????? in the CONSOLE
				fos.write(oneByte); // but CORRECT bytes are written to the file
			}
			System.out.println("\n========================================================");
			fos.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 1.2
		// Byte streams (FileInputStream / FileOutputStream)
		// Reading bytes using a buffer of size bufSize
		try (InputStream is = new FileInputStream(System.getProperty("user.dir") + "/Core/" + "1.txt");
			 OutputStream os = new FileOutputStream(System.getProperty("user.dir") + "/Core/" + "1_2.txt")) {

			int bufSize = 153;
			byte[] buff = new byte[bufSize];
			int numBytes;
			while ((numBytes = is.read(buff)) != -1) { // numBytes = number of bytes read
				System.out.print(numBytes + " ");
				String s = new String(buff, 0, numBytes);
				System.out.println(s);
				os.write(buff, 0, numBytes);
			}
			System.out.println("\n========================================================");
			os.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 1.3
		// ByteArrayOutputStream
		ByteArrayOutputStream buff = new ByteArrayOutputStream();
		buff.write(0);
		buff.write(new byte[]{1, 2, 3});
		buff.write(new byte[]{0, 0, 0, 4, 5, 6, 0, 0, 0}, 3, 3);

		byte[] rawData = buff.toByteArray();
		System.out.println(Arrays.toString(rawData));
		System.out.println("\n========================================================");


		// 2. FileReader / FileWriter

		// 2.1
		// Character streams (FileReader / FileWriter)
		// Reading character by character
		try (Reader reader = new FileReader(System.getProperty("user.dir") + "/Core/" + "1.txt");
			 Writer writer = new FileWriter(System.getProperty("user.dir") + "/Core/" + "2_1.txt")) {

			int ch;
			while ((ch = reader.read()) != -1) { // ch - символ 0x0000-0xffff
				System.out.println(ch);
				writer.write(ch);
			}
			System.out.println("\n========================================================");
			writer.flush();

		} catch (FileNotFoundException exFNF) {
			System.out.println("File not found!");
		} catch (IOException exIO) {
			System.out.println("IO Exception");
		}

		// 2.2
		// Character streams (FileReader / FileWriter)
		// Reading characters using a buffer of size bufSize
		try (Reader reader = new FileReader(System.getProperty("user.dir") + "/Core/" + "1.txt");
			 Writer writer = new FileWriter(System.getProperty("user.dir") + "/Core/" + "2_2.txt")) {

			int bufSize = 57;
			char[] cbuf = new char[bufSize];
			int numBytes;
			while ((numBytes = reader.read(cbuf)) != -1) { // numBytes = number of bytes read
				System.out.println(cbuf); // Might print garbage if the last portion read is smaller than the buffer size
				writer.write(cbuf, 0, numBytes);
			}
			System.out.println("\n========================================================");
			writer.flush();

		} catch (FileNotFoundException exFNF) {
			System.out.println("File not found!");
		} catch (IOException exIO) {
			System.out.println("IO Exception");
		}

		// 3.1
		// BufferedInputStream(FileInputStream) / BufferedOutputStream(FileOutputStream)
		// Reading byte by byte
		try (InputStream bis = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir") + "/Core/" + "1.txt"));
			 OutputStream bos = new BufferedOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/Core/" + "3_1.txt"))) {

			int oneByte;
			while ((oneByte = bis.read()) != -1) {
				System.out.println(oneByte);
				bos.write(oneByte);
			}
			bos.flush();
			System.out.println("\n========================================================");

		} catch (FileNotFoundException exFNF) {
			System.out.println("File not found!");
		} catch (IOException exIO) {
			System.out.println("IO Exception");
		}

		// 3.2
		// BufferedReader(FileReader) / BufferedWriter(FileWriter)
		// Reading lines using readLine()
		try (BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/Core/" + "1.txt"));
			 BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/Core/" + "3_2.txt")))
//			 PrintWriter writer = new PrintWriter(new FileWriter(System.getProperty("user.dir") + "/Core/" + "3_2.txt")))
		{
			String s;
			while ((s = reader.readLine()) != null) {
				System.out.println(s);
				writer.write(s + "\n"); // newline character needed!
//				writer.println(s);
			}
			writer.flush();
			System.out.println("\n========================================================");

		} catch (FileNotFoundException exFNF) {
			System.out.println("File not found!");
		} catch (IOException exIO) {
			System.out.println("IO Exception");
		}

		// 4.1
		// moved to SerializableTest

		// 5.1
		// Data streams
		System.out.println("------------------------------");
		DataOutput dOut;
		try {
			dOut = new DataOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/Core/" + "5_1.dat"));
			for (int i = 0; i < 10; i++) {
				double d = Math.random();
				dOut.writeDouble(d);
				System.out.println(d);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("------------------------------");
		DataInput din;
		try {
			din = new DataInputStream(new FileInputStream(System.getProperty("user.dir") + "/Core/" + "5_1.dat"));
			for (int i = 0; i < 10; i++) {
				System.out.println(din.readDouble());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
