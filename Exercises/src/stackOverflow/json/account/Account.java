package stackOverflow.json.account;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {
    @XmlElement
    private String name;
    @XmlElement
    private String type;
    @XmlElement
    private int id;

    public Account(String name, String type, Integer id) {
        this.name = name;
        this.type = type;
        this.id = id;
    }

    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                '}';
    }
}