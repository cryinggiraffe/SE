package PO;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public GoodPO gpo=null;
    public CategoryPO cpo=null;
    private int id;
    private int pid;
    public int getId(){return this.id;};
    public TreeNode setNode(Object o){

        if(o.getClass()==CategoryPO.class&&cpo.getId()!=null){
            this.gpo=null;
            this.cpo=(CategoryPO) o;
            id=Integer.parseInt(cpo.getId());
            pid=cpo.getPid();
            return this;
        }else if(cpo.getId()!=null){

            this.gpo=(GoodPO) o;
            this.cpo=null;
            id=Integer.parseInt(gpo.getGoodid());
            pid=gpo.getPid();
            return this;
        }else {return null;}

    }
    public TreeNode(){

        gpo=null;
        cpo=null;
    }
    public TreeNode(CategoryPO po){

        cpo=po;
        gpo=null;
        pid=cpo.getPid();
        id=Integer.parseInt(cpo.getId());

    }
    public TreeNode(GoodPO po){

        gpo=po;
        cpo=null;
        pid=gpo.getPid();
        id=Integer.parseInt(gpo.getGoodid());
    }
    public Object getValue(){
        if(cpo!=null)return cpo;
        else if(gpo!=null)return gpo;
        else return null;
    }
    public List<TreeNode> childs;
    public List<TreeNode> collectChildren(List<TreeNode> list){
        List<TreeNode> res=new ArrayList<TreeNode>();
        if(list.size()==0)return null;
        for(int i=0;i!=list.size();i++){
            if(this.id==list.get(i).pid){
                res.add(list.get(i));
                list.remove(i);
                i--;
            }
        }
        for(int i=0;i!=res.size();i++){
            res.get(i).childs=res.get(i).collectChildren(list);
        }
        return res;
    }

    public static List<TreeNode> buildNodes(List<GoodPO> po, List<CategoryPO> po2){
        List<TreeNode> res=new ArrayList<TreeNode>();
        for(int i=0 ;i!=po2.size();i++){
            res.add(new TreeNode(po2.get(i)));
        }
        for(int i=0;i!=po.size();i++){
            res.add(new TreeNode(po.get(i)));
        }
        return res;
    }
    public void print(TreeNode np){
        String buff="";
        String res=""+np.id;
        for(int i=0;i!=np.childs.size();i++){
            buff=buff+","+childs.get(i).id;
        }
        System.out.println(res+"->"+buff);
        for(int i=0;i!=np.childs.size();i++){
            childs.get(i).print(childs.get(i));
        }

    }
    public static void main(String[] agrs){
        //TreeNode t=new TreeNode();
        //t.setNode(new CategoryPO());
        System.out.println();
        ArrayList<CategoryPO> po=new ArrayList<>();
        po.add(new CategoryPO("1",0,""));
        po.add(new CategoryPO("2",0,""));
        po.add(new CategoryPO("3",0,""));
        po.add(new CategoryPO("5",1,""));
        po.add(new CategoryPO("6",2,""));
        po.add(new CategoryPO("7",3,""));
        ArrayList<GoodPO> po2=new ArrayList<>();
        po2.add(new GoodPO("8",1,"","",0,0,0,0,0));
        po2.add(new GoodPO("9",2,"","",0,0,0,0,0));
        po2.add(new GoodPO("10",3,"","",0,0,0,0,0));
        po2.add(new GoodPO("11",4,"","",0,0,0,0,0));
        po2.add(new GoodPO("12",5,"","",0,0,0,0,0));
        po2.add(new GoodPO("13",5,"","",0,0,0,0,0));
        po2.add(new GoodPO("14",1,"","",0,0,0,0,0));
        po2.add(new GoodPO("15",2,"","",0,0,0,0,0));

                //int id, int pid, String name, String type, int num, int pur_price, int ret_price, int rece_price,
        //int rece_ret_price


        TreeNode n=new TreeNode(new CategoryPO("0",0,""));

        n.childs=n.collectChildren(TreeNode.buildNodes(po2,po));
        n.print(n);
        System.out.println(n.childs==null);
    }
}
