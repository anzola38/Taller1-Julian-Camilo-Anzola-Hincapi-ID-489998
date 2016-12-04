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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Archivo {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	
	/**
	 * Es el objeto utlizado para buscar la ruta del texto plano que deseamos
	 * leer
	 */
	private JFileChooser text;
	/**
	 * Es el objeto utilizado para obtener el texto plano que deseamos leer
	 */
	private File leerarchivo;
	/**
	 * Es el objeto que permite leer el texto plano
	 */
	private FileReader archivos;
	/**
	 * Es el objeto que permite leer el interior del texto plano
	 */
	private BufferedReader lee;
	/**
	 * Es el objeto que permite escribir en un archivo de texto plano
	 */
	private FileWriter guardar;
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Sirve para inicializar JFileChooser
	 */
	
	public Archivo() {

		text = new JFileChooser();
	}

	/**
	 * Este metodo guarda los numeros ordenados en un texto plano
	 * <b>pre:</b>para que los datos puedan ser guardados los numeros tienen que
	 * ser ordenados previamente<br>
	 * <b>post:</b>se a guardado los numeros ordenados en un archivo de texto
	 * plano<br>
	 * 
	 * @param numeros_ordenados
	 *            los numeros ordenados a guardar
	 * @return retorna el mensaje de confirmacion o los posibles errores que
	 *         puedan suceder a la hora de guardar los numeros ordenados
	 */

	public String guardarArchivo(String numeros_ordenados) {

		String mensaje = "";

		try {

			text = new JFileChooser();

			if(text.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

				leerarchivo = text.getSelectedFile();

				guardar = new FileWriter(leerarchivo + ".txt");

				guardar.write(numeros_ordenados);

				guardar.close();

				numeros_ordenados = "se a almacenado la informacion";

				return numeros_ordenados;
				
			}

		} catch (Exception error) {

			numeros_ordenados = "-------------------------ERROR-------------------  \n" + error;

			return numeros_ordenados;

		}
		return "No se a guardado la informacion";

	}

	/**
	 * Este metodo lee el archivo que el usuario selecciona <b>pre:</b>Para que
	 * los datos puedan ser leidos el usuario tiene que seleccionar el archivo
	 * de texto plano que desea leer<br>
	 * <b>post:</b>se a leido el archivo de texto plano o se a enviado los
	 * mensaje de errores que sucedieron<br>
	 * 
	 * @return retorna una String donde se encuantra el archivo leido o un
	 *         mensaje con los errores que sucedieron en el proceso de lectura
	 */

	public String leerArchivo() {

		String aux = "";

		String copia = "";

		String error = "----------------ERROR--------------";

		try {

			text = new JFileChooser();
			
			if(text.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	
				leerarchivo = text.getSelectedFile();

				archivos = new FileReader(leerarchivo);

				lee = new BufferedReader(archivos);

				while ((aux = lee.readLine()) != null) {//se copia lo que se encuentra en el texto plano a una String para ser impresa

					copia = copia + aux;

				}

				lee.close();

				return copia;
				
			}
	
		} catch (Exception e) {

			error = "----------------ERROR--------------" + e;

			return error;

		}
		return "No se a seleccionado el archivo";

	}

}
