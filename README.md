# NDP Media Walle系统前后端接口

[TOC]

## 修订历史记录
| 日期 | 版本 | 说明 | 作者 |
|--------|--------|--------|--------|
|2014-10-20|v1.0|接口文档初始化|Mikey|


## 一. 目的

为提高开发效率，明确接口标准、数据格式以及参数名称，规范数据格式和命名。提高后期接口易维护性和易阅读性，给新参与项目人员提供接口的可参考信息。

## 二. 接口说明

### 响应说明

#### 响应格式

```json
{
	"flag": "success/fail",
	"msg": "",
	"errorCode": "",
	"data": {}
}
```

#### flag说明

1. flag标识业务逻辑的成功与失败；
2. flag存在success和fail两种值；
3. fail与errorCode、msg公用。

#### errorCode列表

| Error Code | Description | response |
|--------|--------|--------|--------|
|4|Invalid Token| {"flag":"fail","msg":"Invalid Token.","errorCode":4}|

## 三. Walle接口定义

### 4 控制规则

#### 4.2 获取控制规则

monitoroptimize/showControllRules

**method** : post

> **param**

```json
{
	"batchId": 123
}
```

**return**

- success:

````json
{
	"flag" : "success",
	"errorCode" : "",
	"msg" : "success",
    "data" : [
      {
        "id" : 1122,
        "seqNum":"1",
        "timeRange":{
       		 "startTime":"1","endTime":"2","name":"当天"
        },
        "filterConditions":[
        {
            "field":"cost",
            "name":"推广成本",
            "operation":">=",
            "value":"0",
            "editable":true,
            "unit":""
        }
        ],
        "controllAction":{
            "field":"plause",
            "name":"广告暂停",
            "autoControl":true,
            "value":""
        },
        "enabled":true/false
        }
    ]
}
````

- fail:

```json
{
	"flag": "fail",
	"msg": "错误信息描述。",
	"errorCode": "",
	"data": []
}
```

**后端接口：**  
>//通过批次id查询控制规则  
**List<ControllRule> findByBatchId(Long batchId);**  
**List<ControllRuleTemplate> findAllControllRuleTemplates();**  

#### 4.3 保存控制规则

monitoroptimize/saveControllRules

**method** : post

> **param**

```json
{
	"batchId": 123,
    "rules " : [
      {
          "id" : 112,
          "seqNum":"1",
        "timeRange":{
        "startTime":"1","endTime":"2","name":"当天"
        },
        "filterConditions":[
        {
            "field":"cost",
            "name":"推广成本",
            "operation":">=",
            "value":"0",
            "editable":true,
            "unit":""
        }
        ],
        "controllAction":{
            "field":"plause",
            "name":"广告暂停",
            "autoControl":true,
            "value":""
        },
        "enabled":true/false
}
]
}
```

**return**

- success:

````json
{
    "flag" : "success",
    "errorCode" : "",
    "msg" : "success"
}
````

- fail:

```json
{
	"flag": "fail",
	"msg": "错误信息描述。",
	"errorCode": "",
	"data": []
}
```

**后端接口：**  
>//从PublishBatch这里删除  
**void deleteByBatchId (Long id);**  
**public void saveControl(ControllRule rule);**  
