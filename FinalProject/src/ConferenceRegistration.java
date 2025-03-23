import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConferenceRegistration extends Application {

    // Constants for pricing
    private static final double REGULAR_REGISTRATION_FEE = 895.0;
    private static final double STUDENT_REGISTRATION_FEE = 495.0;
    private static final double DINNER_FEE = 30.0;

    // Workshop prices
    private static final double ECOMMERCE_FEE = 295.0;
    private static final double WEB_FUTURE_FEE = 295.0;
    private static final double VISUAL_BASIC_FEE = 395.0;
    private static final double NETWORK_SECURITY_FEE = 395.0;

    // UI Controls for main form
    private RadioButton regularRegistrationRadio;
    private RadioButton studentRegistrationRadio;
    private CheckBox dinnerCheckBox;
    private CheckBox ecommerceCheckBox;
    private CheckBox webFutureCheckBox;
    private CheckBox visualBasicCheckBox;
    private CheckBox networkSecurityCheckBox;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Conference Registration");

        // Create the main form
        VBox mainLayout = createMainForm(primaryStage);

        Scene scene = new Scene(mainLayout, 450, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createMainForm(Stage primaryStage) {
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));

        // Title
        Label titleLabel = new Label("Conference Registration Options");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Registration Section
        Label registrationLabel = new Label("Registration Type:");
        registrationLabel.setStyle("-fx-font-weight: bold;");

        ToggleGroup registrationGroup = new ToggleGroup();
        regularRegistrationRadio = new RadioButton("Regular Registration ($895)");
        regularRegistrationRadio.setToggleGroup(registrationGroup);
        regularRegistrationRadio.setSelected(true);

        studentRegistrationRadio = new RadioButton("Student Registration ($495)");
        studentRegistrationRadio.setToggleGroup(registrationGroup);

        VBox registrationBox = new VBox(10);
        registrationBox.getChildren().addAll(registrationLabel, regularRegistrationRadio, studentRegistrationRadio);

        // Optional Dinner Section
        Label dinnerLabel = new Label("Optional Events:");
        dinnerLabel.setStyle("-fx-font-weight: bold;");

        dinnerCheckBox = new CheckBox("Opening Night Dinner with Keynote ($30)");

        VBox dinnerBox = new VBox(10);
        dinnerBox.getChildren().addAll(dinnerLabel, dinnerCheckBox);

        // Workshops Section
        Label workshopsLabel = new Label("Optional Preconference Workshops:");
        workshopsLabel.setStyle("-fx-font-weight: bold;");

        ecommerceCheckBox = new CheckBox("Introduction to E-commerce ($295)");
        webFutureCheckBox = new CheckBox("The Future of the Web ($295)");
        visualBasicCheckBox = new CheckBox("Advance Visual Basic ($395)");
        networkSecurityCheckBox = new CheckBox("Network Security ($395)");

        VBox workshopsBox = new VBox(10);
        workshopsBox.getChildren().addAll(
                workshopsLabel,
                ecommerceCheckBox,
                webFutureCheckBox,
                visualBasicCheckBox,
                networkSecurityCheckBox
        );

        // Close Button
        Button closeButton = new Button("Calculate Total");
        closeButton.setPrefWidth(150);

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().add(closeButton);

        // Add all sections to the main layout
        layout.getChildren().addAll(
                titleLabel,
                registrationBox,
                dinnerBox,
                workshopsBox,
                buttonBox
        );

        // Event handling
        registrationGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            boolean registrationSelected = newValue != null;
            dinnerCheckBox.setDisable(!registrationSelected);
            ecommerceCheckBox.setDisable(!registrationSelected);
            webFutureCheckBox.setDisable(!registrationSelected);
            visualBasicCheckBox.setDisable(!registrationSelected);
            networkSecurityCheckBox.setDisable(!registrationSelected);

            if (!registrationSelected) {
                dinnerCheckBox.setSelected(false);
                ecommerceCheckBox.setSelected(false);
                webFutureCheckBox.setSelected(false);
                visualBasicCheckBox.setSelected(false);
                networkSecurityCheckBox.setSelected(false);
            }
        });

        closeButton.setOnAction(event -> {
            // Calculate the total fee
            double totalFee = calculateTotalFee();

            // Show the total in a new window
            showTotalFee(totalFee, primaryStage);
        });

        return layout;
    }

    private double calculateTotalFee() {
        double total = 0.0;

        // Base registration fee
        if (regularRegistrationRadio.isSelected()) {
            total += REGULAR_REGISTRATION_FEE;
        } else if (studentRegistrationRadio.isSelected()) {
            total += STUDENT_REGISTRATION_FEE;
        } else {
            // No registration selected, return 0
            return 0.0;
        }

        // Add dinner if selected
        if (dinnerCheckBox.isSelected()) {
            total += DINNER_FEE;
        }

        // Add workshops if selected
        if (ecommerceCheckBox.isSelected()) {
            total += ECOMMERCE_FEE;
        }

        if (webFutureCheckBox.isSelected()) {
            total += WEB_FUTURE_FEE;
        }

        if (visualBasicCheckBox.isSelected()) {
            total += VISUAL_BASIC_FEE;
        }

        if (networkSecurityCheckBox.isSelected()) {
            total += NETWORK_SECURITY_FEE;
        }

        return total;
    }

    private void showTotalFee(double totalFee, Stage primaryStage) {
        // Create a new stage for the total fee display
        Stage totalStage = new Stage();
        totalStage.setTitle("Registration Summary");

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        // Create labels for the summary
        Label summaryLabel = new Label("Conference Registration Summary");
        summaryLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Label totalLabel = new Label(String.format("Total Registration Fee: $%.2f", totalFee));
        totalLabel.setStyle("-fx-font-size: 14px;");

        Button closeButton = new Button("Close");
        closeButton.setPrefWidth(100);
        closeButton.setOnAction(e -> {
            totalStage.close();
            primaryStage.show(); // Show the main form again
        });

        layout.getChildren().addAll(summaryLabel, totalLabel, closeButton);

        Scene scene = new Scene(layout, 350, 200);
        totalStage.setScene(scene);

        // Hide the main stage and show the total stage
        primaryStage.hide();
        totalStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}