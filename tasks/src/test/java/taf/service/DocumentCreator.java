package taf.service;

import taf.model.Document;

public class DocumentCreator {
  public static final String DOCUMENT_BODY_TEXT = "testdata.document.text";
  public static final String DOCUMENT_NAME = "testdata.document.name";

  public static Document getDocumentName() {
    Document document = new Document();
    document.setName(TestDataReader.getTestData(DOCUMENT_NAME));
    return new Document(document.getName());
  }

  public static Document getBodyText() {
    Document text = new Document();
    text.setText(TestDataReader.getTestData(DOCUMENT_BODY_TEXT));
    return new Document(text.getText());
  }
}
