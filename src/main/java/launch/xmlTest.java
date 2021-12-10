package launch;

import utils.PersistenceUnit;
import utils.WrapperForXML;

public class xmlTest {
	
	public static void main(String[] args) {
		saveTest();
		
	}
	
	
	public static void saveTest() {
		PersistenceUnit pu=new PersistenceUnit();
		WrapperForXML.saveFile(pu);
	}
}
