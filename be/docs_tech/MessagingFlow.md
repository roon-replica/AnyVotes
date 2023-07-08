# Spring integration 메시징 플로우

### 개요
- 주로 DSL로만 작성해보자
- 대략적인 메시지 처리 flow
  - user -> controller -> command channel -> command handler -> event channel -> event handler

### 고민
- Command 전송용 Template 사용 vs @MessagingGateway
  - @MessagingGateway 안쓰면 Message 타입이 빌트인 메시지 타입으로 강제되는게 큰 단점인듯
- Command<ClientRequest> 형태.. 어색?  
  Command가 GenericMessage 타입으로 하면 어색?


