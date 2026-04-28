import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class GymGUI implements ActionListener {
    // Components
    public JFrame frame;
    public JTextField fieldId, fieldName, fieldLocation, fieldPhone, fieldEmail, fieldDOB, fieldMembershipStart,
            fieldReferralSource, fieldPaidAmount, fieldRemovalReason, fieldTrainerName;
    public JRadioButton maleRadio, femaleRadio;
    public JComboBox<String> DOB_Year, DOB_Month, DOB_Day;
    public JComboBox<String> startyear, startmonth, startdate;
    public JComboBox<String> membershipTypeBox, planForRegularBox;
    public JTextField priceField;
    public JButton btnAddRegular, btnAddPremium, btnDisplay, btnActivate, btnDeactivate,
            btnMarkAttendance, btnUpgradePlan, btnCalculateDiscount, btnRevertRegular,
            btnRevertPremium, btnPayDue, btnClear, btnSaveToFile, btnReadFromFile;
    public ButtonGroup genderGroup;
    
        // Member List
    private ArrayList<GymMember> memberList = new ArrayList<>();
    public static void main(String[] args) {new GymGUI();}

    public GymGUI() {
        frame = new JFrame();
        frame.setTitle("Gym Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 800);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.CYAN);
        

        JLabel titleLabel = new JLabel("Gym Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(200, 0, 900, 50);
        frame.add(titleLabel);

        create();
        frame.setVisible(true);
    }
   private void create() {
        JLabel label;

        // ID Input
        label = new JLabel("ID:");
        label.setBounds(30, 30, 150, 25);
        frame.add(label);
        fieldId = new JTextField();
        fieldId.setBounds(200, 30, 200, 25);
        frame.add(fieldId);

        // Name Input
        label = new JLabel("Name:");
        label.setBounds(30, 70, 150, 25);
        frame.add(label);
        fieldName = new JTextField();
        fieldName.setBounds(200, 70, 200, 25);
        frame.add(fieldName);

        // Location Input
        label = new JLabel("Location:");
        label.setBounds(30, 110, 150, 25);
        frame.add(label);
        fieldLocation = new JTextField();
        fieldLocation.setBounds(200, 110, 200, 25);
        frame.add(fieldLocation);
        // Phone Input
        label = new JLabel("Phone:");
        label.setBounds(30, 150, 150, 25);
        frame.add(label);
        fieldPhone = new JTextField();
        fieldPhone.setBounds(200, 150, 200, 25);
        frame.add(fieldPhone);

        // Email Input
        label = new JLabel("Email:");
        label.setBounds(30, 190, 150, 25);
        frame.add(label);
        fieldEmail = new JTextField();
        fieldEmail.setBounds(200, 190, 200, 25);
        frame.add(fieldEmail);

        // Gender Input
        label = new JLabel("Gender:");
        label.setBounds(30, 230, 150, 25);
        frame.add(label);
        maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(200, 230, 80, 25);
        femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(290, 230, 80, 25);
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        frame.add(maleRadio);
        frame.add(femaleRadio);
       
}
