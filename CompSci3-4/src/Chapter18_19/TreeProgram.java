package Chapter18_19;

//import Chapter6.ListQueue;
//import Chapter6.ListQueueOld;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeProgram {

    public static void main(String[] args) {
        int choice;
        TreeNode tree = null;
        do {
            do {
                System.out.println("Tree menu");
                System.out.println("1\tCreate a tree");
                System.out.println("2\tDisplay a tree in preorder");
                System.out.println("3\tDisplay a tree in inorder");
                System.out.println("4\tDisplay a tree in postorder");
                System.out.println("5\tDisplay a tree in levelorder");
                System.out.println("6\tCount the number of nodes in the tree");
                System.out.println("7\tCount the number of leaves in the tree");
                System.out.println("8\tSum the nodes in the tree");
                System.out.println("9\tCompute the height of the tree");
                System.out.println("10\tCompute the width of the tree");
                System.out.println("11\tSearch for a value in the tree");
                System.out.println("12\tDelete a node from the tree");
                System.out.println("13\tDestroy the tree");
                System.out.println("14\tDraw the tree");
                System.out.println("15\tExit");
                String input = "";
                choice = getInt("\nChoice: ");
            } while (choice < 1 && choice > 15);
            System.out.println();
            switch (choice) {
                case 1:
                    int howMany = getInt("Load how many integers: ");
                    tree = loadTree("C:\\Users\\Xiao Bao Bao\\Documents\\NetBeansProjects\\CompSci3-4\\src\\Chapter18_19\\tree.dat", howMany);
                    break;
                case 2:
                    preorder(tree);
                    break;
                case 3:
                    inorder(tree);
                    break;
                case 4:
                    postorder(tree);
                    break;
                case 5:
                    levelorder(tree);
                    break;
                case 6:
                    System.out.println("Number of nodes is " + numNodes(tree));
                    break;
                case 7:
                    System.out.println("Number of leaves is " + numLeaves(tree));
                    break;
                case 8:
                    System.out.println("Sum of the nodes is " + sumNodes(tree));
                    break;
                case 9:
                    System.out.println("The height of the tree is " + height(tree));
                    break;
                case 10:
                    System.out.println("The width of the tree is " + width(tree));
                    break;
                case 11:
                    int value = getInt("Value to look for: ");
                    System.out.println("The search for " + value
                            + " resulted in " + find(tree, value));
                    break;
                case 12:
                    int delValue = getInt("Node value to delete: ");
                    tree = deleteNode(tree, delValue);
                    break;
                case 13:
                    System.out.println("Destroying the tree");
                    tree = destroy(tree);
                    break;
                case 14:
                    System.out.println("Draw tree");
                    drawTree(tree);
                    break;
                case 15:
                    System.out.println("Bye-bye");
                    break;
            }
            if (choice != 15) {
                System.out.println("\n");
            }
        } while (choice != 15);
    }

    /**
     * Returns an integer enter by the user.
     *
     * @return int value that was entered by user input
     */
    private static int getInt(String prompt) {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader console = new BufferedReader(reader);
        String input = "";
        boolean error;
        int value = 0;
        do {
            error = false;
            System.out.print(prompt);
            try {
                input = console.readLine();
            } catch (Exception e) {
                System.out.println(e);
                error = true;
            }
            try {
                value = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("ERROR - Please enter an integer value");
                error = true;
            }
        } while (error);
        return value;
    }

    /**
     * Creates a Binary Search Tree from the integers found in the data file
     * passed.
     *
     * @param filename the filename containing the integers
     * @param count the number of integers in the file to use
     * @return Returns a Binary Search Tree containing count integers from the
     * file filename.
     */
    public static TreeNode loadTree(String filename, int count) {
        FileReader theFile;
        BufferedReader fileIn = null;
        String oneLine;
        TreeNode tree = null;
        int ctr = 0;
        try {
            theFile = new FileReader(filename);
            fileIn = new BufferedReader(theFile);
            while ((oneLine = fileIn.readLine()) != null && ctr < count) {
                // process oneLine
                int value = Integer.parseInt(oneLine);
                System.out.println("Read in value: " + value);
                tree = makeTree(tree, value);
                ctr++;
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (fileIn != null) {
                    fileIn.close();
                }
            } catch (IOException e) {
                // Do nothing if there is an error trying to close the file.
            }
        }
        return tree;
    }

    /**
     * Adds an integer value into a Binary Search Tree. If the BST is empty the
     * value added becomes the root.
     *
     * @param tree the Binary Search Tree to add a value to
     * @param value the integer value to add to the Binary Search Tree
     * @return erturns teh root of the Binary Search Tree
     * @postcondition the value is added to the left if <, otherwise to the
     * right if >=
     */
    private static TreeNode makeTree(TreeNode tree, int value) {
        if (tree == null) {
            return new TreeNode(value);
        }
        if ((int) tree.getValue() > value) {
            tree.setLeft(makeTree(tree.getLeft(), value));
            return tree;
        } else {
            tree.setRight(makeTree(tree.getRight(), value));
            return tree;
        }
    }

    /**
     * Displays a Binary Tree in a Preorder traversal
     *
     * @param tree the binary tree to display
     * @postcondition the binary tree is displayed to the console window in a
     * preorder traversal.
     */
    public static void preorder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        System.out.print(tree.getValue() + " ");
        preorder(tree.getLeft());
        preorder(tree.getRight());
    }

    /**
     * Displays a Binary Tree in a Inorder traversal
     *
     * @param tree the binary tree to display
     * @postcondition the binary tree is displayed to the console window in an
     * inorder traversal.
     */
    public static void inorder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        preorder(tree.getLeft());
        System.out.print(tree.getValue() + " ");
        preorder(tree.getRight());
    }

    /**
     * Displays a Binary Tree in a Postorder traversal
     *
     * @param tree the binary tree to display
     * @postcondition the binary tree is displayed to the console window in a
     * postorder traversal.
     */
    public static void postorder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        preorder(tree.getLeft());
        preorder(tree.getRight());
        System.out.print(tree.getValue() + " ");
    }

    /**
     * Displays a Binary Tree in a Level order traversal
     *
     * @param tree the binary tree to display
     * @postcondition the binary tree is displayed to the console window in a
     * level order traversal.
     */
    public static void levelorder(TreeNode t) {
        ListQueueOld queue = new ListQueueOld();

        queue.enqueue(t);

        while (!queue.isEmpty()) {
            TreeNode temp = (TreeNode) queue.dequeue();

            System.out.print(temp.getValue() + "  ");

            if (temp.getLeft() != null) {
                queue.enqueue(temp.getLeft());
            }

            if (temp.getRight() != null) {
                queue.enqueue(temp.getRight());
            }
        }
    }

    /**
     * Returns the number of nodes in a binary tree.
     *
     * @param tree a binary tree
     * @return returns the number of nodes in the binary tree
     */
    public static int numNodes(TreeNode tree) {
        int num = 0;
        if (tree == null) {
            return 0;
        } else {
            num += 1;
        }
        num += numNodes(tree.getLeft());
        num += numNodes(tree.getRight());

        return num;
    }

    /**
     * Determines if a node is a leaf in a binary tree
     *
     * @param t a node in a binary tree
     * @return returns true if t is a node with empty left & right subtrees,
     * otherwise returns false
     */
    private static boolean isLeaf(TreeNode t) {
        if (t != null && t.getLeft() == null & t.getRight() == null) {
            return true;
        }
        return false;
    }

    /**
     * Returns the number of leaves in a binary tree.
     *
     * @param tree a binary tree
     * @return returns the number of leaves in the binary tree
     */
    public static int numLeaves(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        if (isLeaf(tree)) {
            return 1;
        }
        return numLeaves(tree.getLeft()) + numLeaves(tree.getRight());
    }

    /**
     * Returns the sum of all the nodes in a binary tree.
     *
     * @param tree a binary tree
     * @return returns the sum of all nodes in the binary tree
     */
    public static int sumNodes(TreeNode tree) {

        if (tree == null) {
            return 0;
        }

        return (int) tree.getValue() + sumNodes(tree.getLeft()) + sumNodes(tree.getRight());
    }

    /**
     * Returns the larger of two integers passed.
     *
     * @param lhs any int value
     * @param rhs any int value
     * @returns the larger of lhs & rhs. If they are the same rhs is returned.
     */
    private static int max(int lhs, int rhs) {
        if (lhs == rhs) {
            return lhs;
        }
        return Math.max(lhs, rhs);
    }

    /**
     * Returns the height of a binary tree.
     *
     * @param tree a binary tree
     * @return returns the height of the binary tree passed. An empty tree
     * returns the value of 0.
     */
    public static int height(TreeNode tree) {
        if (tree == null) {
            return 0;
        } else {
            return 1 + max(height(tree.getLeft()), height(tree.getRight()));
        }
    }

    /**
     * Returns the width of a binary tree.
     *
     * @param tree a binary tree
     * @return returns the width of the binary tree passed. An empty tree
     * returns the value of 0.
     */
    public static int width(TreeNode tree) {
        if (tree == null) {
            return 0;
        }

        int sum = 1 + height(tree.getLeft()) + height(tree.getRight());

        if (tree.getLeft() != null) {
            sum = max(width(tree.getLeft()), sum);
        }

        if (tree.getRight() != null) {
            sum = max(sum, width(tree.getRight()));
        }

        return sum;
    }

    /**
     * Determines if a value is within a binary search tree.
     *
     * @param tree a binary search tree
     * @param value the value to search for in binary search tree
     * @return returns true if value is found in the binary search tree,
     * otherwise returns false.
     */
    public static boolean find(TreeNode tree, int value) {
        if ((int) tree.getValue() == value) {
            return true;
        }

        boolean found = false;

        if (tree.getLeft() != null) {
            found = find(tree.getLeft(), value);
        }

        if (!found && tree.getRight() != null) {
            found = find(tree.getRight(), value);
        }

        return found;
    }

    /**
     * Removes a value from a binary search tree.
     *
     * @param root the binary search tree
     * @param delValue the value to remove from the binary search tree
     * @return returns the root of the tree after it has been altered
     */
    public static TreeNode deleteNode(TreeNode root, int delValue) {
        if (root == null) {
            throw new NullPointerException();
        }
        if (delValue < (int) root.getValue()) {
            root.setLeft(deleteNode(root.getLeft(), delValue));
        } else if (delValue > (int) root.getValue()) {
            root.setRight(deleteNode(root.getRight(), delValue));
        } else if (root.getLeft() != null && root.getRight() != null) //two children case
        {
            root.setValue(findMin(root.getRight()).getValue());
            root.setRight(removeMin(root.getRight()));
        } else {
            root = (root.getLeft() != null) ? root.getLeft() : root.getRight();
        }
        return root;
    }

    /**
     * Returns the smallest node in a Binary Tree
     *
     * @param t root of the tree
     * @return the node containing the smallest value
     */
    public static TreeNode findMin(TreeNode t) {
        if (t != null) {
            while (t.getLeft() != null) {
                t = t.getLeft();
            }
        }

        return t;
    }

    /**
     * Method removes the smallest item in a subtree
     *
     * @param t the root of the tree
     * @return the new root of tree
     */
    public static TreeNode removeMin(TreeNode t) {
        if (t == null) {
            throw new NullPointerException();
        } else if (t.getLeft() != null) {
            t.setLeft(removeMin(t.getLeft()));
            return t;
        } else {
            return t.getRight();
        }
    }

    /**
     * Deletes all the node in the binary tree BROKEN BROKEN BROKEN
     *
     * @param tree the binary tree
     * @return returns a null pointer
     */
    public static TreeNode destroy(TreeNode tree) {
       while(tree != null){
           removeMin(tree);
       }
       return tree;
    }

    /**
     * Draws a binary tree to the console window
     *
     * @param tree the binary tree to draw
     * @postcondition draws a binary tree to the console window
     */
    public static void drawTree(TreeNode tree) {
        
        System.out.println(tree.getValue());
        
        TreeNode left = tree.getLeft();
        TreeNode right = tree.getRight();
        
        if(left != null)
        {
            drawTree(left);
        }
        if(right != null)
        {
            drawTree(right);
        }
    }
}
