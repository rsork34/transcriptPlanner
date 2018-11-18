import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI
{

    PlanOfStudy plan;

    JFrame frame;
    Container container;

    // Panels
    JPanel mainPanel;
    JPanel optionPanel;
    JPanel inputPanel;

    public GUI()
    {
        plan = new PlanOfStudy();
        makeGUI();
    }

    private void makeGUI()
    {
        makeFrame();
        makePanels();

        // Add course button to main panel
        JButton addCourseButton = new JButton("Add Course");
        JButton removeCourseButton = new JButton("Remove Course");
        JButton addDegreeButton = new JButton("Add Degree");
        addCourseButton.addActionListener((ActionEvent e) -> addCourse());

        // Add user options to option panel
        optionPanel.add(addCourseButton);
        optionPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        optionPanel.add(removeCourseButton);
        optionPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        optionPanel.add(addDegreeButton);

        // Label
        JLabel infoLabel = new JLabel("Hey there");

        inputPanel.add(infoLabel);

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


    private void addCourse() {

    }

}
