import java.io.*;
import java.nio.file.Files;
import java.io.IOException;
import java.util.*;

public class FileManager {
     public <T> void saveEncryptedList(List<T> list, String filename) throws Exception {
        if (!Files.exists(new File(filename).toPath())) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(list);
            oos.close();
            EncryptionUtil EncryptionUtil = new EncryptionUtil();
            byte[] encrypted = EncryptionUtil.encrypt(bos.toByteArray());
            Files.write(new File(filename).toPath(), encrypted);
        }
        else {
            FileManager manager = new FileManager();
            List<T> oldList = manager.loadEncryptedList(filename);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oldList.addAll(list);
            oos.writeObject(oldList);
            oos.close();
            EncryptionUtil EncryptionUtil = new EncryptionUtil();
            byte[] encrypted = EncryptionUtil.encrypt(bos.toByteArray());
            Files.write(new File(filename).toPath(), encrypted);
        }
    }

    public <T> List<T> loadEncryptedList(String filename) throws Exception {
        byte[] encrypted = Files.readAllBytes(new File(filename).toPath());
        EncryptionUtil EncryptionUtil = new EncryptionUtil();
        byte[] decrypted = EncryptionUtil.decrypt(encrypted);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(decrypted));
        return (List<T>) ois.readObject();
    }

    public void exportToTxt(List<Applicant> applicants, String filename, String club, String fest) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(club+"\n"+fest+"\nRegistration Information\n===========================\n\n");
        if (filename.equals(fest+"_allReg.tdf")) {
            writer.write("Query Type: All Applicants\n\n");
        }
        if (applicants!=null) {
            writer.write("Serial - Intake Semester - Name - Student ID - GSuite Email\n");
            for (Applicant a : applicants) {
                writer.write(a.serialIndex + " - " + a.info[0] + " - " + a.info[1] + " - " + a.info[2] + " - " + a.info[3] + " - " + a.info[4] + " - " + a.info[13] + " - " + a.info[14] + "\n");
            }
        }
        else {
            System.out.println("No Applicant Info Found");
        }
        writer.write("\n");
        writer.close();
    }


    public void openTxt (String filename) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("notepad.exe", filename);
        try {
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}