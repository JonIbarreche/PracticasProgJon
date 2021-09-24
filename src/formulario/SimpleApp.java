package formulario;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clase.Contactos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class SimpleApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	ArrayList<Contactos> Agenda = new ArrayList<Contactos>();

	
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtTwitter;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleApp frame = new SimpleApp();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimpleApp() {
		CrearModelo();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestorDeContactos = new JLabel("GESTOR DE CONTACTOS");
		lblGestorDeContactos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGestorDeContactos.setBounds(47, 28, 239, 33);
		contentPane.add(lblGestorDeContactos);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(46, 102, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(47, 161, 56, 16);
		contentPane.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(47, 222, 56, 16);
		contentPane.add(lblTelefono);
		
		JLabel lblTwitter = new JLabel("Twitter");
		lblTwitter.setBounds(47, 283, 56, 16);
		contentPane.add(lblTwitter);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(136, 99, 116, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(136, 158, 116, 22);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(136, 219, 116, 22);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtTwitter = new JTextField();
		txtTwitter.setBounds(136, 280, 116, 22);
		contentPane.add(txtTwitter);
		txtTwitter.setColumns(10);
		
		

		JButton btnGrabar = new JButton("GRABAR");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a = txtNombre.getText();
				String b = txtApellido.getText();
				String c = txtTelefono.getText();
				String d = txtTwitter.getText();
				
				if (!a.isEmpty()) {
					if (!b.isEmpty()) {
						if (!c.isEmpty()) {
							if (!d.isEmpty()) {
								
								Contactos con = new Contactos(a,b,Integer.parseInt(c),d);
								
								Agenda.add(con);
								
								JOptionPane.showMessageDialog(null, "Contacto se ha grabado con exito!");
								
								txtNombre.setText("");
								txtApellido.setText("");
								txtTelefono.setText("");
								txtTwitter.setText("");

								
								
							} else {
								JOptionPane.showMessageDialog(null, "Rellena el campo Twitter");
							}
							
						} else {
							JOptionPane.showMessageDialog(null, "Rellena el campo Telefono");
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "Rellena el campo Apellido");
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Rellena el campo Nombre");
				}
				
				
			}
		});
		btnGrabar.setBounds(76, 336, 145, 25);
		contentPane.add(btnGrabar);
		
		table = new JTable();
		table.setBounds(350, 91, 458, 347);
		contentPane.add(table);
		
		JButton btnMostrar = new JButton("MOSTRAR");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object o[] = null;
				for (int i = 0; i < Agenda.size(); i++) {
					Contactos c = (Contactos) Agenda.get(i);
					M.addRow(o);
					M.setValueAt(c.getNombre(), i, 0);
					M.setValueAt(c.getApellido(), i, 1);
					M.setValueAt(c.getTelefono(), i, 2);
					M.setValueAt(c.getTwitter(), i, 3);

				}
				
			}
		});
		btnMostrar.setBounds(350, 54, 97, 25);
		contentPane.add(btnMostrar);
	}
	
	DefaultTableModel M;
	
	private void CrearModelo() {
		
		try {
			M = (new DefaultTableModel(
					null, new String[] {
							"Nombre", "Apellido", "Telefono", "Twitter"}) {

								/**
								 * 
								 */
								private static final long serialVersionUID = 1L;});

			table.setModel(M);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		
	}
	
	
}
