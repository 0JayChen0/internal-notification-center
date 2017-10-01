# 脚手架模块说明

xxx为artifactId，各模块说明如下：

- xxx-api模块：微服务系统内部暴露的RPC接口和传输对象定义，除了给server模块使用之外，也给外部调用方依赖使用
  - com.yonghui.xxx.api：内部暴露的dubbo接口或feign接口
  - com.yonghui.xxx.dto：feign接口使用的数据传输对象
- xxx-server模块：微服务接口的具体实现
  - package说明
    - com.yonghui.xxx.api.impl：api模块定义的接口实现
      - dubbo服务的实现使用@Service注解，并在applicationContext-dubbo.xml中使用<dubbo:service>标签暴露
      - feign服务的实现使用@RestController注解，如果同时想把feign接口也以dubbo方式一起暴露，在applicationContext-dubbo.xml中也使用<dubbo:service>标签配置即可
    - com.yonghui.xxx.web: Spring Mvc的Controller实现，对外提供的http接口
    - com.yonghui.xxx.feign：依赖的feign客户端定义
  - 配置说明：
    - application.properties：应用要使用的配置信息
    - bootstrap.properties：启动的基础配置，包含服务名、服务端口号以及配置中心的连接信息    
    - config.properties：不再使用，不要维护内容
    - applicationContext-dubbo.xml：dubbo配置
    
**各个package下的del.md是为了占位上传到git使用，实际编码时可以删除**
**dubbo端口和tomcat端口需要去wiki登记后设置，防止与其他应用冲突**
