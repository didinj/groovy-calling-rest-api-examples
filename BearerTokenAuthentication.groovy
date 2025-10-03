def url = new URL("https://api.example.com/data")
def conn = url.openConnection()
conn.setRequestMethod("GET")

// Add authorization header
conn.setRequestProperty("Authorization", "Bearer YOUR_ACCESS_TOKEN")
conn.setRequestProperty("Accept", "application/json")

println "Response Code: ${conn.responseCode}"
println "Response: ${conn.inputStream.text}"
