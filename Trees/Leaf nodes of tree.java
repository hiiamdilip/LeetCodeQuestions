public static void printLeafNodes(TreeNode node) 
{ 
      List<Integer> result = new ArrayList<>();
  
      if (node == null) return null;
      if (node.left == null && node.right == null) result.add(node.value);
      printLeafNodes(node.left); 
      printLeafNodes(node.right);
      return result;
}

public static void printLeafNodesIteratively(TreeNode root) 
	{ 
		if (root == null) return null; 
		Stack<TreeNode> stack = new Stack<>(); 
		stack.push(root); 
		List<Integer> result = new ArrayList<>();
		
		while (!stack.isEmpty()) 
		{ 
			TreeNode node = stack.pop(); 
			if (node.left == null && node.right == null) result.add(node.value);
			if (node.left != null) stack.add(node.left);
			if (node.right != null) stack.add(node.right); 
		}
	}



