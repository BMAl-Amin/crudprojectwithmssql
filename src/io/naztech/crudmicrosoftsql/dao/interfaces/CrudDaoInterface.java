package io.naztech.crudmicrosoftsql.dao.interfaces;

import java.util.ArrayList;

import io.naztech.crudmicrosoftsql.models.CrudModel;

public interface CrudDaoInterface {
	
	public void createTable(String newTableName);
	public int insertData(int customerId, String customerName, String customerSalary, 
			String customerCountry, String customerZipcode);
	
	public int editData(int customerId,String fieldName,String newDataForCustomerId);
	
	public int deleteRecord(String customerName);
	
	public CrudModel showRecord(int customerId);
	
	public ArrayList<CrudModel> showAll();
	
	public String foundSalaryMax();
}
