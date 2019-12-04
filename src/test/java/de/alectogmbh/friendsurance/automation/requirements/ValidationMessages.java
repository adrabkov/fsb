package de.alectogmbh.friendsurance.automation.requirements;

import de.alectogmbh.friendsurance.automation.form.BaseForm;
import java.util.ArrayList;
import java.util.List;

public class ValidationMessages extends BaseForm {

    //text for validation message for Email field on the registration step 2
    private String textForEmailValidation = "Bitte geben Sie eine korrekte E-Mail-Adresse an.";
    //text for validation message for Password field on the registration step 2
    private String textForPasswordValidation = "Ihr Passwort erfüllt nicht die Sicherheitsanforderungen.";
    //validation message text for register as already existed user
    private String textForAlreadyExistedEmail = "Diese E-Mail-Adresse wird bereits verwendet. Bitte loggen Sie sich ein.";
    //text for validation message for checkbox on the registration step 2
    private String[] conditionText = {
            "Bitte stimmen Sie den AGB zu, um den VR-Versicherungsmanager nutzen zu können.",
            "Bitte stimmen Sie der Datenweitergabe zu, um den VR-Versicherungsmanager nutzen zu können.",
            "Bitte bestätigen Sie, dass Sie die Erstinformation gelesen und heruntergeladen haben."
    };
    // validation message text for Bank field
    private String textForBankFieldValidation = "Bitte wählen Sie eine Bank aus.";


    public String getTextForEmailValidation() {
        return textForEmailValidation;
    }

    public String getTextForPasswordValidation() {
        return textForPasswordValidation;
    }

    public String getTextForAlreadyExistedEmail() {
        return textForAlreadyExistedEmail;
    }

    public List<String> getConditionText() {
        List<String> listConditionText = new ArrayList<>();
        for (String list : conditionText) {
            listConditionText.add(list);
        }
        return listConditionText;
    }

    public String getTextForBankFieldValidation() {
        return textForBankFieldValidation;
    }
}
