package core;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import core.schema.xml.PeopleSchema;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class PeopleParsingOkHttp {

	 public static void main(String... yc) throws Exception {
		 
		               String xml = "http://alex.academy/xml/employee.xml";
		 
		               OkHttpClient client = new OkHttpClient();
		 
		               //Request request = new Request.Builder().url(xml).get().build();
		 
		            MediaType mediaType = MediaType.parse("application/xml");
		            RequestBody body = RequestBody.create(mediaType, "<user> </user>");
		            Request request = new Request.Builder().url(xml).post(body).build();
		 
		 StringReader sr = new StringReader((String) client.newCall(request).execute().body().string());
		 
//		             Response response = client.newCall(request).execute();
//		             String doc = response.body().string();
//		             StringReader sr = new StringReader(doc);
		 
		 //PeopleSchema person = (PeopleSchema) JAXBContext.newInstance(PeopleSchema.class).createUnmarshaller().unmarshal(sr);
		 
		             JAXBContext jaxbC = JAXBContext.newInstance(PeopleSchema.class);
		             Unmarshaller jaxbU = jaxbC.createUnmarshaller();
		             PeopleSchema person = (PeopleSchema) jaxbU.unmarshal(sr);
		 
		               System.out.println( 
		            		   			"Employee ID: " +   person.people.id + ";\n"
		                                 + "First name: " +   person.people.firstname + ";\n"
		                                 + "Last Name: " +    person.people.lastname + ";\n"
		                                 + "Title: " +         person.people.title + ";\n"
		                                 + "Hire date: " +    person.people.hiredate + ";\n"
		                                 + "Phone: " +         person.people.phone + ";\n"
		                                 + "Email: " +         person.people.email
		                            );
		               }
}// END OF CLASS