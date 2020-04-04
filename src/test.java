import java.io.*;

public class test {
	public static void main(String[] args) throws Exception {
		try {
			student fred = new student("admin", "admin");
			student bob = new student("bob", "Glasgow");
			student fs = new student("ds", "fads");
			FileOutputStream fos = new FileOutputStream("userinfo.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(fred);
			oos.writeObject(bob);
			oos.writeObject(fs);
			oos.close();
			FileInputStream fis = new FileInputStream("userinfo.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			student obj = null;

			while ((obj = (student) ois.readObject()) != null) {
				System.out.println("username:" + obj.getUsername() + ", password:" + obj.getPassword());
			}
			ois.close();
		} catch (EOFException ex) { // This exception will be caught when EOF is reached
			System.out.println("End of file reached.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

