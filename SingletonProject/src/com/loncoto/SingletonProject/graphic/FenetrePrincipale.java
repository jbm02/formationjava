package com.loncoto.SingletonProject.graphic;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.loncoto.SingletonProject.config.ConfigurationManager;

public class FenetrePrincipale extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JLabel label1;
	private JLabel label2;
	private JTextField champs1;
	private JTextField champs2;
	private JButton boutonsave;
	private JButton boutonopen;
	
	public FenetrePrincipale() {
		super(ConfigurationManager.getInstance().getApplicationName() + " : " + "principale");
		label1 = new JLabel("nom application");
		label2 = new JLabel("version application");
		champs1 = new JTextField();
		champs2 = new JTextField();
		
		setLayout(new FlowLayout());
		setSize(400, 300);
		setLocationRelativeTo(null);
		
		add(label1);
		add(champs1);
		add(label2);
		add(champs2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		champs1.setText(ConfigurationManager.getInstance().getApplicationName());
		champs2.setText(ConfigurationManager.getInstance().getApplicationVersion());
		
		boutonsave = new JButton("save config");
		boutonsave.addActionListener(this);
		
		boutonopen = new JButton("nouvelle fenètre");
		boutonopen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FenetrePrincipale f = new FenetrePrincipale();
				f.setVisible(true);
			}
		});
		
		add(boutonsave);
		add(boutonopen);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ConfigurationManager cm = ConfigurationManager.getInstance();
		cm.setApplicationName(champs1.getText());
		cm.setApplicationVersion(champs2.getText());
		
	}
	
	
}
