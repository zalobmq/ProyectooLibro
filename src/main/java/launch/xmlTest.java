package launch;

import utils.PersistenceUnit;
import utils.WrapperForXML;

public class xmlTest {
	
	public static void main(String[] args) {
		loadTest();
		
	}
	
	
	public static void saveTest() {
		PersistenceUnit pu=new PersistenceUnit();
		WrapperForXML.saveFile(pu);
	}
	public static void loadTest() {
		PersistenceUnit pu=WrapperForXML.loadFile();
		System.out.println(pu.getName());
	}
}
