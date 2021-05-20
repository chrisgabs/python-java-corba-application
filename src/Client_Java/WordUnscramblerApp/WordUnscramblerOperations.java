package WordUnscramblerApp;


/**
* WordUnscramblerApp/WordUnscramblerOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Lance/Desktop/9322-fingrp2/src/IDL/WordUnscramblerApp.idl
* Tuesday, May 18, 2021 7:02:07 PM CST
*/

public interface WordUnscramblerOperations 
{
  boolean logIn (String username);
  String requestWord (String username);
  boolean checkAnswer (String username, String answer);
  String requestRescramble (String username);
  int requestScore (String username);
  String getLeaderboardPosition (int index);
} // interface WordUnscramblerOperations