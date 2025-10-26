# Soul spaces
This is the API documentation for Soul spaces project.

## Version: pre-v1

### /api/v1/blogs/details

#### PUT
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/blogs/access

#### PUT
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/blogs-details

#### PUT
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/users/{userId}

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| userId | path |  | Yes | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### PUT
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| userId | path |  | Yes | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### DELETE
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| userId | path |  | Yes | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /auth/login

#### POST
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /auth/log-in

#### POST
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/upload

#### POST
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/uploadFiles

#### POST
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| files | query |  | Yes | [ binary ] |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/blogs

#### POST
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/users

#### GET
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### POST
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /auth/check-session

#### GET
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/soulspaces

#### GET
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/blogs/{userId}/blogs

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| userId | path |  | Yes | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/blogs/{userId}/all

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| userId | path |  | Yes | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/blogs/{blogId}

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| blogId | path |  | Yes | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### DELETE
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| blogId | path |  | Yes | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /api/v1/delete

#### DELETE
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| imgUrl | query |  | Yes | string |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### Models


#### BlogUpdateRequest

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| blogId | string |  | No |
| content | string |  | No |
| newImages | [ binary ] |  | No |
| removeImagesUrl | [ string ] |  | No |
| published | boolean |  | No |

#### BlogUpdateResponse

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| blogId | string |  | No |
| content | string |  | No |
| successUrls | [ string ] |  | No |
| failedDeleteFiles | [ string ] |  | No |
| failedUploadFiles | [ string ] |  | No |
| published | boolean |  | No |
| updateAt | dateTime |  | No |

#### BlogAccessRequest

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| blogId | string |  | No |
| published | boolean |  | No |

#### BlogAccessResponse

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| blogId | string |  | No |
| published | boolean |  | No |
| updateAt | dateTime |  | No |

#### UserUpdateRequest

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| username | string |  | Yes |
| password | string |  | Yes |
| fullname | string |  | No |
| dob | date |  | No |

#### UserRespone

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| id | string |  | No |
| username | string |  | No |
| password | string |  | No |
| fullname | string |  | No |
| dob | date |  | No |

#### AuthenticationRequest

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| username | string |  | No |
| password | string |  | No |

#### ApiResponseBoolean

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| code | integer |  | No |
| message | string |  | No |
| result | boolean |  | No |

#### ApiResponseAuthenticationRespone

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| code | integer |  | No |
| message | string |  | No |
| result | [AuthenticationRespone](#authenticationrespone) |  | No |

#### AuthenticationRespone

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| authentication | boolean |  | No |

#### BlogCreateRequest

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| userId | string |  | No |
| content | string |  | No |
| published | boolean |  | No |
| files | [ binary ] |  | No |

#### BlogCreateResponse

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| blogId | string |  | No |
| successUrls | [ string ] |  | No |
| failedFiles | [ string ] |  | No |

#### UserCreationRequest

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| username | string |  | Yes |
| password | string |  | Yes |
| fullname | string |  | No |
| dob | date |  | No |

#### User

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| id | string |  | No |
| username | string |  | No |
| password | string |  | No |
| fullname | string |  | No |
| dob | date |  | No |

#### ApiResponseObject

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| code | integer |  | No |
| message | string |  | No |
| result |  |  | No |

#### BlogDTO

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| id | string |  | No |
| userId | string |  | No |
| userName | string |  | No |
| userAvatarUrl | string |  | No |
| content | string |  | No |
| imageContentUrls | [ string ] |  | No |
| likeCount | long |  | No |
| commentCount | long |  | No |
| shareCount | long |  | No |
| published | boolean |  | No |
| createdAt | dateTime |  | No |
| updateAt | dateTime |  | No |

#### BlogDetailsResponse

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| id | string |  | No |
| userId | string |  | No |
| userName | string |  | No |
| userAvatarUrl | string |  | No |
| content | string |  | No |
| imageUrls | [ string ] |  | No |
| likeCount | long |  | No |
| commentCount | long |  | No |
| shareCount | long |  | No |
| createdAt | dateTime |  | No |