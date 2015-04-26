package hu.firstvan.model;

/**
 * Created by firstvan on 2015.04.22..
 */
public class Products {
    private Integer itemNo;
    private String name;
    private Integer price;
    private String rabat;
    private Integer rabat1;
    private Integer rabat1Price;
    private Integer rabat2;
    private Integer rabat2Price;
    private Integer rabat3;
    private Integer rabat3Price;
    private Integer orderdPiece = 0;
    private Integer subTotal;

    public Products() {
    }

    public Products(Integer itemNo, String name, Integer price, String rabat, Integer rabat1,
                    Integer rabat1Price, Integer rabat2, Integer rabat2Price, Integer rabat3,
                    Integer rabat3Price) {
        this.itemNo = itemNo;
        this.name = name;
        this.price = price;
        this.rabat = rabat;
        this.rabat1 = rabat1;
        this.rabat1Price = rabat1Price;
        this.rabat2 = rabat2;
        this.rabat2Price = rabat2Price;
        this.rabat3 = rabat3;
        this.rabat3Price = rabat3Price;
    }

    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getRabat() {
        return rabat;
    }

    public void setRabat(String rabat) {
        this.rabat = rabat;
    }

    public Integer getRabat1() {
        return rabat1;
    }

    public void setRabat1(Integer rabat1) {
        this.rabat1 = rabat1;
    }

    public Integer getRabat1Price() {
        return rabat1Price;
    }

    public void setRabat1Price(Integer rabat1Price) {
        this.rabat1Price = rabat1Price;
    }

    public Integer getRabat2() {
        return rabat2;
    }

    public void setRabat2(Integer rabat2) {
        this.rabat2 = rabat2;
    }

    public Integer getRabat2Price() {
        return rabat2Price;
    }

    public void setRabat2Price(Integer rabat2Price) {
        this.rabat2Price = rabat2Price;
    }

    public Integer getRabat3() {
        return rabat3;
    }

    public void setRabat3(Integer rabat3) {
        this.rabat3 = rabat3;
    }

    public Integer getRabat3Price() {
        return rabat3Price;
    }

    public void setRabat3Price(Integer rabat3Price) {
        this.rabat3Price = rabat3Price;
    }

    public Integer getOrderdPiece() {
        return orderdPiece;
    }

    public void setOrderdPiece(Integer orderdPiece) {
        this.orderdPiece = orderdPiece;
    }

    public Integer getSubTotal() {
        int actualPrice = price;

        if (orderdPiece >= rabat3 && rabat3 != 0) {
            actualPrice = rabat3Price;
        } else if (orderdPiece >= rabat2 && rabat2 != 0) {
            actualPrice = rabat2Price;
        } else if (orderdPiece >= rabat1 && rabat1 != 0) {
            actualPrice = rabat1Price;
        }

        return orderdPiece * actualPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        return !(itemNo != null ? !itemNo.equals(products.itemNo) : products.itemNo != null);

    }

}
