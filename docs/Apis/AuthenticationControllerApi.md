# AuthenticationControllerApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**authenicate**](AuthenticationControllerApi.md#authenicate) | **POST** /auth/log-in |  |
| [**checkSession**](AuthenticationControllerApi.md#checkSession) | **GET** /auth/check-session |  |
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

<a name="checkSession"></a>
# **checkSession**
> ApiResponseObject checkSession()



### Parameters
This endpoint does not need any parameter.

### Return type

[**ApiResponseObject**](../Models/ApiResponseObject.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

<a name="login"></a>
# **login**
> ApiResponseBoolean login(AuthenticationRequest)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **AuthenticationRequest** | [**AuthenticationRequest**](../Models/AuthenticationRequest.md)|  | |

### Return type

[**ApiResponseBoolean**](../Models/ApiResponseBoolean.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

