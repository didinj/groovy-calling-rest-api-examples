def url = new URL("https://jsonplaceholder.typicode.com/invalid-endpoint")
def conn = url.openConnection()
conn.setRequestMethod("GET")

try {
    def responseCode = conn.responseCode
    if (responseCode == 200) {
        println "Success: ${conn.inputStream.text}"
    } else {
        println "Error: Response code ${responseCode}"
        println "Error details: ${conn.errorStream?.text}"
    }
} catch (IOException e) {
    println "Exception occurred: ${e.message}"
}
