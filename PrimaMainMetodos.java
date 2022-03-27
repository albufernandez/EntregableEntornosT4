package EntregableEntT4;
import java.util.Scanner;


/**
 * <h1>Calculo de prima de empleados</h1>
* <h3>Clase que calcula y asigna primas <em>{P1,P2,P3 o P4}</em> a un conjunto de empleados (insertados por teclado)
* de una empresa en funcion de unos parametros.</h3>
* @author Alba Fernandez Prieto
* @version 0.1, 27/03/2022
*/
public class PrimaMainMetodos {

	
	/**variable teclado para la entrada de los datos que el usuario inserta
	 */
	static Scanner  teclado=new Scanner(System.in);

	
	/**
	* Metodo main que ejecuta el programa, este va a pedirnos que insertemos los datos de los empleados 
	* llamando a otros metodos y nos preguntará si queremos introducir más emmpleados llamando también a otros métodos
	*/
	public static void main(String[] args) {
		
		//Campos de la clase
		int numEmple;		//numero del empleado
		String nomEmple;	//nombre del empleado
		int meses;			//meses de antiguedad en la empresa
		char esDirectivo;	//variable para saber si un empleado es directivo
		char respuesta;		//respuesta a la pregunta de si queremos insertar más empleados
		
		//llama a los metodos de la clase para asignar los valores introducidos a los campos de la clase
		do {
			System.out.println("\nDATOS  EMPLEADO/A");
			numEmple=leerNumEmple();
			nomEmple=leerNomEmple();
			meses=leerMeses();
			esDirectivo=leerEsDirectivo();
			//Imprime la prima correspondiente a ese empleado
			System.out.println("\n\tLe corresponde la prima "+hallarPrima(esDirectivo, meses));
			
			//Pregunta si se quiere introducir más empleados
			System.out.println("\nÂ¿CALCULAR MAS PRIMAS? (S/N): ");
			respuesta=teclado.nextLine().toUpperCase().charAt(0);
			//Si se introduce 'S' vuelve a entrar al bucle
		}while(respuesta=='S');
		
	}

	/**
	* Metodo que halla la prima de el empleado en funcion de los meses que este lleve en la empresa y si es directivo o no
	* @param esDirectivo determina si el empleado es directivo ('+') o si no lo es ('-')
	* @param meses meses de antiguedad del empleado en la empresa
	* @return <ul> <li>P1 si es directivo con 12 o mas meses de antiguedad</li>
	* <li>P2 si es directivo con menos de 12 meses de antiguedad</li>
	* <li>P3 si no es directivo y tiene 12 o mas meses de antiguedad</li>
	* <li>P4 si no es directivo y tiene menos de 12 meses de antiguedad</li>
	* </ul>
	*/
	public static String hallarPrima(char esDirectivo, int meses) {
		if(esDirectivo=='+') // ES DIRECTIVO
			if(meses>=12)
				return "P1";
			else
				return "P3";
		else 	// NO ES DIRECTIVO
			if(meses>=12)
				return "P2";
			else
				return "P4";
	}

	
	/**
	* Metodo que nos permite insertar un valor por pantalla para la variable numEmple teniendo que estar esta entre los valores 100 y 999
	* @return numEmple (entero con valor entre 100 y 999, es el codigo del empleado)
	*/
	public static int leerNumEmple() {		
		int numEmple;
		do{
			System.out.println("NÃšMERO [100-999]: ");
			numEmple = teclado.nextInt();
		//comprueba que el valor insertado no sea menor a 100 ni mayor a 999, en caso de que se salga de ese rango vuelve a ejecutar el bucle
		}while(numEmple<100 || numEmple>999);		
		teclado.nextLine();
		return numEmple;
	}
	
	/**
	* Metodo que nos permite insertar un valor por pantalla para la variable nomEmple teniendo que ser un valor alfanumerico de un
	* máximo de 10 caracteres
	* @return nomEmple (cadena con una longitud de 10 o menos caracteres)
	*/
	public static String leerNomEmple() {
		String nomEmple;
		do {
			System.out.println("NOMBRE (max 10 caracteres): ");
			nomEmple = teclado.nextLine();
		//comprueba que la longitud del nombre insertado no supera los 10 caracteres, en caso de ser mayor vuelve a ejecutar el bucle
		}while(nomEmple.length()>10);		
		return nomEmple;
	}
	
	/**
	* Metodo que nos permite insertar un valor por pantalla para la variable meses teniendo que ser un numero con un valor positivo
	* @return meses (numero entero, meses de antiguedad del empleado en la empresa)
	*/
	public static int leerMeses() {
		int meses;
		do {
			System.out.println("MESES DE TRABAJO: ");
			meses = teclado.nextInt();
		//Comprueba que los meses introducidos no sean menor a 0, en caso de ser inferior vuelve a ejecutar el bucle
		}while(meses<0);
		teclado.nextLine();
		return meses;
	}
	
	/**
	* Metodo que nos permite identificar si un empleado es directo o no es directivo usando los caracteres '+' para directivos y 
	* '-' para los no directivos
	* @return <ul> <li> '+' si es directivo</li>
	* <li>'-' si no es directivo</li>
	* </ul>
	*/
	public static char leerEsDirectivo() {
		char esDirectivo;
		do {
			System.out.println("Â¿ES DIRECTIVO? (+/-): ");
			esDirectivo = teclado.nextLine().charAt(0);
		//Comprueba que los valores insertados sean '+' o '-', en caso de ser otro vulve a ejecutar el bucle
		}while(esDirectivo!='+' && esDirectivo!='-');
		return esDirectivo;
	}
}