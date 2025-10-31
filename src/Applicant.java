import java.io.Serializable;

public class Applicant implements Serializable {
    String serialIndex;
    String[] info = new String[15];

    public Applicant(String[] info) {
        this.serialIndex = System.currentTimeMillis(); // Unique ID
        this.info = info;
    }
}