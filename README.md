# spring cloud zuul !!

* 사용방법에 대해 알아보자

## execute
```
cd node
npm i 
node server.js &
cd ..
./gradlew bootRun

curl -X GET http://localhost:8080/users/1
```

## 목차

1. [zuul 필터](#zuul-필터)
2. [설치](#설치)
3. [사용법](#사용법)

### zuul 

* API Gateway 이다. 
* 사용자한테 api 요청이 들어오면 다른 서버한테 요청해서 받은 응답 값을 사용자한테 다시 전달해준다.  

### zuul 필터

1. Pre Filter
    * 라우팅 전 실행 필터, logging, authorization 등 처리
    * Custom Filter

2. Routing Filter 
    * 요청에 대한 라우팅 처리, httpClient 사용하여 정해진 url 처리
    * Origin Server
 
3. Post Filter 
    * 라우팅 후에 실행 response 에 http header 추가하거나 response 에 대한 응답속도, status code 등 응답에 대한 statistics and metrics 수집

* Error Filter
    * 에러 발생시 실행 필터
    
### @EnableZuulProxy, @EnableZuulServer

* `@EnableZuulServer`⊂`@EnableZuulProxy`
* `@EnableZuulProxy` = (`@EnableZuulServer`∩`@EnableZuulProxy`)<sup>c</sup>

### 설치

```groovy
implementation 'org.springframework.cloud:spring-cloud-starter-netflix-zuul'
```