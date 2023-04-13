package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.
public class Student {
	private String firstName;
	private String lastName;
	private int ID;
	private int attemptedCredits;
	private int passingCredits;
	private double totalGradeQualityPoints;
	private double BearBucksBalance;
	
	public Student(String first, String last, int ID) {
		this.firstName = first;
		this.lastName = last;
		this.ID = ID;
		this.attemptedCredits = 0;
		this.passingCredits = 0;
		this.totalGradeQualityPoints = 0;
		this.BearBucksBalance = 0;
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	public int getId() {
		return this.ID;
	}
	
	public int getTotalAttemptedCredits() {
		return this.attemptedCredits;
	}
	
	public int getTotalPassingCredits() {
		return this.passingCredits;
	}
	
	public double calculateGradePointAverage() {
		return totalGradeQualityPoints / (double)attemptedCredits;
	}
	
	public void submitGrade(double grade, int credits) {
		this.totalGradeQualityPoints += grade*(double)credits;
		this.attemptedCredits += credits;
		
		if (grade >= 1.7) {
			this.passingCredits += credits;
		}
		
	}
	
	public String getClassStanding() {
		if (this.passingCredits < 30) {
			return "First Year";
		} else if (this.passingCredits < 60) {
			return "Sophomore";
		} else if (this.passingCredits < 90) {
			return "Junior";
		} else {
			return "Senior";
		}
	}
	
	public boolean isEligibleForPhiBetaKappa() {
		double GPA = calculateGradePointAverage();
		if (this.passingCredits >= 98 && GPA >= 3.60) {
			return true;
		} else if (this.passingCredits >= 75 && GPA >= 3.80) {
			return true;
		} else {
			return false;
		}
	}
	
	public void depositBearBucks(double amount) {
		this.BearBucksBalance += amount;
	}
	
	public void deductBearBucks(double amount) {
		this.BearBucksBalance -= amount;
	}
	
	public double getBearBucksBalance() {
		return this.BearBucksBalance;
	}
	
	public double cashOutBearBucks() {
		double balance = this.BearBucksBalance;
		this.BearBucksBalance = 0.0;
		if (balance > 10) {
			return balance-10;
		} else {
			return 0.0;
		}
	}
	
	public Student createLegacy(String first, Student otherParent, boolean isHyphenated, int id) {
		String last;
		if (isHyphenated) {
			last = this.lastName + "-" + otherParent.lastName;
		} else {
			last = this.lastName;
		}
		
		Student child = new Student(first, last, id);
		
		double bearBucks = this.cashOutBearBucks() + otherParent.cashOutBearBucks();
		
		child.depositBearBucks(bearBucks);
		
		return child;
	}
	
	public String toString() {
		return this.getFullName() + this.ID;
	}
}
