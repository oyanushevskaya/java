package taf.model;

public class Document {
  private String name;
  private String text;

  public Document() {
  }

  public Document(String s) {
    this.name = s;
    this.text = s;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
