package Chapter18_19;

public class TreeEval {

    public static void main(String[] args) {
        TreeNode root = buildExpression1();
        System.out.println(eval(root));
        root = buildExpression2();
        System.out.println(eval(root));
        root = buildExpression3();
        System.out.println(eval(root));
    }

    /**
     * @param lhs the left side operand
     * @param rhs the right side operand
     * @param op the operator
     * @reutrn returns the results of lhs op rhs
     */
    public static double compute(double lhs, double rhs, char op) {
        switch (op) {
            case '+':
                return lhs + rhs;
            case '-':
                return lhs - rhs;
            case '*':
                return lhs * rhs;
            case '/':
                if (rhs == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return lhs / rhs;
            default:
                throw new ArithmeticException("Unkown operator");
        }
    }

    /**
     * @param t points to a node within a binary expression tree.
     * @return returns true if t points to a leaf, returns false otherwise
	 *
     */
    public static boolean isLeaf(TreeNode t) {
        if (t != null && t.getLeft() == null & t.getRight() == null) {
            return true;
        }
        return false;
    }

    /**
     * @param t points to the root of a binary expression tree.
     * @return returns the value evaluated in the binary expression tree.
     */
    public static double eval(TreeNode t) {
        // Write your code here.
        if (isLeaf(t)) //basecase here
        {
            return (double)t.getValue(); //if leaf, must be a number
        }

        double lhs;
        double rhs;

        if (isLeaf(t.getLeft())) {
            lhs = (double)t.getLeft().getValue();
        } 
        if (isLeaf(t.getRight())) {
            rhs = (double)t.getRight().getValue();
        } 
        
        lhs = eval(t.getLeft());
        rhs = eval(t.getRight());

        //fails leaf checks, its a node 
        char operator = (char)t.getValue(); 
        return compute(lhs, rhs, operator);
    }

    public static TreeNode buildExpression1() {
        TreeNode t1 = new TreeNode(new Double(8), null, null);
        return t1;
    }

    public static TreeNode buildExpression2() {
        TreeNode t1 = new TreeNode(new Double(8), null, null);
        TreeNode t2 = new TreeNode(new Double(4), null, null);
        TreeNode t3 = new TreeNode(new Double(3), null, null);
        TreeNode tc2 = new TreeNode(new Character('*'), t2, t1);
        TreeNode tc1 = new TreeNode(new Character('+'), t3, tc2);
        return tc1;
    }

    public static TreeNode buildExpression3() {
        TreeNode t1 = new TreeNode(new Double(8), null, null);
        TreeNode t2 = new TreeNode(new Double(4), null, null);
        TreeNode t3 = new TreeNode(new Double(3), null, null);
        TreeNode t4 = new TreeNode(new Double(6), null, null);
        TreeNode tc3 = new TreeNode(new Character('-'), t4, t3);
        TreeNode tc2 = new TreeNode(new Character('+'), tc3, t2);
        TreeNode tc1 = new TreeNode(new Character('*'), tc2, t1);
        return tc1;
    }
}
