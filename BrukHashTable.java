public class BrukHashTable {

    String [] hashtable;
    int betterSize;
    int iteration = 0;
    int coll = 0;
    int none =0;

    //no arg constructor
    BrukHashTable (){ hashtable = new String[10];}

    // constructor that recieves the number of items
    BrukHashTable(int numItems){
        hashtable = new String[numItems];
        betterSize = numItems;
    }

    // linear probe method
    public int linear(String word){
        iteration =0;
        coll =0;

        long hash = word.hashCode() % betterSize;

        if(hash < 0) {
            hash = hash* -1;
        }

        while(hashtable[(int)hash] != null)

        while(hashtable[(int)hash] != null){
            hash = (hash+1) % betterSize;
            coll++;
            iteration++;
        }

        //Increment the counter without collisions
        if (iteration == 0){
            none++;
        }

        hashtable[(int)hash] = word; // Cast hash to nearest int and then change address
        return coll;
    }

    //Quadratic probe method
    public int quad(String words){
        iteration =0;
        coll =0;

        long hash = words.hashCode() % betterSize;

        if(hash < 0){
            hash = hash * -1;
        }

        while (hashtable[(int)hash] != null){
            coll++;
            iteration++;
            hash = Math.abs((hash + (long)Math.pow(coll,2)) % betterSize);
        }

        //Check if iteration is zero
        if (iteration == 0){
            none++;
        }

        hashtable[(int)hash] = words;
        return coll;
    }

}
