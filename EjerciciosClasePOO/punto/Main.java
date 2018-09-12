/**
 * Ejemplo de como crear un vector de objetos tipo "Punto"
 */
package punto;

import java.util.Scanner;

public class Main {
	public static void main (String [] args){
		Scanner in = new Scanner(System.in);
		
		Punto[] vector = new Punto[10];
		for(int h=0; h<6; h++){
			int i = in.nextInt();
			int j = in.nextInt();
			Punto p = new Punto(i,j);
			vector[h]=p;
		}
		
		System.out.println(vector[1].getX()+","+vector[1].getY());
		System.out.println(vector[2].getX()+","+vector[2].getY());
		System.out.println(vector[3].getX()+","+vector[3].getY());
	}
}