package productor;

import java.util.concurrent.Semaphore;

public class Productor extends Thread
{
	buffer buffer;	
	String nombre;
	Semaphore semaforo;
	
	public Productor(String nombre, buffer buffer, Semaphore semaforo)
	{
		this.buffer=buffer;
		this.nombre = nombre;
		this.semaforo = semaforo;
	}
	
	public void run()
	{
		while(true) {
			char caracter = (char)(Math.random() * 26);
			caracter += 'a';
			
			try
			{
				semaforo.acquire();
				
				System.out.print(nombre + "  ");
				buffer.PONER(caracter);
				
				semaforo.release();
				
				sleep(800);
			}catch(InterruptedException e) {			
			}
		}
	}
}
