/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model_RS.Dokter;
import model_RS.RumahSakit;

/**
 *
 * @author user only
 */
public class TambahDokterDialog extends JDialog {

    private RumahSakit rumahSakit;
    private JLabel tambahDokterLabel;
    private JLabel idDokterLabel;
    private JTextField idDokterText;
    private JLabel namaDokterLabel;
    private JTextField namaDokterText;
    private JButton tambahButton;
    private MyDokterDialog owner;

    public TambahDokterDialog(MyDokterDialog owner, RumahSakit rs) {
        super(owner);
        this.owner = owner;
        rumahSakit = rs;
        init();
    }

    /**
     * Fungsi untuk inisialisasi
     */
    public void init() {

        // set size
        setSize(400, 300);
        // set layout
        setLayout(null);
        // tambah Tombol Tambah
        
        namaDokterText = new JTextField();
        namaDokterText.setBounds(70, 60, 200, 20);
        add(namaDokterText);

        tambahButton = new JButton("Tambah");
        tambahButton.setBounds(50, 200, 100, 30);
        add(tambahButton);
        
        idDokterText = new JTextField();
        idDokterText.setBounds(300, 60, 200, 20);
        add(idDokterText);
        
        idDokterLabel = new JLabel(" ID DOKTER");
        idDokterLabel.setBounds(300, 20, 300, 50);
        this.add(idDokterLabel);

        this.setLayout(null);
        namaDokterLabel = new JLabel(" Nama Dokter");
        namaDokterLabel.setBounds(70, 20, 300, 50);
        this.add(namaDokterLabel);
        
        

        
        
        
        // set action listener button
        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahDokter();
            }
        });
    }

    public void tambahDokter() {
        Dokter dokter = new Dokter(idDokterText.getText(), namaDokterText.getText());
        rumahSakit.tambahDokter(dokter);
        owner.refreshTabelDokter();
        dispose();
    }
}
