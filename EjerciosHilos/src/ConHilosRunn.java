
public class ConHilosRunn implements Runnable{
	String atributo; 
	public ConHilosRunn(int i) {
		atributo = "algo " + i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 4; i++) {
			Thread ch = new Thread(new ConHilosRunn(i));
			ch.start();
		}
	}
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i + " : " + atributo);
		}
		
	}
}
