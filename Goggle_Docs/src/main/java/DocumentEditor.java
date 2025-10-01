import Database.Persistence;
import Document.Document;
import DocumentElements.ImageElement;
import DocumentElements.TextElement;

public class DocumentEditor {
    private final Document document;
    private final Persistence persistence;
    private String renderedDocument = "";
    
    public DocumentEditor(Document document, Persistence persistence) {
        this.document = document;
        this.persistence = persistence;
    }
    
    public void addText(String text) {
        document.addElement(new TextElement(text));
    }
    
    public void addImage(String imagePath){
        document.addElement(new ImageElement(imagePath));
    }
    
    public String renderDocument() {
        if(renderedDocument.isEmpty()){
            renderedDocument = document.render();
        }
        return renderedDocument;
    }
    
    void saveDocument() {
        persistence.save(renderDocument());
    }
    
}
