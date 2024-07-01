package shakti.thread.application.navigation

sealed class Routes(val routes: String){

    object home: Routes("home")
    object addThread: Routes("addThread")
    object notification: Routes("notification")
    object profile: Routes("profile")
    object search: Routes("search")
    object spalsh: Routes("spalsh")
    object bottomNav: Routes("bottomNav")
    object login: Routes("login")
    object register: Routes("register")
}
