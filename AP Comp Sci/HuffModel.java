
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 16_Bao_Xiao_Bao
 */
public class HuffModel implements IHuffModel {

    protected HuffViewer huffViewer;
    public SimpleCounter ctr;
    
    public HuffModel(HuffViewer viewer)
    {
        ctr = new SimpleCounter();
        this.setViewer(viewer);
    }
    @Override
    public void showCodings() {
        
        TreeMaker maker = new TreeMaker(ctr);
        HuffEncoder encoder = new HuffEncoder();
        encoder.makeTable(maker);
        
        //DEBUG STATEMENT
        System.out.println("Showing Codings:");
        for(int k = 0; k < IHuffConstants.ALPH_SIZE; k++)
        {
            if(encoder.getCode(k) != null)
                System.out.println(k + " " + encoder.getCode(k));
        }
        
        
        List<String> codes = new ArrayList<String>();
        for(int k = 0; k < IHuffConstants.ALPH_SIZE; k++)
        {
            if(encoder.getCode(k) != null)
                codes.add(k + " " + encoder.getCode(k));
            else
                codes.add(k + " ");
        }
        huffViewer.update(codes);
    }

    @Override
    public void showCounts() {
        
        List<String> counts = new ArrayList<String>();
        
        for(int k = 0; k < IHuffConstants.ALPH_SIZE; k++)
        {
            counts.add(k + " " +  ctr.getCount(k));
        }
        huffViewer.update(counts);
    }

    @Override
    public void initialize(InputStream stream) {
        
        ctr = new SimpleCounter();
        
        try {
            ctr.countAll(stream);
        } catch (IOException ex) {
            Logger.getLogger(HuffModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void write(InputStream stream, File file, boolean force) {
        
//        SimpleCounter ctr = new SimpleCounter();
//        try {
//            ctr.countAll(stream);
//        } catch (IOException ex) {
//            Logger.getLogger(HuffModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
        int counterSize = ctr.getCount();
        int headerSize = 0;
        
        TreeMaker maker = new TreeMaker(ctr);
        HuffEncoder encoder = new HuffEncoder();
        encoder.makeTable(maker);
        
        HuffHeader header = new HuffHeader(maker);
        HuffCompressor compressor = new HuffCompressor(encoder);
        
        BitInputStream in = new BitInputStream(stream);
        BitOutputStream out = new BitOutputStream(file.getPath());
        
        //FORCE
        if(force || counterSize > headerSize)
        {
            header.writeHeader(out);
        }
        else
        {
            JOptionPane.showMessageDialog(null, 
                    (counterSize - header.headerSize()) + "\n" +
"            + \" more than the original file.\"\n" +
"            + \"\\n Use foce compression to compress");
        }
        
        //Write the Header
        System.out.println("Writing Header");
        header.writeHeader(out);
        //Write the encodings
        System.out.println("Compressing");
        compressor.compress(in, out);
    }

    @Override
    public void setViewer(HuffViewer viewer) {
        huffViewer = viewer;
    }

    @Override
    public void uncompress(InputStream in, OutputStream out) {
        
        BitInputStream inBit = new BitInputStream(in);
        BitOutputStream outBit = new BitOutputStream(out);
        
        HuffDecoder decoder = new HuffDecoder();
        
        decoder.initialize();
        decoder.doDecode(inBit, outBit);
    }
    
}
