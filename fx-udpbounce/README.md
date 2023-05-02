### Bouncing ball example in JavaFX with UDP network broadcast / receive

Based on __fx-bounce__ project

1. Run one instance with a command line parameter `master` (or any string). This instance will behave as "master", broadcasting the position of the ball through UDP while moving it around the playground.

2. Run a second instance without any command line parameter. This instance will be the "slave" listening on UDP socket and moving the ball according to the received values.
