package de.alectogmbh.friendsurance.automation.steps.web.elements.boxes.faq.data;

public class QuestionData {

  private String questionText;
  private String questionContent;

  public QuestionData() {
  }

  public QuestionData(String questionText, String questionContent) {
    this.questionText = questionText;
    this.questionContent = questionContent;
  }

  public String getQuestionText() {
    return questionText;
  }

  @Override
  public String toString() {
    return "QuestionData{" +
        "questionText='" + questionText + '\'' +
        ", questionContent='" + questionContent + '\'' +
        '}';
  }

}
