package com.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String fileName) {

		File csvFile = new File(System.getProperty("user.dir") + "\\src\\testData\\loginData.csv");
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] data;
		List<User> userList = new ArrayList<User>();
		User user;

		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();

			while ((data = csvReader.readNext()) != null) {

				user = new User(data[0], data[1]);
				userList.add(user);

			}

			for (User userData : userList) {
				System.out.println(userData);

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		catch (CsvValidationException | IOException e) {

			e.printStackTrace();
		}
return userList.iterator();
	}

}
