package com.androidarchitecturecomponents.room.init.flow

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.androidarchitecturecomponents.R
import com.androidarchitecturecomponents.room.init.CommentsDatabase
import com.androidarchitecturecomponents.room.init.Person
import com.androidarchitecturecomponents.room.init.UserEntity

/**
 * Created by Ashutosh Ojha on 4/23/19.
 */
class UserActivity : AppCompatActivity() {

    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        init()
    }

    fun init() {
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)

        findViewById<Button>(R.id.btnSignIn).setOnClickListener {

            val user = CommentsDatabase.getInstance(this).userDao().isCustomerExist(etEmail.text.toString(), etPassword.text.toString())

            if (user != null && (user as UserEntity).email.equals(etEmail.text.toString())) {

                val intent = Intent(this, CommentsActivity::class.java)
                intent.putExtra("email", user.email)
                intent.putExtra("user_id", user.user_id)
                startActivity(intent)

            } else {
                Toast.makeText(this, "You are not registered with us", Toast.LENGTH_SHORT).show()

            }
        }

        findViewById<Button>(R.id.btnSignUp).setOnClickListener {

            val user = CommentsDatabase.getInstance(this).userDao().isCustomerExist(etEmail.text.toString(), etPassword.text.toString())

            if (user != null && (user as UserEntity).email.equals(etEmail.text.toString())) {
                Toast.makeText(this, "You are already registered", Toast.LENGTH_SHORT).show()


            } else {
                val userEntity = UserEntity()
                userEntity.email = etEmail.text.toString()
                userEntity.password = etPassword.text.toString()

                var person= Person()
                person.age=15
                userEntity.person=person

                CommentsDatabase.getInstance(this).userDao().addUser(userEntity)
                Toast.makeText(this, "User added successfully", Toast.LENGTH_SHORT).show()
            }

        }

    }
}