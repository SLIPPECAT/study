# 객체 생성과 파괴  
1. 객체를 만들어야 할 때와 만들지 말아야 할 때를 구분하는 법  
2. 올바른 객체 생성 방법과 불필요한 생성을 피하는 방법  
3. 제때 파괴됨을 보장하고 파괴 전에 수행해야 할 정리 작업을 관리하는 요령

# 생성자에 매개변수가 많다면 빌더를 고려하라
정적 팩터리와 생성자에는 똑같은 제약이 하나 있다. 선택적 매개변수가 많을 때 적절히 대응하기 어렵다는 점이다.  
**점층적 생성자 패턴** : 필수 매개변수와 선택 매개변수의 숫자를 점차 늘려가면서 생성자까지 늘려가는 방식  
점층적 생성자 패턴도 쓸 수는 있지만, 매개변수 개수가 많아지면 클라이언트 코드를 작성하거나 읽기 어렵다.  
  
**자바빈즈 패턴** : 매개변수가 없는 생성자로 객체를 만든 후, 세터 메서드들을 호출해 원하는 매개변수의 값을 설정하는 방식
심각한 단점 : 자바빈즈 패턴에서는 객체 하나를 만들려면 메서드를 여러 개 호출해야 하고 객체가 완전히 생성되기 전까지는 일관성이 무너진 상태에 놓이게 된다.  
(디버깅도 만만치 않다.) 일관성이 무너지는 문제로 자바빈즈 패턴에서는 클래스를 불변으로 만들 수 없으며 스레드 안정성을 얻으려면 프로그래머가 추가 작업으 해줘야 한다.  
   
**빌더 패턴**: 
점층적 생성자 패턴의 안정성 + 자바빈즈 패턴의 가독성
클라이언트는 필요한 객체를 직접 만드는 대신, 필수 매개변수만으로 생성자(혹은 정적 팩터리)를 호출해 빌더 객체를 얻는다. 그런 다음 빌더 객체가 제공하는 일종의 세터 메서드들로
원하는 선택 매개변수들을 설정한다. 마지막으로 매개변수가 없는 build 메서드를 호출해 우리에게 필요한 객체를 얻는다.  
빌더는 생성할 클래스 안에 정적 멤버 클래스로 만들어두는 게 보통이다.  
빌더 패턴은 계층적으로 설계된 클래스와 함께 쓰기에 좋다.  

**정리**
생성자나 정적 팩터리가 처리해야 할 매개변수가 많다면 빌더 패턴을 선택하는 게 더 낫다.  
매개변수 중 다수가 필수가 아니거나 같은 타입이면 특히 더 그렇다. 빌더는 점층적 생성자보다 클라인트 코드를 읽고 쓰기가 훨씬 간결하고, 자바빈즈보다 훨신 안전하다.
