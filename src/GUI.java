import univ.Course;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI
{
    String userInputString;

    PlanOfStudy plan;
    JFrame frame;
    Container container;

    // Panels
    JPanel mainPanel;
    JPanel optionPanel;
    JPanel inputPanel;

    JButton submitButton;
    JTextField inputField;
    JLabel infoLabel;
    JLabel errorLabel;

    public GUI()
    {
        plan = new PlanOfStudy();
        makeGUI();
    }

    private void makeGUI()
    {
        makeFrame();
        makePanels();

        // User story options
        JButton addCourseButton = new JButton("Add Course");
        JButton removeCourseButton = new JButton("Remove Course");
        JButton addDegreeButton = new JButton("Add Degree");

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.setVisible(false);

        // Action events
        addCourseButton.addActionListener((ActionEvent e) -> addCourse());
        submitButton.addActionListener((ActionEvent e) -> getInput());

        // Add user options to option panel
        optionPanel.add(addCourseButton);
        optionPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        optionPanel.add(removeCourseButton);
        optionPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        optionPanel.add(addDegreeButton);

        // Label to prompt user
        infoLabel = new JLabel("Hey there");
        // Error label
        errorLabel = new JLabel("Invalid input");
        errorLabel.setVisible(false);

        // User input field
        inputField = new JTextField();
        inputField.setVisible(false);
        inputField.setColumns(10);

        inputPanel.add(infoLabel);
        inputPanel.add(inputField);
        inputPanel.add(submitButton);

        // Pack and set visible
        frame.pack();
        frame.setVisible(true);
    }

    private void makeFrame(){
        // Create frame and content pane
        frame = new JFrame("Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900,700));
        frame.setLayout(new FlowLayout());
        container = frame.getContentPane();
    }

    private void makePanels() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 0));

        optionPanel = new JPanel();
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));

        inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));

        container.add(mainPanel);
        mainPanel.add(optionPanel);
        mainPanel.add(inputPanel);
    }

    private void getInput() {
        try {
            System.out.println("yeet");
            userInputString = inputField.getText();
            System.out.println(userInputString);
        }
        catch (Exception e) {
            System.out.println("Error, invalid input");
        }
    }

    private void addCourse() {
        boolean validInput = false;
        String input;

        inputField.setVisible(true);
        submitButton.setVisible(true);

        // Get course code to add
        infoLabel.setText("Enter Course Code: ");

        if (userInputString != null) {
            infoLabel.setText(userInputString);
        }
    }
}
