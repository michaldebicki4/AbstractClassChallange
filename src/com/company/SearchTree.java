package com.company;

public class SearchTree implements NodeList {

    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override

        public boolean addItem (ListItem newItem){
            if (this.root == null) {
                // the tree was empty; so item becomes the head of the tree
                this.root = newItem;
                return true;

            }
            // otherwise strat compaering from the head of the tree

            ListItem currentItem = this.root;
            while (currentItem != null) {
                int comparison = (currentItem.compareTo(newItem));
                if (comparison < 0) {
                    //newItem is greater, move right if possible
                    if (currentItem.next() != null) {
                        currentItem = currentItem.next();
                    } else {
                        //there is no node to right so add this pint
                        currentItem.setNext(newItem);
                        return true;

                    }
                } else if (comparison > 0) {
                    //newItem is less move left if possible
                    if (currentItem.previous() != null) {
                        currentItem = currentItem.next();
                    } else {
                        //there is no node to right so add this pint
                        newItem.setPrevious(newItem);
                        this.root = newItem;
                    }
                } else {
                    // equal, so do not add
                    System.out.println(newItem.getValue() + " is already present, not added ");
                    return false;
                }
            }
            return false;
        }


    @Override
    public boolean removeItem(ListItem item) {
        if(item != null)
        {
            System.out.println("Deleating item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = this.root;

        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if(comparison < 0){
                parentItem = currentItem;
                currentItem = currentItem.next();
            }
            else if (comparison > 0){
                parentItem = currentItem;
                currentItem = currentItem.previous();
            }
            else {
                //performRemoval(currentItem, parentItem);
                //comparison > 0
                // we are at item greater than the one deleated
                // so the item is not on the list
                return true;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        //recursive method
        if(root!= null){
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }

    }
}
