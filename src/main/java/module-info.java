module com.ipn.mx.proyectoprobabilidad {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires org.jfree.fxgraphics2d;
    requires jlatexmathfx;


    opens com.ipn.mx to javafx.fxml;
    exports com.ipn.mx;
}