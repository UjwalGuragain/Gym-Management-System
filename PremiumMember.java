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
  
}
