package com.cs2tp.notsketchers.entities;

public enum StockSupply {
    IN_STOCK,
    LOW_STOCK,
    OUT_OF_STOCK;

    private static final int STOCKLOWTHRESHOLD = 5;

    public static StockSupply getBasedOnStock(int amountInStock) {
        if (amountInStock > STOCKLOWTHRESHOLD) {
            return StockSupply.IN_STOCK;
        }
        else if (amountInStock == 0) {
            return StockSupply.OUT_OF_STOCK;
        }
        return StockSupply.LOW_STOCK;
    }
}
