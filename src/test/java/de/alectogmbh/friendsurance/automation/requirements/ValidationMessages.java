package de.alectogmbh.friendsurance.automation.requirements;

import de.alectogmbh.friendsurance.automation.form.BaseForm;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationMessages extends BaseForm {

    private String text_for_sign_up_page_headline = "E-Mail eingeben, Passwort festlegen und ein paar Häkchen!";
    private String validation_text_for_empty_or_incorrect_email = "Bitte geben Sie eine korrekte E-Mail-Adresse an.";
    private String validation_text_for_incorrect_password = "Ihr Passwort erfüllt nicht die Sicherheitsanforderungen.";
    private String validation_text_for_empty_password = "Bitte geben Sie ein Passwort ein.";
    private String validation_text_for_already_existed_email = "Diese E-Mail-Adresse wird bereits verwendet. Bitte loggen Sie sich ein.";
    private String[] text_for_condition_checkbox = {
            "Bitte stimmen Sie den AGB zu, um den VR-Versicherungsmanager nutzen zu können.",
            "Bitte stimmen Sie der Datenweitergabe zu, um den VR-Versicherungsmanager nutzen zu können.",
            "Bitte bestätigen Sie, dass Sie die Erstinformation gelesen und heruntergeladen haben."
    };
    private String textForBankFieldValidation = "Bitte wählen Sie eine Bank aus.";




    public List<String> getConditionText() {
        List<String> listConditionText = new ArrayList<>();
        for (String list : text_for_condition_checkbox) {
            listConditionText.add(list);
        }
        return listConditionText;
    }
}
