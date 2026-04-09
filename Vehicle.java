import java.time.Year; 
public class Vehicle {
    public String brandName;
    public String modelName;
    public double price;
    public String color;
    private String mfgCode;
    private String regNo;
    public Year mfgYear;
    public char fuelType; //

    //Getter and Setter
    public void setMfgCode(String mCode) {
        mfgCode = mCode;
    }

    public String getMfgCode() {
        return mfgCode;
    }

    public String getRegNo() {
        return regNo;
    }

    //Default Constructor
    public Vehicle() {
        brandName = "Hyundai";
        modelName = "i10";
        color = "White";
        price  = 500000.99;
        mfgCode = "HYN12345";
        regNo = "HYN98765";
        mfgYear = Year.of(2020);
        fuelType = 'P'; // E=Electric,P=Petrol,C=CNG
    }

    //Parameterized Constructor
    public Vehicle(String brandName , String modelName , double price, String mfgCode) {
        this.brandName = brandName;
        this.modelName = modelName;                                    //"this" is used if paramter has same name as variable.
        this.price = price;
        this.mfgCode = mfgCode;
    }

    public Vehicle(String c , String bn , String mn, double p) {
        color = c;
        brandName = bn;
        modelName = mn;
        price = p;
    }

    //Copy Constructor
    public Vehicle(Vehicle v) {
        brandName = v.brandName;
        price = v.price;
        color = v.color;
        mfgCode = v.mfgCode;
        regNo = v.regNo;
        mfgYear = v.mfgYear;
        fuelType = v.fuelType;
    }

    public void start(int initSp) {
        System.out.println("I have started with an initial spped of "+ initSp);
    }

    public void stop() {
       System.out.println("That was a nice ride !!!"); 
    }

    public void drive(int initGear, int initSp, int tgtSp){
        if (initGear != 1)
            System.out.println("I always start moving at the first gear."+ initGear);

        if (initSp < 20)
            System.out.println("That is the ideal speed to start with."+ initSp);

        else
            System.out.println("Be Careful !");

        if (tgtSp > 200)
            System.out.println("Look out for Copsss."+ tgtSp);

        else
            System.out.println("You are within the ideal speed range.");
    }

    public double calcTripMileage(double kms, double fuelUsed){
        return kms/fuelUsed;
    }
}
