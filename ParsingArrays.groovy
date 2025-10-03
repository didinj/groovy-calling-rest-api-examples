import groovy.json.JsonSlurper

def url = new URL("https://jsonplaceholder.typicode.com/posts")
def posts = new JsonSlurper().parseText(url.text)

println "Total posts: ${posts.size()}"
println "First post title: ${posts[0].title}"