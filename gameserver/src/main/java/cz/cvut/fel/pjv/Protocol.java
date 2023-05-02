/*
 *  Created for B0B36PJV in b202
 */
package cz.cvut.fel.pjv;

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
  - MOVE|<from-to> -->
  only for opponent
  <- MOVE|<from-to> --
  ...
  ------- QUIT ------>
  only for opponent
  <- QUIT|<from-to> --

*/
public enum Protocol {
  // server origin:
  SUBMIT,
  ACCEPTED,
  REJECTED,
  CHAT,
  // client origin:
  NAME,
  QUIT,
  // both:
  MOVE
}
