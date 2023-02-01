package java_gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.HashMap;
import java.util.Map;

public class Order {

    JFrame orderFrame = new JFrame("Find kunde"); {
        orderFrame.setSize(500, 250);

        // JPanel for the buttons
        JPanel orderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        orderFrame.add(orderPanel);

        JButton newOrderButton = new JButton("Ny ordre");
        newOrderButton.addActionListener(new orderForm().new NewOrderButtonListener());

        JButton notCustomerButton = new JButton("Opret kunde");

        orderPanel.add(notCustomerButton);
        orderPanel.add(newOrderButton);

        orderFrame.setVisible(true);
        
        // ActionListener for the customer button
        notCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource()==notCustomerButton) {
                    NewCustomer newCustomerPage = new NewCustomer();
                    orderForm orderFormInstance = new orderForm();
                    

                }
            }
        });

    }
}    

class orderForm {
    private Map<String, Customer> customers = new HashMap<>();

    public void addCustomer(Customer customer) {
        customers.put(customer.getPhoneNumber(), customer);
        customers.put(String.valueOf(customer.getCustomerNumber()), customer);
    }

    public Customer getCustomer(String searchTerm) {
        Customer customer = customers.get(searchTerm);
        if (customer == null) {
            customer = customers.get(String.valueOf(searchTerm));
        }
        return customer;
    }

    public class NewOrderButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String searchTerm = JOptionPane.showInputDialog("Enter customer number or phone number:");
            Customer customer = getCustomer(searchTerm);
            if (customer == null) {
                JOptionPane.showMessageDialog(null, "Customer not found.");
                return;
            }

            JFrame frame = new JFrame("New Order");
            Container container = frame.getContentPane();
            container.setLayout(new FlowLayout());

            JLabel nameLabel = new JLabel("Name: " + customer.getName());
            JLabel customerNumberLabel = new JLabel("Customer Number: " + customer.getCustomerNumber());
            JLabel phoneNumberLabel = new JLabel("Phone Number: " + customer.getPhoneNumber());
            JLabel addressLabel = new JLabel("Address: " + customer.getAddress());

            container.add(nameLabel);
            container.add(customerNumberLabel);
            container.add(phoneNumberLabel);
            container.add(addressLabel);

            frame.pack();
            frame.setVisible(true);
        }
    }

}
