package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    private FormPanel formPanel;
    private PreviewPanel previewPanel;

    public MainFrame() {

        setTitle("System Profilu Użytkownika");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        formPanel = new FormPanel(this);
        previewPanel = new PreviewPanel(this);

        mainPanel.add(formPanel, "FORM");
        mainPanel.add(previewPanel, "PREVIEW");

        add(mainPanel);

        setVisible(true);
    }

    public void showPreview() {
        previewPanel.loadData();
        cardLayout.show(mainPanel, "PREVIEW");
    }

    public void showForm() {
        cardLayout.show(mainPanel, "FORM");
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}