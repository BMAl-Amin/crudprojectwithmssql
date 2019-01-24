package io.naztech.crudmicrosoftsql.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import io.naztech.crudmicrosoftsql.dao.interfaces.CrudDaoInterface;
import io.naztech.crudmicrosoftsql.models.CrudModel;
import io.naztech.crudmicrosoftsql.utils.DBConnection;

public class CrudDaoImplement implements CrudDaoInterface {

	Connection conn = DBConnection.getDbInstance().getConnection();
	Statement stmt = null;
	String query = null;
	CrudModel crudModel = new CrudModel();
	PreparedStatement statement = null;
	ResultSet rs=null;

	@Override
	public int insertData(int customerId, String customerName, String customerSalary, String customerCountry,
			String customerZipcode) {

		crudModel.setId(customerId);
		crudModel.setName(customerName);
		crudModel.setSalary(customerSalary);
		crudModel.setCauntry(customerCountry);
		crudModel.setZipcode(customerZipcode);

		query = "insert into T_bmemployee values(?,?,?,?,?)";
		try {
			statement = conn.prepareStatement(query);

			// set data for preparedstatement
			statement.setInt(1, crudModel.getId());
			statement.setString(2, crudModel.getName());
			statement.setString(3, crudModel.getSalary());
			statement.setString(4, crudModel.getCauntry());
			statement.setString(5, crudModel.getZipcode());
			statement.executeUpdate();

			statement.close();
			conn.close();
			System.out.println("data inserted");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("data not inserted");
		}
		return 0;
	}

	@Override
	public int editData(int customerId, String fieldName, String newDataForCustomerId) {

		crudModel.setId(customerId);
		crudModel.setFieldName(fieldName);
		crudModel.setNewDataForCustomerId(newDataForCustomerId);

		query = "update T_bmemployee set " + crudModel.getFieldName() + "= ? where id= ?";
		try {
			statement = conn.prepareStatement(query);

			statement.setString(1, crudModel.getNewDataForCustomerId());
			statement.setInt(2, crudModel.getId());
			statement.executeUpdate();
			
			statement.close();
			conn.close();
			
			System.out.println("Successfully Edited");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	@Override
	public int deleteRecord(String customerName) {

		crudModel.setName(customerName);
		
		query = "delete from T_bmemployee where c_name= ?";
		try {
			statement = conn.prepareStatement(query);

			statement.setString(1, crudModel.getName());
			statement.executeUpdate();
			
			statement.close();
			conn.close();
			
			System.out.println("Successfully deleted");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return 0;
	}
	
	@Override
	public CrudModel showRecord(int customerId) {
		
		crudModel.setId(customerId);
		
		query="select * from T_bmemployee where id= ?";
		try {
			statement= conn.prepareStatement(query);
			statement.setInt(1, crudModel.getId());
			
			rs=statement.executeQuery();
			
			rs.next();
			crudModel.setId(rs.getInt(1));
			crudModel.setName(rs.getString(2));
			crudModel.setSalary(rs.getString(3));
			crudModel.setCauntry(rs.getString(4));
			crudModel.setZipcode(rs.getString(5));
			
			statement.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}finally {
			
		}
		return crudModel;
		
	}

	
	public ArrayList<CrudModel> showAll() {
		
		
		ArrayList<CrudModel> records= new ArrayList<CrudModel>();
		
		query="select * from T_bmemployee";
		try {
			statement= conn.prepareStatement(query);
	
			rs=statement.executeQuery();
			while(rs.next()) {
				crudModel= new CrudModel();
				crudModel.setId(rs.getInt(1));
				crudModel.setName(rs.getString(2));
				crudModel.setSalary(rs.getString(3));
				crudModel.setCauntry(rs.getString(4));
				crudModel.setZipcode(rs.getString(5));
				records.add(crudModel);	
			}
	
			statement.close();
			rs.close();
			conn.close();
			
			return records;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public String foundSalaryMax() {
		
		query="select min(c_salary) as salary from T_bmemployee";
		try {
			statement= conn.prepareStatement(query);
			rs=statement.executeQuery();
			rs.next();
			return rs.getString("salary"); //here is a error that has to be solved. problem is about string field. need to be alter as int field
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void createTable(String newTableName) {
		try {
			stmt = conn.createStatement();
			query = "create table "+newTableName+"(" 
			+ "id int NOT NULL identity(1,1), " 
					+ "c_name varchar(30), "
					+ "c_salary varchar(30), "
					+ "c_country varchar(30), "
					+ "c_zipcode varchar(30), "
					+ "primary key(id))";
			
			stmt.executeUpdate(query);
			
			stmt.close();
			conn.close();
			System.out.println("successfully createted");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
