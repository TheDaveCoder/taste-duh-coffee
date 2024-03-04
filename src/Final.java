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

public class Final extends JFrame {
	
	
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
		
		JPanel logo_panel1 = new JPanel();
		logo_panel1.setBackground(Color.GRAY);
		logo_panel1.setBounds(0, 0, 395, 561);
		Register_panel.add(logo_panel1);
		
		JPanel reg_panel = new JPanel();
		reg_panel.setBackground(Color.WHITE);
		reg_panel.setBounds(394, 0, 390, 561);
		Register_panel.add(reg_panel);
		reg_panel.setLayout(null);
		
		JLabel register_lbl = new JLabel("REGISTER");
		register_lbl.setFont(new Font("Tahoma", Font.BOLD, 40));
		register_lbl.setBounds(95, 95, 213, 84);
		reg_panel.add(register_lbl);
		
		JLabel reg_user = new JLabel("Username");
		reg_user.setFont(new Font("Tahoma", Font.PLAIN, 15));
		reg_user.setBounds(37, 281, 73, 25);
		reg_panel.add(reg_user);
		
		reg_user_input = new JTextField();
		reg_user_input.setBounds(37, 317, 323, 25);
		reg_panel.add(reg_user_input);
		reg_user_input.setColumns(10);
		
		JLabel reg_pass = new JLabel("Password");
		reg_pass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		reg_pass.setBounds(37, 353, 73, 25);
		reg_panel.add(reg_pass);
		
		
		Login_panel.setBounds(0, 0, 784, 561);
		contentPane.add(Login_panel);
		Login_panel.setLayout(null);
		
		Register_panel.setVisible(false);
		
		JPanel logo_panel = new JPanel();
		logo_panel.setBackground(Color.LIGHT_GRAY);
		logo_panel.setBounds(0, 0, 396, 561);
		Login_panel.add(logo_panel);
		logo_panel.setLayout(null);
		
		JPanel login_panel = new JPanel();
		login_panel.setBounds(393, 0, 391, 561);
		Login_panel.add(login_panel);
		login_panel.setBackground(Color.WHITE);
		login_panel.setLayout(null);
		
		JLabel welcome = new JLabel("WELCOME");
		welcome.setBounds(94, 109, 214, 50);
		welcome.setFont(new Font("Tahoma", Font.BOLD, 40));
		login_panel.add(welcome);
		
		JLabel user_lbl = new JLabel("Username");
		user_lbl.setBounds(37, 215, 73, 25);
		user_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		login_panel.add(user_lbl);
		
		user_input = new JTextField();
		user_input.setBounds(37, 251, 323, 25);
		login_panel.add(user_input);
		user_input.setColumns(10);
		
		JLabel pass_lbl = new JLabel("Password");
		pass_lbl.setBounds(37, 287, 73, 25);
		pass_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		login_panel.add(pass_lbl);
		
	
		
		JButton login = new JButton("Login");
		login.setBounds(149, 387, 89, 23);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 	String username = user_input.getText();
				 	String password = pass_input.getText();
	                if(AccountManager.checkForMatch(username, password.toString())) {
			            System.out.println("account already exists!");
			            frame.setVisible(false);
			            coffeeshop coffee = new coffeeshop(AccountManager.getUserByUsername(username));
                                    coffee.setExtendedState(MAXIMIZED_BOTH);
			            coffee.setVisible(true);
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
		no_acc.setBounds(63, 452, 164, 14);
		no_acc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		login_panel.add(no_acc);
		
		JButton register = new JButton("Register");
		register.setBounds(237, 448, 89, 23);
		register.setFont(new Font("Tahoma", Font.PLAIN, 15));
		login_panel.add(register);
		register.addActionListener(new ActionListener() { // register action
			public void actionPerformed(ActionEvent e) {
				
				login_panel.setVisible(false);
				Register_panel.setVisible(true);
			}});
		JButton register_btn = new JButton("Register");
		
		register_btn.setBounds(151, 463, 89, 23);
		reg_panel.add(register_btn);
		
		reg_lastname_input = new JTextField();
		reg_lastname_input.setBounds(37, 245, 323, 25);
		reg_panel.add(reg_lastname_input);
		reg_lastname_input.setColumns(10);
		
		JLabel reg_lastname = new JLabel("User's Lastname");
		reg_lastname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		reg_lastname.setBounds(37, 209, 119, 25);
		
		reg_panel.add(reg_lastname);
		
		reg_password_input = new JPasswordField();;
		reg_password_input.setBounds(37, 389, 323, 25);
		reg_panel.add(reg_password_input);
		reg_password_input.setColumns(10);
		register_btn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String lastname = reg_lastname_input.getText();
		        String username = reg_user_input.getText();
		        String password = reg_password_input.getText();
				AccountManager.recordNewUser(lastname, username, password);
				System.out.println(password);
				login_panel.setVisible(true);
				Register_panel.setVisible(false);
		    }
		});
		pass_input = new JPasswordField();
		pass_input.setBounds(37, 317, 323, 25);
		login_panel.add(pass_input);
	}
}
