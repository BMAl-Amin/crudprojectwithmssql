package io.naztech.crudmicrosoftsql.models;

public class CrudModel {

	private int id;
	private String name;
	private String salary;
	private String cauntry;
	private String cityName;
	private String zipcode;
	private String fieldName;
	private String newDataForCustomerId;
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public void setCauntry(String cauntry) {
		this.cauntry = cauntry;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public void setFieldName(String fieldName) {
		this.fieldName=fieldName;
	}
	public void setNewDataForCustomerId(String newDataForCustomerId) {
		this.newDataForCustomerId = newDataForCustomerId;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSalary() {
		return salary;
	}
	public String getCauntry() {
		return cauntry;
	}
	public String getCityName() {
		return cityName;
	}
	public String getZipcode() {
		return zipcode;
	}
	public String getFieldName() {
		return fieldName;
	}
	public String getNewDataForCustomerId() {
		return newDataForCustomerId;
	}
	@Override
	public String toString() {
		return "Record [id=" + id + ", name=" + name + ", salary=" + salary + ", cauntry=" + cauntry + ", zipcode="
				+ zipcode + "]";
	}
	
}
