package fun.westory.mvc.pojo;

import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialVersionUID = 8025439675868935685L;

    private Integer id;

    private String name;

    private String address;

    private String phone;

    private String cardType;
    private String card;

    public Customer() {
    }

    public Customer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Customer(String name, String address, String cardType, String card) {
        this.name = name;
        this.address = address;
        this.cardType = cardType;
        this.card = card;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", cardType='" + cardType + '\'' +
                ", card='" + card + '\'' +
                '}';
    }
}
