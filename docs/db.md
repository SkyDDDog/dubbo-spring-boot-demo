# 数据库设计

## user表
| 字段名 | 类型    | 长度 | 是否非空 | 主键 | 注释 |
| ------ | ------- | ---- | -------- | ---- | ---- |
| id     | varchar | 255  | Y        | Y    | 主键 |
| username     |   varchar    |   255   |     N     |   N   |   用户名   |
|   password     |    varchar     |   255   |     N     |  N    |  密文密码    |
|    create_date    |    datetime     |      |     N     |  N    |  创建时间    |
|    update_date    |    datetime     |      |     N     |  N    |  更新时间    |
|   del_flag     |   char      |   1   |     N     |   N   |   逻辑删除   |
|   remarks     |   varchar      |   255   |     N     |   N   |   备注   |


