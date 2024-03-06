import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Services.AccountManager;
import coffee.coffeeshop;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Final extends JFrame {
	
	private static final String HASH_ALGORITHM = "SHA-256";
	static String endpoint = "database-1.cl85pye4up69.ap-southeast-1.rds.amazonaws.com";
	static String port = "3306";
	static String DBIdentifier = "point-of-system";
	static String masterUsername = "sf_app_admin";
	static String masterPassword = "davePogi123";

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://" + endpoint + ":" + port + "/" + DBIdentifier;
		return DriverManager.getConnection(url, masterUsername, masterPassword);
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel Login_panel = new JPanel();
	private JTextField user_input;
	private JTextField pass_input;
	
    private JTextField reg_user_input;
    private JTextField reg_lastname_input;
    private JTextField reg_password_input;
    public static Final frame = new Final();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	public Final() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Register_panel = new JPanel();
		Register_panel.setBounds(0, 0, 784, 561);
		contentPane.add(Register_panel);
		Register_panel.setLayout(null);
		
		JPanel reg_panel = new JPanel();
		reg_panel.setBackground(new Color(222, 184, 135));
		reg_panel.setBounds(394, 0, 390, 561);
		Register_panel.add(reg_panel);
		reg_panel.setLayout(null);
		
		JLabel register_lbl = new JLabel("REGISTER");
		register_lbl.setForeground(new Color(255, 250, 250));
		register_lbl.setFont(new Font("Tahoma", Font.BOLD, 40));
		register_lbl.setBounds(95, 95, 213, 84);
		reg_panel.add(register_lbl);
		
		JLabel reg_user = new JLabel("Username");
		reg_user.setForeground(new Color(255, 250, 250));
		reg_user.setFont(new Font("Tahoma", Font.PLAIN, 15));
		reg_user.setBounds(37, 281, 73, 25);
		reg_panel.add(reg_user);
		
		reg_user_input = new JTextField();
		reg_user_input.setBounds(37, 317, 323, 25);
		reg_panel.add(reg_user_input);
		reg_user_input.setColumns(10);
		
		JLabel reg_pass = new JLabel("Password");
		reg_pass.setForeground(new Color(255, 250, 250));
		reg_pass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		reg_pass.setBounds(37, 353, 73, 25);
		reg_panel.add(reg_pass);
		
		
		Login_panel.setBounds(0, 0, 784, 561);
		contentPane.add(Login_panel);
		Login_panel.setLayout(null);
		
		Register_panel.setVisible(false);
		
		JPanel login_panel = new JPanel();
		login_panel.setBounds(393, 0, 391, 561);
		Login_panel.add(login_panel);
		login_panel.setBackground(new Color(102, 51, 0));
		login_panel.setLayout(null);
		
		JLabel welcome = new JLabel("LOGIN");
		welcome.setForeground(new Color(255, 255, 255));
		welcome.setBounds(129, 110, 145, 50);
		welcome.setFont(new Font("Tahoma", Font.BOLD, 40));
		login_panel.add(welcome);
		
		JLabel user_lbl = new JLabel("Username");
		user_lbl.setForeground(new Color(255, 255, 255));
		user_lbl.setBounds(37, 215, 73, 25);
		user_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		login_panel.add(user_lbl);
		
		user_input = new JTextField();
		user_input.setBounds(37, 251, 323, 25);
		login_panel.add(user_input);
		user_input.setColumns(10);
		
		JLabel pass_lbl = new JLabel("Password");
		pass_lbl.setForeground(new Color(255, 255, 255));
		pass_lbl.setBounds(37, 287, 73, 25);
		pass_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		login_panel.add(pass_lbl);
		
	
		
		JButton login = new JButton("Login");
		login.setForeground(new Color(102, 51, 0));
		login.setBorderPainted(false);
		login.setBackground(new Color(255, 255, 255));
		login.setBounds(149, 387, 89, 23);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 	String username = user_input.getText();
				 	String password = pass_input.getText();
	                if(AccountManager.checkForMatch(username, password)) {
			            coffeeshop coffee = new coffeeshop(AccountManager.getUserByUsername(username));
                                    coffee.setExtendedState(MAXIMIZED_BOTH);
			            coffee.setVisible(true);
			            System.out.println(password.toString());
			            } 
	                else {
						JOptionPane.showMessageDialog(null, "Incorrect username or password!");
			        }
       
				login_panel.repaint();
			}

		});
		login.setFont(new Font("Tahoma", Font.PLAIN, 15));
		login_panel.add(login);
		
		JLabel no_acc = new JLabel("Don't have an account?");
		no_acc.setForeground(new Color(255, 255, 255));
		no_acc.setBounds(63, 452, 164, 14);
		no_acc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		login_panel.add(no_acc);
		
		JButton register = new JButton("Register");
		register.setForeground(new Color(102, 51, 0));
		register.setBorderPainted(false);
		register.setBackground(new Color(255, 255, 255));
		register.setBounds(237, 448, 89, 23);
		register.setFont(new Font("Tahoma", Font.PLAIN, 15));
		login_panel.add(register);
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				login_panel.setVisible(false);
				Register_panel.setVisible(true);
			}});
		JButton register_btn = new JButton("Register");
		register_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		register_btn.setBorderPainted(false);
		register_btn.setBackground(new Color(184, 134, 11));
		register_btn.setForeground(new Color(255, 250, 250));
		
		register_btn.setBounds(129, 463, 127, 37);
		reg_panel.add(register_btn);
		
		reg_lastname_input = new JTextField();
		reg_lastname_input.setBounds(37, 245, 323, 25);
		reg_panel.add(reg_lastname_input);
		reg_lastname_input.setColumns(10);
		
		JLabel reg_lastname = new JLabel("User's Lastname");
		reg_lastname.setForeground(new Color(255, 250, 250));
		reg_lastname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		reg_lastname.setBounds(37, 209, 119, 25);
		
		reg_panel.add(reg_lastname);
		
		reg_password_input = new JPasswordField();;
		reg_password_input.setBounds(37, 389, 323, 25);
		reg_panel.add(reg_password_input);
		reg_password_input.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("taste-duh-coffee/src/Images/tesda.png"));
		lblNewLabel.setBounds(0, 0, 397, 561);
		Register_panel.add(lblNewLabel);
		register_btn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String lastname = reg_lastname_input.getText();
		        String username = reg_user_input.getText();
		        String password = reg_password_input.getText();
		        System.out.println(password);
				AccountManager.recordNewUser(lastname, username, password);
				login_panel.setVisible(true);
				Register_panel.setVisible(false);
			
		    }
		});
		pass_input = new JPasswordField();
		pass_input.setBounds(37, 317, 323, 25);
		login_panel.add(pass_input);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("taste-duh-coffee/src/Images/tesda1.png"));
		lblNewLabel_1.setBounds(0, 0, 397, 561);
		Login_panel.add(lblNewLabel_1);
	}
}
