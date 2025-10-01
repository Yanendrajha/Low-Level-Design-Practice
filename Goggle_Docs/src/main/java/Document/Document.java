package Document;

import DocumentElements.DocumentElement;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<DocumentElement> documentElement = new ArrayList<>();
    
    public void addElement(DocumentElement element) {
        documentElement.add(element);
    }
    
    public String render(){
        StringBuilder result = new StringBuilder();
        for (DocumentElement element : documentElement) {
            result.append(element.render());
        }
        return result.toString();
    }
}
