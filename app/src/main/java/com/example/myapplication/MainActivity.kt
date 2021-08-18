package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.amazonaws.mobile.client.*
import com.amplifyframework.AmplifyException
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.AWSDataStorePlugin
import com.amplifyframework.datastore.generated.model.Priority
import com.amplifyframework.datastore.generated.model.Todo

//import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // これはauthのplugin // 機能(S3, Cognito etc.)を追加するたびにpluginも増やす
        Amplify.addPlugin(AWSCognitoAuthPlugin())
        Amplify.configure(applicationContext)

//        Amplify.Auth.fetchAuthSession(
//            { Log.i("AmplifyQuickstart", "Auth session = $it") },
//            { Log.e("AmplifyQuickstart", "Failed to fetch auth session") }
//        )

        Amplify.Auth.signInWithWebUI(this,
            { Log.i("AuthQuickStart", "Signin OK = $it") },
            { Log.e("AuthQuickStart", "Signin failed", it) }
        )

        // ほんとにここ？
//        val options = AuthSignUpOptions.builder()
//            .userAttribute(AuthUserAttributeKey.email(), "tamaki.kawagoshi@xecstars.co.jp")
//            .build()
//        Amplify.Auth.signUp("964eb075-bd13-4d0d-b8c7-f383d3756c7d", "Hola5Tamaki", options,
//            { Log.i("AuthQuickStart", "Sign up succeeded: $it") },
//            { Log.e ("AuthQuickStart", "Sign up failed", it) }
//        )
//
//        // ほんとにここ？
//        Amplify.Auth.confirmSignUp(
//            "test", "535393",
//            { result ->
//                if (result.isSignUpComplete) {
//                    Log.i("AuthQuickstart", "Confirm signUp succeeded")
//                } else {
//                    Log.i("AuthQuickstart","Confirm sign up not complete")
//                }
//            },
//            { Log.e("AuthQuickstart", "Failed to confirm sign up", it) }
//        )
//
//        Amplify.Auth.signIn("964eb075-bd13-4d0d-b8c7-f383d3756c7d", "Hola5Tamaki",
//            { result ->
//                if (result.isSignInComplete) {
//                    Log.i("AuthQuickstart", "Sign in succeeded")
//                } else {
//                    Log.i("AuthQuickstart", "Sign in not complete")
//                }
//            },
//            { Log.e("AuthQuickstart", "Failed to sign in", it) }
//        )



            /*AWSMobileClient.getInstance()
                .initialize(applicationContext, object : Callback<UserStateDetails?> {
                    override fun onResult(userStateDetails: UserStateDetails?) {
                        when (userStateDetails?.userState) {
                            UserState.SIGNED_IN -> runOnUiThread {
                                //val textView = findViewById<View>(R.id.text) as TextView
                                amplifyText.text = "Logged IN"
                            }
                            UserState.SIGNED_OUT -> runOnUiThread {
                                //val textView = findViewById<View>(R.id.text) as TextView
                                amplifyText.text = "Logged OUT"

                                // 'this' refers the the current active activity
                                AWSMobileClient.getInstance()
                                    .showSignIn(this@MainActivity, object : Callback<UserStateDetails> {
                                        override fun onResult(result: UserStateDetails) {
                                            Log.d("SIGNIN", "onResult: " + result.userState)
                                        }

                                        override fun onError(e: Exception) {
                                            Log.e("SIGNIN", "onError: ", e)
                                        }
                                    })
                            }
                            else -> AWSMobileClient.getInstance().signOut()
                        }
                    }

                    override fun onError(e: Exception?) {
                        Log.e("INIT", e.toString())
                    }
                })

            // サインアウトボタンの定義
            //val signoutButton = findViewById(R.id.signoutButton) as Button
            signoutButton.setOnClickListener {
                AWSMobileClient.getInstance().signOut()
                Log.d("SIGNOUT", "clickSignoutButton")
                AWSMobileClient.getInstance()
                    .showSignIn(this@MainActivity, object : Callback<UserStateDetails> {
                        override fun onResult(result: UserStateDetails) {
                            Log.d("SIGNIN", "onResult: " + result.userState)
                        }

                        override fun onError(e: Exception) {
                            Log.e("SIGNIN", "onError: ", e)
                        }
                    })
            }*/
        }
    }

        /*val attrs = mapOf(
            AuthUserAttributeKey.email() to "tamaki.kawagoshi@xecstars.co.jp",
            AuthUserAttributeKey.phoneNumber() to "+15551234567"
        )
        val options = AuthSignUpOptions.builder()
            .userAttributes(attrs.map { AuthUserAttribute(it.key, it.value) })
            .build()
        Amplify.Auth.signUp("test", "Password123", options,
            { Log.i("AuthQuickstart", "Sign up result = $it") },
            { Log.e("AuthQuickstart", "Sign up failed", it) }
        )

        Amplify.Auth.confirmSignIn("code received via SMS",
            { Log.i("AuthQuickstart", "Confirmed signin: $it") },
            { Log.e("AuthQuickstart", "Failed to confirm signin", it) }
        )*/
