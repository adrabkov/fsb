package requirements;

import form.BaseForm;

public class ValidationMessages extends BaseForm {

    //text for validation message for Email field on the registration step 2
    private String textForEmailValidation = "Bitte geben Sie eine korrekte E-Mail-Adresse an.";
    //text for validation message for Password field on the registration step 2
    private String textForPasswordValidation = "Bitte geben Sie ein Passwort ein.";
    //text for validation message for checkbox on the registration step 2
    private String textForCheckBoxConditions = "Bitte stimmen Sie den AGB zu, um den VR-Versicherungsmanager nutzen zu können.";

    public String getTextForEmailValidation() {
        return textForEmailValidation;
    }

    public String getTextForPasswordValidation() {
        return textForPasswordValidation;
    }

    public String getTextForCheckBoxConditions() {
        return textForCheckBoxConditions;
    }
}
