def url = new URL("https://jsonplaceholder.typicode.com/posts/1")
def conn = url.openConnection()

// Add custom headers
conn.setRequestProperty("Accept", "application/json")
conn.setRequestProperty("User-Agent", "GroovyClient/1.0")

println "Response Code: ${conn.responseCode}"
println "Response: ${conn.inputStream.text}"