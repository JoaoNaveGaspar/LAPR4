package Domain.Product;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private int photos_id;
    private int baseprice;
    private String name;
    private final int id_default = 0, photos_id_default = 0, base_price_default = 0;
    private final String NAME_DEFAULT = "No Name";

    @Embedded
    private Category category;
    @Embedded
    private Description description;
    @Embedded
    private Barcode barcode;

    public Product(String name, int photos_id, int baseprice, Category category,Barcode barcode1) {
        this.name = name;
        this.photos_id = photos_id;
        this.baseprice = baseprice;
        this.category=category;
        barcode=barcode1;
    }

    protected Product() {
        this.id = id_default;
        this.name = NAME_DEFAULT;
        this.baseprice = base_price_default;
        this.photos_id = photos_id_default;
    }
    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description1) {
        description = description1;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setBaseprice(int baseprice) {
        this.baseprice = baseprice;
    }

    public int getBaseprice() {
        return baseprice;
    }

    public void setPhotos_id(int photos_id) {
        this.photos_id = photos_id;
    }

    public int getPhotos_id() {
        return photos_id;
    }

    public int getId() {
        return id;
    }

    public Barcode getBarcode() {
        return barcode;
    }

    public void setBarcode(Barcode barcode1) {
        barcode = barcode1;
    }
}