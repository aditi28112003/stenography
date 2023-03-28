
package Audio_Steganography;

import Coding.SendEmail;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Decode_Audio extends javax.swing.JFrame {

    private static final String algorithm = "PBEWithMD5AndDES";
    byte[] plainTextBytes;
    private char password[];
    private byte[] audioBytes;

    public Decode_Audio() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jButtonSelectAudio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDecoddedMessage = new javax.swing.JTextArea();
        jTextFieldPassword = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldAudioPath = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButtonDecode = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonSend = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonSelectAudio.setFont(new java.awt.Font("Tahoma", 1, 18));
        jButtonSelectAudio.setText("Select Audio");
        jButtonSelectAudio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSelectAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectAudioActionPerformed(evt);
            }
        });

        jTextAreaDecoddedMessage.setColumns(20);
        jTextAreaDecoddedMessage.setFont(new java.awt.Font("Monospaced", 0, 14));
        jTextAreaDecoddedMessage.setLineWrap(true);
        jTextAreaDecoddedMessage.setRows(5);
        jTextAreaDecoddedMessage.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Decodded Message",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Tahoma", 0, 18)));
        jScrollPane1.setViewportView(jTextAreaDecoddedMessage);

        jTextFieldPassword.setFont(new java.awt.Font("Tahoma", 0, 14));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Password : ");

        jTextFieldAudioPath.setFont(new java.awt.Font("Tahoma", 0, 14));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Decode Audio ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE));

        jButtonDecode.setFont(new java.awt.Font("Tahoma", 1, 18));
        jButtonDecode.setText("Decode");
        jButtonDecode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecodeActionPerformed(evt);
            }
        });

        jButtonSave.setFont(new java.awt.Font("Tahoma", 1, 18));
        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonSend.setFont(new java.awt.Font("Tahoma", 1, 18));
        jButtonSend.setText("Send");
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        jButtonReset.setFont(new java.awt.Font("Tahoma", 1, 18));
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addComponent(jButtonDecode, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 159,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 149,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 153,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jButtonSelectAudio,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 165,
                                                                Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldAudioPath)
                                                        .addComponent(jTextFieldPassword))))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButtonSelectAudio, javax.swing.GroupLayout.DEFAULT_SIZE, 32,
                                                Short.MAX_VALUE)
                                        .addComponent(jTextFieldAudioPath))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 34,
                                                Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButtonDecode, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, 52,
                                                Short.MAX_VALUE)
                                        .addComponent(jButtonSend, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonReset, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));

        pack();
    }

    private void jButtonSelectAudioActionPerformed(java.awt.event.ActionEvent evt) {

        showFileDialog(true);

    }

    private void jButtonDecodeActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTextFieldAudioPath.getText().equals("")
                || jTextFieldPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please First Choose the Audio and Enter Password!");
        } else
            extract();

    }

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {

        jTextAreaDecoddedMessage.setText(null);
        jTextFieldPassword.setText(null);
        jTextFieldAudioPath.setText(null);

    }

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {

        if (jTextAreaDecoddedMessage.getText().equals(""))
            JOptionPane.showMessageDialog(this, "No Message to Save");
        else
            showFileDialog(false);

    }

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {
        SendEmail se = new SendEmail();
        se.setVisible(true);
        se.setLocationRelativeTo(null);
        se.pack();
    }

    /****************************
     * Open File or Save File .
     ****************************/

    private java.io.File showFileDialog(final boolean open) {
        JFileChooser fc = new JFileChooser("Open a File");
        javax.swing.filechooser.FileFilter ff = new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(java.io.File f) {
                String name = f.getName().toLowerCase();
                if (open)
                    return f.isDirectory() ||
                            name.endsWith(".wav") || name.endsWith(".mp3") || name.endsWith(".au");
                return f.isDirectory() || name.endsWith(".txt");
            }

            @Override
            public String getDescription() {
                if (open)
                    return "Audio (*.wav, *.mp3, *.au)";
                return "Text (*.txt)";
            }
        };
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(ff);

        java.io.File f = null;
        if (open && fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)

            jTextFieldAudioPath.setText(fc.getSelectedFile().getAbsolutePath());

        else if (!open && fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {

            String Message = jTextAreaDecoddedMessage.getText();
            String Path = fc.getSelectedFile().getAbsolutePath();

            try {
                PrintWriter out = new PrintWriter(Path + ".txt");
                out.write(Message);
                out.close();
                JOptionPane.showMessageDialog(this, "Saved Succesfully");

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error!");
            }
        }
        return f;
    }

    /****************************
     * End Of File Dialog Window.
     *************************/

    /*******************
     * All Decoding Functions Start from Here.
     * 
     * @return
     ***********************/

    public boolean extract() {

        audioBytes = readAudio(jTextFieldAudioPath.getText());
        password = jTextFieldPassword.getText().toCharArray();

        System.out
                .println("Extracting the encrypted text from the audio file ...");

        System.out
                .println("The audio bytes before extracting the encrypted message length: "
                        + audioBytes.length);
        boolean success = true;
        byte[] buff = decode_text(audioBytes);

        System.out.println("The extracted message length: " + buff.length);
        plainTextBytes = decrypt(buff, password);

        return success;
    }

    /**
     * ========================= Decode_Text Method. ==============================.
     */

    private byte[] decode_text(byte[] data) {

        int length = 0;
        int offset = 32;

        for (int i = 0; i < 32; ++i)

        {
            length = (length << 1) | (data[i] & 1);
        }
        System.out.println("The extracted length is: " + length);

        byte[] result = new byte[length];

        for (int b = 0; b < result.length; ++b)

        {

            for (int i = 0; i < 8; ++i, ++offset) {

                result[b] = (byte) ((result[b] << 1) | (data[offset] & 1));
            }
        }
        return result;
    }

    /**
     * ========================= DeCrypt Method. ** =============================
     */
    /**
     * @param cipherText=
     * @param password
     * @return
     */
    public byte[] decrypt(byte[] cipherText, char password[]) {

        System.out.println("Decrypting the cipher message: "
                + new String(cipherText));
        System.out.println("The cipher message size is: " + cipherText.length);
        System.out
                .println("The decryption password length: " + password.length);

        PBEKeySpec pbeKeySpec;
        PBEParameterSpec pbeParamSpec;
        SecretKeyFactory keyFac;

        byte[] plainText = null;

        byte[] salt = { (byte) 0xc7, (byte) 0x73, (byte) 0x21, (byte) 0x8c,
                (byte) 0x7e, (byte) 0xc8, (byte) 0xee, (byte) 0x99 };

        int count = 20;

        pbeParamSpec = new PBEParameterSpec(salt, count);

        try {
            pbeKeySpec = new PBEKeySpec(password);

            System.out.println("Decrypting the ciphertext ...");

            keyFac = SecretKeyFactory.getInstance(algorithm);
            SecretKey pbeKey = keyFac.generateSecret(pbeKeySpec);

            Cipher pbeCipher = Cipher.getInstance(algorithm);

            pbeCipher.init(Cipher.DECRYPT_MODE, pbeKey, pbeParamSpec);

            try {
                plainText = pbeCipher.doFinal(cipherText);
                System.out.println("The decrypted message: " + new String(plainText));
                String EncryptedMessage = new String(plainText);

                jTextAreaDecoddedMessage.setText(EncryptedMessage);
                System.out.println("The decrypted message length: "
                        + plainText.length);
            } catch (IllegalBlockSizeException | BadPaddingException ex) {
                JOptionPane.showMessageDialog(this,
                        "MayBe Password is wrong or Audio is not Encrypted"
                                + " Or MayBe you encrypted large size of Text! ");

            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidKeyException
                | InvalidAlgorithmParameterException ex) {

            JOptionPane.showMessageDialog(this,
                    "MayBe Password is wrong or Audio is not Encrypted");
        }
        return plainText;
    }

    /**********************
     * This method to read the input audio file.
     ******************/
    /**
     * ================================================================================/
     * 
     * @param audioFilePath
     * @return
     **/
    public static byte[] readAudio(String audioFilePath) {

        System.out.println("Reading the audio file......");

        AudioInputStream audioInputStream = null;
        byte[] audioBytes = null;
        File audioFile = new File(audioFilePath);

        try {
            audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            int bytesPerFrame = audioInputStream.getFormat().getFrameSize();

            int numBytes = 154600 * bytesPerFrame;
            audioBytes = new byte[numBytes];

            try {

                audioInputStream.read(audioBytes);

            } catch (Exception ex) {
                System.out.println("Audio file error:" + ex);
            }
        } catch (UnsupportedAudioFileException | IOException e) {
            System.out.println("Audio file error:" + e);
        }

        return audioBytes;
    }

    /*******************************
     * End of Decoding Functions.
     **************************/

    /**
     * End of Decoding Functions.
     * 
     * @param args
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Decode_Audio.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Decode_Audio.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Decode_Audio.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Decode_Audio.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Decode_Audio().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButtonDecode;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSelectAudio;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDecoddedMessage;
    private javax.swing.JTextField jTextFieldAudioPath;
    private javax.swing.JTextField jTextFieldPassword;

}
