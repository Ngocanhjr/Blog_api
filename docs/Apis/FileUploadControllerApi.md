# FileUploadControllerApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**uploadFile**](FileUploadControllerApi.md#uploadFile) | **POST** /api/v1/upload |  |
| [**uploadFiles**](FileUploadControllerApi.md#uploadFiles) | **POST** /api/v1/uploadFiles |  |


<a name="uploadFile"></a>
# **uploadFile**
> Map uploadFile(uploadFile\_request)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **uploadFile\_request** | [**uploadFile_request**](../Models/uploadFile_request.md)|  | [optional] |

### Return type

[**Map**](../Models/AnyType.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*

<a name="uploadFiles"></a>
# **uploadFiles**
> Map uploadFiles(files)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **files** | [**List**](../Models/File.md)|  | [default to null] |

### Return type

[**Map**](../Models/AnyType.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*

