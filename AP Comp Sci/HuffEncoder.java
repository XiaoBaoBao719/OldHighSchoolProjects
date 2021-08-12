
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
public class HuffEncoder implements IHuffEncoder {

    private String[] table;
    
    public HuffEncoder() {
        
        table = new String[IHuffConstants.ALPH_SIZE];
    }
    
    @Override
    public void makeTable(ITreeMaker treeMaker) {
        
        TreeNode node = treeMaker.makeRoot();
        
         code(node, new String());
    }

    @Override
    public String getCode(int i) {
        
        if(table == null)
            try {
                throw new Exception();
        } catch (Exception ex) {
            System.out.println("Error: Table not created yet");
        }
 
        return table[i];
    }
    
    /** 
     * 
     * @param node
     * @param code
     * @return 
     */
    private void code(TreeNode node, String code)
    {
        if(TreeNode.isLeaf(node))
        {
            table[node.getVal()] = code;
            return;
        }
        if(node.getMyLeft() != null)
        {
            code(node.getMyLeft(), code + "0");
        }
        if(node.getMyRight() != null)
        {
            code(node.getMyRight(), code + "1");
        }
    }
    
    public String getTableVal(int i)
    {
        return table[i];
    }
    
    public String[] getTable()
    {
        return table;
    }
    
}
