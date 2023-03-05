```text
provider模块          // 服务提供者, 提供微服务, 操作数据库
├── build/                                                      // proto文件生成类            
├── src/
│    ├── main/
│    │    ├── java/com/west2/dubbo/springboot/demo/provider/
│    │    │    ├── config/                                      // 配置
│    │    │    ├── entity/                                      // 实体类
│    │    │    │    ├── base/                                   // 基本实体封装类
│    │    │    │    └── db/                                     // 数据库实体类
│    │    │    ├── mapper/                                      // 持久层
│    │    │    ├── service/
│    │    │    │    ├── base/                                   // 基本服务封装类
│    │    │    │    ├── db/                                     // 数据库操作服务
│    │    │    │    └── triple/                                 // 对外提供的微服务
│    │    │    └── ProviderApplication.java                     // 主启动类
│    │    ├── proto/                                            // 存放proto文件
│    │    └── resource/                                         // 资源目录
│    └── test/                                                  // 单元测试
└── pom.xml                                                     // 项目依赖管理文件

```

```text
consumer模块          // 网关层, 调用微服务, 处理路由
├── build/                                                      // proto文件生成类            
├── src/
│    ├── main/
│    │    ├── java/com/west2/dubbo/springboot/demo/consumer/
│    │    │    ├── common/                                      // 封装统一返回类
│    │    │    ├── config/                                      // 配置
│    │    │    ├── controller/                                  // 路由
│    │    │    ├── entity/                                      // 实体类
│    │    │    │    └── vo/                                     // 前端交互类
│    │    │    ├── util/                                        // 工具类
│    │    │    └── ConsumerApplication.java                     // 主启动类
│    │    ├── proto/                                            // 存放proto文件
│    │    └── resource/                                         // 资源目录
│    └── test/                                                  // 单元测试
└── pom.xml                                                     // 项目依赖管理文件

```