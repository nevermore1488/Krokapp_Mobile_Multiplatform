package by.ssrlab.krokapp.mobile

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}