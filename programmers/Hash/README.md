## 해시 : Key-value쌍으로 빠르게 데이터를 찾는다

### HashSet
#### 특징
1. 중복을 허용하지 않는다
2. null 요소도 허용한다
3. 순서대로 입력되지 않고, 일정하게 유지되지 않는다

+ add(value) : 값 추가
+ remove(value) : 값 삭제
+ contains(value) : 값 검색
+ size() : 크기
+ iterator() : Iterator 사용

### HashMap
#### 특징
1. 데이터들이 (키,값)의 1:1 구조의 Entry로 구성된다
2. 키는 중복이 안되고 값은 중복이 될 수 있다
3. null값도 저장이 가능하다

+ put(key,value) :  값 추가
+ remove(key) : 값 삭제
+ containsKey(key) : 키 존재 여부
+ containsValue(value) : 값 존재 여부
+ get(key) : 값 읽기
+ getOrDefault(key,default) : null일 경우 기본값으로 읽기
+ entrySet() : key,value를 가지는 Set 객체 반환, 탐색법으로 사용
+ keySet() : key만 가지는 Set 객체 반환, 탐색법으로 사용

정렬법 (key 기준)

```java
Object[] mapKey = map.keySet().toArray();
Arrays.sort(mapKey);
```

정렬법 (value 기준)

```java
List<Integer> keySetList = new ArrayList<>(map.keySet());

//오름차순
Collections.sort(keySetList, (o1,o2) -> (map.get(o1).compareTo(map.get(o2))));

//내림차순
Collections.sort(keySetList, (o1,o2) -> (map.get(o2).compareTo(map.get(o1))));
```

Iterator 사용 (entrySet())

```java
Iterator<Entry<Integer,String>> entries = map.entrySet().iterator();
while(entries.hasNext()) {
  Map.Entry<Integer, String> entry = entries.next();
}
```

Iterator 사용 (keySet())

```java
Iterator<Integer> keys = map.keySet().iterator();
while(keys.hasNext()) {
  int key = keys.next();
}
```
