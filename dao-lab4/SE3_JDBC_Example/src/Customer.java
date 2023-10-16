
public class Customer {
	
	private double creditLimit;
	private int salesRepEmployeeNumber;
	private String country;
	private String postalCode;
	private String state;
	private String city;
	private String addressLine2;
	private String addressLine1;
	private String phone;
	private String contactFirstName;
	private String customerName;
	private String contactLastName; 
	private int customerNumber;
	
	
	public Customer(double creditLimit, int salesRepEmployeeNumber, String country, String postalCode, String state,
			String city, String addressLine2, String addressLine1, String phone, String contactFirstName,
			String customerName, String contactLastName, int customerNumber) {
		this.creditLimit = creditLimit;
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
		this.country = country;
		this.postalCode = postalCode;
		this.state = state;
		this.city = city;
		this.addressLine2 = addressLine2;
		this.addressLine1 = addressLine1;
		this.phone = phone;
		this.contactFirstName = contactFirstName;
		this.customerName = customerName;
		this.contactLastName = contactLastName;
		this.customerNumber = customerNumber;
	}
	
	
	@Override
	public String toString() {
		return "Customer [creditLimit=" + creditLimit + ", salesRepEmployeeNumber=" + salesRepEmployeeNumber
				+ ", country=" + country + ", postalCode=" + postalCode + ", state=" + state + ", city=" + city
				+ ", addressLine2=" + addressLine2 + ", addressLine1=" + addressLine1 + ", phone=" + phone
				+ ", contactFirstName=" + contactFirstName + ", customerName=" + customerName + ", contactLastName="
				+ contactLastName + ", customerNumber=" + customerNumber + "]";
	}


	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public int getSalesRepEmployeeNumber() {
		return salesRepEmployeeNumber;
	}
	public void setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContactFirstName() {
		return contactFirstName;
	}
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}
	public String getContactLastName() {
		return contactLastName;
	}
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	
}
