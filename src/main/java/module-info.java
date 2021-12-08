module controller {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.xml.bind;
	requires java.sql;
	requires com.h2database;
	requires java.persistence;
	
	opens model to org.hibernate.orm.core;
    opens controller to javafx.fxml;
    opens utils to java.xml.bind;
    exports controller;
    exports utils;
    
}
