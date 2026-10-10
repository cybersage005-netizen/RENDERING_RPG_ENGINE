package game.rpg_engine.asset_util.identifiers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Identifier {
    private final String id;
    protected Identifier(String id) throws IllegalAccessException {
        if(!isValid(id, true)){
            throw new IllegalAccessException("The identifier must not contain spaces, numbers and capital letters!");
        }
        this.id = id;
    }

    protected Identifier(String id, boolean shouldContainDot) throws IllegalAccessException {
        if(!isValid(id, shouldContainDot)){
            throw new IllegalAccessException("The identifier must not contain spaces, numbers and capital letters!");
        }
        this.id = id;
    }

    public final static Identifier of(String id){
        try{
            return new Identifier(id);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isValid(String str, boolean shouldContainDot){

        if(str.contains(" ")){
            return false;
        }

        if(!str.contains(".") && !shouldContainDot){
            return false;
        }

        AtomicBoolean isValid = new AtomicBoolean(true);

        getList(str.toCharArray()).forEach(e -> {
           if(Character.isUpperCase(e)){
               isValid.set(false);
           }
           if(Character.isDigit(e)){
               isValid.set(false);
           }

        });
        return isValid.get();
    }

    public String getId(){
        return this.id;
    }

    protected   List<Character> getList(char[] ch){
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i< ch.length; i++){
            list.add(ch[i]);
        }
        return list;
    }
}
