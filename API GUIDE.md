# Some dependencies use ing project
- Spring web
- Lombok
- Spring security
- Spring data MongoDB
- Spring Boot DevTools
- Validation

## Using swagger
Go to: https://editor.swagger.io/ , import file `.yaml` and then test api

- Also can install extension OpenApi in vscode to run this

### Export `.yaml`

http://localhost:8080/v3/api-docs.yaml

### Backend
Run code and go to: http://localhost:8080/swagger-ui/index.html to test API

### Create file

**Method 1**
```bash
npm install -g openapi-markdown
openapi-markdown -i openapi.json -o ./README.md

```

**Method 2**
```bash
npm install @openapitools/openapi-generator-cli -g
openapi-generator-cli generate -i openapi.json -g markdown -o docs/

```

**Method 3**
```bash
curl http://localhost:8080/v3/api-docs -o openapi.json
npx widdershins openapi.json -o README.md
```

**Method 4**
```bash
mvn springdoc-openapi:generate
```
cre: https://springdoc.org/#migrating-from-springdoc-v1
cre: https://zudoku.dev/
