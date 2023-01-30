package java_gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu {
	
	 // JFrame for the buttons
    JFrame buttonsFrame = new JFrame("Main menu"); {
    buttonsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    buttonsFrame.setSize(500, 250);
    
    // JPanel for buttons
    JPanel buttonsPanel = new JPanel();
    buttonsFrame.add(buttonsPanel);

    // Add the four buttons
    JButton ordreButton = new JButton("Ordre");
    JButton lagerButton = new JButton("Lager");
    JButton kunderButton = new JButton("Kunder");
    JButton økonomiButton = new JButton("Økonomi");
    buttonsPanel.add(ordreButton);
    buttonsPanel.add(lagerButton);
    buttonsPanel.add(kunderButton);
    buttonsPanel.add(økonomiButton);

    // Show the buttons frame
    buttonsFrame.setVisible(true);
    
    // ActionListener for the order button
    ordreButton.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    	
    		if(e.getSource()==ordreButton) {
    			order orderPage = new order();
    		}
    	}
    	
    });
    }
}
