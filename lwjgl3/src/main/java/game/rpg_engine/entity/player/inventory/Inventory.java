package game.rpg_engine.entity.player.inventory;
import game.rpg_engine.registries.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Inventory
{
    int maxSize = 1;

    private List<ItemStack> inventory;

    public Inventory(int size){
        this.maxSize = size;
        inventory = new ArrayList<>(size);
        this.setDefault();
    }

    public boolean isItemIn(ItemStack stack){
        return inventory.contains(stack);
    }

    public int getCountOf(ItemStack stack){
        if(!isItemIn(stack)) return 0;

        int sum = 0;
        for(ItemStack st : inventory){
            sum+=st.getCount();
        }
        return sum;
    }

    public int getCountOfStacks(){
        int full = 0;
        for(ItemStack stack : inventory){
            if(!stack.isEmpty()){
                full += 1;
            }
        }
        return full;
    }

    public String toString(){
        String str = "";
        for(ItemStack stack : inventory){
            if(stack.isEmpty()){
                continue;
            }
            str = str.concat(stack.toString() + " ");
        }
        return str;
    }

    public boolean addItem(ItemStack stack){
        for(int i = 0; i<maxSize; i++){
            ItemStack current = this.inventory.get(i);
            if(current.isEmpty()){
                this.inventory.set(i, stack);

                return true;
            }else if(current.getItem().equals(stack.getItem())){
                this.inventory.set(i, current.tryMerge(stack));
                return true;
            }
        }

        return false;
    }

    public void setDefault(){
        for(int i = 0; i< maxSize; i++){
            inventory.add(ItemStack.EMPTY);
        }
    }
}
