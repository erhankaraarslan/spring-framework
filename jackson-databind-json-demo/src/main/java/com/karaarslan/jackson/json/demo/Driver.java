package com.karaarslan.jackson.json.demo;

import java.io.File;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {

			// create object mapper
			ObjectMapper mapper = new ObjectMapper();

			// read JSON file and map/convert to Java POJO :
			// data/sample-lite.json
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);

			// print first name an last name

			System.out.println("first name : " + theStudent.getFirstName());
			System.out.println("last name : " + theStudent.getLastName());
			System.out.println("adress :" + theStudent.getAddress());
			System.out.println(Arrays.toString(theStudent.getLanguages()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
