import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Final extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel Login_panel = new JPanel();
	private JTextField user_input;
	private JLabel yey;
	private JPasswordField pass_input;
	
	private String[] usernames = {"user1", "user2", "user3"};
    private String[] passwords = {"pass1", "pass2", "pass3"};
    private JTextField reg_user_input;
    private JPasswordField reg_pass_input;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Final frame = new Final();
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
		register_lbl.setBounds(94, 109, 213, 84);
		reg_panel.add(register_lbl);
		
		JLabel reg_user = new JLabel("Username");
		reg_user.setFont(new Font("Tahoma", Font.PLAIN, 15));
		reg_user.setBounds(37, 215, 73, 25);
		reg_panel.add(reg_user);
		
		reg_user_input = new JTextField();
		reg_user_input.setBounds(37, 244, 323, 25);
		reg_panel.add(reg_user_input);
		reg_user_input.setColumns(10);
		
		JLabel reg_pass = new JLabel("Password");
		reg_pass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		reg_pass.setBounds(37, 287, 73, 25);
		reg_panel.add(reg_pass);
		
		reg_pass_input = new JPasswordField();
		reg_pass_input.setBounds(37, 317, 323, 25);
		reg_panel.add(reg_pass_input);
		
		
		
		
		
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
	                char[] password = pass_input.getPassword();
	                boolean isValidCredentials = CheckInput(username, password);

	                if (isValidCredentials) {	               
	                    yey = new JLabel("Login successful!");
	                } else {
	                    yey = new JLabel("Invalid username or password");
	                }

	                yey.setBounds(167, 501, 200, 14);
	                login_panel.add(yey);
				login_panel.repaint();
			}

			private boolean CheckInput(String username, char[] password) {
				for (int i = 0; i < usernames.length; i++) {
		            if (usernames[i].equals(username) && passwords[i].equals(new String(password))) {
		                return true;
		            }
		        }
				return false;
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
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_panel.setVisible(false);
				Register_panel.setVisible(true);
			}});
		JButton register_btn = new JButton("Register");
		
		register_btn.setBounds(150, 397, 89, 23);
		reg_panel.add(register_btn);
		register_btn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String newUsername = reg_user_input.getText();
		        char[] newPassword = reg_pass_input.getPassword();

		        
		        login_panel.setVisible(true);
		        Register_panel.setVisible(false);
		    }
		});
			
			
			
		
		pass_input = new JPasswordField();
		pass_input.setBounds(37, 317, 323, 25);
		login_panel.add(pass_input);
		
		
		
		
	}
}
