This is a very simple usage of **akka-persistence-experimental** (version **2.3.2**), almost a copy from 
https://github.com/akka/akka/blob/master/akka-samples/akka-sample-persistence-scala/src/main/scala/sample/persistence/ProcessorFailureExample.scala

The important thing here is that this example works as expected with:
```
$ java -version
java version "1.8.0_05"
Java(TM) SE Runtime Environment (build 1.8.0_05-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.5-b02, mixed mode)
```

but we are having trouble to make something like the above working on Android.
The corresponding attempt on Android is here:

https://github.com/Optrak/akkaPersistenceWithAndroid