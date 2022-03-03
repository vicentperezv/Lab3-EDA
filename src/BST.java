public class BST {

        private Node root;
        public BST(){
            this.root=null;
        }
        public BST(Node root){
            this.root=root;
        }
        public Node getRoot(){
            return this.root;
        }
        private Node insertStar(Node root, quintupla Value){
            if(root == null){
                root = new Node(Value);
                return root;
            }
            if(Value.getStars()< root.getValue().getStars()){
                root.setLeft(insertStar(root.getLeft(), Value));
            }else if(Value.getStars()>= root.getValue().getStars()){
                root.setRight(insertStar(root.getRight(),Value));
            }
            return root;
        }

        public void insertStar(quintupla Value){
            this.root=insertStar(this.root,Value);
        }
        private Node insertMax_Price(Node root, quintupla Value){
                if(root == null){
                root = new Node(Value);
                return root;
            }
            if(Value.getMax_price()< root.getValue().getMax_price()){
                root.setLeft(insertMax_Price(root.getLeft(), Value));
            }else if(Value.getMax_price()>= root.getValue().getMax_price()){
                root.setRight(insertMax_Price(root.getRight(),Value));
            }
            return root;
        }

    public void insertMax_Price(quintupla Value){
        this.root=insertMax_Price(this.root,Value);
    }


    }
