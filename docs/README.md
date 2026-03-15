# Documentation for Soul spaces

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080*

| Class | Method | HTTP request | Description |
|------------ | ------------- | ------------- | -------------|
| *AuthenticationControllerApi* | [**authenicate**](Apis/AuthenticationControllerApi.md#authenicate) | **POST** /auth/log-in |  |
*AuthenticationControllerApi* | [**checkSession**](Apis/AuthenticationControllerApi.md#checkSession) | **GET** /auth/check-session |  |
*AuthenticationControllerApi* | [**login**](Apis/AuthenticationControllerApi.md#login) | **POST** /auth/login |  |
| *BlogControllerApi* | [**createBlog**](Apis/BlogControllerApi.md#createBlog) | **POST** /api/v1/blogs |  |
*BlogControllerApi* | [**deleteBlog**](Apis/BlogControllerApi.md#deleteBlog) | **DELETE** /api/v1/blogs/{blogId} |  |
*BlogControllerApi* | [**getAllBlogs**](Apis/BlogControllerApi.md#getAllBlogs) | **GET** /api/v1/soulspaces |  |
*BlogControllerApi* | [**getAllBlogsByUser**](Apis/BlogControllerApi.md#getAllBlogsByUser) | **GET** /api/v1/blogs/{userId}/all |  |
*BlogControllerApi* | [**getAllPublicBlogsByUser**](Apis/BlogControllerApi.md#getAllPublicBlogsByUser) | **GET** /api/v1/blogs/{userId}/blogs |  |
*BlogControllerApi* | [**getBlogDetails**](Apis/BlogControllerApi.md#getBlogDetails) | **GET** /api/v1/blogs/{blogId} |  |
*BlogControllerApi* | [**updateBlogAccess**](Apis/BlogControllerApi.md#updateBlogAccess) | **PUT** /api/v1/blogs/access |  |
*BlogControllerApi* | [**updateBlogDetails**](Apis/BlogControllerApi.md#updateBlogDetails) | **PUT** /api/v1/blogs/details |  |
*BlogControllerApi* | [**updatePost**](Apis/BlogControllerApi.md#updatePost) | **PUT** /api/v1/blogs-details |  |
| *FileUploadControllerApi* | [**deleteFiles**](Apis/FileUploadControllerApi.md#deleteFiles) | **DELETE** /api/v1/delete |  |
*FileUploadControllerApi* | [**uploadFile**](Apis/FileUploadControllerApi.md#uploadFile) | **POST** /api/v1/upload |  |
*FileUploadControllerApi* | [**uploadFiles**](Apis/FileUploadControllerApi.md#uploadFiles) | **POST** /api/v1/uploadFiles |  |
| *UserControllerApi* | [**createUsuer**](Apis/UserControllerApi.md#createUsuer) | **POST** /api/users |  |
*UserControllerApi* | [**deleteUser**](Apis/UserControllerApi.md#deleteUser) | **DELETE** /api/users/{userId} |  |
*UserControllerApi* | [**getUList**](Apis/UserControllerApi.md#getUList) | **GET** /api/users |  |
*UserControllerApi* | [**getUser**](Apis/UserControllerApi.md#getUser) | **GET** /api/users/{userId} |  |
*UserControllerApi* | [**updateUser**](Apis/UserControllerApi.md#updateUser) | **PUT** /api/users/{userId} |  |


<a name="documentation-for-models"></a>
## Documentation for Models

 - [ApiResponseAuthenticationRespone](./Models/ApiResponseAuthenticationRespone.md)
 - [ApiResponseBoolean](./Models/ApiResponseBoolean.md)
 - [ApiResponseObject](./Models/ApiResponseObject.md)
 - [AuthenticationRequest](./Models/AuthenticationRequest.md)
 - [AuthenticationRespone](./Models/AuthenticationRespone.md)
 - [BlogAccessRequest](./Models/BlogAccessRequest.md)
 - [BlogAccessResponse](./Models/BlogAccessResponse.md)
 - [BlogCreateResponse](./Models/BlogCreateResponse.md)
 - [BlogDTO](./Models/BlogDTO.md)
 - [BlogDetailsResponse](./Models/BlogDetailsResponse.md)
 - [BlogUpdateResponse](./Models/BlogUpdateResponse.md)
 - [User](./Models/User.md)
 - [UserCreationRequest](./Models/UserCreationRequest.md)
 - [UserRespone](./Models/UserRespone.md)
 - [UserUpdateRequest](./Models/UserUpdateRequest.md)
 - [uploadFile_request](./Models/uploadFile_request.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

All endpoints do not require authorization.
