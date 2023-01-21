# SChatGPT Library
Simple & light weighted chatGPT (openAi API-based library), chat with openai for free and endlessly..

# Installation
> **Step 1.** Add the JitPack repository to your build file
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
> **Step 2.** Add the dependency
```gradle
dependencies {
    implementation 'com.github.smith8h:SGPT:1.0.0'
}
```

# Documentation
> **Step 1.** got to this website [here](https://beta.openai.com/account/api-keys) and get your api-token to use it in this library
> **Step 2.** create new instance of SGPT class and pass your token:
```java
SGPT chat = new SGPT("token here");
```
> **Step 3.** now you can chat with AI by:
```java
// create a callback to interact with chat
SGPT.ChatCallBack callback = new SGPT.ChatCallBack() {
    @Override public void onResponse(String response) {
        // do your stuff on response
    }
    @Override public void onFailure(String message) {
        // do your stuff on failure
    }
};
// now chat with AI
chat.chat("your message/question", callback);
```
And that's it!

# Donations ❤
> If you would like to support this project's further development, the creator of this projects or the continuous maintenance of the project **feel free to donate**.
Your donation is highly appreciated. Thank you!
<br/>

You can **choose what you want to donate**, all donations are awesome!</br>
<br/>

[![PayPal](https://img.shields.io/badge/PayPal-00457C?style=for-the-badge&logo=paypal&logoColor=white)](https://www.paypal.me/husseinshakir)
[![Buy me a coffee](https://img.shields.io/badge/Buy_Me_A_Coffee-FFDD00?style=for-the-badge&logo=buy-me-a-coffee&logoColor=black)](https://www.buymeacoffee.com/HusseinShakir)
[![Ko-fi](https://img.shields.io/badge/Ko--fi-F16061?style=for-the-badge&logo=ko-fi&logoColor=white)](https://ko-fi.com/husseinsmith)
<br/>

<p align="center">
  <img src="https://raw.githubusercontent.com/smith8h/smith8h/main/20221103_150053.png" style="width: 38%;"/>
  <br><b>With :heart:</b>
</p>