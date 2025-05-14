import java.awt.*;
import java.awt.event.*;

public class VoterForm extends Frame {
    private TextField nameField;
    private TextField ageField;
    private CheckboxGroup genderGroup;
    private Checkbox maleCheckbox;
    private Checkbox femaleCheckbox;
    private Button submitButton;
    private TextArea messageArea;
    public VoterForm() {
        setTitle("Voter Eligibility Form");
        setSize(400, 400);
        setLayout(new FlowLayout());
        setBackground(Color.LIGHT_GRAY);
        add(new Label("Name:"));
        nameField = new TextField(20);
        add(nameField);
        add(new Label("Age:"));
        ageField = new TextField(5);
        add(ageField);
        add(new Label("Gender:"));
        genderGroup = new CheckboxGroup();
        maleCheckbox = new Checkbox("Male", genderGroup, false);
        femaleCheckbox = new Checkbox("Female", genderGroup, false);
        add(maleCheckbox);
        add(femaleCheckbox);
        submitButton = new Button("Vote");
        add(submitButton);
        messageArea = new TextArea(5, 30);
        messageArea.setEditable(false);
        add(messageArea);
        submitButton.addActionListener(new VoteButtonListener());
        maleCheckbox.addItemListener(new GenderSelectionListener());
        femaleCheckbox.addItemListener(new GenderSelectionListener());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });

        setVisible(true);
    }
    private class VoteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String name = nameField.getText().trim();
                if (name.isEmpty()) {
                    messageArea.setText("Please enter your name.");
                    return;
                }
                int age;
                try {
                    age = Integer.parseInt(ageField.getText().trim());
                } catch (NumberFormatException ex) {
                    messageArea.setText("Please enter a valid age.");
                    return;
                }
                if (genderGroup.getSelectedCheckbox() == null) {
                    messageArea.setText("Please select your gender.");
                    return;
                }
                if (age >= 18) {
                    messageArea.setText("Congratulations " + name + "! You are eligible to vote.");
                } else {
                    messageArea.setText("Sorry " + name + ", you are not eligible to vote. You must be 18 or older.");
                }
                updateMessageColor();
                
            } catch (Exception ex) {
                messageArea.setText("An error occurred: " + ex.getMessage());
            }
        }
    }
    private class GenderSelectionListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            updateMessageColor();
        }
    }
    private void updateMessageColor() {
        if (genderGroup.getSelectedCheckbox() == maleCheckbox) {
            messageArea.setBackground(Color.BLUE);
            messageArea.setForeground(Color.WHITE);
        } else if (genderGroup.getSelectedCheckbox() == femaleCheckbox) {
            messageArea.setBackground(Color.PINK);
            messageArea.setForeground(Color.BLACK); 
        }
    }

    public static void main(String[] args) {
        new VoterForm();
    }
}