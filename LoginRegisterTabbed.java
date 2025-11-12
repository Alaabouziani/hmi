import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginRegisterTabbed extends JFrame {

    // Registration fields
    private JTextField lastNameField, firstNameField, usernameField, emailField, phoneField;
    private JPasswordField passwordField, confirmPasswordField;

    // Login fields
    private JTextField loginUsernameField;
    private JPasswordField loginPasswordField;

    public LoginRegisterTabbed() {
        setTitle("User Form");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create tabs
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Registration", createRegistrationPanel());
        tabbedPane.addTab("Login", createLoginPanel());

        add(tabbedPane);
        setVisible(true);
    }

    // ---------------- Registration Panel ----------------
    private JPanel createRegistrationPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 247, 250));
        
        // Code label in top right corner
        JLabel codeLabel = new JLabel("R0");
        codeLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        codeLabel.setForeground(Color.GRAY);
        codeLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
        mainPanel.add(codeLabel, BorderLayout.NORTH);
        codeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        // Form panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 247, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Registration Form", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(title, gbc);
        gbc.gridwidth = 1;

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField();

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordField = new JPasswordField();

        JButton validateButton = new JButton("Validate");
        JButton cancelButton = new JButton("Cancel");

        // Position fields
        gbc.gridx = 0; gbc.gridy = 1; panel.add(lastNameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(lastNameField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(firstNameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(firstNameField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; panel.add(usernameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(usernameField, gbc);

        gbc.gridx = 0; gbc.gridy = 4; panel.add(emailLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 4; panel.add(emailField, gbc);

        gbc.gridx = 0; gbc.gridy = 5; panel.add(phoneLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 5; panel.add(phoneField, gbc);

        gbc.gridx = 0; gbc.gridy = 6; panel.add(passwordLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 6; panel.add(passwordField, gbc);

        gbc.gridx = 0; gbc.gridy = 7; panel.add(confirmPasswordLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 7; panel.add(confirmPasswordField, gbc);

        gbc.gridx = 0; gbc.gridy = 8; panel.add(validateButton, gbc);
        gbc.gridx = 1; gbc.gridy = 8; panel.add(cancelButton, gbc);

        // Button actions
        validateButton.addActionListener(e -> validateRegistration());
        cancelButton.addActionListener(e -> clearRegistrationFields());

        mainPanel.add(panel, BorderLayout.CENTER);
        return mainPanel;
    }

    // ---------------- Login Panel ----------------
    private JPanel createLoginPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 247, 250));
        
        // Code label in top right corner
        JLabel codeLabel = new JLabel("L0");
        codeLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        codeLabel.setForeground(Color.GRAY);
        codeLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
        mainPanel.add(codeLabel, BorderLayout.NORTH);
        codeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        // Form panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 247, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Login Form", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(title, gbc);
        gbc.gridwidth = 1;

        JLabel usernameLabel = new JLabel("Username:");
        loginUsernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        loginPasswordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton resetButton = new JButton("Reset");

        // Add main fields
        gbc.gridx = 0; gbc.gridy = 1; panel.add(usernameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(loginUsernameField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(passwordLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(loginPasswordField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; panel.add(loginButton, gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(resetButton, gbc);

        // Add forgotten password/username links
        JLabel forgotPasswordLabel = new JLabel("<HTML><U>Forgotten Password?</U></HTML>");
        forgotPasswordLabel.setForeground(Color.BLUE);
        forgotPasswordLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel forgotUsernameLabel = new JLabel("<HTML><U>Forgotten Username?</U></HTML>");
        forgotUsernameLabel.setForeground(Color.BLUE);
        forgotUsernameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Position the labels
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        panel.add(forgotPasswordLabel, gbc);

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        panel.add(forgotUsernameLabel, gbc);

        // Button actions
        loginButton.addActionListener(e -> validateLogin());
        resetButton.addActionListener(e -> clearLoginFields());

        // Actions for the new clickable labels
        forgotPasswordLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(panel, 
                    "Please contact the administrator or check your email to reset your password.", 
                    "Forgotten Password", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        forgotUsernameLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(panel, 
                    "Please contact the administrator to recover your username.", 
                    "Forgotten Username", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        mainPanel.add(panel, BorderLayout.CENTER);
        return mainPanel;
    }

    // ---------------- Registration Validation ----------------
    private void validateRegistration() {
        String lastName = lastNameField.getText().trim();
        String firstName = firstNameField.getText().trim();
        String username = usernameField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (password.isEmpty()) {
            showError("Password is required!");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showError("Passwords do not match!");
            return;
        }

        if ((firstName.isEmpty() && lastName.isEmpty()) && username.isEmpty()) {
            showError("Username is required if there is no first or last name!");
            return;
        }

        if (email.isEmpty() && phone.isEmpty()) {
            showError("Email or phone number is required!");
            return;
        }

        if (!email.isEmpty() && !email.contains("@")) {
            showError("Email must contain '@' symbol!");
            return;
        }

        if (!phone.isEmpty() && !phone.matches("\\d{10}")) {
            showError("Phone number must contain exactly 10 digits!");
            return;
        }

        showMessage("Registration successful!");
    }

    // ---------------- Login Validation ----------------
    private void validateLogin() {
        String username = loginUsernameField.getText().trim();
        String password = new String(loginPasswordField.getPassword());

        if (username.isEmpty()) {
            showError("Username is required!");
            return;
        }

        if (password.isEmpty()) {
            showError("Password is required!");
            return;
        }

        if (username.equals("admin") && password.equals("1234")) {
            showMessage("Login successful!");
        } else {
            showError("Invalid username or password!");
        }
    }

    // ---------------- Helper methods ----------------
    private void clearRegistrationFields() {
        lastNameField.setText("");
        firstNameField.setText("");
        usernameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
    }

    private void clearLoginFields() {
        loginUsernameField.setText("");
        loginPasswordField.setText("");
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // ---------------- Main ----------------
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginRegisterTabbed());
    }
}
