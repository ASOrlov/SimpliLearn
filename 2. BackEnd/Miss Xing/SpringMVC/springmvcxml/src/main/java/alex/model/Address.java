package alex.model;

public class Address {
    private String street;
    private Integer zipcode;

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }



}
