package shakti.thread.application.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel : ViewModel() {
    val auth =  FirebaseAuth.getInstance()
    val db = FirebaseDatabase.getInstance()
    var userRef = db.getReference("users")

    val firebaseUser = MutableLiveData<FirebaseUser>()
    val error = MutableLiveData<String>("")

    init {
        firebaseUser.value = auth.currentUser
    }

    fun login(email : String,password : String){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful){
                firebaseUser.postValue(auth.currentUser)
            }
            else{
                error.postValue("Something went wrong")
            }
        }
    }

    fun register(email : String,password : String,name : String, userType: String){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful){
                firebaseUser.postValue(auth.currentUser)
            }
            else{
                error.postValue("Something went wrong")
            }
        }
    }

}