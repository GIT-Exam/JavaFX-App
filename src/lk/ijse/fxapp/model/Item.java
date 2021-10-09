package lk.ijse.fxapp.model;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/9/2021
 **/
public class Item {

    private String product_id;
    private String product_name;
    private String description;
    private int qty;

    public Item() {
    }

    public Item(String product_id, String product_name, String description, int qty) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.description = description;
        this.qty = qty;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
