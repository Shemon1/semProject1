package java_gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class order {

    JFrame orderFrame = new JFrame("Find kunde"); {
        orderFrame.setSize(500, 250);

        // JPanel for the buttons
        JPanel orderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        orderFrame.add(orderPanel);

        JLabel customerNumberLabel = new JLabel("Kundenummer:");
        JTextField customerNumberField = new JTextField(10);
        JLabel phoneNumberLabel = new JLabel("Telefon:");
        JTextField phoneNumberField = new JTextField(10);

        JButton newOrderButton = new JButton("Ny ordre");
        JButton notCustomerButton = new JButton("Opret kunde");

        orderPanel.add(customerNumberLabel);
        orderPanel.add(customerNumberField);
        orderPanel.add(phoneNumberLabel);
        orderPanel.add(phoneNumberField);
        orderPanel.add(notCustomerButton);
        orderPanel.add(newOrderButton);

        orderFrame.setVisible(true);
        
        // ActionListener for the customer button
        notCustomerButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        	
        		if(e.getSource()==notCustomerButton) {
        			new_customer newCustomerPage = new new_customer();
        		}
        	}
        });
    }
}    
