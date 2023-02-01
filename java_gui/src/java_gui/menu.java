package java_gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu {
	
	 // JFrame for the buttons
    JFrame buttonsFrame = new JFrame("Main menu"); {
    buttonsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    buttonsFrame.setSize(500, 250);
    
    // JPanel for the buttons
    JPanel buttonsPanel = new JPanel();
    buttonsFrame.add(buttonsPanel);

    // Adding the four buttons
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
    			Order orderPage = new Order();
    		}
    	}
    	
    });
    
    kunderButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==kunderButton) {
                Customers customerPage = new Customers();
                JFrame customersFrame = new JFrame("Customers");
                customersFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                customersFrame.setSize(800, 400);

                JPanel customersPanel = new JPanel();
                customersFrame.add(customersPanel);

                ArrayList<Customer> customerList = customerPage.getCustomers();
                for (Customer c : customerList) {
                    JLabel nameLabel = new JLabel(c.getName());
                    JLabel customerNumberLabel = new JLabel(Integer.toString(c.getCustomerNumber()));
                    JLabel phoneNumberLabel = new JLabel(c.getPhoneNumber());
                    JLabel addressLabel = new JLabel(c.getAddress());
                    JLabel zipCodeLabel = new JLabel(c.getZip());
                    JLabel cityLabel = new JLabel(c.getCity());

                    customersPanel.add(nameLabel);
                    customersPanel.add(customerNumberLabel);
                    customersPanel.add(phoneNumberLabel);
                    customersPanel.add(addressLabel);
                    customersPanel.add(zipCodeLabel);
                    customersPanel.add(cityLabel);
                }

                customersFrame.setVisible(true);
            }
        }
    });

    }
}
