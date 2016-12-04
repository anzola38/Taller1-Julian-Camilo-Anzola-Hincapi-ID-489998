/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Uniminuto(Bogota- Colombia)
 * Departamento de Ingenieria de Sistemas 
 * Licenciado bajo el esquema Academic Free License 
 *
 * Taller Objetos Applets
 * Ejercicio: Metodos De Busqueda
 * Autor: Julian camilo anzola - 31/11/2016
  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
import javax.swing.JApplet;

public class Applet extends JApplet {
	
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * Es el panel que busca un numero dentro de un conjunto de numeros
	 */
	private PanelPrincipal panelprincipal;
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Sirve para construir el applet
	 */
	public void init() {

		panelprincipal = new PanelPrincipal(this);

		setSize(500, 200);

		add(panelprincipal);

	}

	/**
	 * Este metodo envia el numero que se quiere buscar dentro de un conjunto de
	 * numeros que posteriormente tambien se enviara a los diferentes metodos de
	 * busqueda dependiendo del metodo que el usuario elija <b>pre:</b>Para que
	 * se pueda enviar los datos para realizar la busqueda el usuario tiene que
	 * proporcionar el conjunto de numeros en el cual se va a realizar la busqueda,
	 * el dato que se va a buscar y metodo con el cual desea hacer dicha
	 * busqueda <br>
	 * <b>post:</b>se a enviado los datos para realizar la busqueda
	 * posterioirmente se imprimira en el panel la posicion donde se encuentra
	 * el numero<br>
	 * 
	 * @param index
	 *            metodo de busqueda que el usuario eligio
	 * @param dato
	 *            numero que se quiere buscar
	 * @param numeros
	 *            conjunto de numeros en el cual se va a realizar la busqueda
	 */

	public void busqueda(int index, int dato, int[] numeros) {

		Busqueda busqueda=new Busqueda();
		
		BubbleSort bubblesort = new BubbleSort();

		if (index == 0) {

			panelprincipal.imprimir(busqueda.Binary_search(bubblesort.burbuja(numeros), dato));

			panelprincipal.imprimir2(bubblesort.burbuja(numeros));

		} else {

			if (index == 1) {

				panelprincipal.imprimir(busqueda.Interpolation_search(bubblesort.burbuja(numeros), dato));

				panelprincipal.imprimir2(bubblesort.burbuja(numeros));

			} else {

				if (index == 2) {

					panelprincipal.imprimir(busqueda.Linear_search(bubblesort.burbuja(numeros), dato));

					panelprincipal.imprimir2(bubblesort.burbuja(numeros));
				}

			}

		}

	}
	
	/**
	 * Este metodo llama al metodo leerArchivo de la clase archivo para que el
	 * usuario puede elegir que archivo desea leer <b>pre:</b>para que los datos
	 * puedan ser leidos el usuario tiene que seleccionar el archivo que desea
	 * leer y tiene que ser de tipo texto plano (txt) <br>
	 * <b>post:</b>se a leido el archivo de texto plano<br>
	 * 
	 * @return retorna el archivo leido en una String o los posibles errores que
	 *         sucedieron en el proceso
	 */

	public String leer() {

		Archivo archivo = new Archivo();

		return archivo.leerArchivo();

	}
	
	/**
	 * Este metodo llama a el metodo guardarArchivo de la clase archivo el cual
	 * guarda el conjunto de numeros,guarda el conjunto de numeros ordenados,la
	 * posicion donde se encuentra el numero y el numero que el usuario desea
	 * buscar <b>pre:</b>para que los datos puedan ser guardados los numeros
	 * tienen que ser ordenados previamente y se tiene que proporcionar el
	 * numero que se desea buscar y se guarda en un archivo de texto plano
	 * (txt)<br>
	 * <b>post:</b>se a guardado la informacion que el usuario proporciona en un
	 * archivo de texto (txt) plano<br>
	 * 
	 * @param conjuntonumeros
	 *            conjunto de numeros que se leen o que el usuario ingresa
	 * @param numerosordenados
	 *            conjunto de numeros ordenados
	 * @param numeroingresado
	 *            numero que el usuario desea buscar
	 * @param posicion
	 *            posicion el la que se encuentra el numero buscado
	 * @return retorna el mensaje de confirmacion o los posibles errores que
	 *         ocurran en el proceso de guardado
	 */

	public String guardar(String conjuntonumeros, String numerosordenados, String numeroingresado, String posicion) {

		Archivo archivo = new Archivo();

		return archivo.guardarArchivo(conjuntonumeros, numerosordenados, numeroingresado, posicion);

	}

}
