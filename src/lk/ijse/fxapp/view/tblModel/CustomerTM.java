package lk.ijse.fxapp.view.tblModel;

/**
 * @author Thathsara Dananjaya <thathsaradananjaya@gmail.com>
 * @since 10/9/2021
 **/
public class CustomerTM {
    private String customer_id;
    private String customer_name;
    private String address;
    private String contact;

    public CustomerTM() {
    }

    public CustomerTM(String customer_id, String customer_name, String address, String contact) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.address = address;
        this.contact = contact;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
