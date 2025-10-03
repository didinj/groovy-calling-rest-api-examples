@Grab('com.squareup.okhttp3:okhttp:4.12.0')
@Grab('com.fasterxml.jackson.core:jackson-databind:2.18.2')
import okhttp3.*
import com.fasterxml.jackson.databind.ObjectMapper

def client = new OkHttpClient()
def mapper = new ObjectMapper()

// GET request
def request = new Request.Builder()
        .url("https://jsonplaceholder.typicode.com/posts/1")
        .build()

def response = client.newCall(request).execute()
def json = mapper.readTree(response.body().string())

println "Title: ${json.get('title').asText()}"
println "Body: ${json.get('body').asText()}"

// POST request
def postBody = RequestBody.create(
        mapper.writeValueAsString([title: "OkHttp Post", body: "Hello Groovy 4", userId: 1]),
        MediaType.get("application/json; charset=utf-8")
)

def postRequest = new Request.Builder()
        .url("https://jsonplaceholder.typicode.com/posts")
        .post(postBody)
        .build()

def postResponse = client.newCall(postRequest).execute()
println "New Post Response: ${postResponse.body().string()}"
