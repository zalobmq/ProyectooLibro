package launch;

import model.Landscape;
import model.IDAO.DAOException;
import model.MariaDBDAO.LandscapeImpMariaDB;
import model.h2DAO.LandscapeImpH2;

public class LandscapeTest {

	public static void main(String[] args) {

		saveTestH2();
	}
	
	static void saveTestH2() {
		Landscape l=new Landscape("Titulo","descripcion");
		try {
			LandscapeImpH2.save(l);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void saveTestMariaDb() {
		Landscape l=new Landscape("Titulo","descripcion");
		try {
			LandscapeImpMariaDB.save(l);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
