package core;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import core.schema.xml.PeopleSchema;

public class PeopleParsing{

	private PeopleSchema person;
	
	public static void main(String... yc) throws ParserConfigurationException, SAXException, IOException, JAXBException{
		
		 String xml = "http://alex.academy/xml/employee.xml";
	
		               DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		               DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		               Document doc = dBuilder.parse(xml);
	
		               doc.getDocumentElement().normalize(); 
		               //File file = new File("employee.xml");
		               PeopleSchema person = (PeopleSchema) JAXBContext.newInstance(PeopleSchema.class).createUnmarshaller().unmarshal(doc);
		               //PeoplesSchema person = ((JAXBContext) new PeoplesSchema()).createUnmarshaller().unmarshal(doc);
		               
		               System.out.println("Employee ID: " +   person.people.id + ";\n"
		 
		                                   + "First name: " +  person.people.firstname + ";\n"
		                                   + "Last Name: " +   person.people.lastname + ";\n"
		                                   + "Title: " +       person.people.title + ";\n"
		 
		                                   + "Hire date: " +   person.people.hiredate + ";\n"
		                                   + "Phone: " +       person.people.phone + ";\n"
		                                   + "Email: " +       person.people.email
		                                   );
	}
	
	public PeopleParsing doParsing() throws SAXException, IOException, ParserConfigurationException, JAXBException{
		 String xml = "http://alex.academy/xml/employee.xml";
		 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(xml);
         person = (PeopleSchema) JAXBContext.newInstance(PeopleSchema.class).createUnmarshaller().unmarshal(doc);
         doc.getDocumentElement().normalize(); 
		
		return this;
	}
	
	
	
} // END OF CLASS
