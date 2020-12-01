# springcloud-demo
springcloud基本框架

代码解析链接

https://www.yuque.com/keep_zero/spring_cloud/kiis1m

启动顺序
-

1. springcloud-eureka：SpringCloudEurekaApplication 端口：8761

2. springcloud-config：SpringCloudConfigApplication 端口：8080

3. springcloud-gateway：SpringCloudGatewayApplication(可以不用启动) 端口：9999

4. springcloud-moudle：springcloud-client：SpringCloudClientApplication 端口：7900

springcloud-eureka访问地址：http://localhost:8761/

springcloud-client中swagger访问地址：http://localhost:7900/swagger-ui.html
    经由springcloud-gateway访问地址：http://localhost:9999/
    需要在header中添加token，value默认为1