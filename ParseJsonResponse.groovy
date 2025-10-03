import groovy.json.JsonSlurper

def url = new URL("https://jsonplaceholder.typicode.com/posts/1")
def jsonText = url.text

def json = new JsonSlurper().parseText(jsonText)

println("ID: ${json.id}")
println("User ID: ${json.userId}")
println("Title: ${json.title}")
println("Body: ${json.body}")
