module com.pedroc.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pedroc.javafx to javafx.fxml;
    exports com.pedroc.javafx;
}