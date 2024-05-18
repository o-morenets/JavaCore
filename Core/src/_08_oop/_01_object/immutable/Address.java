package _08_oop._01_object.immutable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.country) && Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, zipCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
