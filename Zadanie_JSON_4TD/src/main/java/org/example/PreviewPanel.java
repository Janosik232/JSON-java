package org.example;

import javax.swing.*;
import java.awt.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class PreviewPanel extends JPanel {

    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel emailLabel;

    private MainFrame frame;

    public PreviewPanel(MainFrame frame) {

        this.frame = frame;

        setLayout(new GridLayout(4,1));

        firstNameLabel = new JLabel();
        lastNameLabel = new JLabel();
        emailLabel = new JLabel();

        add(firstNameLabel);
        add(lastNameLabel);
        add(emailLabel);

        JButton backButton = new JButton("Powrót do edycji");
        add(backButton);

        backButton.addActionListener(e -> frame.showForm());
    }

    public void loadData() {

        try {

            ObjectMapper mapper = new ObjectMapper();
            UserProfile profile =
                    mapper.readValue(new File("profile.json"), UserProfile.class);

            firstNameLabel.setText("Imię: " + profile.getFirstName());
            lastNameLabel.setText("Nazwisko: " + profile.getLastName());
            emailLabel.setText("Email: " + profile.getEmail());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}