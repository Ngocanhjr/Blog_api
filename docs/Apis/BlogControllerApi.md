# BlogControllerApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createBlog**](BlogControllerApi.md#createBlog) | **POST** /api/v1/blogs |  |
| [**deleteBlog**](BlogControllerApi.md#deleteBlog) | **DELETE** /api/v1/blogs/{blogId} |  |
| [**getAllBlogs**](BlogControllerApi.md#getAllBlogs) | **GET** /api/v1/soulspaces |  |
| [**getAllBlogsByUser**](BlogControllerApi.md#getAllBlogsByUser) | **GET** /api/v1/blogs/{userId}/all |  |
| [**getAllPublicBlogsByUser**](BlogControllerApi.md#getAllPublicBlogsByUser) | **GET** /api/v1/blogs/{userId}/blogs |  |
| [**getBlogDetails**](BlogControllerApi.md#getBlogDetails) | **GET** /api/v1/blogs/{blogId} |  |
| [**updateBlogAccess**](BlogControllerApi.md#updateBlogAccess) | **PUT** /api/v1/blogs/access |  |
| [**updateBlogDetails**](BlogControllerApi.md#updateBlogDetails) | **PUT** /api/v1/blogs/details |  |
| [**updatePost**](BlogControllerApi.md#updatePost) | **PUT** /api/v1/blogs-details |  |


<a name="createBlog"></a>
# **createBlog**
> BlogCreateResponse createBlog(userId, content, published, files)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userId** | **String**|  | [optional] [default to null] |
| **content** | **String**|  | [optional] [default to null] |
| **published** | **Boolean**|  | [optional] [default to null] |
| **files** | **List**|  | [optional] [default to null] |

### Return type

[**BlogCreateResponse**](../Models/BlogCreateResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: */*

<a name="deleteBlog"></a>
# **deleteBlog**
> String deleteBlog(blogId)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **blogId** | **String**|  | [default to null] |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
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

<a name="getAllBlogsByUser"></a>
# **getAllBlogsByUser**
> List getAllBlogsByUser(userId)



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

<a name="getAllPublicBlogsByUser"></a>
# **getAllPublicBlogsByUser**
> List getAllPublicBlogsByUser(userId)



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

<a name="updateBlogAccess"></a>
# **updateBlogAccess**
> BlogAccessResponse updateBlogAccess(BlogAccessRequest)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **BlogAccessRequest** | [**BlogAccessRequest**](../Models/BlogAccessRequest.md)|  | |

### Return type

[**BlogAccessResponse**](../Models/BlogAccessResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

<a name="updateBlogDetails"></a>
# **updateBlogDetails**
> BlogUpdateResponse updateBlogDetails(blogId, content, newImages, removeImagesUrl, published)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **blogId** | **String**|  | [optional] [default to null] |
| **content** | **String**|  | [optional] [default to null] |
| **newImages** | **List**|  | [optional] [default to null] |
| **removeImagesUrl** | [**List**](../Models/String.md)|  | [optional] [default to null] |
| **published** | **Boolean**|  | [optional] [default to null] |

### Return type

[**BlogUpdateResponse**](../Models/BlogUpdateResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: */*

<a name="updatePost"></a>
# **updatePost**
> Object updatePost(blogId, content, newImages, removeImagesUrl, published)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **blogId** | **String**|  | [optional] [default to null] |
| **content** | **String**|  | [optional] [default to null] |
| **newImages** | **List**|  | [optional] [default to null] |
| **removeImagesUrl** | [**List**](../Models/String.md)|  | [optional] [default to null] |
| **published** | **Boolean**|  | [optional] [default to null] |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: */*

