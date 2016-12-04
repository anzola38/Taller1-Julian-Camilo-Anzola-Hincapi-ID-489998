/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Uniminuto(Bogota- Colombia)
 * Departamento de Ingenieria de Sistemas 
 * Licenciado bajo el esquema Academic Free License 
 *
 * Taller Objetos Applets
 * Ejercicio: Estudiante Uniminuto
 * Autor: Julian camilo anzola - 31/11/2016
  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
import javax.swing.JApplet;

public class Applet extends JApplet{
	
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * Es el panel que agrega un nuevo estudiante
	 */
	private PanelCoordinador panelcoordinador;
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Sirve para construir el applet
	 */
	public void init() {

		panelcoordinador = new PanelCoordinador(this);

		setSize(500, 350);

		add(panelcoordinador);
	}

	/**
	 * Este metodo llama a el metodo guardar_estudiante_nuevo de la clase
	 * archivo el cual guarda la informacion de un estudiante en un texto plano
	 * nuevo (nombre,codigo,numero de documento, semestre,fecha de
	 * nacimiento,direccion,telefono,correo) <b>pre:</b>para que los datos
	 * puedan ser guardados el usuario debe de proporcionar
	 * (nombre,codigo,numero de documento, semestre,fecha de
	 * nacimiento,direccion,telefono,correo) y se guarda en un archivo de texto
	 * plano (txt) nuevo<br>
	 * <b>post:</b>se a guardado la informacion que el usuario proporciona en un
	 * archivo de texto plano(txt) nuevo<br>
	 * 
	 * @param nombre
	 *            nombre del estudiante
	 * @param codigo
	 *            codigo del estudiante
	 * @param documento
	 *            numero del documento del estudiante
	 * @param semestre
	 *            semestre que cursa el estudiante
	 * @param nacimiento
	 *            fecha de nacimiento del estudiante
	 * @param dirreccion
	 *            direccion donde vive el estudiante
	 * @param telefono
	 *            telefono del estudiante
	 * @param correo
	 *            correo electronico del estudiante
	 * @return un mensaje de confirmacion o de posibles errores que sucedieron
	 *         en el proceso
	 */

	public String guardar(String nombre, String codigo, String documento, String semestre, String nacimiento,
			String dirreccion, String telefono, String correo) {

		Archivo archivo = new Archivo();

		return archivo.guardar_estudiante_nuevo(nombre, codigo, documento, semestre, nacimiento, dirreccion, telefono,
				correo);

	}

	/**
	 * Este metodo llama a el metodo guardar_estudiante_existente de la clase
	 * archivo el cual guarda la informacion de un estudiante en un texto plano
	 * existente (nombre,codigo,numero de documento, semestre,fecha de
	 * nacimiento,direccion,telefono,correo)<b>pre:</b>para que los datos
	 * puedan ser guardados el usuario debe de proporcionar
	 * (nombre,codigo,numero de documento, semestre,fecha de
	 * nacimiento,direccion,telefono,correo) y se guarda en un archivo de texto
	 * plano existente(txt)<br>
	 * <b>post:</b>se a guardado la informacion que el usuario proporciona en un
	 * archivo de texto plano (txt) existente<br>
	 * 
	 * @param nombre
	 *            nombre del estudiante
	 * @param codigo
	 *            codigo del estudiante
	 * @param documento
	 *            numero del documento del estudiante
	 * @param semestre
	 *            semestre que cursa el estudiante
	 * @param nacimiento
	 *            fecha de nacimiento del estudiante
	 * @param dirreccion
	 *            direccion donde vive el estudiante
	 * @param telefono
	 *            telefono del estudiante
	 * @param correo
	 *            correo electronico del estudiante
	 * @return un mensaje de confirmacion o de posibles errores que sucedieron
	 *         en el proceso
	 */

	public String guardar_existente(String nombre, String codigo, String documento, String semestre, String nacimiento,
			String dirreccion, String telefono, String correo) {

		Archivo archivo = new Archivo();

		return archivo.guardar_estudiante_existente(nombre, codigo, documento, semestre, nacimiento, dirreccion,
				telefono, correo);

	}

	/**
	 * Este metodo llama al metodo buscar de la clase archivo para poder leer el
	 * archivo de los estudiantes y poder realizar la busqueda
	 * 
	 * @return informacion de los estudiantes (nombre,codigo,numero de
	 *         documento, semestre,fecha de
	 *         nacimiento,direccion,telefono,correo)
	 */

	public String[] buscar() {

		Archivo archivo = new Archivo();

		return archivo.buscar();

	}

}
