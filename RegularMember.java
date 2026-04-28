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

    //A method to upgrade the plan
    public String upgradePlan(String newPlan) {
        if (newPlan == null || newPlan.equalsIgnoreCase(plan)) {
            return "No upgrade performed.";
        }
        if (newPlan.equalsIgnoreCase("Basic")) {
            plan = "Basic";
            price = 6500.0;
        } else if (newPlan.equalsIgnoreCase("Standard")) {
            plan = "Standard";
            price = 12500.0;
        } else if (newPlan.equalsIgnoreCase("Deluxe")) {
            plan = "Deluxe";
            price = 18500.0;
        } else {
            return "Invalid plan selected.";
        }
        return "Plan upgraded to " + plan + ". New price: Rs " + price;
    }
    
    //A method to reset attributes of the regular member to default
    public void revertRegularMember(String removalReason) {
        resetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = removalReason;
    }
     //A display method that calls the method form parent class to show all details of regular member
    @Override
    public void display() {
        super.display();
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        if (!removalReason.isEmpty()) {
            System.out.println("Removal Reason: " + removalReason);
        }
    }

    public int getAttendanceLimit() {
        return attendanceLimit;
    }

    public boolean isEligibleForUpgrade() {
        return isEligibleForUpgrade;
    }

    public String getRemovalReason() {
        return removalReason;
    }

    public String getReferralSource() {
        return referralSource;
    }

    public String getPlan() {
        return plan;
    }

    public double getPrice() {
        return price;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public void setEligibleForUpgrade(boolean eligibleForUpgrade) {
        isEligibleForUpgrade = eligibleForUpgrade;
    }

    public void setRemovalReason(String removalReason) {
        this.removalReason = removalReason;
    }

    public void setReferralSource(String referralSource) {
        this.referralSource = referralSource;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Optional: add a payDueAmount method for RegularMember
    public String payDueAmount(double amount) {
        if (paidAmount >= price) {
            return "Full payment is already completed.";
        }
        paidAmount += amount;
        if (paidAmount > price) {
            paidAmount -= amount; // revert
            return "Payment exceeds the total charge.";
        }
        return "Payment successful. Your Remaining balance is: " + (price - paidAmount);
    }
 }
