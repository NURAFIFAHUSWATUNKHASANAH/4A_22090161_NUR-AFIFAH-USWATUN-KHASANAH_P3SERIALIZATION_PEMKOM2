package serialisasi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationDemo {
    private static final String FILE_NAME = "product.ser";

    public static void main(String[] args) {
        // Membuat objek Product
        List<ProductItem> items = new ArrayList<>();
        items.add(new ProductItem("1", "Item 1", new ArrayList<>(), "Kategori A"));
        items.add(new ProductItem("2", "Item 2", new ArrayList<>(), "Kategori A"));
        Product product = new Product("1", "Product A", items, "Kategori A");

        // Menyimpan Product ke dalam file yang diserialisasi
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(product);
            oos.close();
            fos.close();
            System.out.println("Product berhasil disimpan.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Membaca Product dari file yang diserialisasi
        try {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Product loadedProduct = (Product) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Product berhasil di-load:");
            System.out.println(loadedProduct.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
//PERTANYAAN   :
//Temukan perbedaan antara data member yang menggunakan/tidak menggunakan keyword/access modifier ???????
//JAWAB        :
//Data member yang ditandai sebagai static, final, dan transient adalah data yang 
//nilainya tidak dapat diubah setelah inisialisasi, dan tidak diserialisasi. 
//Ini berarti nilai dari data member tersebut tidak akan disimpan atau dipulihkan saat proses serialisasi dan deserialisasi, 
//dan nilai tersebut tidak dapat diubah setelah proses deserialisasi