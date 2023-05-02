/*
 *  Created for B0B36PJV in b202
 */
package cz.cvut.fel.pjv.chat;

/**
 *
 * @author ladislav.seredi@fel.cvut.cz
 */

/*

Client            Server
-1.----------------------
  <----- SUBMIT ------
  --- NAME|<name> --->
  <---- REJECTED -----
-2.----------------------
  <----- SUBMIT ------
  --- NAME|<name> --->
  <---- ACCEPTED -----
  - BROADCAST|<msg> ->
  <--- CHAT|<msg> ----
  ...
  ------- QUIT ------>

*/
public enum Protocol {
  // server origin:
  SUBMIT,
  ACCEPTED,
  REJECTED,
  CHAT,
  // client origin:
  NAME,
  BROADCAST,
  QUIT
}
