package serialisasi;

import java.io.Serializable;
import java.util.List;

public class ProductItem implements Serializable {
    private String id;
    private String nama;
    private List<ProductItem> items;
    private transient String kodePromosi; // Data member dengan modifier transient
    private static int jumlahItem; // Data member dengan modifier static

    public ProductItem(String id, String nama, List<ProductItem> items, String kategori) {
        this.id = id;
        this.nama = nama;
        this.items = items;
        jumlahItem++;
    }

    // Getter dan setter untuk data member
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<ProductItem> getItems() {
        return items;
    }

    public void setItems(List<ProductItem> items) {
        this.items = items;
    }

    public String getKodePromosi() {
        return kodePromosi;
    }

    public void setKodePromosi(String kodePromosi) {
        this.kodePromosi = kodePromosi;
    }

    public static int getJumlahItem() {
        return jumlahItem;
    }

    @Override
    public String toString() {
        String produk = "Produk:\r\n"
                + "Id=" + id + "\r\n"
                + "Nama=" + nama + "\r\n"
                + "=======================\r\n"
                + "Product Item:\r\n";
        String item = items.stream().map(ProductItem::toString).reduce("", String::concat);
        return produk + item;
    }
}
