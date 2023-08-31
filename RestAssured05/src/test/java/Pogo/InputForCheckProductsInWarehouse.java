package Pogo;

public class InputForCheckProductsInWarehouse {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;

    public InputForCheckProductsInWarehouse(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

}
