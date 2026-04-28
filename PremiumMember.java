// A class that inherits GymMember class
public class PremiumMember extends GymMember{
    private final double premiumCharge = 50000.00;
    private String personalTrainer;
    private boolean isFullPayment = false;
    private double paidAmount = 0.0;
    private double discountAmount = 0.0;

    //An constructor that accepts parameters for premium members and calls the parent constructor
    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }
    //Implementing the abstract method from parent class to track attendance and loyalty points of premium members
    @Override
    public void markAttendance() {
        if (activeStatus) {
            attendance++;
            loyaltyPoints += 5;
        }
        else {
            System.out.println("Membership is not active, Activate first.");
        }
    }
    
    //A method to pay due amount, show remaining balance,  update the paid amount and payment status
    public String payDueAmount(double amount) {
        if (isFullPayment) {
            return "Full payment is already completed.";
        }
        paidAmount += amount;
        if (paidAmount > premiumCharge) {
            return "Payment exceeds the total charge.";
        }
        if (paidAmount == premiumCharge) {

            isFullPayment = true;
        }
        return "Payment successful. Your Remaining balance is: " + (premiumCharge - paidAmount);
    }
    
    //A method to calculate the discount for Full payment
    public void calculateDiscount() {
        if (isFullPayment) {
            discountAmount = premiumCharge * 0.1;
            System.out.println("Discountable Amount: " + discountAmount);
        }
        else {
            System.out.println("Full payment is required for the discount.");
        }
    }
}
