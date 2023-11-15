import java.util.Scanner;

public class CFilPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		CFil hijo;
		CFil padre;
		CFil[] hijos;
		
		
		System.out.println("¿Que desea hacer?  \n - Retrasar hijo -> 1.\n - Acelerar hijo -> 2. \n - Punto 3 -> 3. \n - Escoger cuantos procesos iniciar -> 4");
		String input = sc.nextLine();

		if (input.equals("1")) {
			hijo = new CFil("Hijo 1");
			hijo.start();
			
			padre = new CFil("Padre 1");
			padre.setTemporizador(3000);
			padre.start();
			
		}else if(input.equals("2")) {
			hijo = new CFil("Hijo 2");
			hijo.setTemporizador(3000);
			hijo.start();
			
			padre = new CFil("Padre 2");
			padre.start();
		}else if(input.equals("3")) {
			try {
				hijo = new CFil("Hijo 3");
				hijo.setTemporizador(3000);
				hijo.start();
				
				hijo.join();
				
				padre = new CFil("Padre 3");
				padre.start();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else if(input.equals("4")) {
			System.out.println("Ingrese el número de procesos hijos (Max 10):");
            int numProcesos = sc.nextInt();

            if (numProcesos <= 0 || numProcesos > 11) {
                System.out.println("Número de procesos no válido. Saliendo...");
                System.exit(0);
            }

            hijos = new CFil[numProcesos];

            for (int i = 0; i < numProcesos; i++) {
                hijos[i] = new CFil("Hijo " + (i + 1));
                hijos[i].setTemporizador(1000 * (i + 1));
                hijos[i].start();
            }

            for (CFil _hijo : hijos) {
                try {
                	_hijo.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            padre = new CFil("Padre");
            padre.start();
            try {
                padre.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

	      }

	      sc.close();
	 }
		
}

