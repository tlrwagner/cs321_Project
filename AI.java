import java.util.*;
// Immutable.  Stores 3 strings referred to as entity, relation, and
// property. Each Record has a unique integer ID which is set on
// creation.  All records are made through the factory method
// Record.makeRecord(e,r,p).  Record which have some fields wild are
// created using Record.makeQuery(wild,e,r,p)
public class AI {

    public int difficulty;

    public AI(){

    }

    public int[] makeMove(){
        int a[] = {1,2};
        return a;
    }

    public static void main(String[] args) {

    }
}
