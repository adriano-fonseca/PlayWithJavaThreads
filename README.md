# PlayWithJavaThreads
Here is some util code to turn easy to understand how use threads in java.

# You will see codes like that
With this code you can define the doThat and doThis are going to be executed like a atomic operation.
```java
synchronized (this) {
      doThat();
      doThis();
    }
```
