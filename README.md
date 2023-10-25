# 공지사항 기능 구현 연습
 <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=Spring%20Boot&logoColor=black"/> <img alt="postgresql" src ="https://img.shields.io/badge/postgresql-4169E1.svg?&style=for-the-badge&logo=postgresql&logoColor=white"/> <img alt="swagger" src ="https://img.shields.io/badge/swagger-85EA2D.svg?&style=for-the-badge&logo=swagger&logoColor=white"/> <img alt="apachemaven" src ="https://img.shields.io/badge/apachemaven-C71A36.svg?&style=for-the-badge&logo=apachemaven&logoColor=white"/><br>
-DBMS : DBeaver <br>
-Frontend: mustache
## 기능1. 관리자만 글을 작성할 수 있음
## 기능2. 고정하고 싶은 글은 최상단에 위치함
![image](https://github.com/koratoo/notice-board/assets/96603612/6548ef53-5713-410f-b4d2-07094e584c2f)

## 새로운 기술스택 : PostgreSQL, DBeaver
![image](https://github.com/koratoo/notice/assets/96603612/f205bf9f-3623-4319-86a9-9d7b30fabe8b)

## Mustache 사용시 에러사항 - if문의 부재
![image](https://github.com/koratoo/notice-board/assets/96603612/da3964f7-3c06-4c7f-bcba-e6a112a7f42c)<br>

머스태치는 굉장히 쉽고 직관적으로 사용하기 편했다. 하지만 if문이 지원되지 않아 서버단에서 참/거짓을 판별 후 flag를 전송해 주어야 한다.기능은 구현했지만 불필요한 코드가 추가되는 느낌을 받았다. vue.js의 경우 v-if문법을 통해 쉽게 참/거짓을 판별하고 jsp에서도 if문이 가능해서 당연히 지원되는 기능이라 생각했다.

## Swagger 사용시 에러사항 - Unable to infer baseurl
![image](https://github.com/koratoo/notice-board/assets/96603612/56af3c63-36d7-49bc-9f33-3dd7c8643a06)
블로그에 정리 : https://blog.naver.com/lears98/223246099775

## 구현시 주의점 : 단위테스트 작성
![image](https://github.com/koratoo/notice-board/assets/96603612/2d93e2bb-a9f1-4df2-b66b-f014a75e33c7)
