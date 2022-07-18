# AutoPlug-Core
Frequently used code across all AutoPlug projects inside one jar.
[Click here for maven/gradle/sbt/leinigen instructions](https://jitpack.io/#Osiris-Team/AutoPlug-Core/LATEST) (Java 8 or higher required).

### Features
- Easy to use logger with cross-platform ANSI/color support.
- Utils for handling JSON from http/s.

## Logging
The `AL` class (short for AutoPlug-Logger) contains static methods for logging
with 4 levels: error, warn, info, and debug. All messages are pre-formatted
and support ANSI colors. 

It also allows registering listeners for specific or all messages and 
mirroring the console output to multiple files easily.

## Json
The `Json` class contains static methods for retrieving Json from an `URL`
and parsing it from/to a String. Under the hood it uses the `Gson` library (probably
the fastest Json library for Java).

## Sorting
The `QuickSort` class implements the QuickSort algorithm and provides useful
static methods to sort **arrays** and **lists** of any type (including `JsonArrays`). Usage example:
```java
new QuickSort().sortJsonArray(arr, (thisEl, otherEl) -> {
    int thisId = thisEl.el.getAsJsonObject().get("id").getAsInt();
    int otherId = otherEl.el.getAsJsonObject().get("id").getAsInt();
    return Integer.compare(thisId, otherId);
});
```


