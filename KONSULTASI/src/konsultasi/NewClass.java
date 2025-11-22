/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konsultasi;
import javax.swing.*;
import java.awt.*;

public class NewClass {
    public static void main(String[] args) {

        // Buat panel untuk tombol vertikal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Pilih menu pertama:");
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // supaya center
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // spasi

        // Buat tombol secara manual
        JButton btnHitung = new JButton("Hitung IMT");
        JButton btnCek = new JButton("Cek Kategori");
        JButton btnKeluar = new JButton("Keluar");

        btnHitung.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCek.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnKeluar.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(btnHitung);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(btnCek);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(btnKeluar);

        // Dialog custom
        JDialog dialog = new JDialog();
        dialog.setTitle("Menu 1");
        dialog.getContentPane().add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);

        // Tombol action
        btnHitung.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Anda memilih: Hitung IMT");
            dialog.dispose();
        });

        btnCek.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Anda memilih: Cek Kategori");
            dialog.dispose();
        });

        btnKeluar.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Program selesai!");
            dialog.dispose();
        });

        dialog.setVisible(true);
    }
}