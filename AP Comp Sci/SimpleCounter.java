
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author 16_Bao_Xiao_Bao
 */
public class SimpleCounter implements ICharCounter {

    private int [] array;
    //private int count;

    public SimpleCounter() {
        array = new int [IHuffConstants.ALPH_SIZE];
        //count = -1;
    }

    @Override
    public int getCount(int ch) {

        return array[ch];
    }

    @Override
    public int countAll(InputStream stream) throws IOException {

        BitInputStream bits = new BitInputStream(stream);
        int temp = 0;
        int bitCtr = 0;
        
        while((temp = bits.read(IHuffConstants.BITS_PER_WORD))!= -1){
 
            array[temp]++;
            bitCtr++;
        }
        
        return bitCtr;
    }

    @Override
    public void add(int i) {

        array[i]++;
    }

    @Override
    public void set(int i, int value) {

        array[i] = value;
    }

    @Override
    public void clear() {

        array = new int[0];
    }
    
    public int getCount()
    {
        int count = 0;
        
        for(int k = 0; k < IHuffConstants.ALPH_SIZE; k++)
        {
            count += getCount(k);
        }
        return count;
    }
}
