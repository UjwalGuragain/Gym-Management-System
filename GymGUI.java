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
       
       // DOB Input
        label = new JLabel("DOB:");
        label.setBounds(30, 270, 150, 25);
        frame.add(label);
        String[] years = new String[201];
        for (int i = 0; i <= 200; i++) {
            years[i] = String.valueOf(2026 - i);
        }
        DOB_Year = new JComboBox<>(years);
        DOB_Year.setBounds(200, 270, 80, 25);
        frame.add(DOB_Year);

        DOB_Month = new JComboBox<>(new String[]{
            "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"
        });
        DOB_Month.setBounds(280, 270, 100, 25);
        frame.add(DOB_Month);

        DOB_Day = new JComboBox<>();
        for (int i = 1; i <= 32; i++) {
            DOB_Day.addItem(String.valueOf(i));
        }
        DOB_Day.setBounds(380, 270, 80, 25);
        frame.add(DOB_Day);

        // Membership Start Date Input
        label = new JLabel("Membership Start Date:");
        label.setBounds(900, 150, 150, 25);
        frame.add(label);
        String[] year = new String[201];
        for (int i = 0; i <= 200; i++) {
            year[i] = String.valueOf(2026 - i);
        }
        startyear = new JComboBox<>(year);
        startyear.setBounds(1080, 150, 80, 25);
        frame.add(startyear);

        startmonth = new JComboBox<>(new String[]{
            "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"
        });
        startmonth.setBounds(1160, 150, 100, 25);
        frame.add(startmonth);

        startdate = new JComboBox<>();
        for (int i = 1; i <= 32; i++) {
            startdate.addItem(String.valueOf(i));
        }
        startdate.setBounds(1260, 150, 50, 25);
        frame.add(startdate);

        // Referral Source Input
        label = new JLabel("Referral Source:");
        label.setBounds(900, 190, 150, 25);
        frame.add(label);
        fieldReferralSource = new JTextField();
        fieldReferralSource.setBounds(1080, 190, 200, 25);
        frame.add(fieldReferralSource);

        // Trainer Name Input
        label = new JLabel("Trainer's Name:");
        label.setBounds(900, 230, 150, 25);
        frame.add(label);
        fieldTrainerName = new JTextField();
        fieldTrainerName.setBounds(1080, 230, 200, 25);
        frame.add(fieldTrainerName);

        // Membership Type Label and ComboBox
        JLabel membershipTypeLabel = new JLabel("Membership Type:");
        membershipTypeLabel.setBounds(30, 310, 150, 25);
        frame.add(membershipTypeLabel);

        membershipTypeBox = new JComboBox<>(new String[] { "Regular", "Premium" });
        membershipTypeBox.setBounds(200, 310, 150, 25);
        frame.add(membershipTypeBox);

        // Plan for Regular Label and ComboBox
        JLabel planForRegularLabel = new JLabel("Plan for Regular:");
        planForRegularLabel.setBounds(30, 350, 150, 25);
        frame.add(planForRegularLabel);

        planForRegularBox = new JComboBox<>(new String[] { "Basic", "Standard", "Deluxe" });
        planForRegularBox.setBounds(200, 350, 150, 25);
        frame.add(planForRegularBox);

        // Regular Plan Price Field
        JLabel regularPlanPriceLabel = new JLabel("Regular plan price:");
        regularPlanPriceLabel.setBounds(900, 30, 150, 30);
        frame.add(regularPlanPriceLabel);

        priceField = new JTextField("Rs 6500");
        priceField.setBounds(1080, 30, 200, 30);
        priceField.setEditable(false);
        priceField.setHorizontalAlignment(JTextField.CENTER);
        priceField.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
        frame.add(priceField);

        // Show/hide Plan for Regular based on Membership Type
        planForRegularLabel.setVisible(true);
        planForRegularBox.setVisible(true);

        membershipTypeBox.addActionListener(e -> {
            boolean isRegular = membershipTypeBox.getSelectedItem().equals("Regular");
            planForRegularLabel.setVisible(isRegular);
            planForRegularBox.setVisible(isRegular);
            // Set price for Regular or clear for Premium
            if (isRegular) {
                String plan = (String) planForRegularBox.getSelectedItem();
                if (plan.equals("Basic"))
                    priceField.setText("Rs 6500");
                else if (plan.equals("Standard"))
                    priceField.setText("Rs 12500");
                else if (plan.equals("Deluxe"))
                    priceField.setText("Rs 18500");
            } else {
                priceField.setText("");
            }
        });

        // Update price when Plan for Regular changes
        planForRegularBox.addActionListener(e -> {
            String plan = (String) planForRegularBox.getSelectedItem();
            if (plan.equals("Basic"))
                priceField.setText("Rs 6500");
            else if (plan.equals("Standard"))
                priceField.setText("Rs 12500");
            else if (plan.equals("Deluxe"))
                priceField.setText("Rs 18500");
        });

        // Paid Amount Input
        label = new JLabel("Paid Amount:");
        label.setBounds(900, 110, 100, 30);
        frame.add(label);
        fieldPaidAmount = new JTextField();
        fieldPaidAmount.setBounds(1080, 110, 200, 30);
        frame.add(fieldPaidAmount);

        // Removal Reason Input
        label = new JLabel("Removal Reason:");
        label.setBounds(900, 270, 150, 25);
        frame.add(label);
        fieldRemovalReason = new JTextField();
        fieldRemovalReason.setBounds(1080, 270, 200, 25);
        frame.add(fieldRemovalReason);
        JLabel premiumlabel = new JLabel("Premium Plan Price:");
        premiumlabel.setBounds(900, 70, 150, 30);
        frame.add(premiumlabel);

        JTextField premiumpriceField = new JTextField("Rs 50000");
        premiumpriceField.setBounds(1080, 70, 200, 30);
        premiumpriceField.setEditable(false);
        premiumpriceField.setHorizontalAlignment(JTextField.CENTER);
        premiumpriceField.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
        frame.add(premiumpriceField);

        // Buttons
        btnAddRegular = new JButton("Add Regular Member");
        btnAddRegular.setBounds(30, 480, 200, 30);
        btnAddRegular.addActionListener(this);
        frame.add(btnAddRegular);

        btnAddPremium = new JButton("Add Premium Member");
        btnAddPremium.setBounds(1080, 480, 200, 30);
        btnAddPremium.addActionListener(this);
        frame.add(btnAddPremium);

        btnDisplay = new JButton("Display Members");
        btnDisplay.setBounds(30, 560, 200, 30);
        btnDisplay.addActionListener(this);
        frame.add(btnDisplay);

        btnActivate = new JButton("Activate Membership");
        btnActivate.setBounds(30, 520, 200, 30);
        btnActivate.addActionListener(this);
        frame.add(btnActivate);

        btnDeactivate = new JButton("Deactivate Membership");
        btnDeactivate.setBounds(1080, 560, 200, 30);
        btnDeactivate.addActionListener(this);
        frame.add(btnDeactivate);

        btnMarkAttendance = new JButton("Mark Attendance");
        btnMarkAttendance.setBounds(1080, 520, 200, 30);
        btnMarkAttendance.addActionListener(this);
        frame.add(btnMarkAttendance);

        btnUpgradePlan = new JButton("Upgrade Plan");
        btnUpgradePlan.setBounds(550, 480, 200, 30);
        btnUpgradePlan.addActionListener(this);
        frame.add(btnUpgradePlan);

        btnCalculateDiscount = new JButton("Calculate Discount");
        btnCalculateDiscount.setBounds(1080, 600, 200, 30);
        btnCalculateDiscount.addActionListener(this);
        frame.add(btnCalculateDiscount);

        btnRevertRegular = new JButton("Revert Regular Member");
        btnRevertRegular.setBounds(30, 640, 200, 30);
        btnRevertRegular.addActionListener(this);
        frame.add(btnRevertRegular);

        btnRevertPremium = new JButton("Revert Premium Member");
        btnRevertPremium.setBounds(30, 600, 200, 30);
        btnRevertPremium.addActionListener(this);
        frame.add(btnRevertPremium);

        btnPayDue = new JButton("Pay Due Amount");
        btnPayDue.setBounds(550, 520, 200, 30);
        btnPayDue.addActionListener(this);
        frame.add(btnPayDue);

        btnClear = new JButton("Clear Fields");
        btnClear.setBounds(1080, 640, 200, 30);
        btnClear.addActionListener(this);
        frame.add(btnClear);

        // Add Save to File button
        btnSaveToFile = new JButton("Save to File");
        btnSaveToFile.setBounds(550, 560, 200, 30);
        btnSaveToFile.addActionListener(this);
        frame.add(btnSaveToFile);

        // Add Read from File button
        btnReadFromFile = new JButton("Read from File");
        btnReadFromFile.setBounds(550, 600, 200, 30);
        btnReadFromFile.addActionListener(this);
        frame.add(btnReadFromFile);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        try {
            if (a.getSource() == btnAddRegular) {
                regularmember();
            } else if (a.getSource() == btnAddPremium) {
                premiummember();
            } else if (a.getSource() == btnDisplay) {
                display();
            } else if (a.getSource() == btnActivate) {
                activate();
            } else if (a.getSource() == btnDeactivate) {
                deactivate();
            } else if (a.getSource() == btnMarkAttendance) {
                markAttendance();
            } else if (a.getSource() == btnCalculateDiscount) {
                calculateDiscount();
            } else if (a.getSource() == btnRevertRegular) {
                revertRegularMember();
            } else if (a.getSource() == btnRevertPremium) {
                revertPremiumMember();
            } else if (a.getSource() == btnPayDue) {
                payDueAmount();
            } else if (a.getSource() == btnClear) {
                clearFields();
            } else if (a.getSource() == btnSaveToFile) {
                saveToFile();
            } else if (a.getSource() == btnReadFromFile) {
                readFromFile();
            } else if (a.getSource() == btnUpgradePlan) {
                upgradePlan();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "An Error Occurred: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void regularmember() {
        try {
            int id = Integer.parseInt(fieldId.getText().trim());

            // Check for duplicate ID
            if (isDuplicateId(id)) {
                JOptionPane.showMessageDialog(frame, "Member ID already exists! Please use a unique ID.", "Duplicate ID", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String gender = maleRadio.isSelected() ? "Male" : "Female";
            String dob = DOB_Day.getSelectedItem() + "/" + DOB_Month.getSelectedItem() + "/" + DOB_Year.getSelectedItem();
            String membershipStart = startdate.getSelectedItem() + "/" + startmonth.getSelectedItem() + "/" + startyear.getSelectedItem();

            RegularMember member = new RegularMember(
                    id, fieldName.getText(), fieldLocation.getText(), fieldPhone.getText(),
                    fieldEmail.getText(), gender, dob, membershipStart,
                    fieldReferralSource.getText());

            // Set plan and price
            String plan = (String) planForRegularBox.getSelectedItem();
            member.setPlan(plan);
            if (plan.equalsIgnoreCase("Basic")) member.setPrice(6500.0);
            else if (plan.equalsIgnoreCase("Standard")) member.setPrice(12500.0);
            else if (plan.equalsIgnoreCase("Deluxe")) member.setPrice(18500.0);

            // Set paid amount if entered
            String paidText = fieldPaidAmount.getText().trim();
            if (!paidText.isEmpty()) {
                try {
                    double paid = Double.parseDouble(paidText);
                    if (paid < 0) {
                        JOptionPane.showMessageDialog(frame, "Paid amount cannot be negative!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (paid > 0) {
                        member.setPaidAmount(paid);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid paid amount entered!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            memberList.add(member);
            JOptionPane.showMessageDialog(frame, "Regular Member added successfully.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid details!", "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void premiummember() {
        try {
            int id = Integer.parseInt(fieldId.getText().trim());

            // Check for duplicate ID
            if (isDuplicateId(id)) {
                JOptionPane.showMessageDialog(frame, "Member ID already exists! Please use a unique ID.", "Duplicate ID", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Prevent adding Premium Member if membershipTypeBox is "Regular"
            if (membershipTypeBox.getSelectedItem().toString().equalsIgnoreCase("Regular")) {
                JOptionPane.showMessageDialog(frame, "Cannot add Premium Member when Membership Type is set to Regular.", "Invalid Operation", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String gender = maleRadio.isSelected() ? "Male" : "Female";
            String dob = DOB_Day.getSelectedItem() + "/" + DOB_Month.getSelectedItem() + "/" + DOB_Year.getSelectedItem();
            String membershipStart = startdate.getSelectedItem() + "/" + startmonth.getSelectedItem() + "/" + startyear.getSelectedItem();

            PremiumMember member = new PremiumMember(
                    id, fieldName.getText(), fieldLocation.getText(), fieldPhone.getText(),
                    fieldEmail.getText(), gender, dob, membershipStart, fieldTrainerName.getText());

            // Set paid amount from the field
            String paidText = fieldPaidAmount.getText().trim();
            if (!paidText.isEmpty()) {
                try {
                    double paid = Double.parseDouble(paidText);
                    if (paid < 0) {
                        JOptionPane.showMessageDialog(frame, "Paid amount cannot be negative!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (paid > 0) {
                        member.setPaidAmount(paid);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid paid amount entered!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            memberList.add(member);
            JOptionPane.showMessageDialog(frame, "Premium Member added successfully.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid details!", "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void display() {
        JFrame displayFrame = new JFrame("Gym Members");
        displayFrame.setSize(600, 700);
        displayFrame.setLocationRelativeTo(frame);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        boolean hasMembers = false;

        for (GymMember member : memberList) {
            if (member.marksAsReverted())
                continue;

            hasMembers = true;

            JPanel memberPanel = new JPanel(new GridLayout(0, 1));
            memberPanel.setBorder(BorderFactory.createTitledBorder(
                    member.getClass().getSimpleName() + " - ID: " + member.id));

            // Membership Type
            String membershipType = (member instanceof RegularMember) ? "Regular" : "Premium";
            memberPanel.add(new JLabel("Membership Type: " + membershipType));

            // Membership Plan
            String plan = (member instanceof RegularMember) ? ((RegularMember) member).getPlan() : "Premium";
            memberPanel.add(new JLabel("Membership Plan: " + plan));

            memberPanel.add(new JLabel("Name: " + member.name));
            memberPanel.add(new JLabel("Phone: " + member.phone));
            memberPanel.add(new JLabel("Email: " + member.email));
            memberPanel.add(new JLabel("Location: " + member.location));
            memberPanel.add(new JLabel("Gender: " + member.gender));
            memberPanel.add(new JLabel("DOB: " + member.DOB));
            memberPanel.add(new JLabel("Membership Start: " + member.membershipStartDate));
            memberPanel.add(new JLabel("Attendance: " + member.attendance));
            memberPanel.add(new JLabel("Loyalty Points: " + member.loyaltyPoints));
            memberPanel.add(new JLabel("Status: " + (member.activeStatus ? "Active" : "Inactive")));

            if (member instanceof RegularMember) {
                RegularMember rm = (RegularMember) member;
                memberPanel.add(new JLabel("Paid Amount: " + rm.getPaidAmount()));
                memberPanel.add(new JLabel("Referral Source: " + rm.getReferralSource()));
            } else if (member instanceof PremiumMember) {
                PremiumMember pm = (PremiumMember) member;
                memberPanel.add(new JLabel("Paid Amount: " + pm.getPaidAmount()));
                memberPanel.add(new JLabel("Trainer Name: " + pm.getPersonalTrainer()));
            }

            contentPanel.add(memberPanel);
        }

        if (!hasMembers) {
            contentPanel.add(new JLabel("No Members to Display."));
        }

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        displayFrame.add(scrollPane);
        displayFrame.setVisible(true);
    }

    private void activate() {
        try {
            int id = findMemberId("Activate Membership");
            if (id == -1)
                return;
            for (GymMember member : memberList) {
                if (member.id == id) {
                    member.activateMembership();
                    JOptionPane.showMessageDialog(frame, "Membership activated for member ID: " + id);
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "No member found with ID: " + id, "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid ID to activate membership!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deactivate() {
        try {
            int id = findMemberId("Deactivate Membership");
            if (id == -1)
                return;
            for (GymMember member : memberList) {
                if (member.id == id) {
                    member.deactivateMembership();
                    JOptionPane.showMessageDialog(frame, "Membership deactivated for member ID: " + id);
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "No member found with ID: " + id, "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid ID to deactivate membership!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    
}
