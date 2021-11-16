package eu.regente.demo

class GreetService {
    fun greet(name: String): String =
        if (name.isEmpty()) "Hello anonymous user" else "Hello $name"
}

