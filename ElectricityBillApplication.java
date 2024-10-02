import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ElectricityBill {
    // Class members
    private String consumerNo;
    private String consumerName;
    private double previousReading;
    private double currentReading;
    private String connectionType;

    // Constructor
    public ElectricityBill(String consumerNo, String consumerName, double previousReading, double currentReading, String connectionType) {
        this.consumerNo = consumerNo;
        this.consumerName = consumerName;
        this.previousReading = previousReading;
        this.currentReading = currentReading;
        this.connectionType = connectionType;
    }

    // Method to calculate bill
    public double calculateBill() {
        double unitsConsumed = currentReading - previousReading;
        double billAmount = 0.0;

        // Calculate bill based on connection type
        if (connectionType.equalsIgnoreCase("domestic")) {
            if (unitsConsumed <= 100) {
                billAmount = unitsConsumed * 2.0;
            } else if (unitsConsumed <= 200) {
                billAmount = (100 * 2.0) + ((unitsConsumed - 100) * 3.5);
            } else if (unitsConsumed <= 500) {
                billAmount = (100 * 2.0) + (100 * 3.5) + ((unitsConsumed - 200) * 5.0);
            } else {
                billAmount = (100 * 2.0) + (100 * 3.5) + (300 * 5.0) + ((unitsConsumed - 500) * 6.0);
            }
        } else if (connectionType.equalsIgnoreCase("commercial")) {
            if (unitsConsumed <= 100) {
                billAmount = unitsConsumed * 3.0;
            } else if (unitsConsumed <= 200) {
                billAmount = (100 * 3.0) + ((unitsConsumed - 100) * 5.5);
            } else if (unitsConsumed <= 500) {
                billAmount = (100 * 3.0) + (100 * 5.5) + ((unitsConsumed - 200) * 7.0);
            } else {
                billAmount = (100 * 3.0) + (100 * 5.5) + (300 * 7.0) + ((unitsConsumed - 500) * 8.0);
            }
        } else {
            System.out.println("Invalid connection type.");
        }

        return billAmount;
    }

    // Method to display bill details
    public String displayBill() {
        StringBuilder billDetails = new StringBuilder();
        billDetails.append("Electricity Bill Details:\n");
        billDetails.append("Consumer Number: ").append(consumerNo).append("\n");
        billDetails.append("Consumer Name: ").append(consumerName).append("\n");
        billDetails.append("Units Consumed: ").append(currentReading - previousReading).append("\n");
        billDetails.append(String.format("Total Bill Amount: Rs. %.2f", calculateBill()));
        return billDetails.toString();
    }
}

public class ElectricityBillApplication extends JFrame {
    private JTextField consumerNoField, consumerNameField, previousReadingField, currentReadingField;
    private JComboBox<String> connectionTypeComboBox;
    private JTextArea billDisplayArea;

    public ElectricityBillApplication() {
        // Set up the frame
        setTitle("Electricity Bill Generator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Create and add components
        add(new JLabel("Consumer Number:"));
        consumerNoField = new JTextField();
        add(consumerNoField);

        add(new JLabel("Consumer Name:"));
        consumerNameField = new JTextField();
        add(consumerNameField);

        add(new JLabel("Previous Month Reading:"));
        previousReadingField = new JTextField();
        add(previousReadingField);

        add(new JLabel("Current Month Reading:"));
        currentReadingField = new JTextField();
        add(currentReadingField);

        add(new JLabel("Connection Type:"));
        String[] connectionTypes = {"domestic", "commercial"};
        connectionTypeComboBox = new JComboBox<>(connectionTypes);
        add(connectionTypeComboBox);

        JButton generateButton = new JButton("Generate Bill");
        add(generateButton);

        // Area to display the bill
        billDisplayArea = new JTextArea();
        billDisplayArea.setEditable(false);
        add(new JScrollPane(billDisplayArea));

        // Button action
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateBill();
            }
        });
    }

    private void generateBill() {
        // Get user input
        String consumerNo = consumerNoField.getText();
        String consumerName = consumerNameField.getText();
        double previousReading = Double.parseDouble(previousReadingField.getText());
        double currentReading = Double.parseDouble(currentReadingField.getText());
        String connectionType = (String) connectionTypeComboBox.getSelectedItem();

        // Create ElectricityBill object
        ElectricityBill bill = new ElectricityBill(consumerNo, consumerName, previousReading, currentReading, connectionType);

        // Display bill
        billDisplayArea.setText(bill.displayBill());
    }

    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(() -> {
            ElectricityBillApplication app = new ElectricityBillApplication();
            app.setVisible(true);
        });
    }
}
