
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 16_Bao_Xiao_Bao
 */
public class HuffHeader implements IHuffHeader {

    TreeNode node;
    int counter;
    String treeHeader = ""; //DEBUG HEADER
    
    public HuffHeader(TreeMaker maker)
    {
        node = maker.makeRoot();
        counter = 0;
    }
    
    @Override
    public int headerSize() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeHeader(BitOutputStream out) {
        
        //Write the magic number
        out.write(IHuffConstants.BITS_PER_INT, IHuffConstants.MAGIC_NUMBER);
        //Write the Huffman Tree
        getTreeCode(node, out);

        //Imaginary Pseudo - eof leaf
        //YES THIS IS A LEAF
        out.write(1,1);
        //YES THIS IS THE LAST LEAF, END HEADER
        out.write(1,1);
        treeHeader += " 1 1";
        
        System.out.println(treeHeader);
        
        out.flush();
    }
    
    private void getTreeCode(TreeNode node, BitOutputStream out)
    {
        
        if(TreeNode.isLeaf(node))
        {
            //CHECK IF IS A LEAF
            treeHeader += " 1";
            out.write(1, 1);
            
            //CHECK IF LAST LEAF
            out.write(1, 0);
            treeHeader += " 0";
            
            //CHECK LEAF VALUE
            treeHeader += " " + Integer.toBinaryString(node.getVal());
            out.write(IHuffConstants.BITS_PER_INT, 
                    Integer.parseInt(Integer.toBinaryString(node.getVal())));
            out.flush();
        }
        
        if(node.getMyLeft() != null)
        {
            treeHeader += " 0";
            out.write(1, 0);
            out.flush();
            getTreeCode(node.getMyLeft(), out);
        }
        
        if(node.getMyRight() != null)
        {
            treeHeader += " 0";
            out.write(1, 0);
            out.flush();
            getTreeCode(node.getMyRight(), out);
        }
    }
    
//    private int headerR(TreeNode n)
//    {
//        if(TreeNode.isLeaf(n))
//        {
//            return IHuffConstants.ALPH_SIZE + 2;
//        }
//        if(n.myRight != null)
//        {
//            return 
//        }
//    }

    @Override
    public ITreeMaker readHeader(BitInputStream in) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
