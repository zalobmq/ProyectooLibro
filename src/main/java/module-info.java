module controller {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.xml.bind;

    opens controller to javafx.fxml;
    opens utils to java.xml.bind;
    exports controller;
    exports utils;
}
