package com.atul.androidmasterclass.suspendfunction

class SuspendDemo {
    private fun firstFunction(){
    // some code
    }

    private suspend fun secondFunction(){
    // some code
    }
}

/*To create Kotlin Bytecode to check how Suspend Function work
Steps:- 1) Click on Rebuild Project.
        2) Click on Tools Menu, then select Kotlin and then click on Kotlin Bytecode
        3) TO make it readable we have to decompile it.
        4) Then Click on Decompile button to create decompiled code.
*/

/* The Decompile code is
public final class SuspendDemo {
   private final void firstFunction() {
   }

   private final Object secondFunction(Continuation $completion) {
      return Unit.INSTANCE;
   }
}
*/

/*
We can see our Suspended function has been converted by the compiler into another function without using Suspend Keyword.
But a Compiler has added new parameter of type Continuation.
eg:-  private final Object secondFunction(Continuation $completion)
 */

/* Continuation -
 Continuation is a Kotlin Interface which has all the structured required to resume or suspend a fn.

Continuation Code:-
public interface Continuation<in T> {

    public val context: CoroutineContext
    public fun resumeWith(result: Result<T>)
}

 */