import java.util.Iterator;
import java.util.Random;

public class CFil extends Thread {
	
	private String nombre;
	private long temporizacion;
	
	public CFil (String str) {
		this.nombre = str;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setTemporizador(long Temporizacion) {
		this.temporizacion = Temporizacion;
	}
	 @Override
	public void run() {
		 
		try {
			sleep(temporizacion);
			System.out.println(getNombre());
		}catch(Exception e) {
			System.out.println(e);
		}
			
	}
}
