#API 명세서.md

# Step 1. (API 명세서)

| API (Schedule) | Method | URL                | Request                              |                                     Response                                      |    상태코드    | 
|----------------|--------|--------------------|--------------------------------------|:---------------------------------------------------------------------------------:|:----------:|
| 일정 등록          | POST   | /api/schedule      | body <br/>(UserName, Title. Contents) |  등록정보  <br/>(UserId, UserName, Title, Contents, CreationDate, ModificationDate)   | 200: 정상 등록 |
| 일정 조회          | GET    | /api/schedule/{id} | PathVariable <br/>(UserId)           | 단건 응답 정보 <br/>(UserId, UserName, Title, Contents, CreationDate, ModificationDate) | 200: 정상 조회 |
| 일정 수정          | PUT    | /api/schedule/{id} | PathVariable <br/>(UserId)           |  수정 정보 <br/>(UserId, UserName, Title, Contents, CreationDate, ModificationDate)   | 200: 정상 수정 |

| API (Comment) | Method | URL                               | Request                                                         |                                                   Response                                                    |    상태코드    | 
|---------------|--------|-----------------------------------|-----------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------------:|:----------:|
| 댓글 등록         | POST   | /api/schedules/{id}/comments      | PathVariable(UserId), body<br/>(CommentUserId, CommentContents) |   등록정보 <br/>(commentUserId, commentUserName, commentContents, commentCreationDate, commentModificationDate)   | 200: 정상 등록 |
| 댓글 조회         | GET    | /api/schedules/{id}/comments/{id} | PathVariable<br/>(CommentUserId)                                | 단건 응답 정보 <br/>(CommentUserId, CommentUserName, CommentContents, CommentCreationDate, CommentModificationDate) | 200: 정상 조회 |
| 댓글 목록 조회      | GET    | /api/schedules/{id}/comment       | PathVariable                                                    |  다건 응답 정보<br/>(CommentUserId, CommentUserName, CommentContents,CommentCreationDate, CommentModificationDate)  | 200: 정상 조회 |
| 댓글 수정         | PUT    | /api/schedules/{id}/comments/{id} | PathVariable<br/>(CommentUserId, CommentContents)               |             수정 정보<br/>(CommentUserId, CommentUserName, CommentContents, CommentModificationDate)              | 200: 정상 수정 |
| 댓글 삭제         | DELETE | /api/schedules/{id}/comments/{id} | PathVariable<br/>(CommentUserId)                                |                                                     void                                                      | 200: 정상 삭제 |



# Step 2. (ERD 링크)
https://www.erdcloud.com/d/YqoaYTx2tjxxwhCpY