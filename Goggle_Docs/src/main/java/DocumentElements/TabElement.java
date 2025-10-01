package DocumentElements;

public class TabElement implements DocumentElement{
    
    @Override
    public String render() {
        return "\t";
    }
}
