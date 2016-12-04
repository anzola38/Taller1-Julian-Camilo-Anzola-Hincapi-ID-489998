/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Uniminuto(Bogota- Colombia)
 * Departamento de Ingenieria de Sistemas 
 * Licenciado bajo el esquema Academic Free License 
 *
 * Taller Objetos Applets
 * Ejercicio: Metodos De Ordenamientos
 * Autor: Julian camilo anzola - 31/11/2016
  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Applet extends JApplet {
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * Es el panel que ordena un conjunto de numeros
	 */
	private PanelLeerTexto panelusuario;
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Sirve para construir el applet
	 */
	public void init() {

		panelusuario = new PanelLeerTexto(this);

		setSize(500, 150);

		add(panelusuario);

	}

	/**
	 * Este metodo envia el conjunto de numeros ingresados a los diferentes
	 * metodos de ordenamiento para ser ordenados y posteriormente los envia al
	 * panel para ser impreso <b>pre:</b>para que los datos puedan ser enviados
	 * a organizar tienen que contener el conjunto de numeros y el metodo con el
	 * cual se desea ordenar <br>
	 * <b>post:</b>se a enviado los datos a ordenar a los metodos de
	 * ordenamiento y se a impreso los numeros ordenados en el panel<br>
	 * 
	 * @param numeros
	 *            conjunto de numeros ingresados por el ususario
	 * @param index
	 *            metodo de ordenamiento seleccionado
	 * @param numeros2
	 *            conjunto de numeros ingresador por el usuario es exclusiovo
	 *            para el radixor
	 */

	public void Ordenar(int[] numeros, int index, String[] numeros2) {

		RadixSort radixsort = new RadixSort();

		Ordenamiento ordenamiento=new Ordenamiento();
		
		if (index == 0) {

			panelusuario.imprimir(ordenamiento.Bubble_sort(numeros));

		} else {

			if (index == 1) {

				panelusuario.imprimir2(radixsort.Radix_sort(numeros2));

			} else {

				if (index == 2) {

					panelusuario.imprimir(ordenamiento.Merge_sort(numeros));

				} else {

					if (index == 3) {

						panelusuario.imprimir(ordenamiento.sort(numeros));

					} else {

						if (index == 4) {

							panelusuario.imprimir(ordenamiento.Counting_sort(numeros));

						}

					}

				}

			}

		}

	}

	/**
	 * Este metodo llama al metodo leer archivo de la clase archivo para que el
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
	 * guarda los numeros ordenados <b>pre:</b>para que los datos puedan ser
	 * guardados los numeros tienen que ser ordenados previamente y se guarda en
	 * un archivo de texto plano (txt)<br>
	 * <b>post:</b>se a guardado los numeros ordenados en un archivo de texto
	 * plano<br>
	 * 
	 * @param informacion
	 *            los numeros ordenados
	 * @return retorna el mensaje de confirmacion o los posibles errores que
	 *         puedan suceder a la hora de guardar los numeros ordenados
	 */

	public String guardar(String numeros_a_ordenar) {

		Archivo archivo = new Archivo();

		return archivo.guardarArchivo(numeros_a_ordenar);

	}

}
