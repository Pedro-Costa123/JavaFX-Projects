module com.pedroc.proj2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.pedroc.proj2 to javafx.fxml;
    exports com.pedroc.proj2;
}