// A class that inherits GymMember class
public class RegularMember extends GymMember{
    private final int attendanceLimit = 30;
    private boolean isEligibleForUpgrade = false;
    private String removalReason = "";
    private String referralSource;
    private String plan = "Basic";
    private double price = 6500.0;
    private double paidAmount = 0.0; 
    
    //A constructor that accepts parameters for regular members and calls the parent constructor
    public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String referralSource) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.referralSource = referralSource;
    }
    
    //Implementing the abstract method from parent class to track attendance and loyalty points of regular members
    @Override
    public void markAttendance() {
        if (activeStatus) {
            attendance++;
            loyaltyPoints += 5;
            if (attendanceLimit <= attendance) 
            isEligibleForUpgrade = true;
        } else 
        {
            System.out.println("Membership is not active, Activate first.");
        }
    }
    
    //A method to get the price of various plans
    public double getPlanPrice(String plan) {
        switch (plan) {
            case "basic":
                return 6500.0;
            case "standard":
                return 12500.0;
            case "deluxe":
                return 18500.0;
            default:
                return -1;
        }
    }
