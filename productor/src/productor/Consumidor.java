package productor;

import java.util.concurrent.Semaphore;

public class Consumidor extends Thread
{
	buffer buffer;
	String nombre;
	Semaphore semaforo;
	
	public Consumidor(String nombre ,buffer buffer, Semaphore semaforo)
	{
		this.semaforo = semaforo;
		this.nombre = nombre;
		this.buffer = buffer;
	}
	public void run()
	{
		while(true)
		{
			try
			{
				semaforo.acquire();
				
				System.out.print(nombre + " ");
				buffer.SACAR();
				semaforo.release();
				
				sleep(900);	
	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
