module cz.cvut.fel.pjv.hangmanfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens cz.cvut.fel.pjv.hangmanfx to javafx.fxml;
    exports cz.cvut.fel.pjv.hangmanfx;
}