package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	
	private final Map<String, Student> database = new HashMap<String, Student>();

	public void addStudent(String accountName, Student student) {
		database.put(accountName, student);
	}

	public int getStudentCount() {
		return database.size();
	}

	public String lookupFullName(String accountName) {
		if (database.get(accountName) != null) {
			Student stud = database.get(accountName);
			return stud.getFullName();
		} else {
			return null;
		}
	}

	public double getTotalBearBucks() {
		double total = 0.0;
		for (String account : database.keySet()) {
			if (database.get(account) != null) {
				Student stud = database.get(account);
				total = total + stud.getBearBucksBalance();
			}
		}
		
		return total;
	}
}
