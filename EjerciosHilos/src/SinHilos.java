
public class SinHilos {
	String atributo; 
	public SinHilos(int i) {
		atributo = "algo " + i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 4; i++) {
			SinHilos sh = new SinHilos(i);
			sh.run();
		}
	}
	private void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i + " : " + atributo);
		}
		
	}

}
