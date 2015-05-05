package hu.firstvan.model;

/**
 * Product representation.
 */
public class Products {

    /**
     * Item number of product.
     */
    private Integer itemNo;

    /**
     * Name of product.
     */
    private String name;

    /**
     * Price of product.
     */
    private Integer price;

    /**
     * Product has it sales.
     */
    private String rabat;

    /**
     * First sales piece.
     */
    private Integer rabat1;

    /**
     * First sales price.
     */
    private Integer rabat1Price;

    /**
     * Second sales piece.
     */
    private Integer rabat2;

    /**
     * Second sales price.
     */
    private Integer rabat2Price;

    /**
     * Third sales piece.
     */
    private Integer rabat3;

    /**
     * Third sales price.
     */
    private Integer rabat3Price;

    /**
     * Piece of ordered item.
     */
    private Integer orderdPiece = 0;

    /**
     * Price of ordered of this product.
     */
    private Integer subTotal;

    /**
     * Null contructor.
     */
    public Products(){};

    /**
     * Constructor of a product.
     *
     * @param itemNo item number of product
     * @param name name of product
     * @param price price of product
     * @param rabat sales of product
     * @param rabat1 sales piece of product
     * @param rabat1Price sales price of product
     * @param rabat2 sales2 piece of product
     * @param rabat2Price sales2 price of product
     * @param rabat3 sales3 piece of product
     * @param rabat3Price sales3 price of product
     */
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

    /**
     * Get item number of product.
     *
     * @return item number or product
     */
    public Integer getItemNo() {
        return itemNo;
    }

    /**
     * Set item number of product.
     *
     * @param itemNo item number of product
     */
    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    /**
     * Get name of product.
     *
     * @return name of product
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of product.
     *
     * @param name name of product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get price of product.
     *
     * @return price of product
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Set price of product.
     *
     * @param price price of product
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * Returns whether the product has discount.
     *
     * @return whether the product has discount
     */
    public String getRabat() {
        return rabat;
    }

    /**
     * Set whether the product has discount.
     *
     * @param rabat whether the product has discount
     */
    public void setRabat(String rabat) {
        this.rabat = rabat;
    }

    /**
     * Returns piece of product, when you get salary.
     *
     * @return piece of product, when you get salary
     */
    public Integer getRabat1() {
        return rabat1;
    }

    /**
     * Set piece, when you get salary.
     *
     * @param rabat1 piece, when you get salary
     */
    public void setRabat1(Integer rabat1) {
        this.rabat1 = rabat1;
    }

    /**
     * Returns the price of first salary
     *
     * @return price of first salary
     */
    public Integer getRabat1Price() {
        return rabat1Price;
    }

    /**
     * Set price of second salary
     *
     * @param rabat1Price price of second salary
     */
    public void setRabat1Price(Integer rabat1Price) {
        this.rabat1Price = rabat1Price;
    }

    /**
     * Returns piece of product, when you get better salary.
     *
     * @return piece of product, when you get better salary
     */
    public Integer getRabat2() {
        return rabat2;
    }

    /**
     * Set piece, when you get better salary.
     *
     * @param rabat2 piece, when you get better salary
     */
    public void setRabat2(Integer rabat2) {
        this.rabat2 = rabat2;
    }

    /**
     * Returns the price of second salary
     *
     * @return price of second salary
     */
    public Integer getRabat2Price() {
        return rabat2Price;
    }

    /**
     * Returns the price of third salary
     *
     * @return price of third salary
     */
    public void setRabat2Price(Integer rabat2Price) {
        this.rabat2Price = rabat2Price;
    }

    /**
     * Returns piece of product, when you get the best salary.
     *
     * @return piece of product, when you get the best salary
     */
    public Integer getRabat3() {
        return rabat3;
    }

    /**
     * Set piece, when you get the best salary.
     *
     * @param rabat3 piece, when you get the best salary
     */
    public void setRabat3(Integer rabat3) {
        this.rabat3 = rabat3;
    }

    /**
     * Returns the price of third salary
     *
     * @return price of third salary
     */
    public Integer getRabat3Price() {
        return rabat3Price;
    }

    /**
     * Returns the price of third salary
     *
     * @return price of third salary
     */
    public void setRabat3Price(Integer rabat3Price) {
        this.rabat3Price = rabat3Price;
    }

    /**
     * Returns ordered price of product.
     *
     * @return ordered price of product
     **/
    public Integer getOrderdPiece() {
        return orderdPiece;
    }

    /**
     * Set ordered price of product.
     *
     * @param orderdPiece ordered price of product
     */
    public void setOrderdPiece(Integer orderdPiece) {
        this.orderdPiece = orderdPiece;
    }

    /**
     * Get sub total of ordered items.
     *
     * @return sub total of ordered items
     */
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

    /**
     * Return whether the product's item number is equal.
     *
     * @param o another product
     * @return whether the product's item number is equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        return !(itemNo != null ? !itemNo.equals(products.itemNo) : products.itemNo != null);

    }

}
