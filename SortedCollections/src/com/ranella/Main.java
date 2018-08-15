package com.ranella;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread",0.86,100);
        stockList.addStock(temp);

        temp = new StockItem("cake",1.10,7);
        stockList.addStock(temp);

        temp = new StockItem("pizza",1.20,10);
        stockList.addStock(temp);
        temp = new StockItem("pizza",1.00,5);
        stockList.addStock(temp);

        temp = new StockItem("juice",2.30,36);
        stockList.addStock(temp);

        temp = new StockItem("milk",2.10,20);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket myBasket = new Basket("Chris");
        grabItem(myBasket,"pizza",1);
        grabItem(myBasket,"cake",7);
        grabItem(myBasket,"milk",1);
        grabItem(myBasket,"ham",1);
        System.out.println(stockList);
        System.out.println(myBasket);

        putBackItem(myBasket,"cake",4);
        System.out.println(stockList);
        System.out.println(myBasket);

        checkout(myBasket);

        System.out.println(stockList);
        System.out.println(myBasket);

    }

    public static int grabItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem,quantity);
        }
        return 0;
    }

    public static int putBackItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(basket.Items().get(stockItem) == null) {
            System.out.println(item + " not present in basket");
            return 0;
        }
        if(stockList.unreserveStock(item, quantity) != 0) {
            return basket.removeFromBasket(stockItem,quantity);
        }
        return 0;
    }

    public static void checkout(Basket basket) {
        System.out.println();
        for(Map.Entry<StockItem,Integer> item : basket.Items().entrySet()) {
            String itemName = item.getKey().getName();
            int itemCount = item.getValue();
            stockList.sellStock(itemName,itemCount);
            stockList.unreserveStock(itemName,itemCount);
            System.out.println("Purchased " + itemCount + " " + itemName + "(s)");
        }
        basket.clearBasket();
    }
}
