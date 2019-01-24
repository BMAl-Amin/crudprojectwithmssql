package io.naztech.crudmicrosoftsql.main;

import io.naztech.crudmicrosoftsql.dao.impl.CrudDaoImplement;
import io.naztech.crudmicrosoftsql.dao.interfaces.CrudDaoInterface;
import io.naztech.crudmicrosoftsql.models.CrudModel;

public class MainClass {

	public static void main(String[] args) {
		
		CrudDaoInterface crudDaoInterface= new CrudDaoImplement();
		
		//crudDaoInterface.createTable("T_bmemployeeA"); //create new table
		//crudDaoInterface.insertData(1, "alamin", "50000", "uganda", "9246"); //insert new record
		//crudDaoInterface.deleteRecord("bm"); //delete specific record
		//crudDaoInterface.editData(1, "c_salary", "5000"); //edit existed record
		//System.out.println(crudDaoInterface.showRecord(1)); //view specific record
//		for(CrudModel crudModel: crudDaoInterface.showAll()) { //view all records
//			System.out.println(crudModel);
//		}
		System.out.println(crudDaoInterface.foundSalaryMax());
	}

}
