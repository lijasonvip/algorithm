package com.xtfggef.dp.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 本代码出自博客：http://blog.csdn.net/zhangerqing 
 * email:xtfggef@gmail.com
 * 微博：http://weibo.com/xtfggef
 * @author egg
 */
public class TreeNode {
	
	private String name;
	private TreeNode parent;
	private Vector<TreeNode> children = new Vector<TreeNode>();
	
	public TreeNode(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	//添加孩子节点
	public void add(TreeNode node){
		children.add(node);
	}
	
	//删除孩子节点
	public void remove(TreeNode node){
		children.remove(node);
	}
	
	//取得孩子节点
	public Enumeration<TreeNode> getChildren(){
		return children.elements();
	}
}
