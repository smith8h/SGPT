# SChatGPT Library

<p align="center">
    <!-- Latest release -->
    <img src="https://img.shields.io/github/v/release/smith8h/SGPT?include_prereleases&amp;label=latest%20release" alt="Latest release"/>
    <!-- Build and test -->
    <img src="https://github.com/smith8h/SGPT/actions/workflows/build.yml/badge.svg" alt="Builds and tests"/>
    <!-- JitPack release -->
    <a href="https://jitpack.io/#smith8h/SGPT">
        <img src="https://jitpack.io/v/smith8h/SGPT.svg" />
    </a>
    <!-- Stability -->
    <img src="https://img.shields.io/badge/stability-stable-green.svg" alt="stability" />
    <!-- minSDK -->
    <img src="https://img.shields.io/badge/minSDK-24-f39f37" alt="minsdk" />
    <!-- stable version -->
    <img src="https://img.shields.io/badge/stable_version-1.0-blue" alt="stable"/>
    <!-- repo size -->
    <img src="https://img.shields.io/github/repo-size/smith8h/SGPT" alt="size"/>
</p>

</br>

Simple & light weighted chatGPT (OpenAI API-based library). chat with OpenAI for free and endlessly..

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
    implementation 'com.github.smith8h:SGPT:1.0'
}
```

# Documentation
> **Step 1.** got to [this website here](https://beta.openai.com/account/api-keys) and get your api-token to use it in this library.
> **Step 2.** use these codes to start a conversation wi chatGPT:
```java
SGPT.setup(this, "token")
    .callback(new ChatCallBack() {
        @Override public void onResponse(String response) {
            // use response
        }
        
        @Override public void onFailure(String message) {
            // use message
        }
    }
    .chat("your message");
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