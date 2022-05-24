module com.example.cuphead {
    requires javafx.controls;
    requires javafx.fxml;
            
                        
    opens view to javafx.fxml;
    exports view;

    opens main to javafx.fxml;
    exports main;

    //TODO other places
}