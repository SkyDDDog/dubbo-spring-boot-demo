# 接口设计

## 用户接口: UserController
### 用户登录
* 接口描述: 用户登录
* 请求方法: POST
* Url: /user/login
* 参数: 

| 参数名 | 数据类型 | 参数类型 | 是否必填 | 说明     |
| ------ | -------- | -------- | -------- | -------- |
| vo     | UserVO   | body     | Y        | 用户对象 |
* 示例
  * 请求参数
    ~~~text
    {
        "password": "password",
        "username": "username"
    }
    ~~~
  * 返回值
    ~~~text
    {
      "errMsg": "未知错误.",
      "item": {},
      "msgCode": -10000,
      "receiptDateTime": "2018-09-29 11:26:20",
      "returnDateTime": "2018-09-29 11:26:20",
      "success": true
    }
    ~~~

### 用户注册
* 接口描述: 用户注册
* 请求方法: POST
* Url: /user/register
* 参数:

| 参数名 | 数据类型 | 参数类型 | 是否必填 | 说明     |
| ------ | -------- | -------- | -------- | -------- |
| vo     | UserVO   | body     | Y        | 用户对象 |
* 示例
    * 请求参数
      ~~~text
      {
          "password": "password",
          "username": "username"
      }
      ~~~
    * 返回值
      ~~~text
      {
        "errMsg": "未知错误.",
        "item": {},
        "msgCode": -10000,
        "receiptDateTime": "2018-09-29 11:26:20",
        "returnDateTime": "2018-09-29 11:26:20",
        "success": true
      }
      ~~~

## 备忘录接口: NoteController 
### 查询所有note
* 接口描述: 查询所有note
* 请求方法: GET
* Url: /note ; /note/list
* 参数:
无
* 示例
    * 请求参数
  
      无
    * 返回值
      ~~~text
      {
        "errMsg": "未知错误.",
        "item": {},
        "msgCode": -10000,
        "receiptDateTime": "2018-09-29 11:26:20",
        "returnDateTime": "2018-09-29 11:26:20",
        "success": true
      }
      ~~~

### 创建note
* 接口描述: 创建note
* 请求方法: POST
* Url: /note
* 参数:

| 参数名 | 数据类型 | 参数类型 | 是否必填 | 说明     |
| ------ | -------- | -------- | -------- | -------- |
| vo     | NoteVO   | body     | Y        | 用户对象 |
* 示例
    * 请求参数
      ~~~text
      {
          "content": "内容",
          "userId": "用户id"
      }
      ~~~
    * 返回值
      ~~~text
      {
        "errMsg": "未知错误.",
        "item": {},
        "msgCode": -10000,
        "receiptDateTime": "2018-09-29 11:26:20",
        "returnDateTime": "2018-09-29 11:26:20",
        "success": true
      }
      ~~~
