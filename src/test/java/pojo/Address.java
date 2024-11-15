package pojo;

public class Address {
	
	private String street;
	private String city;
	private String state;
	
	public Address(String street,String city,String state) {
		// TODO Auto-generated constructor stub
		this.state=state;
		this.city=city;
		this.street=street;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street=street;
	}

	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city=city;
	}
	
	public String state() {
		return city;
	}
	
	public void setState(String state) {
		this.state=state;
	}
}
