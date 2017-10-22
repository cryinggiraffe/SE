# 进销存系统软件体系结构描述文档

## 1. 引言

### 1.1 编制目的

​	本报告详细完成对南京某灯具厂管理系统的概要设计，达到指导详细设计和开发的目的，同时实现和测试人员及用户的沟通。

​	本报告面向开发人员、测试人员及最终用户而编写，是理解系统的导航。

### 1.2 词汇表

（蒲）

|     词汇名称      | 词汇含义  |  备注  |
| :-----------: | :---: | :--: |
| presentation  |  展示层  |      |
| businesslogic | 业务逻辑层 |      |
|     data      |  数据层  |      |

### 1.3 参考资料

## 2. 产品概述

参考之前的管理系统用例文档和需求规格说明文档中对产品的概括和描述。



## 3. 逻辑视角

（文字部分：蒲  图片部分：徐）

本系统使用分层体系结构风格，系统被分为presentation，businesslogic，data三层，能够很好的概括高层抽象。presentation包含了GUI页面的实现，交互动作的实现。businesslogic层包含业务逻辑处理的实现，data层负责数据的持久化和访问。

## 4. 组合视角

### 4.1 开发包图

（徐）

### 4.2 运行时进程

（徐）

### 4.3 物理部署

（徐）

## 5. 接口视角

### 5.1模块的职责

（三个表：路 ）

- 表 客户端各层的职责

|  层   |  职责  |
| :--: | :--: |
|      |      |
|      |      |
|      |      |
|      |      |

- 表 服务器端各层的职责

|  层   |  职责  |
| :--: | :--: |
|      |      |
|      |      |
|      |      |



- 表 层之间调用的接口

  （此表可能形式要改，合理即可）

| 接口   | 服务调用方 | 服务提供方 |
| ---- | ----- | ----- |
|      |       |       |
|      |       |       |

（各自参照图9，画了命名成“XX用例层之间调用的接口”将图片保存成png格式存在SEhomework\doc\img下即可）

- 库存用例层之间调用的接口



- 销售用例层之间调用的接口



- 财务用例层之间调用的接口



- 销售策略用例层之间调用的接口



- 审批用例层之间调用的接口



- 系统管理用例层之间调用的接口



###5.2 用户界面层的分解

（各自手绘画好自己的界面部分拍照给徐由徐整理）

###5.3 业务逻辑层的分解 

（图12：徐 ）

#### 5.3.1 业务逻辑层模块的职责

业务逻辑层模块的职责如表所示

（把各自负责的部分填写）

- 表 业务逻辑层模块的职责

|     模块      |        职责        |
| :---------: | :--------------: |
| categorybl  |  负责实现商品界面所需要的服务  |
|   goodbl    |  负责实现商品界面所需要的服务  |
|   viewbl    | 负责实现库存查看界面所需要的服务 |
|   giftbl    | 负责实现赠送库存界面所需要的服务 |
| supervisebl | 负责实现库存监管界面所需要的服务 |
|             |                  |

#### 5.3.2 业务逻辑层模块的接口规范

示例：

> #####salebl模块的接口规范
>
> ##### **提供的服务<供接口>**
>
> #####**1. Sales.addMenber** 
>
> #####**语法:**public ResultMessage addMember(long id)
>
> #####**前置条件:**启动一个销售回合
>
> #####**后置条件:**在一个销售回合中，增加购物的会员信息
>
> #####**2. Sales.addMenber** 
>
> #####**语法:**……
>
> #####**前置条件:**……
>
> #####**后置条件:**……
>
> #####。。。。
>
> #####**需要的服务<需接口>**

|              服务名              |       服务        |
| :---------------------------: | :-------------: |
| SalesDataService.find(int id) | 根据ID进行查找单一持久化对象 |
|              ……               |       ……        |



（下面部分照着示例把自己的部分补充完整）

#####categorybl模块的接口规范

**提供的服务<供接口>**

##### **1. category.addNew**

##### **语法:**public ResultMessage addCategory(String category_name)

##### **前置条件:**

##### **后置条件:**显示添加商品分类成功或者失败

##### **2. category.delete**

##### **语法:**public ResultMessage deleteCategory(Click rightClick)

##### **前置条件:**

##### **后置条件:**显示删除商品分类成功或者失败

##### **3. category.rename**

##### **语法:**public ResultMessage renameCategory(String categoryName)

##### **前置条件:**

##### **后置条件:**显示修改商品分类名称成功或者失败

**需要的服务<需接口>** 

|                 服务名                 |      服务      |
| :---------------------------------: | :----------: |
| DatabaseFacory.getInventoryDatabase | 得到库存数据库服务的引用 |

##### goodbl模块的接口规范

**提供的服务<供接口>**

##### **1. Good.addNew**

##### **语法:**public ResultMessage addGood(String goodName)

##### **前置条件:**

##### **后置条件:**显示添加商品成功或者失败

##### **2.Client.deleteGood **

##### **语法:**public ResultMessage deleteGood(Click rightClick)

##### **前置条件:**

##### **后置条件:**显示删除商品成功

##### **3.Client.renameGood **

##### **语法:**public ResultMessage renameGood(String goodName)

##### **前置条件:**

##### **后置条件:**显示修改商品名称成功

##### **4.Client.moveGood  **

##### **语法:**public ResultMessage moveGood()

##### **前置条件:**

##### **后置条件:**显示移动商品成功

##### **5.Client.searchGood **

##### **语法:**public ResultMessage searchGood(String keyword)

**public ResultMessage searchGood(int id)** 

##### **前置条件:**

##### **后置条件:**

**需要的服务<需接口>** 

|                 服务名                 |      服务      |
| :---------------------------------: | :----------: |
| DatabaseFacory.getInventoryDatabase | 得到库存数据库服务的引用 |

##### viewbl模块的接口规范

**提供的服务<供接口>**

##### **1. View.period**

##### **语法:**public ResultMessage search_by_period(Period period)

##### **前置条件:**

##### **后置条件:**

##### **2. View.check**

##### **语法:**public ResultMessage check(Click leftClick)

##### **前置条件:**

##### **后置条件:**

##### **3. View.ouput_Excel**

##### **语法:**public ResultMessage output_Excel(Click leftClick)

##### **前置条件:**

##### **后置条件:**

**需要的服务<需接口>** 

|                 服务名                 |      服务      |
| :---------------------------------: | :----------: |
| DatabaseFacory.getInventoryDatabase | 得到库存数据库服务的引用 |



### 5.4 数据层的分解

（此处照着把书上的图画了命名为“XXX数据层模块的描述”保存成png格式存在SEhomework\doc\img下即可）

#### 5.4.1 数据层模块的职责

##### 商品分类管理数据层模块的职责

|                   模块                    |                    职责                    |
| :-------------------------------------: | :--------------------------------------: |
|           CategoryDataService           |     持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务      |
|    CategoryDataServiceExcelFileImpl     | 基于Excel文件的持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务 |
| CategoryDataServiceSerializableFileImpl | 基于序列化文件的持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务  |
|      CategoryDataServiceMySqlImpl       | 基于MySql数据库的持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务 |

##### 商品数据层模块的职责

|                 模块                  |                    职责                    |
| :---------------------------------: | :--------------------------------------: |
|           GoodDataService           |     持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务      |
|    GoodDataServiceExcelFileImpl     | 基于Excel文件的持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务 |
| GoodDataServiceSerializableFileImpl | 基于序列化文件的持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务  |
|      GoodDataServiceMySqlImpl       | 基于MySql数据库的持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务 |

**查看库存数据层模块的职责** 

|                 模块                  |                    职责                    |
| :---------------------------------: | :--------------------------------------: |
|           ViewDataService           |     持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务      |
|    ViewDataServiceExcelFileImpl     | 基于Excel文件的持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务 |
| ViewDataServiceSerializableFileImpl | 基于序列化文件的持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务  |
|      ViewDataServiceMySqlImpl       | 基于MySql数据库的持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务 |

##### 赠品数据层模块的职责

|                 模块                  |                    职责                    |
| :---------------------------------: | :--------------------------------------: |
|           GiftDataService           |     持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务      |
|    GiftDataServiceExcelFileImpl     | 基于Excel文件的持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务 |
| GiftDataServiceSerializableFileImpl | 基于序列化文件的持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务  |
|      GiftDataServiceMySqlImpl       | 基于MySql数据库的持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务 |

**库存监管数据层模块的职责**

|                   模块                   |                    职责                    |
| :------------------------------------: | :--------------------------------------: |
|           ReceiptDataService           |     持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务      |
|    ReceiptDataServiceExcelFileImpl     | 基于Excel文件的持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务 |
| ReceiptDataServiceSerializableFileImpl | 基于序列化文件的持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务  |
|      ReceiptDataServiceMySqlImpl       | 基于MySql数据库的持久化数据库的接口，提供集体载入、集体保存、增、删、改、查服务 |

## 6 信息视角

### 6.1 数据持久化对象

此处照书上填写自己部分需要填写的，然后写出定义

- CategoryPo类是包含商品分类的编号属性
- GoodPO类是包含商品的编号、名称、型号、库存数量、进价、零售价、最近进价、最近零售价属性。
- ViewPo类是保存一段时间内库存情况的数据的类，包含出库数量及金额，入库数量及金额，销售数量及金额，进货数量及金额，并且包括库存数量的合计。
- ViewTodayPo类是保存当天内库存情况的数据的类，包含当天各种商品的名称、型号、库存数量、库存均价、批次、批号、出场日期
- GiftPo类是保存赠品的数据的类，包含编号、名称、型号、库存数量、进价、零售价、最近进价、最近零售价属性。
- ReceiptPo类是保存库存库存报溢、报损、报警数据的类，包含包含编号、名称、型号、库存数量、进价、零售价、最近进价、最近零售价属性。

持久化用户对象CategoryPO的定义如下：

```
public class CategoryPO implements Serializable {
  int id;
  String name;
  
  public CategoryPo(String name){
    this.name = name;
  }
  public String getName(){
    return name;
  }
  public String getId(){
    return id;
  }
}
```

持久化用户对象GoodPO的定义如下：

```
public class GoodPO implements Serializable {
  int id;
  String name;
  String type;
  int num;
  int pur_price;
  int ret_price;
  int rece_price;
  int rece_ret_price;
  
  public GoodPo(String name, String type, int num, int pur_price, int ret_price, int rece_price, int rece_ret_price){
    this.name = name;
    this.type = type;
    this.num = num;
    this.pur_price = pur_price;
    this.ret_price = rece_price;
    this.rece_ret_price = rece_ret_price;
  }
  public String getName(){
    reutrn name;
  }
  public String getType(){
    return type;
  }
  public int getNum(){
    return num;
  }
  public int getPur_price(){
    return pur_price;
  }
  public int getRet_price(){
    return ret_price;
  }
  public int getRece_ret_price(){
    return rece_ret_price;
  }
}
```

持久化用户对象ViewPO的定义如下：

包含出库数量及金额，入库数量及金额，销售数量及金额，进货数量及金额，并且包括库存数量的合计

```
public class ViewPO implements Serializable {
  int out_num;
  int out_price;
  int in_num;
  int in_price;
  int sale_num;
  int sale_price;
  
 ;
  
//未完待续
}
```

持久化用户对象ViewTodayPO的定义如下：

```
public class ViewTodayPO implements Serializable {
  String name;
  String type;
  int num;
  int ava_price;
  int batch；
  int batch_num;
  Date dp;
  
  public ViewTodayPo(String name, String type, int num, int ava_price, int batch, int batch_num, Date dp){
    this.name = name;
    this.type = type;
    this.num = num;
    this.ava_price = ava_price;
    this.batch = batch;
    this.batch_num = batch_num;
    this.dp = dp;
  }
  public String getName(){
    return name;
  }
  public String getType(){
    return type;
  }
  public int getNum(){
    return num;
  }
   public int getAva_price(){
    return ava_price;
  }
   public int get_Batch(){
    return batch;
  }
   public int getBatch_num(){
    return batch_num;
  }
  public Date getDate(){
    return dp;
  }
}
```

持久化用户对象GiftPO的定义如下：

```
public class GiftPO implements Serializable extends GoodPo {
  //把赠品信息发送给总经理
  public void sendToManager(){
    sendMessage();
  }
  //接受总经理的回复
  public String receiveFromManager(){
    return receiveMessage();
  }
}
```

持久化用户对象ReceiptPO的定义如下：

```
public class ReceiptPO implements Serializable {
  int id;
  String name;
  int num;
  
  public ReceiptPO(int id, String name, int num){
    this.id = id;
    this.name = name;
    this.num = num;
  }
  public String getName(){
    return name;
  }
  public int getId(){
    return id;
  }
  public int getNum(){
    return num;
  }
  sendMessage();
  receiveMessage();
}
```



### 6.2 Excel 持久化格式

**Category.xlsx** 

每行分别对应商品的编号、名称。如下所示：

| 编号            | 名称   |
| ------------- | ---- |
| 1234567890123 | 饮品   |

**Good.xlsx** 

每行分别对应商品的编号、名称、型号、库存数量、进价、零售价、最近进价、最近零售价。如下所示：

| 编号            | 名称   | 型号    | 库存数量 | 进价   | 零售价  | 最近进价 | 最近零售价 |
| ------------- | ---- | ----- | ---- | ---- | ---- | ---- | ----- |
| 1234567891234 | 牙膏   | TX183 | 3000 | 25   | 30   | 25   | 33    |

**Receipt.xlsx**

每行分别对应商品的编号、名称、库存数量。如下所示：

| 编号            | 名称   | 库存数量 |
| ------------- | ---- | ---- |
| 1234567891235 | 牙刷   | 500  |

### 6.3 数据库表

数据库中包括Category表、Good表、Gift表、Receipt表