package presentation.goodui;

import PO.CategoryPO;
import PO.GoodPO;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

public class Good {
    JFrame jf;

    JTree tree;
    //上面JTree对象对应的model
    DefaultTreeModel model;

    //定义需要被拖动的TreePath
    TreePath movePath;

    JButton addCategoryButton = new JButton("添加目录");
    JButton addGoodButton = new JButton("添加商品");
    JButton deleteButton = new JButton("删除节点");
    JButton editButton = new JButton("编辑当前节点");

    public void init() {

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new CategoryPO("001",0, "所有商品"));

        jf = new JFrame("商品管理");
        tree = new JTree(root);
        //获取JTree对应的TreeModel对象
        model = (DefaultTreeModel) tree.getModel();
        //设置JTree可编辑
        tree.setEditable(true);
        MouseListener ml = new MouseAdapter() {
            //按下鼠标时候获得被拖动的节点
            public void mousePressed(MouseEvent e) {
                //如果需要唯一确定某个节点，必须通过TreePath来获取。
                TreePath tp = tree.getPathForLocation(e.getX(), e.getY());
                if (tp != null) {
                    movePath = tp;
                }
            }

            //鼠标松开时获得需要拖到哪个父节点
            public void mouseReleased(MouseEvent e) {
                //根据鼠标松开时的TreePath来获取TreePath
                TreePath tp = tree.getPathForLocation(e.getX(), e.getY());

                if (tp != null && movePath != null) {
                    //阻止向子节点拖动
                    if (movePath.isDescendant(tp) && movePath != tp) {
                        JOptionPane.showMessageDialog(jf, "目标节点是被移动节点的子节点，无法移动！",
                                "非法操作", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    //既不是向子节点移动，而且鼠标按下、松开的不是同一个节点
                    else if (movePath != tp) {
                        DefaultMutableTreeNode moveFrom = (DefaultMutableTreeNode)movePath.getLastPathComponent();
                        DefaultMutableTreeNode moveTo = (DefaultMutableTreeNode)tp.getLastPathComponent();
                        System.out.println(moveFrom.getUserObject().getClass());
                        System.out.println(moveTo.getUserObject().getClass());

                        System.out.println(tp.getLastPathComponent());
                        //add方法可以先将原节点从原父节点删除，再添加到新父节点中
                        ((DefaultMutableTreeNode) tp.getLastPathComponent()).add(
                                (DefaultMutableTreeNode) movePath.getLastPathComponent());
                        movePath = null;
                        tree.updateUI();
                    }
                }
            }
        };
        tree.addMouseListener(ml);

        JPanel panel = new JPanel();

        addCategoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //获取选中节点
                DefaultMutableTreeNode selectedNode
                        = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                //如果节点为空，直接返回
                if (selectedNode == null) {
                    JOptionPane.showMessageDialog(null, "请选择一个节点！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                //如果节点为商品，提示错误，返回
                if (selectedNode.getUserObject() instanceof GoodPO) {
                    JOptionPane.showMessageDialog(null, "商品下不能添加目录！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                //如果节点下包含商品，提示错误，返回
                if (contain_good(selectedNode)) {
                    JOptionPane.showMessageDialog(null, "该目录下包含商品，添加目录失败！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                //创建一个新的目录节点
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new CategoryPO());
                //直接通过model来添加新节点，则无需通过调用JTree的updateUI方法
                //model.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
                //直接通过节点添加新节点，则需要调用tree的updateUI方法
                selectedNode.add(newNode);
                //--------下面代码实现显示新节点（自动展开父节点）-------
                DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                TreeNode[] nodes = model.getPathToRoot(newNode);
                TreePath path = new TreePath(nodes);
                tree.scrollPathToVisible(path);
                tree.updateUI();
            }
        });
        panel.add(addCategoryButton);

        addGoodButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //获取选中节点
                DefaultMutableTreeNode selectedNode
                        = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                //如果节点为空，直接返回
                if (selectedNode == null) {
                    JOptionPane.showMessageDialog(null, "请选择一个节点！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                //如果节点为商品，提示错误，返回
                if (selectedNode.getUserObject() instanceof GoodPO) {
                    JOptionPane.showMessageDialog(null, "商品下不能添加商品！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                //如果节点下包含目录，提示错误，返回
                if (contain_category(selectedNode)) {
                    JOptionPane.showMessageDialog(null, "该目录下包含目录，添加商品失败！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                //创建一个新的商品节点
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new GoodPO());
                //直接通过model来添加新节点，则无需通过调用JTree的updateUI方法
                //model.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
                //直接通过节点添加新节点，则需要调用tree的updateUI方法
                selectedNode.add(newNode);
                //--------下面代码实现显示新节点（自动展开父节点）-------
                DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                TreeNode[] nodes = model.getPathToRoot(newNode);
                TreePath path = new TreePath(nodes);
                tree.scrollPathToVisible(path);
                tree.updateUI();
            }
        });
        panel.add(addGoodButton);

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                DefaultMutableTreeNode selectedNode
                        = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                //只剩根节点，无法进行删除操作
                if (selectedNode.getParent() == null) {
                    JOptionPane.showMessageDialog(null, "无法删除！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (selectedNode == null) {
                    JOptionPane.showMessageDialog(null, "请选择一个节点进行删除！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                //如果节点是叶子节点
                if (selectedNode.isLeaf()) {
                    //再询问一遍
                    int yes_or_no = JOptionPane.showConfirmDialog(null, "确定删除吗？", "确定删除", JOptionPane.OK_CANCEL_OPTION);
                    if (yes_or_no == 2)
                        return;
                    else
                        model.removeNodeFromParent(selectedNode);
                } else {
                    JOptionPane.showMessageDialog(null, "还有子节点，不能删除！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        });
        panel.add(deleteButton);

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                TreePath selectedPath = tree.getSelectionPath();
                if (selectedPath != null) {
                    //编辑选中节点
                    tree.startEditingAtPath(selectedPath);
                }
            }
        });
        panel.add(editButton);
        panel.setBackground(Color.orange);

        jf.add(new JScrollPane(tree));
        jf.add(panel, BorderLayout.SOUTH);
        jf.pack();
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setBounds(550,250,800,600);

    }

    //treenode n的子节点中是否包含商品
    public boolean contain_good(TreeNode n) {
        if (n.isLeaf())
            return false;
        Enumeration enumeration = n.children();
        while (enumeration.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumeration.nextElement();
            if (node.getUserObject() instanceof GoodPO)
                return true;
        }
        return false;
    }

    //treenode n的子节点中是否包含目录
    public boolean contain_category(TreeNode n) {
        if (n.isLeaf())
            return false;
        Enumeration enumeration = n.children();
        while (enumeration.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumeration.nextElement();
            if (node.getUserObject() instanceof CategoryPO)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new Good().init();
    }
}
