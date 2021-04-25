# 159355Assignment2
 Massey 159355 concurrent system assignment
### Author: Yiming Shi, ID: 19023253
### There are 2 packages in the folder "src"
### "Library" is the Library Problem, "Escalator" is the Budget Escalator.
### Please run "RunLibrary.java" and "RunEscalator.java" to start.
***
***When running the library problem, 100 threads will randomly request one of the 20 books. If the book is successfully obtained, the thread will keep it for a while and return it, then request another book, each thread will borrow three books in total, when the book is in someone else's hands, it can't be obtained.***
***
***When running the budget escalator, the escalator will run from one floor to another, some threads will randomly take the escalator (threads with odd Id want to go to 1F, and threads with even id want to go to 2F), and stay on the escalator for a period of time until they reach their destination. The elevator will change its running direction every certain period of time. Before that, the system will prompt "ready to reverse, entrance closed.", at this time, no more threads can enter the escalator. In the command line display we may only see the threads get off. When there are no threads on the escalator, the escalator will change its running direction. Also, if there are 10 threads on the escalator at the same time, the system will prompt "maximum capacity reached!", At this time, no more threads can enter the escalator until a thread leaves the escalator.***
