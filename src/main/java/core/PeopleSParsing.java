package core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import core.schema.xml.PeopleListSchema;
import core.schema.xml.PeopleSchema;

public class PeopleSParsing {

	private PeopleSchema person;

	public static void main(String... yc)
			throws ParserConfigurationException, SAXException, IOException, JAXBException {

		String xml = "http://alex.academy/xml/employees.xml";

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();

		Document doc = db.parse(xml);

		doc.getDocumentElement().normalize();
		// File file = new File("employees.xml");

		PeopleListSchema o = (PeopleListSchema) JAXBContext.newInstance(PeopleListSchema.class).createUnmarshaller()
				.unmarshal(doc);

		for (PeopleListSchema.Person emp : o.getEmployees()) {

			List<String> id = new ArrayList<String>();
			id.addAll(emp.getId());

			List<String> fn = new ArrayList<String>();
			fn.addAll(emp.getFirstNames());

			List<String> ln = new ArrayList<String>();
			ln.addAll(emp.getLastNames());

			List<String> t = new ArrayList<String>();
			t.addAll(emp.getTitle());

			List<String> hd = new ArrayList<String>();
			hd.addAll(emp.getHireDate());

			List<String> p = new ArrayList<String>();
			p.addAll(emp.getPhone());

			List<String> e = new ArrayList<String>();
			e.addAll(emp.getEmail());

			System.out.println("Employee ID: " + id.toString().replaceAll("\\[|\\]", "") + "; "

					+ "First name: " + fn.toString().replaceAll("\\[|\\]", "") + "; "

					+ "Last Name: " + ln.toString().replaceAll("\\[|\\]", "") + "; "

					+ "Title: " + t.toString().replaceAll("\\[|\\]", "") + "; "

					+ "Hire date: " + hd.toString().replaceAll("\\[|\\]", "") + "; "

					+ "Phone: " + p.toString().replaceAll("\\[|\\]", "") + "; "

					+ "Email: " + e.toString().replaceAll("\\[|\\]", "")

			);
		}
	}
} // END OF CLASS
