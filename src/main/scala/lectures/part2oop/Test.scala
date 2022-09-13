package lectures.part2oop

object Test extends App {

  def getMinJumps(flagHeight: Int, bigJump: Int): Int = {
    var bigJumpNumbers = flagHeight/bigJump
    var smallJumps = flagHeight%bigJump


    return bigJumpNumbers + smallJumps
  }

  def getMinJumpsV2(flagHeight: Int, bigJump: Int): Int = {
    var currentHeight = 0
    var jumpNumbers = 0

    while (currentHeight != flagHeight) {
      if (currentHeight + bigJump > flagHeight) {
        currentHeight = currentHeight + 1
      } else {
        currentHeight = currentHeight + bigJump

      }

      jumpNumbers = jumpNumbers + 1
    }



    return jumpNumbers
  }

  println(getMinJumpsV2(8, 3))
  println(getMinJumpsV2(14, 3))
}
