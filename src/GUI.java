import univ.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI {
    private PlanOfStudy plan;
    private JPanel mainPanel;
    private JPanel optionsPanel;
    private JPanel inputPanel;
    private JButton addToPlanButton;
    private JLabel courseCodeLabel;
    private JLabel semesterLabel;
    private JLabel gradeLabel;
    private JLabel statusLabel;
    private JComboBox statusComboBox;
    private JTextField gradeTextField;
    private JComboBox semesterComboBox;
    private JComboBox courseCodeComboBox;
    private JButton submitButton;
    private JLabel errorLabel;
    private JButton addDegreeButton;
    private JComboBox degreeComboBox;
    private JLabel degreeLabel;
    private JButton removeCourseButton;
    private JLabel plannedCurrentLabel;
    private JComboBox plannedCurrentComboBox;
    private JComboBox completeComboBox;
    private JLabel completeLabel;
    private JButton changeGradeButton;
    private JButton viewGPAButton;
    private JButton viewCreditsButton;
    private JButton viewCISGPAButton;
    private JButton studentInfoButton;
    private JTextField studentInfoTextField;
    private JLabel studentInfoLabel;
    private JLabel studentNumberLabel;
    private JTextField studentNumberTextField;
    private JFrame frame;

    private String currentOption;

    public GUI() {
        currentOption = "none";
        plan = new PlanOfStudy();
        makeGUI();
    }

    private void makeGUI() {
        frame = new JFrame("Planner");
        frame.setContentPane(mainPanel);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setAllInvisible();

        // Set courses to choose from
        courseCodeComboBox.addItem("");
        for (Course c : plan.getCatalog().getCourseCatalog()) {
            courseCodeComboBox.addItem(c.getCourseCode());
        }

        // Set semester options
        semesterComboBox.addItem("");
        semesterComboBox.addItem("Fall");
        semesterComboBox.addItem("Winter");

        // Set status options
        statusComboBox.addItem("");
        statusComboBox.addItem("In Progress");
        statusComboBox.addItem("Planned");
        statusComboBox.addItem("Completed");

        degreeComboBox.addItem("");
        degreeComboBox.addItem("CS");
        degreeComboBox.addItem("SEng");
        degreeComboBox.addItem("BCG");

        // Event listeners
        submitButton.addActionListener((ActionEvent e) -> submit());
        addDegreeButton.addActionListener((ActionEvent e) -> selectAddDegree());
        addToPlanButton.addActionListener((ActionEvent e) -> selectAddCourse());
        removeCourseButton.addActionListener((ActionEvent e) -> selectRemoveCourse());
        changeGradeButton.addActionListener((ActionEvent e) -> selectChangeGrade());
        viewGPAButton.addActionListener((ActionEvent e) -> selectViewGPA());
        viewCreditsButton.addActionListener((ActionEvent e) -> selectViewTotalCredits());
        viewCISGPAButton.addActionListener((ActionEvent e) -> selectViewCisGPA());
        studentInfoButton.addActionListener((ActionEvent e) -> selectStudentInfo());

        frame.pack();
        frame.setVisible(true);
    }

    private void setAllInvisible() {
        errorLabel.setText("");

        studentInfoLabel.setVisible(false);
        studentInfoTextField.setVisible(false);
        studentNumberLabel.setVisible(false);
        studentNumberTextField.setVisible(false);

        courseCodeLabel.setVisible(false);
        courseCodeComboBox.setVisible(false);

        semesterComboBox.setVisible(false);
        semesterLabel.setVisible(false);

        gradeLabel.setVisible(false);
        gradeTextField.setVisible(false);

        statusComboBox.setVisible(false);
        statusLabel.setVisible(false);

        degreeComboBox.setVisible(false);
        degreeLabel.setVisible(false);

        plannedCurrentComboBox.setVisible(false);
        plannedCurrentLabel.setVisible(false);
        completeComboBox.setVisible(false);
        completeLabel.setVisible(false);

        submitButton.setVisible(false);
    }

    private void selectChangeGrade() {
        plannedCurrentComboBox.removeAllItems();
        completeComboBox.removeAllItems();
        gradeTextField.setText("");

        plannedCurrentComboBox.addItem("");
        completeComboBox.addItem("");

        for (Attempt a : plan.getStudent().getTranscript().getCompletedCourses()) {
            completeComboBox.addItem(a.getCourseCode() + " " + a.getSemesterTaken());
        }

        for (Attempt a : plan.getStudent().getTranscript().getPlannedCourses()) {
            if (!a.getStatus().equals("Planned")) {
                plannedCurrentComboBox.addItem(a.getCourseCode() + " " + a.getSemesterTaken());
            }
        }

        currentOption = "change grade";
        errorLabel.setText("");

        studentInfoLabel.setVisible(false);
        studentInfoTextField.setVisible(false);
        studentNumberLabel.setVisible(false);
        studentNumberTextField.setVisible(false);

        courseCodeLabel.setVisible(false);
        courseCodeComboBox.setVisible(false);

        semesterComboBox.setVisible(false);
        semesterLabel.setVisible(false);

        gradeLabel.setVisible(true);
        gradeTextField.setVisible(true);

        statusComboBox.setVisible(false);
        statusLabel.setVisible(false);

        degreeComboBox.setVisible(false);
        degreeLabel.setVisible(false);

        plannedCurrentComboBox.setVisible(true);
        plannedCurrentLabel.setVisible(true);
        completeComboBox.setVisible(true);
        completeLabel.setVisible(true);

        submitButton.setVisible(true);
    }

    private void selectAddCourse() {
        currentOption = "add course";
        errorLabel.setText("");
        gradeTextField.setText("");

        studentInfoLabel.setVisible(false);
        studentInfoTextField.setVisible(false);
        studentNumberLabel.setVisible(false);
        studentNumberTextField.setVisible(false);

        courseCodeLabel.setVisible(true);
        courseCodeComboBox.setVisible(true);

        semesterComboBox.setVisible(true);
        semesterLabel.setVisible(true);

        gradeLabel.setVisible(true);
        gradeTextField.setVisible(true);

        statusComboBox.setVisible(true);
        statusLabel.setVisible(true);

        degreeComboBox.setVisible(false);
        degreeLabel.setVisible(false);

        plannedCurrentComboBox.setVisible(false);
        plannedCurrentLabel.setVisible(false);
        completeComboBox.setVisible(false);
        completeLabel.setVisible(false);

        submitButton.setVisible(true);
    }

    private void selectRemoveCourse() {
        plannedCurrentComboBox.removeAllItems();
        completeComboBox.removeAllItems();

        plannedCurrentComboBox.addItem("");
        completeComboBox.addItem("");

        for (Attempt a : plan.getStudent().getTranscript().getCompletedCourses()) {
            completeComboBox.addItem(a.getCourseCode() + " " + a.getSemesterTaken());
        }

        for (Attempt a : plan.getStudent().getTranscript().getPlannedCourses()) {
            plannedCurrentComboBox.addItem(a.getCourseCode() + " " + a.getSemesterTaken());
        }

        currentOption = "remove course";
        errorLabel.setText("");

        studentInfoLabel.setVisible(false);
        studentInfoTextField.setVisible(false);
        studentNumberLabel.setVisible(false);
        studentNumberTextField.setVisible(false);

        courseCodeLabel.setVisible(false);
        courseCodeComboBox.setVisible(false);

        semesterComboBox.setVisible(false);
        semesterLabel.setVisible(false);

        gradeLabel.setVisible(false);
        gradeTextField.setVisible(false);

        statusComboBox.setVisible(false);
        statusLabel.setVisible(false);

        degreeComboBox.setVisible(false);
        degreeLabel.setVisible(false);

        plannedCurrentComboBox.setVisible(true);
        plannedCurrentLabel.setVisible(true);
        completeComboBox.setVisible(true);
        completeLabel.setVisible(true);

        submitButton.setVisible(true);
    }

    private void selectViewTotalCredits() {
        currentOption = "total credits";
        errorLabel.setText("");

        studentInfoLabel.setVisible(false);
        studentInfoTextField.setVisible(false);
        studentNumberLabel.setVisible(false);
        studentNumberTextField.setVisible(false);

        courseCodeLabel.setVisible(false);
        courseCodeComboBox.setVisible(false);

        semesterComboBox.setVisible(false);
        semesterLabel.setVisible(false);

        gradeLabel.setVisible(false);
        gradeTextField.setVisible(false);

        statusComboBox.setVisible(false);
        statusLabel.setVisible(false);

        degreeComboBox.setVisible(false);
        degreeLabel.setVisible(false);

        plannedCurrentComboBox.setVisible(false);
        plannedCurrentLabel.setVisible(false);
        completeComboBox.setVisible(false);
        completeLabel.setVisible(false);


        submitButton.setVisible(true);
    }

    private void selectViewCisGPA() {
        currentOption = "CIS GPA";
        errorLabel.setText("");

        studentInfoLabel.setVisible(false);
        studentInfoTextField.setVisible(false);
        studentNumberLabel.setVisible(false);
        studentNumberTextField.setVisible(false);

        courseCodeLabel.setVisible(false);
        courseCodeComboBox.setVisible(false);

        semesterComboBox.setVisible(false);
        semesterLabel.setVisible(false);

        gradeLabel.setVisible(false);
        gradeTextField.setVisible(false);

        statusComboBox.setVisible(false);
        statusLabel.setVisible(false);

        degreeComboBox.setVisible(false);
        degreeLabel.setVisible(false);

        plannedCurrentComboBox.setVisible(false);
        plannedCurrentLabel.setVisible(false);
        completeComboBox.setVisible(false);
        completeLabel.setVisible(false);

        submitButton.setVisible(true);
    }

    private void selectViewGPA() {
        currentOption = "GPA";
        errorLabel.setText("");

        studentInfoLabel.setVisible(false);
        studentInfoTextField.setVisible(false);
        studentNumberLabel.setVisible(false);
        studentNumberTextField.setVisible(false);

        courseCodeLabel.setVisible(false);
        courseCodeComboBox.setVisible(false);

        semesterComboBox.setVisible(false);
        semesterLabel.setVisible(false);

        gradeLabel.setVisible(false);
        gradeTextField.setVisible(false);

        statusComboBox.setVisible(false);
        statusLabel.setVisible(false);

        degreeComboBox.setVisible(false);
        degreeLabel.setVisible(false);

        plannedCurrentComboBox.setVisible(false);
        plannedCurrentLabel.setVisible(false);
        completeComboBox.setVisible(false);
        completeLabel.setVisible(false);


        submitButton.setVisible(true);
    }

    private void selectAddDegree() {
        currentOption = "add degree";

        if (!plan.getStudent().getTranscript().hasDegree()) {
            errorLabel.setText("Current Degree: None");
        } else {
            errorLabel.setText("Current Degree: " + plan.getStudent().getTranscript().getDegreeTitle());
        }

        studentInfoLabel.setVisible(false);
        studentInfoTextField.setVisible(false);
        studentNumberLabel.setVisible(false);
        studentNumberTextField.setVisible(false);

        courseCodeLabel.setVisible(false);
        courseCodeComboBox.setVisible(false);

        semesterComboBox.setVisible(false);
        semesterLabel.setVisible(false);

        gradeLabel.setVisible(false);
        gradeTextField.setVisible(false);

        statusComboBox.setVisible(false);
        statusLabel.setVisible(false);

        degreeComboBox.setVisible(true);
        degreeLabel.setVisible(true);

        plannedCurrentComboBox.setVisible(false);
        plannedCurrentLabel.setVisible(false);
        completeComboBox.setVisible(false);
        completeLabel.setVisible(false);


        submitButton.setVisible(true);
    }

    private void selectStudentInfo() {
        currentOption = "student info";

        studentInfoLabel.setVisible(true);
        studentInfoTextField.setVisible(true);
        studentNumberLabel.setVisible(true);
        studentNumberTextField.setVisible(true);

        courseCodeLabel.setVisible(false);
        courseCodeComboBox.setVisible(false);

        semesterComboBox.setVisible(false);
        semesterLabel.setVisible(false);

        gradeLabel.setVisible(false);
        gradeTextField.setVisible(false);

        statusComboBox.setVisible(false);
        statusLabel.setVisible(false);

        degreeComboBox.setVisible(false);
        degreeLabel.setVisible(false);

        plannedCurrentComboBox.setVisible(false);
        plannedCurrentLabel.setVisible(false);
        completeComboBox.setVisible(false);
        completeLabel.setVisible(false);

        submitButton.setVisible(true);
    }

    private void submit() {
        if (currentOption.equals("add course")) {
            addCourseToPlan();
        } else if (currentOption.equals("add degree")) {
            addDegreeToPlan();
        } else if (currentOption.equals("remove course")) {
            removeCourseFromPlan();
        } else if (currentOption.equals("change grade")) {
            changeGrade();
        } else if (currentOption.equals("GPA")) {
            viewGPA();
        } else if (currentOption.equals("total credits")) {
            viewTotalCredits();
        } else if (currentOption.equals("CIS GPA")) {
            viewCisGPA();
        } else if (currentOption.equals("student info")) {
            setStudentInfo();
        }
    }

    private void setStudentInfo() {
        String fullName = studentInfoTextField.getText();
        String studentNumberString = studentNumberTextField.getText();
        int studentNumber;
        String[] nameParts;
        String firstName = null;
        String lastName = null;

        // Error checking
        if (fullName.isEmpty()) {
            errorLabel.setText("Error: No Name");
            return;
        }

        // Student name length is not 2
        nameParts = fullName.split(" ");
        if (nameParts.length != 2) {
            errorLabel.setText("Enter only first and last name");
            return;
        } else {
            try {
                firstName = nameParts[0];
                lastName = nameParts[1];
                if (firstName.isEmpty() || lastName.isEmpty()) {
                    errorLabel.setText("Error: invalid input");
                    return;
                }
                plan.getStudent().setFirstName(firstName);
                plan.getStudent().setLastName(lastName);
            } catch (Exception e) {
                errorLabel.setText("Error: invalid input");
            }
        }

        if (studentNumberString.isEmpty()) {
            errorLabel.setText("Error: No Student Number");
            return;
        }
        try {
            if (studentNumberString.length() != 7) {
                errorLabel.setText("Error: student number length should be 7");
                return;
            }

            studentNumber = Integer.parseInt(studentNumberString);
            plan.getStudent().setStudentNumber(studentNumber);
        } catch (Exception e) {
            errorLabel.setText("Error: Invalid Student Number");
            return;
        }

        errorLabel.setText(firstName + " " + lastName + ": " + studentNumberString);
    }

    /**
     * Displays the total number of credits completed
     */
    private void viewTotalCredits() {
        // Get number of credits completed from transcript
        double credits = plan.getStudent().getTranscript().getCreditsCompleted();

        // Could not find number of credits
        if (credits == -1) {
            errorLabel.setText("Error");
            return;
        }

        errorLabel.setText("Total credits: " + credits);
    }

    /**
     * Display the GPA of all CIS courses completed in the transcript
     */
    private void viewCisGPA() {
        if (plan.getStudent().getTranscript().getCreditsCompleted() == 0) {
            errorLabel.setText("No CIS courses Completed");
            return;
        }

        for (Attempt a : plan.getStudent().getTranscript().getCompletedCourses()) {
            try {
                String courseCode = a.getCourseCode();
                System.out.println("REEEEE " + courseCode);
            } catch (Exception e) {

            }
        }
    }

    /**
     * Display the GPA of all completed courses in the transcript
     */
    private void viewGPA() {
        // No credits completed, GPA is empty
        if (plan.getStudent().getTranscript().getCreditsCompleted() == 0) {
            errorLabel.setText("No Courses Completed");
            return;
        }

        // Find GPA from transcript
        double gpa = plan.getStudent().getTranscript().getGPA();

        // Error finding GPA
        if (gpa == -1) {
            errorLabel.setText("Error: can't get GPA");
            return;
        }

        errorLabel.setText("GPA: " + gpa);
    }

    /**
     * Change the grade of a course attempt in the student's transcript
     *
     * @Exception Exception if the input grade is non numerical
     */
    private void changeGrade() {
        // Ensure valid grade
        String gradeString = gradeTextField.getText();
        double grade;
        if (gradeString.isEmpty()) {
            errorLabel.setText("Empty grade");
            return;
        }
        try {
            grade = Double.parseDouble(gradeString);
        } catch (Exception e) {
            errorLabel.setText("Error: invalid grade");
            return;
        }
        if (grade < 0 || grade > 100) {
            errorLabel.setText("Error: invalid grade");
            return;
        }

        String completed = (String) completeComboBox.getSelectedItem();
        String plannedCurrent = (String) plannedCurrentComboBox.getSelectedItem();

        // If no boxes or both boxes are selected, error
        if (plannedCurrent.isEmpty() && completed.isEmpty()) {
            errorLabel.setText("No course selected");
            return;
        } else if (!plannedCurrent.isEmpty() && !completed.isEmpty()) {
            errorLabel.setText("Select one course only");
            return;
        }

        // Change grade for a current course
        if (!plannedCurrent.isEmpty()) {
            try {
                plan.getStudent().getTranscript().updatePlannedGrade(plannedCurrent, gradeString);
                errorLabel.setText(plannedCurrent + " grade is now: " + gradeString + "%");
                return;
            } catch (Exception e) {
                errorLabel.setText("Could not update grade");
                return;
            }
        }
        // Change grade for completed course
        else if (!completed.isEmpty()) {
            try {
                String[] holder = completed.split(" ");
                plan.getStudent().getTranscript().updateCompletedGrade(holder[0] + " " + holder[1], gradeString);
                errorLabel.setText(completed + " grade is now: " + gradeString + "%");
                return;
            } catch (Exception e) {
                errorLabel.setText("Could not update grade");
                return;
            }
        }
    }

    /**
     * Removes a course from a students plan of study
     *
     * @Exception Exception in case of null value passed back from transcript
     */
    private void removeCourseFromPlan() {
        String plannedToRemove = (String) plannedCurrentComboBox.getSelectedItem();
        String completeToRemove = (String) completeComboBox.getSelectedItem();
        String[] holder;

        // Two or zero courses selected to remove
        if (plannedToRemove.isEmpty() && completeToRemove.isEmpty()) {
            errorLabel.setText("No course(s) chosen");
            return;
        } else if (!plannedToRemove.isEmpty() && !completeToRemove.isEmpty()) {
            errorLabel.setText("Error: choose only 1 course to remove");
            return;
        }

        // Remove planned course from transcript
        if (!plannedToRemove.isEmpty()) {
            try {
                holder = plannedToRemove.split(" ");
                plan.getStudent().getTranscript().removePlannedCourse(holder[0] + " " + holder[1]);
                errorLabel.setText("Removed: " + holder[0] + " " + holder[1]);
            } catch (Exception e) {
                errorLabel.setText("Could not remove course");
            }
        }

        // Remove completed course from transcript
        if (!completeToRemove.isEmpty()) {
            try {
                holder = completeToRemove.split(" ");
                plan.getStudent().getTranscript().removeCompleteCourse(holder[0] + " " + holder[1]);
                errorLabel.setText("Removed: " + holder[0] + " " + holder[1]);
            } catch (Exception e) {
                errorLabel.setText("Could not remove course");
            }
        }

    }

    /**
     * Takes user selected course code, grade, course status, and semester and creates a course
     * attempt, and adds it to their transcript
     *
     * @throws Exception if user enters a non numerical value into course grade
     */
    private void addCourseToPlan() {
        errorLabel.setText("");
        Course courseToAddToPlan;

        // Create course from chosen course code
        String courseSelected = (String) courseCodeComboBox.getSelectedItem();

        // If the course exists create it
        if (!(courseSelected.isEmpty())) {
            courseToAddToPlan = new Course(plan.getCatalog().findCourse(courseSelected));
        } else {
            errorLabel.setText("Error: course not found");
            return;
        }

        // Ensure valid semester
        String semester = (String) semesterComboBox.getSelectedItem();
        if (semester.isEmpty()) {
            errorLabel.setText("Error: no semester");
            return;
        }

        // Ensure valid course status
        String status = (String) statusComboBox.getSelectedItem();
        if (status.isEmpty()) {
            errorLabel.setText("Error: no status");
            return;
        }

        // Ensure valid grade
        String gradeString = gradeTextField.getText();
        double grade;
        if (gradeString.isEmpty() && !status.equals("Planned")) {
            errorLabel.setText("Error: no grade");
            return;
        } else if (!gradeString.isEmpty() && status.equals("Planned")) {
            errorLabel.setText("Error: planned course with grade");
            return;
        } else if (gradeString.isEmpty() && status.equals("Planned")) {

        } else {
            try {
                grade = Double.parseDouble(gradeString);
            } catch (Exception e) {
                errorLabel.setText("Error: invalid grade");
                return;
            }
            if (grade < 0 || grade > 100) {
                errorLabel.setText("Error: invalid grade");
                return;
            }
        }

        Attempt newAttempt = new Attempt(courseToAddToPlan, semester, gradeString, status);

        // Make sure attempt is not already in plan of study, if not then add it
        // Add course to planned list
        if (status.equals("In Progress") || status.equals("Planned")) {
            for (Attempt a : plan.getStudent().getTranscript().getCompletedCourses()) {
                if (a.getSemesterTaken().equals(semester) && a.getCourseCode().equals(courseSelected)) {
                    errorLabel.setText("Course already exists");
                    return;
                }
            }
            for (Attempt a : plan.getStudent().getTranscript().getPlannedCourses()) {
                if (a.getSemesterTaken().equals(semester) && a.getCourseCode().equals(courseSelected)) {
                    errorLabel.setText("Course already exists");
                    return;
                }
            }
            plan.getStudent().getTranscript().addPlannedCourse(newAttempt);
            errorLabel.setText("Course Added");
        }

        // Add course attempt to completed list
        if (status.equals("Completed")) {
            for (Attempt a : plan.getStudent().getTranscript().getPlannedCourses()) {
                if (a.getSemesterTaken().equals(semester) && a.getCourseCode().equals(courseSelected)) {
                    errorLabel.setText("Already exists");
                    return;
                }
            }
            for (Attempt a : plan.getStudent().getTranscript().getCompletedCourses()) {
                if (a.getSemesterTaken().equals(semester) && a.getCourseCode().equals(courseSelected)) {
                    errorLabel.setText("Already exists");
                    return;
                }
            }
            plan.getStudent().getTranscript().addCompletedCourse(newAttempt);
            errorLabel.setText("Course Added");
        }
    }

    /**
     * Takes choice for degree and sets degree in transcript
     */
    private void addDegreeToPlan() {
        errorLabel.setText("");
        String choice = (String) degreeComboBox.getSelectedItem();

        // Ensure degree is selected
        if (choice.isEmpty()) {
            errorLabel.setText("Nothing selected");
            return;
        }

        // Create degree for student
        if (choice.equals("CS")) {
            Degree deg = new CS();
            plan.getStudent().getTranscript().setDegree(deg);
            errorLabel.setText("Degree added");
        } else if (choice.equals("SEng")) {
            Degree deg = new SEng();
            plan.getStudent().getTranscript().setDegree(deg);
            errorLabel.setText("Degree added");
        } else if (choice.equals("BCG")) {
            Degree deg = new BCG();
            plan.getStudent().getTranscript().setDegree(deg);
            errorLabel.setText("Degree added");
        } else {
            errorLabel.setText("Error");
        }
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setEnabled(true);
        optionsPanel = new JPanel();
        optionsPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(8, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(optionsPanel, BorderLayout.WEST);
        removeCourseButton = new JButton();
        removeCourseButton.setText("Remove Course");
        optionsPanel.add(removeCourseButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        viewGPAButton = new JButton();
        viewGPAButton.setText("View GPA");
        optionsPanel.add(viewGPAButton, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        viewCreditsButton = new JButton();
        viewCreditsButton.setText("View Total Credits");
        optionsPanel.add(viewCreditsButton, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        studentInfoButton = new JButton();
        studentInfoButton.setText("Set Student Info");
        optionsPanel.add(studentInfoButton, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        viewCISGPAButton = new JButton();
        viewCISGPAButton.setText("View CIS GPA");
        optionsPanel.add(viewCISGPAButton, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        changeGradeButton = new JButton();
        changeGradeButton.setText("Change Grade");
        optionsPanel.add(changeGradeButton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addDegreeButton = new JButton();
        addDegreeButton.setText("Add Degree");
        optionsPanel.add(addDegreeButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addToPlanButton = new JButton();
        addToPlanButton.setText("Add Course ");
        optionsPanel.add(addToPlanButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        inputPanel = new JPanel();
        inputPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(10, 2, new Insets(0, 0, 0, 0), -1, -1));
        inputPanel.setEnabled(true);
        inputPanel.setVisible(true);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        courseCodeLabel = new JLabel();
        courseCodeLabel.setText("Course Code:");
        inputPanel.add(courseCodeLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        semesterLabel = new JLabel();
        semesterLabel.setText("Semester:");
        inputPanel.add(semesterLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gradeLabel = new JLabel();
        gradeLabel.setText("Grade:");
        inputPanel.add(gradeLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        statusLabel = new JLabel();
        statusLabel.setText("Status:");
        inputPanel.add(statusLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        statusComboBox = new JComboBox();
        inputPanel.add(statusComboBox, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(128, 30), null, 0, false));
        gradeTextField = new JTextField();
        inputPanel.add(gradeTextField, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(128, 30), null, 0, false));
        semesterComboBox = new JComboBox();
        inputPanel.add(semesterComboBox, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(128, 30), null, 0, false));
        courseCodeComboBox = new JComboBox();
        inputPanel.add(courseCodeComboBox, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(128, 30), null, 0, false));
        submitButton = new JButton();
        submitButton.setText("Submit");
        inputPanel.add(submitButton, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        errorLabel = new JLabel();
        errorLabel.setText("");
        inputPanel.add(errorLabel, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        degreeLabel = new JLabel();
        degreeLabel.setText("Degree:");
        inputPanel.add(degreeLabel, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        degreeComboBox = new JComboBox();
        inputPanel.add(degreeComboBox, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        plannedCurrentLabel = new JLabel();
        plannedCurrentLabel.setText("Planned/Current:");
        inputPanel.add(plannedCurrentLabel, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        plannedCurrentComboBox = new JComboBox();
        inputPanel.add(plannedCurrentComboBox, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        completeComboBox = new JComboBox();
        inputPanel.add(completeComboBox, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        completeLabel = new JLabel();
        completeLabel.setText("Complete:");
        inputPanel.add(completeLabel, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        studentInfoLabel = new JLabel();
        studentInfoLabel.setText("Name:");
        inputPanel.add(studentInfoLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        studentInfoTextField = new JTextField();
        inputPanel.add(studentInfoTextField, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        studentNumberLabel = new JLabel();
        studentNumberLabel.setText("Student Number");
        inputPanel.add(studentNumberLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        studentNumberTextField = new JTextField();
        inputPanel.add(studentNumberTextField, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}