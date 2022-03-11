## :rocket:소개
전시, 뮤지컬, 콘서트 등 공연 내역을 조회하고, 예약 및 예약내역을 조회하는 기능의 웹 프로그램

<br/>
<br/>


## 📝기능
* 카테고리별 공연 내역 조회 기능
* 공연 정보 및 한줄평(리뷰) 조회 기능
* 공연 예매 기능
* 이메일을 이용한 예약 확인 기능
* 예약 취소 기능
     
<br/>
<br/>

## 🔧기술
* Java JDK 8
* Apache Tomcat v.8.5
* Spring MVC를 이용한 웹페이지 제작 및 Rest API 작성
* Maven을 활용한 의존성 라이브러리 관리

<br/>
<br/>

## :page_facing_up:Web API 스펙
### 🏷️상품API
* 상품 목록 구하기

| method | uri |
| ------ | -----|
| GET | /api/products |


<details open>
<summary><u>Example Value 보기</u></summary>

```
   
[
    {
        "productId": 0,
        "displayInfoId": 0,
        "fileName": "string",
        "description": "string",
        "placeName": "string",
        "content": "string"
    }
]
```

</details>

<br/>


* 상품 전시 정보 구하기

| method | uri |
| ------ | -----|
| GET | /api/products/{displayInfoId} |
    

<details open>
<summary>Example Value 보기</summary>
    
```
{
  "averageScore": 0,
  "comments": [
    {
      "comment": "string",
      "commentId": 0,
      "commentImages": [
        {
          "contentType": "string",
          "createDate": "2022-03-11T16:15:51.349Z",
          "deleteFlag": true,
          "fileId": 0,
          "fileName": "string",
          "imageId": 0,
          "modifyDate": "2022-03-11T16:15:51.349Z",
          "reservationInfoId": 0,
          "reservationUserCommentId": 0,
          "saveFileName": "string"
        }
      ],
      "createDate": "2022-03-11T16:15:51.349Z",
      "modifyDate": "2022-03-11T16:15:51.349Z",
      "productId": 0,
      "reservationDate": "2022-03-11T16:15:51.349Z",
      "reservationEmail": "string",
      "reservationInfoId": 0,
      "reservationName": "string",
      "reservationTelephone": "string",
      "score": 0
    }
  ],
  "displayInfo": {
    "categoryId": 0,
    "categoryName": "string",
    "createDate": "2022-03-11T16:15:51.349Z",
    "displayInfoId": 0,
    "email": "string",
    "homepage": "string",
    "modifyDate": "2022-03-11T16:15:51.349Z",
    "openingHours": "string",
    "placeLot": "string",
    "placeName": "string",
    "placeStreet": "string",
    "productContent": "string",
    "productDescription": "string",
    "productEvent": "string",
    "productId": 0,
    "telephone": "string"
  },
  "displayInfoImage": {
    "contentType": "string",
    "createDate": "2022-03-11T16:15:51.349Z",
    "deleteFlag": true,
    "displayInfoId": 0,
    "displayInfoImageId": 0,
    "fileId": 0,
    "fileName": "string",
    "modifyDate": "2022-03-11T16:15:51.349Z",
    "saveFileName": "string"
  },
  "productImages": [
    {
      "contentType": "string",
      "createDate": "2022-03-11T16:15:51.349Z",
      "deleteFlag": true,
      "fileInfoId": 0,
      "fileName": "string",
      "modifyDate": "2022-03-11T16:15:51.349Z",
      "productId": 0,
      "productImageId": 0,
      "saveFileName": "string",
      "type": "ma"
    }
  ],
  "productPrices": [
    {
      "createDate": "2022-03-11T16:15:51.349Z",
      "discountRate": 0,
      "modifyDate": "2022-03-11T16:15:51.349Z",
      "price": 0,
      "priceTypeName": "string",
      "productId": 0,
      "productPriceId": 0
    }
  ]
}
```
</details>

<br/>


### 🏷️예약API
* 예약정보 조회

| method | uri |
| ------ | -----|
| GET | /api/reservations |
    
<details open>
<summary>Example Value 보기</summary>
    
```
{
  "reservations": [
    {
      "cancelYn": true,
      "createDate": "2022-03-11T16:17:38.323Z",
      "displayInfo": {
        "categoryId": 0,
        "categoryName": "string",
        "createDate": "2022-03-11T16:17:38.323Z",
        "displayInfoId": 0,
        "email": "string",
        "homepage": "string",
        "modifyDate": "2022-03-11T16:17:38.323Z",
        "openingHours": "string",
        "placeLot": "string",
        "placeName": "string",
        "placeStreet": "string",
        "productContent": "string",
        "productDescription": "string",
        "productEvent": "string",
        "productId": 0,
        "telephone": "string"
      },
      "displayInfoId": 0,
      "modifyDate": "2022-03-11T16:17:38.323Z",
      "productId": 0,
      "reservationDate": "string",
      "reservationEmail": "string",
      "reservationInfoId": 0,
      "reservationName": "string",
      "reservationTelephone": "string",
      "totalPrice": 0
    }
  ],
  "size": 0
}
```
</details>
   

<br/>


* 예약하기

| method | uri |
| ------ | -----|
| POST | /api/reservations |
   
   
<details open>
<summary>Example Value 보기</summary>
    
```
/*Parameters*/
{
  "displayInfoId": 0,
  "prices": [
    {
      "count": 0,
      "productPriceId": 0,
      "reservationInfoId": 0,
      "reservationInfoPriceId": 0
    }
  ],
  "productId": 0,
  "reservationEmail": "string",
  "reservationName": "string",
  "reservationTelephone": "string",
  "reservationYearMonthDay": "string"
}
```

</details>

<br/>

* 예약취소하기

| method | uri |
| ------ | -----|
| PUT | /api/reservations/{reservationId} |

<br/>

### 🏷️카테고리API
* 카테고리 목록 구하기

| method | uri |
| ------ | -----|
| GET | /api/categories |

<details open>
<summary>Example Value 보기</summary>

```
[
    {
        "id": 0,
        "name": "string"
    }
]
```

</details>

<br/>
    
### 🏷️프로모션API
* 프로모션 목록 구하기

| method | uri |
| ------ | -----|
| GET | /api/promotions |


<details open>
<summary>Example Value 보기</summary>

```
[
    {
        "id": 0,
        "fileName": "string"
    }
]
```

</details>


<br/>
<br/>

## ✅시연
      
* 공연 리스트 조회        
![1리스트조회](https://user-images.githubusercontent.com/33050838/157902001-e23819a9-a03c-485d-9bb2-9707eee1e6be.gif)

<br/>
<br/>

* 공연 상세 정보 및 한줄평 조회       
![2공연상세정보및한줄평](https://user-images.githubusercontent.com/33050838/157902369-902030c6-967d-47e1-8a45-bb680a2f197b.gif)
    
<br/>
<br/>

* 예매하기
       
![3예매하기](https://user-images.githubusercontent.com/33050838/157902374-ad773d23-ae05-4314-a9e7-269417e17965.gif)

<br/>
<br/>
        
* 예약확인 및 예약 취소
   
      
![4예매확인및취소](https://user-images.githubusercontent.com/33050838/157902356-05dc73de-80a4-4ed7-875d-d92c61b2b9b6.gif)


<br/>
<br/>


## 🚩배운점
스프링mvc를 이용한 웹 어플리케이션 제작 방법과 웹 어플리케이션 개발시 레이어드 아키텍쳐를 사용하는 이유에 대해 알게되었다.

<br/>
<br/>


## 🚩앞으로 학습할 내용
품 정보API에서 예매자 리뷰 목록을 반환해 줄 때 리뷰이미지 목록(commentImages)을 service단에서 반복문을 통해 set해주어서 구현하였다. 보통 현업에서는 DB에 조회한 결과를 mybatis(마이바티스), JPA등을 이용하여 객체 멤버 필드와 맵핑한다고하여 향후 mybatis(마이바티스) 또는 JPA를 학습할 예정이다.

<br/>
<br/>

## 참고

부스트코스(https://www.boostcourse.org/) 교육과정

<br/>
<br/>
