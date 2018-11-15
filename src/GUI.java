import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI
{
    JFrame frame;
    GUIEvents events;
    JPanel addCoursePanel;
    Container container;
    JLabel displayLabel;
    JLabel infoLabel;
    JTextField inputField;

    public GUI()
    {
        makeGUI();
    }

    private void makeGUI()
    {
        // Create frame and content pane
        frame = new JFrame("Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900,700));
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        container = frame.getContentPane();

        // Main Panel
        JPanel mainPanel = new JPanel();
        container.add(mainPanel);

        // Add course button to main panel
        JButton addCourseButton = new JButton("Add Course");
        addCourseButton.addActionListener((ActionEvent e) -> {addCourse();});
        mainPanel.add(addCourseButton);

        // Panel for user info
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.PAGE_AXIS));
        userPanel.setPreferredSize(new Dimension(900,200));
        container.add(userPanel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        JPanel infoPanel = new JPanel();

        userPanel.add(inputPanel);
        userPanel.add(infoPanel);

        // Label to display current info
        displayLabel = new JLabel("Select Option");
        inputPanel.add(displayLabel);

        // Text field for input
        inputField = new JTextField();
        inputPanel.add(inputField);

        // Submit button
        JButton submitButton = new JButton("SUBMIT");
        inputPanel.add(submitButton);

        infoLabel = new JLabel("Info");
        infoPanel.add(infoLabel);

        // Pack and set visible
        frame.pack();
        frame.setVisible(true);
    }


    private void addCourse()
    {
        displayLabel.setText("Enter Course Code: \n");
    }

}
