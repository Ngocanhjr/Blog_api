# Documentation for Soul spaces

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080*

| Class | Method | HTTP request | Description |
|------------ | ------------- | ------------- | -------------|
| *AuthenticationControllerApi* | [**authenicate**](Apis/AuthenticationControllerApi.md#authenicate) | **POST** /auth/log-in |  |
*AuthenticationControllerApi* | [**login**](Apis/AuthenticationControllerApi.md#login) | **POST** /auth/login |  |
| *BlogControllerApi* | [**createBlog**](Apis/BlogControllerApi.md#createBlog) | **POST** /api/v1/blogs |  |
*BlogControllerApi* | [**getAllBlogs**](Apis/BlogControllerApi.md#getAllBlogs) | **GET** /api/v1/soulspaces |  |
*BlogControllerApi* | [**getAllBlogsByAuthor**](Apis/BlogControllerApi.md#getAllBlogsByAuthor) | **GET** /api/v1/users/{userId}/blogs |  |
*BlogControllerApi* | [**getBlogDetails**](Apis/BlogControllerApi.md#getBlogDetails) | **GET** /api/v1/blogs/{blogId} |  |
| *FileUploadControllerApi* | [**uploadFile**](Apis/FileUploadControllerApi.md#uploadFile) | **POST** /api/v1/upload |  |
*FileUploadControllerApi* | [**uploadFiles**](Apis/FileUploadControllerApi.md#uploadFiles) | **POST** /api/v1/uploadFiles |  |
| *UserControllerApi* | [**createUsuer**](Apis/UserControllerApi.md#createUsuer) | **POST** /api/users |  |
*UserControllerApi* | [**deleteUser**](Apis/UserControllerApi.md#deleteUser) | **DELETE** /api/users/{userId} |  |
*UserControllerApi* | [**getUList**](Apis/UserControllerApi.md#getUList) | **GET** /api/users |  |
*UserControllerApi* | [**getUser**](Apis/UserControllerApi.md#getUser) | **GET** /api/users/{userId} |  |
*UserControllerApi* | [**updateUser**](Apis/UserControllerApi.md#updateUser) | **PUT** /api/users/{userId} |  |


<a name="documentation-for-models"></a>
## Documentation for Models

 - [ApiResponseAuthenticationRespone](./Models/ApiResponseAuthenticationRespone.md)
 - [AuthenticationRequest](./Models/AuthenticationRequest.md)
 - [AuthenticationRespone](./Models/AuthenticationRespone.md)
 - [BlogDTO](./Models/BlogDTO.md)
 - [BlogDetailsResponse](./Models/BlogDetailsResponse.md)
 - [CreateBlogResponse](./Models/CreateBlogResponse.md)
 - [User](./Models/User.md)
 - [UserCreationRequest](./Models/UserCreationRequest.md)
 - [UserRespone](./Models/UserRespone.md)
 - [UserUpdateRequest](./Models/UserUpdateRequest.md)
 - [uploadFile_request](./Models/uploadFile_request.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

All endpoints do not require authorization.
