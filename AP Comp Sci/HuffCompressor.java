
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 16_Bao_Xiao_Bao
 */
public class HuffCompressor implements IHuffCompressor {

    private HuffEncoder coder;
    
    public HuffCompressor(HuffEncoder coder)
    {
        this.coder = coder;
    }
    @Override
    public void compress(InputStream in, OutputStream out) {
        BitInputStream inBit = new BitInputStream(in);
        BitOutputStream outBit = new BitOutputStream(out);

        int temp;
        //System.out.println("Testing Compression 1");
        try {
            while ((temp = inBit.read(IHuffConstants.BITS_PER_WORD)) != -1) {
                System.out.println("Testing Compression " + temp);
                if(coder.getCode(temp) != null)
                {
                    System.out.println("Code: " + coder.getCode(temp));
                    int output = Integer.parseInt(coder.getCode(temp));
                    outBit.write(IHuffConstants.BITS_PER_INT, output);
                    System.out.println("Writing Encoding: " + temp + " " + output);
                }
                out.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(HuffCompressor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
