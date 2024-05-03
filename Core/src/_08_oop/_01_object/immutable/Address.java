package _08_oop._01_object.immutable;

public class Address implements Cloneable {

    private String country;
    private Integer zipCode;

    public Address(String country, Integer zipCode) {
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Address(country, zipCode);
        }
    }
}
