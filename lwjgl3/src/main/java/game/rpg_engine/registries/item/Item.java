package game.rpg_engine.registries.item;

public class Item
{
    final String name;
    final char id;
    private final int maxCount;

    public Item(char id, String name){
        this(id, name, 64);
    }

    public Item(char id, String name, int maxCount){
        if(!isValidName(name)){
            throw new RuntimeException("Invalid name for an item");
        }
        this.id = id;
        this.name = name;
        this.maxCount = maxCount;
    }

    public ItemStack asStack(){
        return new ItemStack(this, 1);
    }

    private boolean isValidName(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c) || Character.isWhitespace(c) || Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public String getVisualName(){
        if(this == null){
            return "EMPTY";
        }

        String str = this.getName();
        str = str.replaceAll("item" , "");
        str = str.replaceAll("_", "");
        str = Character.toUpperCase((char)(str.charAt(0))) + str.substring(1);
        return str;
    }

    public char getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getMaxCount(){
        return maxCount;
    }

    public boolean equals(Item item){
        return item.getId() == this.getId() && item.getName() == this.getName();
    }
}
