package pojo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Payload {

	private String email;
	private String firstName;
	private String lastName;
	private ArrayList<String> primarySkill=new ArrayList<String>();
	private ArrayList<Integer> mobileNumber=new ArrayList<Integer>();
	private ArrayList<Object> educations=new ArrayList<Object>();
	private ArrayList<Object> address=new ArrayList<Object>();

	public Payload(String email, String firstName, String lastName) {
		// TODO Auto-generated constructor stub
		this.email=email;
		this.firstName=firstName;
		this.lastName=lastName;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String lastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ArrayList<String> getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(String... primarySkill) {
		for (int i = 0; i < primarySkill.length; i++) {
			this.primarySkill.add(primarySkill[i]);
		}
	}

	public ArrayList<Integer> getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int... mobileNumber) {
		for (int i = 0; i < mobileNumber.length; i++) {
			this.mobileNumber.add(mobileNumber[i]);
		}
	}

	public Object getEducation() {
		return educations;
	}

	public void setEducation(Object... educations) {
		for (int i = 0; i < educations.length; i++) {
			this.educations.add(educations[i]);
		}
	}
	
	public ArrayList<Object> getAddress(){
		return address;
	}
	
	public void setAddress(Object ...addresses) {
	for(int i=0;i< addresses.length;i++) {	
		this.address.add(addresses[i]);
	}
	}

}
