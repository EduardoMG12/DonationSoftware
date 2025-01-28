module com.charleseduardo.donation.donationsjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    exports com.charleseduardo.donation.donationsjavafx.controllers; // Exporta o pacote do controlador
    opens com.charleseduardo.donation.donationsjavafx.controllers to javafx.fxml; // Permite a reflexão do FXMLLoader

    opens com.charleseduardo.donation.donationsjavafx to javafx.fxml;
    exports com.charleseduardo.donation.donationsjavafx;
}