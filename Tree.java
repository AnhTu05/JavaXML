import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class Tree {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuil = dbFactory.newDocumentBuilder();
            Document doc = dbBuil.newDocument();

            Element rootElement = doc.createElement("class");
            doc.appendChild(rootElement);

            Attr total = doc.createAttribute("totalStudents");
            total.setValue("2");
            rootElement.setAttributeNode(total);

            Element student1 = doc.createElement("student");
            rootElement.appendChild(student1);
            Attr name = doc.createAttribute("name");
            name.setValue("Anh Tu");
            student1.setAttributeNode(name);
            Element age = doc.createElement("age");
            age.appendChild(doc.createTextNode("18"));
            student1.appendChild(age);
            Element gpa = doc.createElement("gpa");
            gpa.appendChild(doc.createTextNode("4.0"));
            student1.appendChild(gpa);

            Element student2 = doc.createElement("student");
            rootElement.appendChild(student2);
            Attr name1 = doc.createAttribute("name");
            name1.setValue("Nguyen Hoang");
            student2.setAttributeNode(name);
            Element age1 = doc.createElement("age");
            age1.appendChild(doc.createTextNode("18"));
            student1.appendChild(age);
            Element gpa1 = doc.createElement("gpa");
            gpa1.appendChild(doc.createTextNode("3.7"));
            student2.appendChild(gpa);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("D:\\VKU\\6. LẬP TRÌNH JAVA\\XML\\student.xml"));
            transformer.transform(source, result);

            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}