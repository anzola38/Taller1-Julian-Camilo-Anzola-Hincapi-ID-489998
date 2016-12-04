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
     * Es el objeto que permite escribir en un archivo de texto
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
	 * Este metodo lee el archivo que el usuario selecciona <b>pre:</b>Para que
	 * los datos puedan ser leidos el usuario tiene que seleccionar el archivo
	 * de texto plano que desea leer<br>
	 * <b>post:</b>se a leido el archivo de texto plano o se a enviado los
	 * mensaje de errores que sucedieron<br>
	 * 
	 * @return retorna una String donde se encuantra el archivo leido o un
	 *         mensaje con los errores que sucedieron en el proceso de lectura
	 */
	
	public String leerArchivo(){

		String aux="";
		
		String copia="";
		
		try{
		
			text = new JFileChooser();
			
			if(text.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

				  leerarchivo=text.getSelectedFile();
			
				  archivos=new FileReader(leerarchivo);
				  
				  lee=new BufferedReader(archivos);
				  
				  while((aux=lee.readLine())!=null)//se copia lo que se encuentra en el texto plano a una String para ser impresa
			      {
			    		 copia=copia+aux;
			      }
				  
				  lee.close();
				  
				  return copia;
				
			}
		
		}catch(Exception error){
			
			return "-----------------ERROR----------------"+error;
			
		}
		return "No se a seleccionado ningun archivo";
		
	}

	/**
	 * Este metodo guarda el conjunto de numeros,guarda el conjunto de numeros
	 * ordenados,la posicion donde se encuentra el numero y el numero que el
	 * usuario desea buscar <b>pre:</b>para que los datos puedan ser guardados
	 * el usuario tiene que proporcionar el conjunto de numeros.Los numeros
	 * tiene que estar organizados y tiene que ingresar el numero que desea
	 * buscar<br>
	 * <b>post:</b>se a guardado la informacion que el usuario proporciona en un
	 * archivo de texto plano (txt)<br>
	 * 
	 * @param conjuntonumeros
	 *            conjunto de numeros que se leyeron o que el usuario ingreso
	 * @param numerosordenados
	 *            conjunto de numeros organizados
	 * @param numeroingresado
	 *            numero que el usuario desea buscar
	 * @param posicion
	 *            posicion en la que se encuentra el numero que se busca
	 * @return retorna un mensaje de confirmacion o de posibles errores que
	 *         sucedan en el proceso de guardado
	 */

	public String guardarArchivo(String conjuntonumeros, String numerosordenados, String numeroingresado,
			String posicion) {

		String informacion = "";

		informacion = informacion + "Conjuntos de numeros: " + conjuntonumeros + "  Numeros ordenados: "
				+ numerosordenados + "  El numero ingresaro: " + numeroingresado + "  Posicion en que se encuentra: "
				+ posicion;
		try {

			text = new JFileChooser();
			
			if(text.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

				leerarchivo = text.getSelectedFile();

				guardar = new FileWriter(leerarchivo + ".txt");

				guardar.write(informacion);

				guardar.close();

				return "Se a guardado la informacion con exito";
				
			}

		} catch (Exception error) {

			return "--------------------ERROR-------------" + error;

		}

		return "No se a guardado la informacion";
		
	}

}
