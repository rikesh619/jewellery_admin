package com.brjewels.admin.android.activity.authentication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.brjewels.admin.android.MainActivity
import com.brjewels.admin.android.databinding.ActivityLoginBinding
import com.brjewels.admin.android.models.Users
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    private var db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnLogIn.setOnClickListener {
            val email = binding.emailTextInput.text.toString()
            val password = binding.passwordTextInput.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() ){

                firebaseAuth.signInWithEmailAndPassword(email , password).addOnCompleteListener {
                    if (it.isSuccessful){
                        val currentUser = firebaseAuth.currentUser
                        currentUser?.let {firebaseUser ->
                            val userId = firebaseUser.uid
                            db = Firebase.firestore
                            db.collection("users").document(userId).get().addOnSuccessListener {documentSnapshot ->
                                if (documentSnapshot.exists()){
                                    val user = documentSnapshot.toObject(Users :: class.java)
                                    if (user != null && user.role == "admin" && user.user_id == userId){
                                        val intent = Intent(this , MainActivity :: class.java)
                                        startActivity(intent)
                                    }else {
                                        Toast.makeText(this , "Sorry You Are Authorized to have the Access" , Toast.LENGTH_SHORT).show()
                                        firebaseAuth.signOut()
                                    }
                                }
                            }.addOnFailureListener {
                                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
                            }
                        }
                    }else{
                        Toast.makeText(this , "Either Your Email Or Password Is Incorrect !! \n Please Try Again Later" , Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this ,"Field Cannot Be Empty", Toast.LENGTH_SHORT).show()
            }
        }


    }

}