package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class JanelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldUsuario;
	private JTextField fieldSenha;
	private JButton buttonAutenticar;
	private JButton buttonLimpar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaLogin frame = new JanelaLogin();
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
	public JanelaLogin() {
		setTitle("Tela Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		buttonAutenticar = new JButton("Autenticar");
		panel.add(buttonAutenticar);
		
		buttonLimpar = new JButton("Limpar");
		panel.add(buttonLimpar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(Color.PINK);
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel labelUsuario = new JLabel("Usuário");
		labelUsuario.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_1.add(labelUsuario);
		
		fieldUsuario = new JTextField();
		panel_1.add(fieldUsuario);
		fieldUsuario.setColumns(25);
		
		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_1.add(labelSenha);
		
		fieldSenha = new JTextField();
		panel_1.add(fieldSenha);
		fieldSenha.setColumns(25);
	}

	public JTextField getFieldUsuario() {
		return fieldUsuario;
	}

	public void setFieldUsuario(JTextField fieldUsuario) {
		this.fieldUsuario = fieldUsuario;
	}

	public JTextField getFieldSenha() {
		return fieldSenha;
	}

	public void setFieldSenha(JTextField fieldSenha) {
		this.fieldSenha = fieldSenha;
	}

	public JButton getButtonAutenticar() {
		return buttonAutenticar;
	}

	public void setButtonAutenticar(JButton buttonAutenticar) {
		this.buttonAutenticar = buttonAutenticar;
	}

	public JButton getButtonLimpar() {
		return buttonLimpar;
	}

	public void setButtonLimpar(JButton buttonLimpar) {
		this.buttonLimpar = buttonLimpar;
	}

	public void limpadados() {
		fieldUsuario.setText(null);
		fieldSenha.setText(null);
	}

}
