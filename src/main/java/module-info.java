module master.tmexp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires okhttp3;


    opens master.tmexp to javafx.fxml;
    exports master.tmexp;

}
