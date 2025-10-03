def url = new URL("https://api.example.com/weather")
def conn = url.openConnection()
conn.setRequestMethod("GET")

conn.setRequestProperty("x-api-key", "YOUR_API_KEY")

println "Response Code: ${conn.responseCode}"
println "Response: ${conn.inputStream.text}"