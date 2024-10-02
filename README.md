Electricity Bill Generator
This is a simple Java Swing application that generates an electricity bill based on the type of electricity board (EB) connection (domestic or commercial) and the number of units consumed. The application provides a graphical user interface (GUI) for easy user interaction.

Features
Enter consumer information, including consumer number, name, previous month reading, and current month reading.
Select the type of electricity connection: domestic or commercial.
Automatically calculates the bill based on the number of units consumed.
Displays the bill in a text area on the GUI.
Tariff Calculation
Domestic Tariff:
First 100 units: Rs. 2 per unit
101–200 units: Rs. 3.50 per unit
201–500 units: Rs. 5 per unit
Above 500 units: Rs. 6 per unit
Commercial Tariff:
First 100 units: Rs. 3 per unit
101–200 units: Rs. 5.50 per unit
201–500 units: Rs. 7 per unit
Above 500 units: Rs. 8 per unit
Prerequisites
Java Development Kit (JDK) version 8 or higher.
A text editor or an IDE like IntelliJ IDEA, Eclipse, or NetBeans.
How to Run
1. Clone or Download the Repository
Download the project files or clone the repository using Git:

bash
Copy code
git clone https://github.com/HarshThakur54/Electric-bill-generator.git
2. Compile the Java Code
Open a terminal and navigate to the directory where the ElectricityBillApplication.java file is located:

bash
Copy code
cd path/to/your/directory
Compile the Java code using the following command:

bash
Copy code
javac ElectricityBillApplication.java
3. Run the Java Application
After successful compilation, run the application using:

bash
Copy code
java ElectricityBillApplication
4. GUI Interaction
The application will open a GUI window. Enter the required details:

Consumer Number: Unique number identifying the consumer.
Consumer Name: Name of the consumer.
Previous Month Reading: The meter reading from the previous month.
Current Month Reading: The meter reading for the current month.
Connection Type: Select either domestic or commercial from the dropdown.
Click the "Generate Bill" button, and the electricity bill will be displayed in the text area below the form.

Project Structure
bash
Copy code
.
├── ElectricityBill.java          # Class to calculate and display the electricity bill
└── ElectricityBillApplication.java # Main class that builds the GUI and handles user interaction
Example
Input:
Consumer Number: C1234
Consumer Name: John Doe
Previous Month Reading: 100
Current Month Reading: 250
Connection Type: domestic
Output:
yaml
Copy code
Electricity Bill Details:
Consumer Number: C1234
Consumer Name: Harsh
Units Consumed: 150
Total Bill Amount: Rs. 625.00
Troubleshooting
JDK Not Found Error: Ensure that the JDK is installed and properly set up in your environment. You can verify the installation by running:
bash
Copy code
java -version
Compilation Errors: Make sure that the Java file names match the class names exactly. For example, ElectricityBillApplication.java must contain the public class ElectricityBillApplication.

GUI Not Opening: If the GUI does not open, ensure that you are running the application from the correct directory where the .class file was compiled.
