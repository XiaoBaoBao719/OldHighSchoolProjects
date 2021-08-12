/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter20;

/**
 *
 * @author Xiao Bao Bao
 */
public class HashTable implements HashFunction {

    HashValue[] hashTable;

    int tableSize;
    int currentSize;

    /**
     * Creates HashTable objects
     * @param size of the desired hashTable for storage
     */
    public HashTable(int size) {
        //System.out.println("Initializing table");
        tableSize = nextPrime(size);
        hashTable = new HashValue[tableSize];
        //System.out.println("Table size: " + tableSize);
    }

    /**
     * Inserts an object into the hashTable and
     * returns whether the attempt was successful or not
     * @param x the Object that is to be inserted
     * @return true if the Object was sucessfully inserted
     * false if we discover that the object has already been deleted
     */
    public boolean store(Object x) {
        
        System.out.println("Storing: " + x);
        int currentPos = getHashPos(x);
        if(currentPos == -1 || currentSize == hashTable.length)
            return false;
        
        System.out.println("Storing at: " + currentPos);
        hashTable[currentPos] = new HashValue(x, true);
        currentSize++;
        return true;
    }

    /**
     * Searches the hash table for the desired object
     * @param x the object that we are looking for
     * @return the index of the object we are looking for
     * returns -1 if we could not locate the object
     */
    public int search(Object x) {
        
        int currentPos = hash(x);
        int temp = currentPos;
        System.out.println("Searching for: " + x);
        do{
            System.out.println("Checking index: " + currentPos);
           
            if(hashTable[currentPos] != null){
                 System.out.println("Element is " + hashTable[currentPos].getElement());
                if(hashTable[currentPos].getElement() == x){
                    return currentPos;   
            } 
            }
             currentPos = (currentPos + 1) % tableSize;   
            
        }while(currentPos != temp);
        
        return -1;
    }

    /**
     * Deletes an object in the hash table through
     * use of "lazy deletion". We set the HashValue object's
     * state to "inActive"
     * @param x the object that we wish to delete
     * @return true if the delete attempt was successful
     * return false if the object has already been marked for deletion
     */
    public boolean delete(Object x) {
        
        int currentPos = search(x);
        if(currentPos == -1 || !hashTable[currentPos].getState())
            return false;
        
        hashTable[currentPos].setState(false);
        
        return true;
    }

    /**
     * Cleans up the Hash Table of objects that have been marked
     * for deletion through lazy deletion. We'll search the Hash Table
     * for Hash Value objects
     */
    public void cleanup() {

        for(int currentPos = 0; currentPos < hashTable.length; currentPos++){
            
            if(hashTable[currentPos] != null 
                    && !hashTable[currentPos].getState()) {
                
              hashTable[currentPos] = null; //Deletion returns to heap
                
            } else if(hashTable[currentPos] != null 
                    && hashTable[currentPos].getState())
                
              store(hashTable[currentPos].getElement()); //Re-storing the value
                
        }
        
        //currentSize = 0;
    }

    /**
     *
     * @param key the object we want the hash code of
     * @return the hashCode() of the key object, % (modded) by the table size
     */
    @Override
    public int hash(Object key) {
        
        return key.hashCode() % hashTable.length;
    }

    /**
     * Generates hash code values for the last three letter in a 
     * given string. First the last three letters in the string are stored
     * in a temp string, the temp string is converted toUpperCase. We 
     * cast the chars in the temp string into integers and subtract 
     * according the ASCII values. 
     * @param name a Name object that we want the string of
     * @return 
     */
    public int hash(Name name){
        
        String s = name.getName();
        String temp = "";
        
        for(int k = s.length() - 1; k >= 0; k--){
            
            temp += s.charAt(k);
        }
        
        temp.toUpperCase();
        int hashCode = 0;
        
        for(int n = temp.length() - 1; n >= 0; n--){
            
            hashCode += ((int)temp.charAt(n) - 65) * Math.pow(27, n);
        }
        
        return hashCode;
    }

    /**
     * Returns the correct index for insertion and
     * resolves collision with a Linear Probing protocol
     * @param x the object we are inserting
     * @return the index of the next available space. 
     */
    public int getHashPos(Object x) {
        
        //int collisionPos = 0;
        int currentPos = hash(x);
        //store the initial index
        int temp = currentPos;
        
        do{
            if(hashTable[currentPos] == null){
                
                return currentPos;
                
            } 
            //Iterate through the hash table
             currentPos = currentPos + 1;
             
             //Check if we reached end of array
             if(currentPos == (hashTable.length))
                 currentPos = 0; //reset
            
             //System.out.println(currentPos);
        }while(currentPos != temp);
        
        //System.out.println("Returning ind: " + currentPos);
        return currentPos;
    }

    
    /**
     * Looks for the next prime number given a number
     * @param n
     * @return the next prime number
     */
    @SuppressWarnings("empty-statement")
    private int nextPrime(int n) {

        //System.out.println("Checking primes for table size");
       if( n % 2 == 0)
           return n++;
       for(; !isPrime(n);n += 1)
           ;
       return n;  
    }
    
    /**
     * Checks whether a number is prime or not
     * @param n
     * @return true if prime, false if not prime
     */
    private boolean isPrime(int n){
        
        //System.out.println("Checking primes ***");
        int j = 2;
        boolean isPrime = true;
        
        while(j <= (n / 2)){
            
            //System.out.println("Checking potential primes *****");
            if(n % j == 0) {
                isPrime = false;
                break;
            }
            j++;
        }
        
        return isPrime;
    }
    
    /**
     * Checks the state of an object, given a position.
     *
     * @param array the hash table we a looking through
     * @param pos the index of the object we want to look at
     * @return true if the object is active, returns false if the\ object is
     * non-active (which means it has been marked for deletion)
     */
    private static boolean isActive(HashValue[] array, int pos) {

        return pos != -1 && array[pos].getState();
    }
    
    
    /**
     * Displays all the filled cells in the table. If a cell has been marked
     * for deletion, then it shall display "DELETED"
     * @return the contents of the table
     */
    @Override
    public String toString(){
        
        int ctr = 0;
        String str = "";
        
        for(int k = 0; k < hashTable.length; k++){
            
            if(hashTable[k] != null && hashTable[k].getState()){
                
                str += "Index: " + k + 
                        " Value: " + hashTable[k].getElement() + "\n";
                ctr++;
                
            } else if (hashTable[k] != null && !hashTable[k].getState()){
                
                str += "Index: " + k + " Value: DELETED\n"; 
            }
        }
        
        str += "\nTotal Space Filled: " + ctr + "/" + hashTable.length;
        
        return str;
    }
}
