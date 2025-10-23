# BlogControllerApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createBlog**](BlogControllerApi.md#createBlog) | **POST** /api/v1/blogs |  |
| [**getAllBlogs**](BlogControllerApi.md#getAllBlogs) | **GET** /api/v1/soulspaces |  |
| [**getAllBlogsByAuthor**](BlogControllerApi.md#getAllBlogsByAuthor) | **GET** /api/v1/users/{userId}/blogs |  |
| [**getBlogDetails**](BlogControllerApi.md#getBlogDetails) | **GET** /api/v1/blogs/{blogId} |  |


<a name="createBlog"></a>
# **createBlog**
> CreateBlogResponse createBlog(userId, content, published, files)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userId** | **String**|  | [optional] [default to null] |
| **content** | **String**|  | [optional] [default to null] |
| **published** | **Boolean**|  | [optional] [default to null] |
| **files** | **List**|  | [optional] [default to null] |

### Return type

[**CreateBlogResponse**](../Models/CreateBlogResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: */*

<a name="getAllBlogs"></a>
# **getAllBlogs**
> List getAllBlogs()



### Parameters
This endpoint does not need any parameter.

### Return type

[**List**](../Models/BlogDTO.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="getAllBlogsByAuthor"></a>
# **getAllBlogsByAuthor**
> List getAllBlogsByAuthor(userId)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userId** | **String**|  | [default to null] |

### Return type

[**List**](../Models/BlogDTO.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="getBlogDetails"></a>
# **getBlogDetails**
> BlogDetailsResponse getBlogDetails(blogId)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **blogId** | **String**|  | [default to null] |

### Return type

[**BlogDetailsResponse**](../Models/BlogDetailsResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

