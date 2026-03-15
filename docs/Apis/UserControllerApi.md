# UserControllerApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createUsuer**](UserControllerApi.md#createUsuer) | **POST** /api/users |  |
| [**deleteUser**](UserControllerApi.md#deleteUser) | **DELETE** /api/users/{userId} |  |
| [**getUList**](UserControllerApi.md#getUList) | **GET** /api/users |  |
| [**getUser**](UserControllerApi.md#getUser) | **GET** /api/users/{userId} |  |
| [**updateUser**](UserControllerApi.md#updateUser) | **PUT** /api/users/{userId} |  |


<a name="createUsuer"></a>
# **createUsuer**
> User createUsuer(UserCreationRequest)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **UserCreationRequest** | [**UserCreationRequest**](../Models/UserCreationRequest.md)|  | |

### Return type

[**User**](../Models/User.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

<a name="deleteUser"></a>
# **deleteUser**
> String deleteUser(userId)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userId** | **String**|  | [default to null] |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="getUList"></a>
# **getUList**
> List getUList()



### Parameters
This endpoint does not need any parameter.

### Return type

[**List**](../Models/User.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="getUser"></a>
# **getUser**
> UserRespone getUser(userId)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userId** | **String**|  | [default to null] |

### Return type

[**UserRespone**](../Models/UserRespone.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="updateUser"></a>
# **updateUser**
> UserRespone updateUser(userId, UserUpdateRequest)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userId** | **String**|  | [default to null] |
| **UserUpdateRequest** | [**UserUpdateRequest**](../Models/UserUpdateRequest.md)|  | |

### Return type

[**UserRespone**](../Models/UserRespone.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

