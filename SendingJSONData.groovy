import groovy.json.JsonOutput

def url = new URL("https://jsonplaceholder.typicode.com/posts")
def conn = url.openConnection()
conn.setRequestMethod("POST")
conn.doOutput = true
conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8")

// JSON payload
def payload = [
    title : "Groovy Post",
    body  : "Hello from Groovy!",
    userId: 1
]

// Write the JSON to the request body
conn.outputStream.withWriter("UTF-8") { writer ->
    writer << JsonOutput.toJson(payload)
}

// Read the response
println "Response Code: ${conn.responseCode}"
println "Response: ${conn.inputStream.text}"
