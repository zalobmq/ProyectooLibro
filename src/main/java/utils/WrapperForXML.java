package utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class WrapperForXML {

	
	public static void saveFile(PersistenceUnit persistenceUnit) {
		
		try {
			JAXBContext j=JAXBContext.newInstance(PersistenceUnit.class);
			Marshaller m=j.createMarshaller();
			m.setProperty(m.JAXB_FORMATTED_OUTPUT,true);
			m.marshal(persistenceUnit,new File("servers.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static PersistenceUnit loadFile() {
		PersistenceUnit result=null;
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(PersistenceUnit.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		     
		    result = (PersistenceUnit) jaxbUnmarshaller.unmarshal(new File( "servers.xml" ));
		    
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
