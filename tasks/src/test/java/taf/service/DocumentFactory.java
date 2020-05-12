package taf.service;

import taf.model.Document;

public class DocumentFactory {
  public static final String DOCUMENT_BODY_TEXT = "testdata.document.text";
  public static final String DOCUMENT_NAME = "testdata.document.name";

  public static Document getDocumentInfo() {
    Document document = new Document();
    document.setName(TestDataReader.getTestData(DOCUMENT_NAME));
    document.setText(TestDataReader.getTestData(DOCUMENT_BODY_TEXT));
    return document;
  }
}
