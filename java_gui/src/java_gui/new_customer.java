package java_gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class new_customer {

    private customers customers = new customers();

	JFrame newCustomerFrame = new JFrame("Ny kunde"); {
		newCustomerFrame.setSize(500, 250);

		// JPanel for the buttons
		JPanel newCustomerPanel = new JPanel(new GridLayout(0, 2, 10, 10));
		newCustomerFrame.add(newCustomerPanel);
		
		// JLabels and JFields for the customer information
		JLabel fullNameLabel = new JLabel("Navn:");
		JTextField fullNameField = new JTextField(10);
		JLabel phoneNumberLabel = new JLabel("Telefonnummer:");
		JTextField phoneNumberField = new JTextField(10);
		JLabel addressLabel = new JLabel("Adresse:");
		JTextField addressField = new JTextField(10);
		JLabel zipLabel = new JLabel("Postnummer:");
		JTextField zipField = new JTextField(10);
		JLabel cityLabel = new JLabel("By:");
		JTextField cityField = new JTextField(10);
		JLabel customerNumberLabel = new JLabel("Kundenummer:");
		JTextField customerNumberField = new JTextField(10);
		customerNumberField.setEditable(false);

		JButton addCustomerButton = new JButton("Tilføj kunde");

		newCustomerPanel.add(fullNameLabel);
		newCustomerPanel.add(fullNameField);
		newCustomerPanel.add(phoneNumberLabel);
		newCustomerPanel.add(phoneNumberField);
		newCustomerPanel.add(addressLabel);
		newCustomerPanel.add(addressField);
		newCustomerPanel.add(zipLabel);
		newCustomerPanel.add(zipField);
		newCustomerPanel.add(cityLabel);
		newCustomerPanel.add(cityField);
		newCustomerPanel.add(customerNumberLabel);
		newCustomerPanel.add(customerNumberField);
		newCustomerPanel.add(addCustomerButton);

		newCustomerFrame.setVisible(true);
		
		// ActionListener for the Add Customer button
		addCustomerButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if(e.getSource() == addCustomerButton) {
		            Random random = new Random();
		            int customerNumber = 100000 + random.nextInt(900000);
		            customerNumberField.setText(Integer.toString(customerNumber));
		            int phoneNumber = Integer.parseInt(phoneNumberField.getText());
		            int zipCode = Integer.parseInt(zipField.getText());
		            customers.addCustomer(new Customer(customerNumber, fullNameField.getText(),
		                                                phoneNumber, addressField.getText(),
		                                                zipCode, cityField.getText()));
				}
			}
		});
	}
}
