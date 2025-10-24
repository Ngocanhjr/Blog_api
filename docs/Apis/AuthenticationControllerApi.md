# AuthenticationControllerApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**authenicate**](AuthenticationControllerApi.md#authenicate) | **POST** /auth/log-in |  |
| [**login**](AuthenticationControllerApi.md#login) | **POST** /auth/login |  |


<a name="authenicate"></a>
# **authenicate**
> ApiResponseAuthenticationRespone authenicate(AuthenticationRequest)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **AuthenticationRequest** | [**AuthenticationRequest**](../Models/AuthenticationRequest.md)|  | |

### Return type

[**ApiResponseAuthenticationRespone**](../Models/ApiResponseAuthenticationRespone.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

<a name="login"></a>
# **login**
> Boolean login(AuthenticationRequest)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **AuthenticationRequest** | [**AuthenticationRequest**](../Models/AuthenticationRequest.md)|  | |

### Return type

**Boolean**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

