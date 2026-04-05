//An abstract parent class GymMember is created
public abstract class GymMember {
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance = 0;
    protected double loyaltyPoints = 0.0;
    protected boolean activeStatus = false;
    protected boolean isReverted;

    //A constructor that accepts the various details of the member as parameters
    public GymMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
    }

    //An abstract method is created to track the attendance and loyalty points of member and is to be implemented by subclasses
    public abstract void markAttendance();

    //A method that activates the membership
    public void activateMembership()
    {
        activeStatus = true;
    }

    //A method that deactivates the membership
    public void deactivateMembership()
    {
        if (activeStatus) {
            activeStatus = false;
        }
        else {
            System.out.println("Membership has already been deactivated.");
        }
    }

    //A method to reset the member's attendance, loyalty points and active status
    public void resetMember()
    {
        this.activeStatus = false;
        this.loyaltyPoints = 0.0;
        this.attendance = 0;
    }

    // Mark the member as reverted
    public void markAsReverted() {
        this.isReverted = true;  // Set the flag to true when reverted
    }

    // Check if the member is reverted
    public boolean marksAsReverted() {
        return this.isReverted;
    }

    //A method that displays the details of the member
    public void display()
    {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("DOB: " + DOB);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Active Status: " + activeStatus);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getDOB() {
        return DOB;
    }

    public String getMembershipStartDate() {
        return membershipStartDate;
    }

    public int getAttendance() {
        return attendance;
    }

    public double getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }
}

