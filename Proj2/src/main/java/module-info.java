module com.pedroc.proj2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires io.github.cdimascio.dotenv.java;

    opens com.pedroc.proj2 to javafx.fxml;
    exports com.pedroc.proj2;
    exports com.pedroc.proj2.entities;
    opens com.pedroc.proj2.entities to javafx.fxml;
}