package productor;

import javax.swing.JTextField;

public class buffer
{
	char[] contenedor = new char[20];
	int contador = 0;
	JTextField tf;
	
	public buffer(JTextField tf)
	{
		this.tf = tf;
	}
	
	public void SACAR()
	{
		if(contador == 0)
		{
			System.out.println("Buffer vacio");
		}
		else
		{
			System.out.println(contenedor[contador - 1]);
			contenedor[contador - 1] = ' ';
			contador--;
			
			tf.setText("");
			for(int i = 0; i < contador; i++) {
				tf.setText(tf.getText() + contenedor[i]);
			}
			
			
		}
	}
	public void PONER(char caracter)
	{
		if(contador == 20)
		{
			System.out.println("Buffer lleno");
		}
		else
		{
			System.out.println(caracter);
			contenedor[contador] = caracter;
			contador++;
			
			tf.setText("");
			for(int i = 0; i < contador; i++) {
				tf.setText(tf.getText() + contenedor[i]);
			}
		}
	}
}

