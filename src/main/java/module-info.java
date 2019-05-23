module dreamTeam {
    requires javafx.controls;
    requires javafx.fxml;
    requires log4j.api;
    requires java.desktop;

    opens dreamTeam to javafx.fxml, log4j.api;
    exports dreamTeam;
}