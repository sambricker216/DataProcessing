import java.util.*;
public class InMemoryDB implements InMemDBInt{
    HashMap<String, Integer> hash;
    HashMap<String, Integer> tempHash;
    boolean inTransaction;

    public InMemoryDB(){
        hash = new HashMap<String, Integer>();
        tempHash = new HashMap<String, Integer>();
        inTransaction = false;
    }

    public Integer get(String key){
        if(hash.containsKey(key))
            return hash.get(key);
        return null;
    }

    public void put(String key, int val){
        if(!inTransaction)
            throw new IllegalStateException("Not currently in transcation");
        tempHash.put(key, val);
    }

    public void begin_transaction(){
        if(inTransaction)
            throw new IllegalStateException("Only one transaction may be active at a time");
        inTransaction = true;
    }

    public void commit(){
        if(!inTransaction)
            throw new IllegalStateException("Not currently in transcation");
        for(Map.Entry<String, Integer> entry: tempHash.entrySet()){
            hash.put(entry.getKey(), entry.getValue());
        }
        inTransaction = false;
        tempHash.clear();
    }

    public void rollback(){
        if(!inTransaction)
            throw new IllegalStateException("Not currently in transcation");
        tempHash.clear();
        inTransaction = false;
    }
}
