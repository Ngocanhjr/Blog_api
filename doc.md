---
title: Soul spaces vpre-v1
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
highlight_theme: darkula
headingLevel: 2

---

<!-- Generator: Widdershins v4.0.1 -->

<h1 id="soul-spaces">Soul spaces vpre-v1</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

This is the API documentation for Soul spaces project.

Base URLs:

* <a href="http://localhost:8080">http://localhost:8080</a>

<h1 id="soul-spaces-blog-controller">blog-controller</h1>

## updateBlogDetails

<a id="opIdupdateBlogDetails"></a>

> Code samples

```shell
# You can also use wget
curl -X PUT http://localhost:8080/api/v1/blogs/details \
  -H 'Content-Type: multipart/form-data' \
  -H 'Accept: */*'

```

```http
PUT http://localhost:8080/api/v1/blogs/details HTTP/1.1
Host: localhost:8080
Content-Type: multipart/form-data
Accept: */*

```

```javascript
const inputBody = '{
  "blogId": "string",
  "content": "string",
  "newImages": [
    "string"
  ],
  "removeImagesUrl": [
    "string"
  ],
  "published": true
}';
const headers = {
  'Content-Type':'multipart/form-data',
  'Accept':'*/*'
};

fetch('http://localhost:8080/api/v1/blogs/details',
{
  method: 'PUT',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'multipart/form-data',
  'Accept' => '*/*'
}

result = RestClient.put 'http://localhost:8080/api/v1/blogs/details',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'multipart/form-data',
  'Accept': '*/*'
}

r = requests.put('http://localhost:8080/api/v1/blogs/details', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'multipart/form-data',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('PUT','http://localhost:8080/api/v1/blogs/details', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/blogs/details");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"multipart/form-data"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("PUT", "http://localhost:8080/api/v1/blogs/details", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`PUT /api/v1/blogs/details`

> Body parameter

```yaml
blogId: string
content: string
newImages:
  - string
removeImagesUrl:
  - string
published: true

```

<h3 id="updateblogdetails-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[BlogUpdateRequest](#schemablogupdaterequest)|false|none|

> Example responses

> 200 Response

<h3 id="updateblogdetails-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[BlogUpdateResponse](#schemablogupdateresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## updateBlogAccess

<a id="opIdupdateBlogAccess"></a>

> Code samples

```shell
# You can also use wget
curl -X PUT http://localhost:8080/api/v1/blogs/access \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*'

```

```http
PUT http://localhost:8080/api/v1/blogs/access HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: */*

```

```javascript
const inputBody = '{
  "blogId": "string",
  "published": true
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'*/*'
};

fetch('http://localhost:8080/api/v1/blogs/access',
{
  method: 'PUT',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => '*/*'
}

result = RestClient.put 'http://localhost:8080/api/v1/blogs/access',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': '*/*'
}

r = requests.put('http://localhost:8080/api/v1/blogs/access', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('PUT','http://localhost:8080/api/v1/blogs/access', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/blogs/access");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("PUT", "http://localhost:8080/api/v1/blogs/access", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`PUT /api/v1/blogs/access`

> Body parameter

```json
{
  "blogId": "string",
  "published": true
}
```

<h3 id="updateblogaccess-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[BlogAccessRequest](#schemablogaccessrequest)|true|none|

> Example responses

> 200 Response

<h3 id="updateblogaccess-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[BlogAccessResponse](#schemablogaccessresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## updatePost

<a id="opIdupdatePost"></a>

> Code samples

```shell
# You can also use wget
curl -X PUT http://localhost:8080/api/v1/blogs-details \
  -H 'Content-Type: multipart/form-data' \
  -H 'Accept: */*'

```

```http
PUT http://localhost:8080/api/v1/blogs-details HTTP/1.1
Host: localhost:8080
Content-Type: multipart/form-data
Accept: */*

```

```javascript
const inputBody = '{
  "blogId": "string",
  "content": "string",
  "newImages": [
    "string"
  ],
  "removeImagesUrl": [
    "string"
  ],
  "published": true
}';
const headers = {
  'Content-Type':'multipart/form-data',
  'Accept':'*/*'
};

fetch('http://localhost:8080/api/v1/blogs-details',
{
  method: 'PUT',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'multipart/form-data',
  'Accept' => '*/*'
}

result = RestClient.put 'http://localhost:8080/api/v1/blogs-details',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'multipart/form-data',
  'Accept': '*/*'
}

r = requests.put('http://localhost:8080/api/v1/blogs-details', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'multipart/form-data',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('PUT','http://localhost:8080/api/v1/blogs-details', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/blogs-details");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"multipart/form-data"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("PUT", "http://localhost:8080/api/v1/blogs-details", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`PUT /api/v1/blogs-details`

> Body parameter

```yaml
blogId: string
content: string
newImages:
  - string
removeImagesUrl:
  - string
published: true

```

<h3 id="updatepost-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[BlogUpdateRequest](#schemablogupdaterequest)|false|none|

> Example responses

> 200 Response

<h3 id="updatepost-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="updatepost-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

## createBlog

<a id="opIdcreateBlog"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8080/api/v1/blogs \
  -H 'Content-Type: multipart/form-data' \
  -H 'Accept: */*'

```

```http
POST http://localhost:8080/api/v1/blogs HTTP/1.1
Host: localhost:8080
Content-Type: multipart/form-data
Accept: */*

```

```javascript
const inputBody = '{
  "userId": "string",
  "content": "string",
  "published": true,
  "files": [
    "string"
  ]
}';
const headers = {
  'Content-Type':'multipart/form-data',
  'Accept':'*/*'
};

fetch('http://localhost:8080/api/v1/blogs',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'multipart/form-data',
  'Accept' => '*/*'
}

result = RestClient.post 'http://localhost:8080/api/v1/blogs',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'multipart/form-data',
  'Accept': '*/*'
}

r = requests.post('http://localhost:8080/api/v1/blogs', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'multipart/form-data',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8080/api/v1/blogs', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/blogs");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"multipart/form-data"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8080/api/v1/blogs", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/v1/blogs`

> Body parameter

```yaml
userId: string
content: string
published: true
files:
  - string

```

<h3 id="createblog-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[BlogCreateRequest](#schemablogcreaterequest)|false|none|

> Example responses

> 200 Response

<h3 id="createblog-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[BlogCreateResponse](#schemablogcreateresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## getAllBlogs

<a id="opIdgetAllBlogs"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/api/v1/soulspaces \
  -H 'Accept: */*'

```

```http
GET http://localhost:8080/api/v1/soulspaces HTTP/1.1
Host: localhost:8080
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8080/api/v1/soulspaces',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get 'http://localhost:8080/api/v1/soulspaces',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('http://localhost:8080/api/v1/soulspaces', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8080/api/v1/soulspaces', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/soulspaces");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8080/api/v1/soulspaces", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/v1/soulspaces`

> Example responses

> 200 Response

<h3 id="getallblogs-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getallblogs-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[[BlogDTO](#schemablogdto)]|false|none|none|
|» id|string|false|none|none|
|» userId|string|false|none|none|
|» userName|string|false|none|none|
|» userAvatarUrl|string|false|none|none|
|» content|string|false|none|none|
|» imageContentUrls|[string]|false|none|none|
|» likeCount|integer(int64)|false|none|none|
|» commentCount|integer(int64)|false|none|none|
|» shareCount|integer(int64)|false|none|none|
|» published|boolean|false|none|none|
|» createdAt|string(date-time)|false|none|none|
|» updateAt|string(date-time)|false|none|none|

<aside class="success">
This operation does not require authentication
</aside>

## getAllPublicBlogsByUser

<a id="opIdgetAllPublicBlogsByUser"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/api/v1/blogs/{userId}/blogs \
  -H 'Accept: */*'

```

```http
GET http://localhost:8080/api/v1/blogs/{userId}/blogs HTTP/1.1
Host: localhost:8080
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8080/api/v1/blogs/{userId}/blogs',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get 'http://localhost:8080/api/v1/blogs/{userId}/blogs',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('http://localhost:8080/api/v1/blogs/{userId}/blogs', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8080/api/v1/blogs/{userId}/blogs', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/blogs/{userId}/blogs");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8080/api/v1/blogs/{userId}/blogs", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/v1/blogs/{userId}/blogs`

<h3 id="getallpublicblogsbyuser-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|userId|path|string|true|none|

> Example responses

> 200 Response

<h3 id="getallpublicblogsbyuser-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getallpublicblogsbyuser-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[[BlogDTO](#schemablogdto)]|false|none|none|
|» id|string|false|none|none|
|» userId|string|false|none|none|
|» userName|string|false|none|none|
|» userAvatarUrl|string|false|none|none|
|» content|string|false|none|none|
|» imageContentUrls|[string]|false|none|none|
|» likeCount|integer(int64)|false|none|none|
|» commentCount|integer(int64)|false|none|none|
|» shareCount|integer(int64)|false|none|none|
|» published|boolean|false|none|none|
|» createdAt|string(date-time)|false|none|none|
|» updateAt|string(date-time)|false|none|none|

<aside class="success">
This operation does not require authentication
</aside>

## getAllBlogsByUser

<a id="opIdgetAllBlogsByUser"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/api/v1/blogs/{userId}/all \
  -H 'Accept: */*'

```

```http
GET http://localhost:8080/api/v1/blogs/{userId}/all HTTP/1.1
Host: localhost:8080
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8080/api/v1/blogs/{userId}/all',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get 'http://localhost:8080/api/v1/blogs/{userId}/all',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('http://localhost:8080/api/v1/blogs/{userId}/all', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8080/api/v1/blogs/{userId}/all', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/blogs/{userId}/all");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8080/api/v1/blogs/{userId}/all", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/v1/blogs/{userId}/all`

<h3 id="getallblogsbyuser-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|userId|path|string|true|none|

> Example responses

> 200 Response

<h3 id="getallblogsbyuser-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getallblogsbyuser-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[[BlogDTO](#schemablogdto)]|false|none|none|
|» id|string|false|none|none|
|» userId|string|false|none|none|
|» userName|string|false|none|none|
|» userAvatarUrl|string|false|none|none|
|» content|string|false|none|none|
|» imageContentUrls|[string]|false|none|none|
|» likeCount|integer(int64)|false|none|none|
|» commentCount|integer(int64)|false|none|none|
|» shareCount|integer(int64)|false|none|none|
|» published|boolean|false|none|none|
|» createdAt|string(date-time)|false|none|none|
|» updateAt|string(date-time)|false|none|none|

<aside class="success">
This operation does not require authentication
</aside>

## getBlogDetails

<a id="opIdgetBlogDetails"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/api/v1/blogs/{blogId} \
  -H 'Accept: */*'

```

```http
GET http://localhost:8080/api/v1/blogs/{blogId} HTTP/1.1
Host: localhost:8080
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8080/api/v1/blogs/{blogId}',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get 'http://localhost:8080/api/v1/blogs/{blogId}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('http://localhost:8080/api/v1/blogs/{blogId}', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8080/api/v1/blogs/{blogId}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/blogs/{blogId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8080/api/v1/blogs/{blogId}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/v1/blogs/{blogId}`

<h3 id="getblogdetails-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|blogId|path|string|true|none|

> Example responses

> 200 Response

<h3 id="getblogdetails-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[BlogDetailsResponse](#schemablogdetailsresponse)|

<aside class="success">
This operation does not require authentication
</aside>

## deleteBlog

<a id="opIddeleteBlog"></a>

> Code samples

```shell
# You can also use wget
curl -X DELETE http://localhost:8080/api/v1/blogs/{blogId} \
  -H 'Accept: */*'

```

```http
DELETE http://localhost:8080/api/v1/blogs/{blogId} HTTP/1.1
Host: localhost:8080
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8080/api/v1/blogs/{blogId}',
{
  method: 'DELETE',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.delete 'http://localhost:8080/api/v1/blogs/{blogId}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.delete('http://localhost:8080/api/v1/blogs/{blogId}', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('DELETE','http://localhost:8080/api/v1/blogs/{blogId}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/blogs/{blogId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("DELETE", "http://localhost:8080/api/v1/blogs/{blogId}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`DELETE /api/v1/blogs/{blogId}`

<h3 id="deleteblog-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|blogId|path|string|true|none|

> Example responses

> 200 Response

<h3 id="deleteblog-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|string|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="soul-spaces-user-controller">user-controller</h1>

## getUser

<a id="opIdgetUser"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/api/users/{userId} \
  -H 'Accept: */*'

```

```http
GET http://localhost:8080/api/users/{userId} HTTP/1.1
Host: localhost:8080
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8080/api/users/{userId}',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get 'http://localhost:8080/api/users/{userId}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('http://localhost:8080/api/users/{userId}', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8080/api/users/{userId}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/users/{userId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8080/api/users/{userId}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/users/{userId}`

<h3 id="getuser-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|userId|path|string|true|none|

> Example responses

> 200 Response

<h3 id="getuser-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[UserRespone](#schemauserrespone)|

<aside class="success">
This operation does not require authentication
</aside>

## updateUser

<a id="opIdupdateUser"></a>

> Code samples

```shell
# You can also use wget
curl -X PUT http://localhost:8080/api/users/{userId} \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*'

```

```http
PUT http://localhost:8080/api/users/{userId} HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: */*

```

```javascript
const inputBody = '{
  "username": "string",
  "password": "stringst",
  "fullname": "string",
  "dob": "2019-08-24"
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'*/*'
};

fetch('http://localhost:8080/api/users/{userId}',
{
  method: 'PUT',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => '*/*'
}

result = RestClient.put 'http://localhost:8080/api/users/{userId}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': '*/*'
}

r = requests.put('http://localhost:8080/api/users/{userId}', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('PUT','http://localhost:8080/api/users/{userId}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/users/{userId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("PUT", "http://localhost:8080/api/users/{userId}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`PUT /api/users/{userId}`

> Body parameter

```json
{
  "username": "string",
  "password": "stringst",
  "fullname": "string",
  "dob": "2019-08-24"
}
```

<h3 id="updateuser-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|userId|path|string|true|none|
|body|body|[UserUpdateRequest](#schemauserupdaterequest)|true|none|

> Example responses

> 200 Response

<h3 id="updateuser-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[UserRespone](#schemauserrespone)|

<aside class="success">
This operation does not require authentication
</aside>

## deleteUser

<a id="opIddeleteUser"></a>

> Code samples

```shell
# You can also use wget
curl -X DELETE http://localhost:8080/api/users/{userId} \
  -H 'Accept: */*'

```

```http
DELETE http://localhost:8080/api/users/{userId} HTTP/1.1
Host: localhost:8080
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8080/api/users/{userId}',
{
  method: 'DELETE',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.delete 'http://localhost:8080/api/users/{userId}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.delete('http://localhost:8080/api/users/{userId}', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('DELETE','http://localhost:8080/api/users/{userId}', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/users/{userId}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("DELETE", "http://localhost:8080/api/users/{userId}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`DELETE /api/users/{userId}`

<h3 id="deleteuser-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|userId|path|string|true|none|

> Example responses

> 200 Response

<h3 id="deleteuser-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|string|

<aside class="success">
This operation does not require authentication
</aside>

## getUList

<a id="opIdgetUList"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/api/users \
  -H 'Accept: */*'

```

```http
GET http://localhost:8080/api/users HTTP/1.1
Host: localhost:8080
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8080/api/users',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get 'http://localhost:8080/api/users',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('http://localhost:8080/api/users', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8080/api/users', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/users");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8080/api/users", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /api/users`

> Example responses

> 200 Response

<h3 id="getulist-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getulist-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[[User](#schemauser)]|false|none|none|
|» id|string|false|none|none|
|» username|string|false|none|none|
|» password|string|false|none|none|
|» fullname|string|false|none|none|
|» dob|string(date)|false|none|none|

<aside class="success">
This operation does not require authentication
</aside>

## createUsuer

<a id="opIdcreateUsuer"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8080/api/users \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*'

```

```http
POST http://localhost:8080/api/users HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: */*

```

```javascript
const inputBody = '{
  "username": "string",
  "password": "stringst",
  "fullname": "string",
  "dob": "2019-08-24"
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'*/*'
};

fetch('http://localhost:8080/api/users',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => '*/*'
}

result = RestClient.post 'http://localhost:8080/api/users',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': '*/*'
}

r = requests.post('http://localhost:8080/api/users', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8080/api/users', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/users");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8080/api/users", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/users`

> Body parameter

```json
{
  "username": "string",
  "password": "stringst",
  "fullname": "string",
  "dob": "2019-08-24"
}
```

<h3 id="createusuer-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[UserCreationRequest](#schemausercreationrequest)|true|none|

> Example responses

> 200 Response

<h3 id="createusuer-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[User](#schemauser)|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="soul-spaces-authentication-controller">authentication-controller</h1>

## login

<a id="opIdlogin"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8080/auth/login \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*'

```

```http
POST http://localhost:8080/auth/login HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: */*

```

```javascript
const inputBody = '{
  "username": "string",
  "password": "string"
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'*/*'
};

fetch('http://localhost:8080/auth/login',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => '*/*'
}

result = RestClient.post 'http://localhost:8080/auth/login',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': '*/*'
}

r = requests.post('http://localhost:8080/auth/login', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8080/auth/login', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/auth/login");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8080/auth/login", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /auth/login`

> Body parameter

```json
{
  "username": "string",
  "password": "string"
}
```

<h3 id="login-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[AuthenticationRequest](#schemaauthenticationrequest)|true|none|

> Example responses

> 200 Response

<h3 id="login-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[ApiResponseBoolean](#schemaapiresponseboolean)|

<aside class="success">
This operation does not require authentication
</aside>

## authenicate

<a id="opIdauthenicate"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8080/auth/log-in \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*'

```

```http
POST http://localhost:8080/auth/log-in HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: */*

```

```javascript
const inputBody = '{
  "username": "string",
  "password": "string"
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'*/*'
};

fetch('http://localhost:8080/auth/log-in',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => '*/*'
}

result = RestClient.post 'http://localhost:8080/auth/log-in',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': '*/*'
}

r = requests.post('http://localhost:8080/auth/log-in', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8080/auth/log-in', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/auth/log-in");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8080/auth/log-in", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /auth/log-in`

> Body parameter

```json
{
  "username": "string",
  "password": "string"
}
```

<h3 id="authenicate-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[AuthenticationRequest](#schemaauthenticationrequest)|true|none|

> Example responses

> 200 Response

<h3 id="authenicate-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[ApiResponseAuthenticationRespone](#schemaapiresponseauthenticationrespone)|

<aside class="success">
This operation does not require authentication
</aside>

## checkSession

<a id="opIdcheckSession"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/auth/check-session \
  -H 'Accept: */*'

```

```http
GET http://localhost:8080/auth/check-session HTTP/1.1
Host: localhost:8080
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8080/auth/check-session',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get 'http://localhost:8080/auth/check-session',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('http://localhost:8080/auth/check-session', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8080/auth/check-session', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/auth/check-session");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8080/auth/check-session", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /auth/check-session`

> Example responses

> 200 Response

<h3 id="checksession-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[ApiResponseObject](#schemaapiresponseobject)|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="soul-spaces-file-upload-controller">file-upload-controller</h1>

## uploadFile

<a id="opIduploadFile"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8080/api/v1/upload \
  -H 'Content-Type: application/json' \
  -H 'Accept: */*'

```

```http
POST http://localhost:8080/api/v1/upload HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: */*

```

```javascript
const inputBody = '{
  "file": "string"
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'*/*'
};

fetch('http://localhost:8080/api/v1/upload',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => '*/*'
}

result = RestClient.post 'http://localhost:8080/api/v1/upload',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': '*/*'
}

r = requests.post('http://localhost:8080/api/v1/upload', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8080/api/v1/upload', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/upload");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8080/api/v1/upload", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/v1/upload`

> Body parameter

```json
{
  "file": "string"
}
```

<h3 id="uploadfile-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|object|false|none|
|» file|body|string(binary)|true|none|

> Example responses

> 200 Response

<h3 id="uploadfile-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="uploadfile-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|» **additionalProperties**|any|false|none|none|

<aside class="success">
This operation does not require authentication
</aside>

## uploadFiles

<a id="opIduploadFiles"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8080/api/v1/uploadFiles?files=string \
  -H 'Accept: */*'

```

```http
POST http://localhost:8080/api/v1/uploadFiles?files=string HTTP/1.1
Host: localhost:8080
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8080/api/v1/uploadFiles?files=string',
{
  method: 'POST',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.post 'http://localhost:8080/api/v1/uploadFiles',
  params: {
  'files' => 'array[string]'
}, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.post('http://localhost:8080/api/v1/uploadFiles', params={
  'files': [
  "string"
]
}, headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8080/api/v1/uploadFiles', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/uploadFiles?files=string");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8080/api/v1/uploadFiles", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /api/v1/uploadFiles`

<h3 id="uploadfiles-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|files|query|array[string]|true|none|

> Example responses

> 200 Response

<h3 id="uploadfiles-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="uploadfiles-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|» **additionalProperties**|any|false|none|none|

<aside class="success">
This operation does not require authentication
</aside>

## deleteFiles

<a id="opIddeleteFiles"></a>

> Code samples

```shell
# You can also use wget
curl -X DELETE http://localhost:8080/api/v1/delete?imgUrl=string \
  -H 'Accept: */*'

```

```http
DELETE http://localhost:8080/api/v1/delete?imgUrl=string HTTP/1.1
Host: localhost:8080
Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'
};

fetch('http://localhost:8080/api/v1/delete?imgUrl=string',
{
  method: 'DELETE',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.delete 'http://localhost:8080/api/v1/delete',
  params: {
  'imgUrl' => 'string'
}, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.delete('http://localhost:8080/api/v1/delete', params={
  'imgUrl': 'string'
}, headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('DELETE','http://localhost:8080/api/v1/delete', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/api/v1/delete?imgUrl=string");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("DELETE", "http://localhost:8080/api/v1/delete", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`DELETE /api/v1/delete`

<h3 id="deletefiles-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|imgUrl|query|string|true|none|

> Example responses

> 200 Response

<h3 id="deletefiles-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="deletefiles-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|» **additionalProperties**|any|false|none|none|

<aside class="success">
This operation does not require authentication
</aside>

# Schemas

<h2 id="tocS_BlogUpdateRequest">BlogUpdateRequest</h2>
<!-- backwards compatibility -->
<a id="schemablogupdaterequest"></a>
<a id="schema_BlogUpdateRequest"></a>
<a id="tocSblogupdaterequest"></a>
<a id="tocsblogupdaterequest"></a>

```json
{
  "blogId": "string",
  "content": "string",
  "newImages": [
    "string"
  ],
  "removeImagesUrl": [
    "string"
  ],
  "published": true
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|blogId|string|false|none|none|
|content|string|false|none|none|
|newImages|[string]|false|none|none|
|removeImagesUrl|[string]|false|none|none|
|published|boolean|false|none|none|

<h2 id="tocS_BlogUpdateResponse">BlogUpdateResponse</h2>
<!-- backwards compatibility -->
<a id="schemablogupdateresponse"></a>
<a id="schema_BlogUpdateResponse"></a>
<a id="tocSblogupdateresponse"></a>
<a id="tocsblogupdateresponse"></a>

```json
{
  "blogId": "string",
  "content": "string",
  "successUrls": [
    "string"
  ],
  "failedDeleteFiles": [
    "string"
  ],
  "failedUploadFiles": [
    "string"
  ],
  "published": true,
  "updateAt": "2019-08-24T14:15:22Z"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|blogId|string|false|none|none|
|content|string|false|none|none|
|successUrls|[string]|false|none|none|
|failedDeleteFiles|[string]|false|none|none|
|failedUploadFiles|[string]|false|none|none|
|published|boolean|false|none|none|
|updateAt|string(date-time)|false|none|none|

<h2 id="tocS_BlogAccessRequest">BlogAccessRequest</h2>
<!-- backwards compatibility -->
<a id="schemablogaccessrequest"></a>
<a id="schema_BlogAccessRequest"></a>
<a id="tocSblogaccessrequest"></a>
<a id="tocsblogaccessrequest"></a>

```json
{
  "blogId": "string",
  "published": true
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|blogId|string|false|none|none|
|published|boolean|false|none|none|

<h2 id="tocS_BlogAccessResponse">BlogAccessResponse</h2>
<!-- backwards compatibility -->
<a id="schemablogaccessresponse"></a>
<a id="schema_BlogAccessResponse"></a>
<a id="tocSblogaccessresponse"></a>
<a id="tocsblogaccessresponse"></a>

```json
{
  "blogId": "string",
  "published": true,
  "updateAt": "2019-08-24T14:15:22Z"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|blogId|string|false|none|none|
|published|boolean|false|none|none|
|updateAt|string(date-time)|false|none|none|

<h2 id="tocS_UserUpdateRequest">UserUpdateRequest</h2>
<!-- backwards compatibility -->
<a id="schemauserupdaterequest"></a>
<a id="schema_UserUpdateRequest"></a>
<a id="tocSuserupdaterequest"></a>
<a id="tocsuserupdaterequest"></a>

```json
{
  "username": "string",
  "password": "stringst",
  "fullname": "string",
  "dob": "2019-08-24"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|username|string|true|none|none|
|password|string|true|none|none|
|fullname|string|false|none|none|
|dob|string(date)|false|none|none|

<h2 id="tocS_UserRespone">UserRespone</h2>
<!-- backwards compatibility -->
<a id="schemauserrespone"></a>
<a id="schema_UserRespone"></a>
<a id="tocSuserrespone"></a>
<a id="tocsuserrespone"></a>

```json
{
  "id": "string",
  "username": "string",
  "password": "string",
  "fullname": "string",
  "dob": "2019-08-24"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|string|false|none|none|
|username|string|false|none|none|
|password|string|false|none|none|
|fullname|string|false|none|none|
|dob|string(date)|false|none|none|

<h2 id="tocS_AuthenticationRequest">AuthenticationRequest</h2>
<!-- backwards compatibility -->
<a id="schemaauthenticationrequest"></a>
<a id="schema_AuthenticationRequest"></a>
<a id="tocSauthenticationrequest"></a>
<a id="tocsauthenticationrequest"></a>

```json
{
  "username": "string",
  "password": "string"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|username|string|false|none|none|
|password|string|false|none|none|

<h2 id="tocS_ApiResponseBoolean">ApiResponseBoolean</h2>
<!-- backwards compatibility -->
<a id="schemaapiresponseboolean"></a>
<a id="schema_ApiResponseBoolean"></a>
<a id="tocSapiresponseboolean"></a>
<a id="tocsapiresponseboolean"></a>

```json
{
  "code": 0,
  "message": "string",
  "result": true
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|code|integer(int32)|false|none|none|
|message|string|false|none|none|
|result|boolean|false|none|none|

<h2 id="tocS_ApiResponseAuthenticationRespone">ApiResponseAuthenticationRespone</h2>
<!-- backwards compatibility -->
<a id="schemaapiresponseauthenticationrespone"></a>
<a id="schema_ApiResponseAuthenticationRespone"></a>
<a id="tocSapiresponseauthenticationrespone"></a>
<a id="tocsapiresponseauthenticationrespone"></a>

```json
{
  "code": 0,
  "message": "string",
  "result": {
    "authentication": true
  }
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|code|integer(int32)|false|none|none|
|message|string|false|none|none|
|result|[AuthenticationRespone](#schemaauthenticationrespone)|false|none|none|

<h2 id="tocS_AuthenticationRespone">AuthenticationRespone</h2>
<!-- backwards compatibility -->
<a id="schemaauthenticationrespone"></a>
<a id="schema_AuthenticationRespone"></a>
<a id="tocSauthenticationrespone"></a>
<a id="tocsauthenticationrespone"></a>

```json
{
  "authentication": true
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|authentication|boolean|false|none|none|

<h2 id="tocS_BlogCreateRequest">BlogCreateRequest</h2>
<!-- backwards compatibility -->
<a id="schemablogcreaterequest"></a>
<a id="schema_BlogCreateRequest"></a>
<a id="tocSblogcreaterequest"></a>
<a id="tocsblogcreaterequest"></a>

```json
{
  "userId": "string",
  "content": "string",
  "published": true,
  "files": [
    "string"
  ]
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|userId|string|false|none|none|
|content|string|false|none|none|
|published|boolean|false|none|none|
|files|[string]|false|none|none|

<h2 id="tocS_BlogCreateResponse">BlogCreateResponse</h2>
<!-- backwards compatibility -->
<a id="schemablogcreateresponse"></a>
<a id="schema_BlogCreateResponse"></a>
<a id="tocSblogcreateresponse"></a>
<a id="tocsblogcreateresponse"></a>

```json
{
  "blogId": "string",
  "successUrls": [
    "string"
  ],
  "failedFiles": [
    "string"
  ]
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|blogId|string|false|none|none|
|successUrls|[string]|false|none|none|
|failedFiles|[string]|false|none|none|

<h2 id="tocS_UserCreationRequest">UserCreationRequest</h2>
<!-- backwards compatibility -->
<a id="schemausercreationrequest"></a>
<a id="schema_UserCreationRequest"></a>
<a id="tocSusercreationrequest"></a>
<a id="tocsusercreationrequest"></a>

```json
{
  "username": "string",
  "password": "stringst",
  "fullname": "string",
  "dob": "2019-08-24"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|username|string|true|none|none|
|password|string|true|none|none|
|fullname|string|false|none|none|
|dob|string(date)|false|none|none|

<h2 id="tocS_User">User</h2>
<!-- backwards compatibility -->
<a id="schemauser"></a>
<a id="schema_User"></a>
<a id="tocSuser"></a>
<a id="tocsuser"></a>

```json
{
  "id": "string",
  "username": "string",
  "password": "string",
  "fullname": "string",
  "dob": "2019-08-24"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|string|false|none|none|
|username|string|false|none|none|
|password|string|false|none|none|
|fullname|string|false|none|none|
|dob|string(date)|false|none|none|

<h2 id="tocS_ApiResponseObject">ApiResponseObject</h2>
<!-- backwards compatibility -->
<a id="schemaapiresponseobject"></a>
<a id="schema_ApiResponseObject"></a>
<a id="tocSapiresponseobject"></a>
<a id="tocsapiresponseobject"></a>

```json
{
  "code": 0,
  "message": "string",
  "result": null
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|code|integer(int32)|false|none|none|
|message|string|false|none|none|
|result|any|false|none|none|

<h2 id="tocS_BlogDTO">BlogDTO</h2>
<!-- backwards compatibility -->
<a id="schemablogdto"></a>
<a id="schema_BlogDTO"></a>
<a id="tocSblogdto"></a>
<a id="tocsblogdto"></a>

```json
{
  "id": "string",
  "userId": "string",
  "userName": "string",
  "userAvatarUrl": "string",
  "content": "string",
  "imageContentUrls": [
    "string"
  ],
  "likeCount": 0,
  "commentCount": 0,
  "shareCount": 0,
  "published": true,
  "createdAt": "2019-08-24T14:15:22Z",
  "updateAt": "2019-08-24T14:15:22Z"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|string|false|none|none|
|userId|string|false|none|none|
|userName|string|false|none|none|
|userAvatarUrl|string|false|none|none|
|content|string|false|none|none|
|imageContentUrls|[string]|false|none|none|
|likeCount|integer(int64)|false|none|none|
|commentCount|integer(int64)|false|none|none|
|shareCount|integer(int64)|false|none|none|
|published|boolean|false|none|none|
|createdAt|string(date-time)|false|none|none|
|updateAt|string(date-time)|false|none|none|

<h2 id="tocS_BlogDetailsResponse">BlogDetailsResponse</h2>
<!-- backwards compatibility -->
<a id="schemablogdetailsresponse"></a>
<a id="schema_BlogDetailsResponse"></a>
<a id="tocSblogdetailsresponse"></a>
<a id="tocsblogdetailsresponse"></a>

```json
{
  "id": "string",
  "userId": "string",
  "userName": "string",
  "userAvatarUrl": "string",
  "content": "string",
  "imageUrls": [
    "string"
  ],
  "likeCount": 0,
  "commentCount": 0,
  "shareCount": 0,
  "createdAt": "2019-08-24T14:15:22Z"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|string|false|none|none|
|userId|string|false|none|none|
|userName|string|false|none|none|
|userAvatarUrl|string|false|none|none|
|content|string|false|none|none|
|imageUrls|[string]|false|none|none|
|likeCount|integer(int64)|false|none|none|
|commentCount|integer(int64)|false|none|none|
|shareCount|integer(int64)|false|none|none|
|createdAt|string(date-time)|false|none|none|

