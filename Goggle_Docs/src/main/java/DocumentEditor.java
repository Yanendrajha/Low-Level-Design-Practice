import Database.Persistence;
import Document.Document;
import DocumentElements.ImageElement;
import DocumentElements.NewLineElement;
import DocumentElements.TabElement;
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
    
    // Adds a new line to the document.
    public void addNewLine() {
        document.addElement(new NewLineElement());
    }
    
    // Adds a tab space to the document.
    public void addTabSpace() {
        document.addElement(new TabElement());
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
