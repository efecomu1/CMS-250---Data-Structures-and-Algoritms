
public class BinarySearchTree {
	TreeNode root;
	
		BinarySearchTree()
		{
			root = null;
		}
	
		BinarySearchTree( TreeNode inputRoot )
		{
			root = inputRoot;
		}

		public TreeNode searchTree( int searchValue)
		{
			return searchTree(this.root, searchValue);
		}
		
		public TreeNode searchTree(TreeNode currentNode, int searchValue)
		{
			System.out.println("Visited Node "+currentNode.value);
			
			if(currentNode.value == searchValue)
			{
				System.out.println("Value "+searchValue+" found in this tree.");
				return currentNode;
			}
			
			if( searchValue < currentNode.value && currentNode.left == null )
			{
				System.out.println("Value "+searchValue+" does not exist in this tree.");
				return currentNode;
			}
			
			if( searchValue > currentNode.value && currentNode.right == null )
			{
				System.out.println("Value "+searchValue+" does not exist in this tree.");
				return currentNode;
			}
			
			if( searchValue < currentNode.value )
			{
				return searchTree( currentNode.left, searchValue );
			}
			else
			{
				return searchTree( currentNode.right, searchValue );
			}
			
		}
		
		public void inorder(TreeNode root)
		{
			 if (root != null) {
		            inorder(root.left);
		            System.out.print(root.value + " ");
		            inorder(root.right);
		        }
		    }
		
		public void addNode(int newValue)
		{
			TreeNode searchResult;
			searchResult = searchTree(newValue);
			if(searchResult.value == newValue)
			{
				System.out.println("Node "+newValue+" already exists.");
				return;
			}
			
			TreeNode newNode = new TreeNode(newValue);
			
			if(newValue < searchResult.value)
			{
				searchResult.setLeft(newNode);
			}
			else
			{
				searchResult.setRight(newNode);
			}
			
			return;
		}
		
		 TreeNode delete(TreeNode root, int key)
		    {
		        // If tree is empty
		        if (root == null)
		            return root;
		 
		        // Travel down tree to get to the node to delete
		        if (key < root.value)
		            root.left = delete(root.left, key);
		        else if (key > root.value)
		            root.right = delete(root.right, key);
		 
		        // If found this is the node to delete
		        // If not, skip the else statement
		        else {
		        	
		            if (root.left == null)
		                return root.right;
		            else if (root.right == null)
		                return root.left;
		 
		            root.value = minValue(root.right);
		 
		            // Delete the node after
		            root.right = delete(root.right, root.value);
		        }
		 
		        return root;
		    }
		 
		    // finding the minimum value
		    int minValue(TreeNode root)
		    {
		        int minval = root.value;
		        while (root.left != null)
		        {
		            minval = root.left.value;
		            root = root.left;
		        }
		        return minval;
		    }
		
}
