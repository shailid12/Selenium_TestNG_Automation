package data;

import utilities.Xls_Reader;

public class DataClass {
	
	Xls_Reader data = new Xls_Reader("C:\\Users\\shaili\\Downloads\\QA files\\NikulTest.xlsx");
	
	//Login Data
	 public String wrong_email = data.getCellData("Data1", 1, 3);
	 public String wrong_password = data.getCellData("Data1", 2, 2);
	 public String invalid_email = data.getCellData("Data1", 1, 4);
	 public String global_exp_error = data.getCellData("Data1", 5, 2);
	 public String empty_email_error = data.getCellData("Data1", 3, 4);
	 public String empty_password_error = data.getCellData("Data1", 4, 3);
	 public String invalid_email_error = data.getCellData("Data1", 3, 5);
	 
	 //Home Data
	 
	 
	 //Career Data

}
