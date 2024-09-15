package securepass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;

/**
 *
 * @author Developed and Maintained by Sandipan Kundu (Ergophile)
 */
public class SecurePass implements ActionListener {

    JLabel l0, l1, l2;
    JTextArea area;
    JButton b;
    JFrame f;
    private static String dir;

    SecurePass(String myText) {
        f = new JFrame();
        l0 = new JLabel("SecurePass © Ergophile");
        l0.setBounds(150, 10, 300, 30);
        l1 = new JLabel();
        l1.setBounds(20, 25, 300, 30);
        l2 = new JLabel("Developed and Maintained by Sandipan Kundu");
        l2.setBounds(110, 520, 500, 20);
        area = new JTextArea();
        area.setBounds(3, 75, 1500, 350);
        area.setText(myText);
        b = new JButton("Save & Close");
        b.setBounds(175, 450, 120, 30);
        b.addActionListener(this);
        f.add(l0);
        f.add(l1);
        f.add(l2);
        f.add(area);
        f.add(b);
        f.setSize(500, 600);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String text = area.getText();
            String fileName = dir + "\\Data.txt";
            String keyFile = dir + "\\metaData.txt";
            SecretKey secretKey = generateAESKey();
            saveKey(secretKey, keyFile);
            saveEncryptedDataToFile(text, fileName, secretKey);
            f.dispose();
            System.exit(0);
        } catch (Exception ex) {
        }
    }

    public static SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();
        return secretKey;
    }

    public static void saveKey(SecretKey key, String fileName) {
        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(encodedKey.getBytes());
        } catch (IOException e) {
        }
    }

    public static SecretKey loadKey(String fileName) throws IOException {
        byte[] encodedKey = Files.readAllBytes(Paths.get(fileName));
        byte[] decodedKey = Base64.getDecoder().decode(new String(encodedKey));
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

    }

    public static void saveEncryptedDataToFile(String Data, String fileName, SecretKey secretKey)
            throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(Data.getBytes());
        String encryptedDataString = Base64.getEncoder().encodeToString(encryptedData);
        try (FileOutputStream fos = new FileOutputStream(new File(fileName))) {
            fos.write(encryptedDataString.getBytes());
        } catch (IOException e) {
        }

    }

    public static String readAndDecryptDataFromFile(String fileName, SecretKey secretKey)
            throws Exception {
        byte[] fileContent = Files.readAllBytes(Paths.get(fileName));
        String encryptedDataString = new String(fileContent);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedDataString));
        return new String(decryptedData);
    }

    public static void main(String[] args) throws Exception {
        dir = "C:\\SecurePassDir\\SecurePass";
        File file1 = new File(dir, "metaData.txt");
        File file2 = new File(dir, "Data.txt");

        if (file1.exists() && file1.isFile() && file2.exists() && file2.isFile()) {
            SecretKey loadedKey = loadKey(dir + "\\metaData.txt");
            String fileName = dir + "\\Data.txt";
            String myText = readAndDecryptDataFromFile(fileName, loadedKey);
            new SecurePass(myText);
        } else {
            new SecurePass(" ");
        }

    }

}
