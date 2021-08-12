/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 16_Bao_Xiao_Bao
 */
public class TreeMaker implements ITreeMaker {

    private SimpleCounter counts;
    
    public TreeMaker(SimpleCounter counts) {
        
        this.counts = counts;
    }
    @Override
    public TreeNode makeRoot() {
       
        PriorityQueue queue = new PriorityQueue();
 
        //ADD THE PSEUDO-EOF LEAF NODE TO FOREST
        //TreeNode eof = new TreeNode(IHuffConstants.PSEUDO_EOF, -1);
        //queue.add(eof);
        
        for(int k = 0; k < IHuffConstants.ALPH_SIZE; k++)
        {
            if(counts.getCount(k) > 0) 
                queue.add(new TreeNode(k , counts.getCount(k)));
        }
        
        while(queue.size() != 1)
        {
            TreeNode first = (TreeNode) queue.remove();
            TreeNode second = (TreeNode) queue.remove();
            queue.add(new TreeNode(
                    0, first.getWeight() + second.getWeight(), 
                    second, first));
        }

        return (TreeNode) queue.remove();
    }
}
