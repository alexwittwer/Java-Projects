public class BTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(0);
        tree.add(1);
        tree.add(25);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(9);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder(tree.root);
        System.out.println("\n");

        tree.delete(0);
        System.out.println("New order");
        tree.printPreorder(null);
        System.out.println("\n");
        
    }

    static class Node {
        int key;
        Node left, right;

        Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        BinaryTree() {
            root = null;
        }

        void printPostorder(Node node) {
            if (node == null) {
                return;
            }
            printPostorder(node.left);
            printPostorder(node.right);
            System.out.print(node.key + " ");
        }

        void printInorder(Node node) {
            if (node == null) {
                return;
            }
            printInorder(node.left);
            System.out.print(node.key + " ");
            printInorder(node.right);
        }

        void printPreorder(Node node) {
            if (node == null) {
                return;
            }
            System.out.print(node.key + " ");
            printPreorder(node.left);
            printPreorder(node.right);
        }

        void add(int key) {
            root = addRec(root, key);
        }

        Node addRec(Node root, int key) {
            if (root == null) {
                root = new Node(key);
                return root;
            }
            if (key < root.key) {
                root.left = addRec(root.left, key);
            } else if (key > root.key) {
                root.right = addRec(root.right, key);
            }
            return root;
        }

        void delete(int key) {
            root = deleteRec(root, key);
        }

        Node deleteRec(Node root, int key) {
            if (root == null) {
                return root;
            }
            if (key < root.key) {
                root.left = deleteRec(root.left, key);
            } else if (key > root.key) {
                root.right = deleteRec(root.right, key);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }
                root.key = minValue(root.right);
                root.right = deleteRec(root.right, root.key);
            }
            return root;

        }

        int minValue(Node root) {
            int minValue = root.key;
            while (root.left != null) {
                minValue = root.left.key;
                root = root.left;
            }
            return minValue;
        }


        Node searchRec(Node root, int key) {
            if (root == null || root.key == key) {
                return root;
            }
            if (root.key > key) {
                return searchRec(root.left, key);
            }
            return searchRec(root.right, key);
        }
    }
    
}
