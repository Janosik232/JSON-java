package org.example;
import javax.swing.*;
import java.awt.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class FormPanel extends JPanel {

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;

    private MainFrame frame;

    public FormPanel(MainFrame frame) {

        this.frame = frame;

        setLayout(new GridLayout(4,2));

        add(new JLabel("Imię"));
        firstNameField = new JTextField();
        add(firstNameField);

        add(new JLabel("Nazwisko"));
        lastNameField = new JTextField();
        add(lastNameField);

        add(new JLabel("Email"));
        emailField = new JTextField();
        add(emailField);

        JButton saveButton = new JButton("Zapisz i Dalej");
        add(saveButton);

        saveButton.addActionListener(e -> saveProfile());
    }

    private void saveProfile() {
        try {

            UserProfile profile = new UserProfile(
                    firstNameField.getText(),
                    lastNameField.getText(),
                    emailField.getText()
            );

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("profile.json"), profile);

            frame.showPreview();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}