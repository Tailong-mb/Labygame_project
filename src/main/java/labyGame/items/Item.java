package labyGame.items;

import java.util.Objects;

public class Item {
    private final int bonus;
    private final ItemName name;
    private final String description;

    public Item(int bonus,ItemName name, String description){
        this.bonus = bonus;
        this.name = name;
        this.description = description;
    }

    //Set and get
    public int getBonus() {
        return bonus;
    }

    public String getDescription() {
        return description;
    }

    public ItemName getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getBonus() == item.getBonus() && getName() == item.getName() && Objects.equals(getDescription(), item.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBonus(), getName(), getDescription());
    }
}
