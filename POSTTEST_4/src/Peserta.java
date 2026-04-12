public class Peserta {
    private String nama;
    private String negara;

    public Peserta(String nama, String negara) {
        this.nama = nama;
        this.negara = negara;
    }

    public String getNama() {
        return nama;
    }

    public String getNegara() {
        return negara;
    }

    public void setNama(String nama) {
        if (nama == null || nama.isEmpty()) {
            System.out.println("Nama tidak boleh kosong.");
        } else {
            this.nama = nama;
        }
    }

    public void setNegara(String negara) {
        if (negara == null || negara.isEmpty()) {
            System.out.println("Negara tidak boleh kosong.");
        } else {
            this.negara = negara;
        }
    }

    public void tampilkanInfo() {
        System.out.println("  Nama          : " + this.nama);
        System.out.println("  Negara        : " + this.negara);
    }

    public void tampilkanInfo(String judul) {
        System.out.println("  === " + judul + " ===");
        System.out.println("  Nama          : " + this.nama);
        System.out.println("  Negara        : " + this.negara);
    }
}