# 2024-GlowHackerton
## 참여
[장동재](https://github.com/JangDJ1227)|[장하영](https://github.com/JHY3066)|[정세엽](https://github.com/clcok)|[한재준](https://github.com/junjaebrother)
|:---:|:---:|:---:|:---:|
<img src="https://github.com/JangDJ1227.png">|<img src="https://github.com/JHY3066.png">|<img src="https://github.com/clcok.png">|<img src="https://github.com/junjaebrother.png">

## 동기
GlowHackerTon의 주제인 < 지역 사회의 지속 가능한 발전을 위한 지역 사회 문제 해결을 위한 아이디어 > 에서 전통 시장의 정보를 알려주고 직접 시장의 점포를 등록하는 어플을 만들어 지역 사회의 경제 발전에 이바지하고자 했습니다.

## 기능
시장 검색을 통해 방문한 시장의 지도를 알려주고 지도를 통해 점포 위치와 상세 정보등을 알려주고 등록되지 않은 점포에 대해 사용자가 등록할 수 있습니다.

## 세부 기능
- 시장 검색
- 선택된 시장의 정보
- 음식, 옷 점포 목록 표시
- 시장 지도에서 선택된 점포 위치 표시
- 선택된 점포의 세부 정보 및 별점, 댓글 표시
- 시장에서 미등록된 점포 추가

### Design
- Figma

### FE
- Kotlin

### BE
- Spring
  DB- MySQL


## 사용자 플로우
1. 시장 검색 시작하기 버튼을 누르면 DB에 등록된 시장들이 노출이 됩니다.

2. 검색 창에 시장의 이름을 검색하면 등록된 시장을 검색합니다.

3. 시장이 검색되었다면 요약된 시장 정보가 노출이 되고, 시장의 점포를 보거나 점포를 등록할 수 있는 버튼이 보이게 됩니다.

4. 시장 점포를 선택하게 되면, 점포의 요약정보를 볼 수 있고 세부적인 정보를 볼 수 있는 버튼을 누르면 모든 메뉴, 댓글이 보이고, 별점과 댓글을 남길 수 있습니다.

5. 시장에 점포를 등록하고 싶다면, 옷과 음식 타입을 선택한뒤 점포 정보와 메뉴들을 입력하면 등록할 수 있습니다.


## HTTP API
### 시장 관련
-시장 목록 제공
-GET /market

-시장 검색
-GET /market/search

### 점포 관련
-시장의 모든 점포 가져오기
-GET /shop/all

-시장의 점포를 선택된 타입(음식, 옷)으로 가져오기
-GET /shop/select

-점포의 요약된 정보를 가져오기
-GET /shop/summarized

-점포의 상세 정보를 가져오기
-GET /shop/detail

-점포에 관한 별점 및 댓글 남기기
-POST /shop/comment

-시장에 새로운 점포를 등록하기
-POST /shop/new


### 구현 API 명세
1. GET /market
   현재 DB에 등록된 시장 목록을 가져온다.

2. GET /market/search
   현재 DB에 등록된 시장을 검색하여 시장의 정보를 가져온다.
   요청 시 json의 형식은 { "name" : String}이고
   search에 성공한다면 json의 형식은 {   "name" : String, "telephone" : String, "address": String, "workingTime" : String, "information" : String}로 시장의 정보를 가져오고, 그렇지 않다면 오류가 발생한다.

4. GET /shop/all
   시장의 이름과 타입을 바탕으로 시장의 모든 점포들을 가져온다.
   요청 시 json의 형식은 { "name" : String, "type" : Integer}이고
   응답 시 json의 형식은 {"name" : String}이다.

6. GET /shop/select
   시장의 이름과 타입을 바탕으로 시장의 점포들을 검색하여 가져온다.
   요청 시 json의 형식은 { "name" : String, "type" : Integer}이고
   응답 시 json의 형식은 {"name" : String}이다.

8. GET /shop/summarized
   점포의 이름을 바탕으로 요약된 점포의 정보를 불러온다.
   요청 시 json의 형식은 { "name" : String}이고
   응답 시 json의 형식은 { "name":String, "address":String, "telephone": String, "workingTime" : String, "briefExplanation": String, "star":Long} 이다.

10. GET /shop/detail
   점포의 이름을 바탕으로 상세 점포의 정보를 불러온다.
   요청 시 json의 형식은 { "name" : String}이고
   응답 시 json의 형식은 { "menus" : { "name":String, "price":  Integer, "comments" : { "comment" : String, "starPoint" : long} 이다.

12. POST /shop/comment
   점포에 대해 별점과 댓글을 남긴다.
   요청 시 json의 형식은 { "name" : String, "comment" : String, "starPoint" : Integer}이다.

14. POST /shop/new
   시장에 새로운 점포를 등록한다.
   요청 시 json의 형식은 { "type" : Integer, "name" : String, "address" : String, "telephone" : String, "workingTime" : String, "Breif" : String, "x" : Long, "y": Long} 이다.

15. POST /shop/new/menu
   등록된 점포에 메뉴를 등록한다.
   요청 시 json의 형식은 { "marketName" : String, "name" : String, "price" : Integer} 이다.
