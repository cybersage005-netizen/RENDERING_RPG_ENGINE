package game.rpg_engine.registries.item;

public class ItemStack
{
    int count;
    final Item item;
    public static final ItemStack EMPTY = new ItemStack(null, 0);

    public ItemStack(Item item, int count){
        this.item = item;
        this.count = count;
    }

    public Item getItem(){
        return this.item;
    }

    public int getCount(){
        return this.count;
    }

    ItemStack(Item item){
        this(item, 1);
    }

    public String toString(){
        String str = "";
        str = str.concat(item==null ? "EMPTY" : item.getVisualName() + ": " + this.getCount());
        return str;
    }

    public ItemStack tryMerge(ItemStack second){
        if(this.count == this.item.getMaxCount()){
            return this;
        }

        if(this.count + second.getCount() > this.item.getMaxCount()){
            return this;
        }

        if(second.isEmpty()){
            return this;
        }

        this.count += second.getCount();
        return this;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean equals(ItemStack stack){
        return stack.getCount() == this.getCount() && stack.getItem() == this.getItem();
    }
}
