/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Uniminuto(Bogota- Colombia)
 * Departamento de Ingenieria de Sistemas 
 * Licenciado bajo el esquema Academic Free License 
 *
 * Taller Objetos Applets
 * Ejercicio: Dibujar Figuras En 2D
 * Autor: Julian camilo anzola - 31/11/2016
  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PanelDibujo extends JPanel implements MouseListener,ActionListener{

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
     * Es una referencia a la ventana principal del applet
     */
	private Applet applet;
	
	//----------------------------------------------------------
	/**
	 * se utiliza para obtener los colores de forma aleatoria
	 */
	private Random colores;
	
	//----------------------------------------------------------------------------------
    // Elementos de la interfaz
    //----------------------------------------------------------------------------------
	
	/**
     * Es la barra de soporte que permite agregar la pestaña opciones
     */
	private JMenuBar jmbsoporte;
	
	//------------------------------------------------------------
	
	/**
     * Es la pestaña que permite agregar las opciones de limpiar y salir
     */
	private JMenu jmopciones;
	
	//-----------------------------------------------------------
	
	/**
     * Es la opcion que permite limpiar el panel
     */
	private JMenuItem jmilimpiar;
	/**
     * Es la opcion que permite cerrar el programa
     */
	private JMenuItem jmisalir;
	
	//-----------------------------------------------------------
	
	/**
     * Comando limpiar
     */
	public static final String limpiar="limpiar";
	/**
     * Comando salir
     */
	public static final String salir="salir";
	
	//-----------------------------------------------------------
	
	/**
     * Es la opcion de que desea dibujar el usuario
     */
	private JComboBox jcfiguras;
	
	//-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
	
	/**
	 * Crea el panel PanelDibujol con el applet
	 *
	 * @param applet
	 *            Ventana principal. v != null.
	 */
	
	public PanelDibujo(Applet applet){
		
		//----------------------------------------------------------
		
		this.applet=applet;
		this.setLayout(new BorderLayout());
		
		addMouseListener(this);
		
		//----------------------------------------------------------
		
		
		jmbsoporte=new JMenuBar();
		
		jmopciones=new JMenu("Opciones");
		jmilimpiar=new JMenuItem("Limpiar");
		
		jmisalir=new JMenuItem("Salir");
		jcfiguras=new JComboBox();
		
		//-----------------------------------------------------------
		
		jmopciones.add(jmilimpiar);
		jmopciones.add(jmisalir);
		
		jmbsoporte.add(jmopciones);
		jcfiguras.addItem("Cuadrado");
		
		jcfiguras.addItem("Triangulo");
		jcfiguras.addItem("Circulo");
		
		jcfiguras.addItem("Rombo");
		
		//----------------------------------------------------------
		
		jmilimpiar.addActionListener(this);
		jmilimpiar.setActionCommand(limpiar);
		
		jmisalir.addActionListener(this);
		jmisalir.setActionCommand(salir);
		
		//-----------------------------------------------------------
		
		add(jmbsoporte,BorderLayout.NORTH);
		add(jcfiguras,BorderLayout.EAST);
		
		//------------------------------------------------------------
		
	}

	/**
	 * Este metodo se activa cuando se hace click en alguna
	 * parte del panel
	 *
	 * @param e
	 *            Es el evento del click sobre el panel
	 */
	
	public void mouseClicked(MouseEvent e) {
		
		colores=new Random();//genera los colores de forma aleatoria
		
		int x=e.getX();//se obtiene la coordenada x del panel donde se hizo click 
		
		int y=e.getY();//se optiene la coordenada y del panel donde se hizo click
		
		Graphics g=getGraphics();
		
		g.setColor(new Color(colores.nextInt(255),colores.nextInt(255),colores.nextInt(255)));//se le asigna el color a el Graphics
		
		if(jcfiguras.getSelectedIndex()==0){//condicional para identificar si se quiere dibujar un cuadrado
		
			g.fillRect(x-50, y-50, 100, 100);
			
		}else{
			
			if(jcfiguras.getSelectedIndex()==1){//condicional para identificar si se quiere dibujar un triangulo
				
				g.drawLine(x, y-50, x+50, y+50);
				
				g.drawLine(x, y-50, x-50, y+50);
				
				g.drawLine(x-50, y+50, x+50, y+50);
				
			}else{
				
				if(jcfiguras.getSelectedIndex()==2){//condicional para identificar si se quiere dibujar un circulo
				
					g.fillOval(x-50, y-50, 100, 100);
					
				}else{
					
					if(jcfiguras.getSelectedIndex()==3){//condicional para identificar si se quiere dibujar un rombo
						
						g.drawLine(x, y-50, x+30, y);
						
						g.drawLine(x, y-50, x-30, y);
						
						g.drawLine(x+30, y, x, y+50);
	
						g.drawLine(x-30, y, x, y+50);
						
					}else{
						
						
					}
					
				}
				
			}
			
			
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Este motodo ejecuta las acciones adecuadas segun el boton que haya sido
	 * presionado
	 *
	 * @param e
	 *            Es el evento del click sobre el boton
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		
		if(comando.equals(salir)){
			
			System.exit(0);//cierra el programa
			
		}else{
			
			if(comando.equals(limpiar)){
				
				repaint();//limpia el panel
				
			}
			
		}
		
	}
	
}
