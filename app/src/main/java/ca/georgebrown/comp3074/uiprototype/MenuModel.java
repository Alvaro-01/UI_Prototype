package ca.georgebrown.comp3074.uiprototype;

public class MenuModel {
    private String category;
    private String name;
    private int price;

    public MenuModel (String category,String name, int price){
        this.category=category;
        this.name=name;
        this.price=price;
    }

    @Override
    public String toString() {
        return "MenuModel{" +
                "Category='" + category + '\'' +
                ", Name='" + name + '\'' +
                ", Price=" + price +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}