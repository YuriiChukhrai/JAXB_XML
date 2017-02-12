package core.schema.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employees")
public class PeopleListSchema {

	List<Person> employees = new ArrayList<Person>();

	@XmlElement(name = "employee")
	public List<Person> getEmployees() {
		return employees;
	}

	public static class Person {

		List<String> id = new ArrayList<String>();

		@XmlAttribute(name = "id")
		public List<String> getId() {
			return id;
		}

		List<String> firstname = new ArrayList<String>();

		@XmlElement(name = "firstname")
		public List<String> getFirstNames() {
			return firstname;
		}

		List<String> lastname = new ArrayList<String>();

		@XmlElement(name = "lastname")
		public List<String> getLastNames() {
			return lastname;
		}

		List<String> title = new ArrayList<String>();

		@XmlElement(name = "title")
		public List<String> getTitle() {
			return title;
		}

		List<String> hiredate = new ArrayList<String>();

		@XmlElement(name = "hiredate")
		public List<String> getHireDate() {
			return hiredate;
		}

		List<String> phone = new ArrayList<String>();

		@XmlElement(name = "phone")
		public List<String> getPhone() {
			return phone;
		}

		List<String> email = new ArrayList<String>();

		@XmlElement(name = "email")
		public List<String> getEmail() {
			return email;
		}
		
	}
}// END OF CLASS