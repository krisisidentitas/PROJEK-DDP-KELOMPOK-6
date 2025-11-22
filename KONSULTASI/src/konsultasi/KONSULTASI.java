package konsultasi;  
import java.awt.HeadlessException;
import javax.swing.*;
public class KONSULTASI {
    public static void main(String[] args) {
        boolean ulang = true;
        double imt = 0;
        String kategori = "",rekomendasi = "";
        while (ulang) {
            String[] menu = {"Cek Indeks Massa Tubuh (IMT)", "Rekomendasi Shade Dari Undertone", "Rekomendasi Aktivitas dari IMT"};
            int mn = JOptionPane.showOptionDialog(null, """
                                                        ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
                                                        ============================================
                                                        SELAMAT DATANG DI KONSULTASI BERAT BADAN 
                                                        DAN KECANTIKAN DENGAN MENGECEK UNDERTONE
                                                        ============================================
                                                        ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
                                                        ""","Selamat datang, silakan pilih.",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,menu,menu[0]);
            
            switch (mn) {
                case 0 -> {
                    boolean loop = true;
                    while (loop) {                        
                        String inputBerat = JOptionPane.showInputDialog("Masukkan berat badan (kg):", "Berapa Berat Badanmu?");
                        if (inputBerat == null) {
                            break;
                        }
                        
                        String inputTinggi = JOptionPane.showInputDialog("Masukkan tinggi badan (cm):", "Berapa Tinggi Badanmu?");
                        if (inputTinggi == null) {
                            break;
                        }
                        
                        try {
                            double berat = Double.parseDouble(inputBerat);
                            double tinggi = Double.parseDouble(inputTinggi) / 100;
                            imt = berat / (tinggi * tinggi);
                            
                            if (imt >= 0 && imt < 17.0) {
                                kategori = "Sangat Kurus";
                            } else if (imt >= 17.0 && imt < 18.5) {
                                kategori = "Kurus";
                            } else if (imt >= 18.5 && imt < 25.0) {
                                kategori = "Normal";
                            } else if (imt >= 25.0 && imt < 27.0) {
                                kategori = "Gemuk";
                            } else if (imt >= 27.0 && imt < 40.0) {
                                kategori = "Sangat Gemuk";
                            } else if (imt < 0) {
                                kategori = "IMT tidak valid";
                            } else {
                                kategori = "Obesitas";
                            }
                            
                            JOptionPane.showMessageDialog(null, "IMT Anda: " + String.format("%.2f", imt) + "\nKategori: " + kategori,
                                    "Hasil pengecekan", JOptionPane.INFORMATION_MESSAGE);
                            loop = false;
                        } catch (Exception ie) {
                            JOptionPane.showMessageDialog(null,
                                    "Input harus berupa angka!",
                                    "Kesalahan Input, tipe data salah.",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                
                case 1 -> {
                    String[] utone = {"Cool","Neutral","Warm"};
                    int ut = JOptionPane.showOptionDialog(null, """
                                                                Apa undertone mu?
                                                                Lihat urat nadimu!
                                                                Jika warnanya:
                                                                1. Biru Keunguan, maka undertonemu cool!
                                                                2. Hijau Kebiruan, maka undertonemu netral.
                                                                3. Kehijauan, maka undertonemu warm~
                                                                ""","Pilih Undertone Sesuai Kulitmu",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,utone,utone[0]);
                    
                    switch (ut) {
                        case 0 -> {
                            JOptionPane.showMessageDialog(null,"""
                                                               COOL UNDERTONE
                                                               ==============================================
                                                               #TIPS MEMILIH SHADE:
                                                                - Gunakan base makeup atau 
                                                               foundation tone berwarna pink.
                                                               ==============================================
                                                               #CONTOH SHADE:
                                                                - Pink;
                                                                - Ivory;
                                                                - Light;
                                                                - Nude, dll.
                                                               ==============================================
                                                               #NOTE:
                                                                - Cool Undertone cocok dengan perhiasan emas!
                                                               ==============================================
                                                               ""","Tips Untukmu!",JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                        case 1 -> {
                            JOptionPane.showMessageDialog(null,"""
                                                               NEUTRAL UNDERTONE
                                                               ==============================================
                                                               #TIPS MEMILIH SHADE:
                                                                - Gunakan base makeup atau 
                                                                  foundation tone netral.
                                                               ==============================================
                                                               #CONTOH SHADE:
                                                                - Natural;
                                                                - Beige;
                                                                - Walnut, dll.
                                                               ==============================================
                                                               #NOTE:
                                                                - Neutral Undertone cocok dengan perhiasan emas maupun perak!
                                                               ==============================================
                                                               ""","Tips Untukmu!",JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                        case 2 -> {
                            JOptionPane.showMessageDialog(null,"""
                                                               WARM UNDERTONE
                                                               ==============================================
                                                               #TIPS MEMILIH SHADE:
                                                                - Gunakan base makeup atau 
                                                                  foundation tone berwarna kuning (yellow).
                                                               ==============================================
                                                               #CONTOH SHADE:
                                                                - Yellow;
                                                                - Caramel;
                                                                - Honey;
                                                                - Golden, dll.
                                                               ==============================================
                                                               #NOTE:
                                                                - Warm Undertone cocok dengan perhiasan perak!
                                                               ==============================================
                                                               ""","Tips Untukmu!",JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }                                       
                    }
                }            
                
                case 2 -> {
                    if (imt == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Silakan hitung IMT dulu pada menu nomor 1!", "tidak bisa langsung ke sini!",JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                    
                    switch (kategori) {
                        case "Sangat Kurus" -> rekomendasi = """
                                          - Latihan kekuatan 3-4x/minggu
                                          - Yoga ringan atau pilates
                                          - Hindari kardio berlebihan
                                          - Perbanyak istirahat & kalori sehat
                                          """;
                        case "Kurus" -> rekomendasi = """
                                          - Latihan beban ringan-sedang 3-5x/minggu
                                          - Kardio ringan 1-2x/minggu
                                          - Fokus asupan protein & kalori
                                          """;
                        case "Normal" -> rekomendasi = """
                                          - Kombinasi latihan beban + kardio 3-5x/minggu
                                          - Jogging, berenang, bersepeda
                                          - Peregangan / yoga untuk fleksibilitas
                                          """;
                        case "Gemuk" -> rekomendasi = """
                                          - Kardio sedang-tinggi 4-5x/minggu
                                          - Latihan beban 2-3x/minggu
                                          - Aktivitas harian lebih aktif
                                          """;
                        case "Sangat Gemuk" -> rekomendasi = """
                                          - Kardio low-impact: berenang, sepeda statis
                                          - Latihan kekuatan bertahap 2-3x/minggu
                                          - Durasi 20-30 menit, tingkatkan perlahan
                                          """;
                        case "Obesitas" -> rekomendasi = """
                                          - Aqua fitness, berjalan di air, yoga kursi
                                          - Latihan kekuatan ringan untuk otot inti
                                          - Durasi 10-20 menit, tingkatkan perlahan
                                          - Konsultasi dokter/pelatih dianjurkan
                                          """;
                         default -> rekomendasi = "";
                    }

                    JOptionPane.showMessageDialog(null, "IMT Anda: "+String.format("%.2f", imt)+"\nKategori: "+kategori+"\nRekomendasi Aktivitas: \n"+rekomendasi,
                            "Hasil IMT & Aktivitas", JOptionPane.INFORMATION_MESSAGE);
                }

                default -> JOptionPane.showMessageDialog(null, "terima kasih.");
            }

            int jawab = JOptionPane.showConfirmDialog(null, 
                    "Apakah ingin mengulang?", 
                    "Konfirmasi", 
                    JOptionPane.YES_NO_OPTION);

            switch (jawab) {
                case JOptionPane.NO_OPTION -> ulang = false;
                case JOptionPane.YES_OPTION -> ulang = true;
                default -> {
                    return;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Terima kasih!", "SELESAI",JOptionPane.INFORMATION_MESSAGE);
    }
}
