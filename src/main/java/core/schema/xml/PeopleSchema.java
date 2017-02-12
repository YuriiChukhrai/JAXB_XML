package core.schema.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employees")
public class PeopleSchema {

	@XmlElement(name = "employee")
	public Level2 people;

	public static class Level2 {

		@XmlAttribute(name = "id")
		public String id;

		@XmlElement(name = "firstname")
		public String firstname;

		@XmlElement(name = "lastname")
		public String lastname;

		@XmlElement(name = "title")
		public String title;

		@XmlElement(name = "hiredate")
		public String hiredate;

		@XmlElement(name = "phone")
		public String phone;

		@XmlElement(name = "email")
		public String email;

	}

}
