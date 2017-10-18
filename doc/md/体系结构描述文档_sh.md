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

|     模块      |           职责           |
| :---------: | :--------------------: |
| commoditybl |                        |
|   salebl    | 负责实现进货销售/退货订单的制定所需要的服务 |
|  financebl  |                        |
| promotionbl |   负责实现促销策略制定界面所需要的服务   |
|  approvebl  |    负责实现单据审批界面所需要的服务    |
|  systembl   |                        |

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

#####commoditybl模块的接口规范

**提供的服务<供接口>**



**需要的服务<需接口>** 

| 服务名  |  服务  |
| :--: | :--: |
|      |      |

##### salebl模块的接口规范

**提供的服务<供接口>**

##### **1. Client.addClient**

##### **语法:**public ResultMessage addClient(ClientVO cvo)

##### **前置条件:**启动一个销售/进货回合，且原表中用户信息不存在

##### **后置条件:**成功添加用户信息

##### **2.Client.deleteClient **

##### **语法:**public ResultMessage deleteClient(int id)

##### **前置条件:**与客户结束交易过程，应收/应付清算完成，且原表中用户信息存在

##### **后置条件:**用户信息成功删除

##### **3.Client.updateClient **

##### **语法:**public ResultMessage updateClient(ClientVO cvo)

##### **前置条件:**修改值合法

##### **后置条件:**用户信息修改成功

**需要的服务<需接口>** 

| 服务名  |  服务  |
| :--: | :--: |
|      |      |

##### financebl模块的接口规范

**提供的服务<供接口>**



**需要的服务<需接口>** 

| 服务名  |  服务  |
| :--: | :--: |
|      |      |



##### promotionbl模块的接口规范



**提供的服务<供接口>**

**1. Promotion.makePromotion**

##### **语法:**public ResultMessage makePromotion(PromotionVO promotionVo)

##### **前置条件:**启动一个制定促销策略回合

##### **后置条件:**成功制定促销策略，持久化更新涉及的领域对象的数据

**2. Promotion.endPromotion**

##### **语法:** public void endPromotion()

##### **前置条件:** 已经制定了一个销售策略

##### **后置条件:** 结束此次制定促销策略回合



**需要的服务<需接口>** 

|                   服务名                    |    服务     |
| :--------------------------------------: | :-------: |
| PricePromotionDataService.insert(PromotionPO promotionPO) | 插入单一持久化对象 |
| PricePromotionDataService.delete(PromotionPO promotionPO) | 删除单一持久化对象 |
| PricePromotionDataService.update(PromotionPO promotionPO) | 更新单一持久化对象 |
|   PricePromotionDataService.findAll()    | 查找全部持久化对象 |
| CommodityPromotionDataService.insert(PromotionPO promotionPO) | 插入单一持久化对象 |
| CommodityPromotionDataService.delete(PromotionPO promotionPO) | 删除单一持久化对象 |
| CommodityPromotionDataService.update(PromotionPO promotionPO) | 更新单一持久化对象 |
| CommodityPromotionDataService.finaAll()  | 查找全部持久化对象 |
| UserClassPromotionDataService.insert(PromotionPO promotionPO) | 插入单一持久化对象 |
| UserCalssPromotionDataService.delete(PromotionPO promotionPO) | 删除单一持久化对象 |
| UserClassPromotionDataService.update(PromotionPO promotionPO) | 更新单一持久化对象 |
| UserClassPromotionDataService.findAll()  | 查找全部持久化对象 |



##### approvebl模块的接口规范



**提供的服务<供接口>**

**1. Approve.getApplication**

##### **语法:** public void getApplication()

##### **前置条件:** 启动一个审批单据的回合

##### **后置条件:** 返回所有申请单据

**2. Approve.approveApplication**

##### **语法:** public void approveApplication()

##### **前置条件:** 获取了所有的申请单据

##### **后置条件:** 更新申请单据的状态

**3. Approve.sendMessage**

##### **语法:** public void sendMessage()

##### **前置条件:** 单据审批通过

##### **后置条件:** 给库存管理员发送一条审批通过的消息

**4. Approve.endApplication**

##### **语法:** public void endPromotion()

##### **前置条件:** 已经完成了单据的审批

##### **后置条件:** 结束此次审批单据的回合



**需要的服务<需接口>** 

|                   服务名                    |     服务      |
| :--------------------------------------: | :---------: |
|       ApproveDataService.findAll()       |  查找全部持久化对象  |
| ApproveDataService.update(ApplicationPo applicationPo) |  更新单一持久化对象  |
| ApproveMessageDataService.insert(String message) | 在数据库中插入一条消息 |
|  ApproveMessageDataServicefind(int id)   |  查找最新的一条消息  |
|    ApproveMessageDataService.count()     | 统计一共有多少条消息  |

##### systembl模块的接口规范

**提供的服务<供接口>**



**需要的服务<需接口>** 

| 服务名  |  服务  |
| :--: | :--: |
|      |      |



### 5.4 数据层的分解

（此处照着把书上的图画了命名为“XXX数据层模块的描述”保存成png格式存在SEhomework\doc\img下即可）

#### 5.4.1 数据层模块的职责

##### 库存数据层模块的职责

|  模块  |  职责  |
| :--: | :--: |
|      |      |
|      |      |

##### 销售数据层模块的职责

|  模块  |  职责  |
| :--: | :--: |
|      |      |
|      |      |

##### 财务数据层模块的职责

|  模块  |  职责  |
| :--: | :--: |
|      |      |
|      |      |

##### 销售策略数据层模块的职责

|                    模块                    |                    职责                    |
| :--------------------------------------: | :--------------------------------------: |
|        PricePromotionDataService         |     持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务     |
|  PricePromotionDataServiceExcelFileImpl  | 基于Excel文件的持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务 |
| PricePromotionDataServiceSerializableFileImpl | 基于序列化文件的持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务 |
|    PricePromotionDataServiceMySqlImpl    | 基于MySql数据库的持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务 |
|      CommodityPromotionDataService       |     持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务     |
| CommodityPromotionDataServiceExcelFileImpl | 基于Excel文件的持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务 |
| CommodityPromotionDataServiceSerializableFileImpl | 基于序列化文件的持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务 |
|  CommodityPromotionDataServiceMySqlImpl  | 基于MySql数据库的久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务 |
|      UserClassPromotionDataService       |     持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务     |
| UserClassPromotionDataServiceExcelFileImpl | 基于Excel文件持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务 |
| UserClassPromotionDataServiceSerializableFileImpl | 基于序列化文件的持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务 |
|  UserClassPromotionDataServiceMySqlImpl  | 基于MySql数据库的持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务 |

##### 审批数据层模块的职责

|                    模块                    |                    职责                    |
| :--------------------------------------: | :--------------------------------------: |
|            ApproveDataService            |     持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务     |
|     ApproveDataServiceExcelFileImpl      | 基于Excel文件的持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务 |
|  ApproveDataServiceSerializableFileImpl  | 基于序列化文件的持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务 |
|       ApproveDataServiceMySqlImpl        | 基于MySql数据库的持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务 |
|        ApproveMessageDataService         |     持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务     |
|  ApproveMessageDataServiceExcelFileImpl  | 基于Excel文件的持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务 |
| ApproveMessageDataServiceSerializableFileImpl | 基于序列化文件的持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务 |
|    ApproveMessageDataServiceMySqlImpl    | 基于MySql数据库的持久化数据库的接口，提供集体的载入、集体保存、增、删、改、查服务 |

##### 系统管理数据层模块的职责

|  模块  |  职责  |
| :--: | :--: |
|      |      |
|      |      |

#### 5.4.2 数据层模块的接口规范

（此处格式参照5.3.2接口规范示例）

##### 库存数据层模块的接口规范

**提供的服务<供接口>**



##### 销售数据层模块的接口规范

**提供的服务<供接口>**



##### 财务数据层模块的接口规范

**提供的服务<供接口>**



##### 销售策略数据层模块的接口规范

**提供的服务<供接口>**



##### 审批数据层模块的接口规范

**提供的服务<供接口>**



##### 系统管理数据层模块的接口规范

**提供的服务<供接口>**



## 6 信息视角

### 6.1 数据持久化对象

此处照书上填写自己部分需要填写的，然后写出定义

示例：

> - UserPO类包含用户的用户名、密码属性
>
> 持久化用户对象UserPO的定义如下：
>
> ~~~
> public class UserPO implements Serializable {
>   ……
>   ……
>   ……
> }
> ~~~
>
> 

### 6.2 Txt 持久化格式

根据自己部分的需要照书上的例子填写



### 6.3 数据库表

数据库中包括Appliction表、Message表、UserClassPromtion表、CommodityPromotion表、PricePromotion表