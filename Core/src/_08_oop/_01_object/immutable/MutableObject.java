package _08_oop._01_object.immutable;

import java.util.Objects;

public class MutableObject implements Cloneable {

    private String str;
    private Address address;

    public MutableObject(String str, Address address) {
        this.str = str;
        this.address = address;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public MutableObject clone() {
        MutableObject mutableObject;

        try {
            mutableObject = (MutableObject) super.clone();
        } catch (CloneNotSupportedException e) {
            mutableObject = new MutableObject(str, address);
            mutableObject.setAddress(address.clone());
        }

        return mutableObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutableObject that = (MutableObject) o;
        return Objects.equals(str, that.str) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str, address);
    }
}
