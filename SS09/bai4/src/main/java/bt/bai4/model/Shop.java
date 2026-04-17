package bt.bai4.model;

public class Shop {
    private String customerName;
    private String phone;
    private String address;
    private String shopName;
    private String category;

    public Shop() {
    }

    public Shop(String customerName, String phone, String address, String shopName, String category) {
        this.customerName = customerName;
        this.phone = phone;
        this.address = address;
        this.shopName = shopName;
        this.category = category;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "customerName='" + customerName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", shopName='" + shopName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}