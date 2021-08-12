
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Xiao Bao Bao
 */
public class HuffDecoder implements IHuffDecoder {

    @Override
    public void initialize(ITreeMaker treeMaker) {

    }

    @Override
    public void doDecode(BitInputStream input, BitOutputStream output) throws IOException {

        //CHECK MAGIC NUMBER 
        int magic = input.read(BITS_PER_INT);

        try {
            if (magic != MAGIC_NUMBER) {
                throw new IOException("magic number not right");
            }
        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, "Error Reading Compressed File\n"
            + "trouble reading magic number" + ex);
        }
        
        //READ THE ENCRYPTED TREE AND CREATE IT
        TreeNode template = new TreeNode();
        int bits;
       while (true)
       {
           bits = input.read(1);
           if (bits == -1)
           {
               throw new IOException("unexpected end of input file");
           }
           else
           { 
               // use the zero/one value of the bit read
               // to traverse Huffman coding tree
               // if a leaf is reached, decode the character and print UNLESS
               // the character is pseudo-EOF, then decompression done

               if ((bits & 1) == 0) // read a 0, go left  in tree
               else                  // read a 1, go right in tree

               if (at leaf-node in tree)
               {
                   if (leaf-node stores pseudo-eof char) 
                       break;   // out of loop
                   else
                       write character stored in leaf-node
               }
           }
       }
        
        //READ ENCODED BITS AND WRITE TO OUTPUT

    }
